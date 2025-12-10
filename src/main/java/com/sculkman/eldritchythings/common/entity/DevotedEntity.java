package com.sculkman.eldritchythings.common.entity;

import com.sculkman.eldritchythings.common.item.EldritchyThingsItems;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.RandomSource;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.animal.IronGolem;
import net.minecraft.world.entity.monster.AbstractIllager;
import net.minecraft.world.entity.monster.Ravager;
import net.minecraft.world.entity.monster.Vindicator;
import net.minecraft.world.entity.npc.AbstractVillager;
import net.minecraft.world.entity.npc.Villager;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.raid.Raider;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;

public class DevotedEntity extends AbstractIllager {
    protected DevotedEntity(EntityType<? extends AbstractIllager> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
    }

    protected void registerGoals() {
        super.registerGoals();
        this.goalSelector.addGoal(0, new FloatGoal(this));
        this.goalSelector.addGoal(2, new OpenDoorGoal(this, true));
        this.goalSelector.addGoal(3, new Raider.HoldGroundAttackGoal(this, 10.0F));
        this.goalSelector.addGoal(4, new DevotedMeleeAttackGoal(this));
        this.targetSelector.addGoal(1, (new HurtByTargetGoal(this, new Class[]{Raider.class})).setAlertOthers(new Class[0]));
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal(this, Player.class, true));
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal(this, Villager.class, true));
        this.targetSelector.addGoal(3, new NearestAttackableTargetGoal(this, IronGolem.class, true));
        this.goalSelector.addGoal(8, new RandomStrollGoal(this, 0.6));
        this.goalSelector.addGoal(9, new LookAtPlayerGoal(this, Player.class, 3.0F, 1.0F));
        this.goalSelector.addGoal(10, new LookAtPlayerGoal(this, Mob.class, 8.0F));
    }

    public AbstractIllager.IllagerArmPose getArmPose() {
        if (this.isAggressive()) {
            return IllagerArmPose.ATTACKING;
        } else {
            return this.isCelebrating() ? IllagerArmPose.CELEBRATING : IllagerArmPose.CROSSED;
        }
    }

    @Override
    public void tick() {
        ItemStack mainhand = getItemBySlot(EquipmentSlot.MAINHAND);
        super.tick();
        if (!mainhand.equals(new ItemStack(EldritchyThingsItems.YELLOW_DAGGER.get()))) {
            this.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(EldritchyThingsItems.YELLOW_DAGGER.get()));
        }
    }

    class DevotedMeleeAttackGoal extends MeleeAttackGoal {
        private int ticksUntilNextAttack;

        public DevotedMeleeAttackGoal(DevotedEntity p_34123_) {
            super(p_34123_, (double)1.0F, false);
        }

        protected double getAttackReachSqr(LivingEntity p_34125_) {
            if (this.mob.getVehicle() instanceof Ravager) {
                float $$1 = this.mob.getVehicle().getBbWidth() - 0.1F;
                return (double)($$1 * 2.0F * $$1 * 2.0F + p_34125_.getBbWidth());
            } else {
                return super.getAttackReachSqr(p_34125_);
            }
        }
        @Override
        protected void checkAndPerformAttack(LivingEntity pEnemy, double pDistToEnemySqr) {
            double d0 = this.getAttackReachSqr(pEnemy);
            if (pDistToEnemySqr <= d0 && this.ticksUntilNextAttack <= 0) {
                if (pEnemy instanceof Villager) {
                    ((Villager) pEnemy).convertTo(EldritchyThingsEntities.DEVOTED.get(), false);
                } else {
                    this.resetAttackCooldown();
                    this.mob.swing(InteractionHand.MAIN_HAND);
                    this.mob.doHurtTarget(pEnemy);
                }
            }
        }
    }

    public boolean isAlliedTo(Entity p_34110_) {
        if (super.isAlliedTo(p_34110_)) {
            return true;
        } else if (p_34110_ instanceof LivingEntity && ((LivingEntity)p_34110_).getMobType() == MobType.ILLAGER) {
            return this.getTeam() == null && p_34110_.getTeam() == null;
        } else {
            return false;
        }
    }

    public static AttributeSupplier createDevotedAttributes() {
        return Mob.createLivingAttributes()
                .add(Attributes.MAX_HEALTH, 30F)
                .add(Attributes.FOLLOW_RANGE, 24.0F)
                .add(Attributes.MOVEMENT_SPEED, 0.40F)
                .add(Attributes.ATTACK_DAMAGE, 8.0F)
                .add(Attributes.ATTACK_KNOCKBACK, 0.5F)
                .add(Attributes.KNOCKBACK_RESISTANCE, 0.2F)
                .add(Attributes.ARMOR, 4.0F)
                .add(Attributes.ARMOR_TOUGHNESS, 1.5F)
                .build();
    }

    @Override
    public void applyRaidBuffs(int i, boolean b) {

    }

    @Override
    public SoundEvent getCelebrateSound() {
        return SoundEvents.VINDICATOR_CELEBRATE;
    }

    protected SoundEvent getAmbientSound() {
        return SoundEvents.VINDICATOR_AMBIENT;
    }

    protected SoundEvent getDeathSound() {
        return SoundEvents.VINDICATOR_DEATH;
    }

    protected SoundEvent getHurtSound(DamageSource p_34103_) {
        return SoundEvents.VINDICATOR_HURT;
    }
}

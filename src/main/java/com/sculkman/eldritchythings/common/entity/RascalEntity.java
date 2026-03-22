package com.sculkman.eldritchythings.common.entity;

import com.sculkman.eldritchythings.common.entity.goals.*;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.world.entity.AnimationState;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.Pose;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.FloatGoal;
import net.minecraft.world.entity.ai.goal.LookAtPlayerGoal;
import net.minecraft.world.entity.ai.goal.OpenDoorGoal;
import net.minecraft.world.entity.ai.goal.WaterAvoidingRandomStrollGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;

public class RascalEntity extends Monster {
    protected RascalEntity(EntityType<? extends Monster> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
    }

    private static final EntityDataAccessor<Boolean> ATTACKING =
            SynchedEntityData.defineId(RascalEntity.class, EntityDataSerializers.BOOLEAN);
    private static final EntityDataAccessor<Boolean> CRASHING_OUT =
            SynchedEntityData.defineId(RascalEntity.class, EntityDataSerializers.BOOLEAN);
    public final AnimationState idle = new AnimationState();
    private int idleAnimationTimeout = 0;
    public final AnimationState attack = new AnimationState();
    public int attackAnimationTimeout = 0;
    public final AnimationState crashing_out = new AnimationState();

    private void setupAnimationStates() {
        if (this.idleAnimationTimeout <=0) {
            this.idleAnimationTimeout = this.random.nextInt(52) + 80;
            this.idle.start(this.tickCount);
        } else {
            --this.idleAnimationTimeout;
        }

        if (this.isAttacking() && attackAnimationTimeout <=0) {
            attackAnimationTimeout = 7;
            attack.start(this.tickCount);
        } else {
            --this.attackAnimationTimeout;
        }
        if (!this.isAttacking()) {
            attack.stop();
        }
        if (isCrashingOut()) {
            crashing_out.start(this.tickCount);
        } else {
            crashing_out.stop();
        }
    }

    protected void registerGoals() {
        super.registerGoals();
        this.goalSelector.addGoal(0, new FloatGoal(this));
        this.goalSelector.addGoal(3, new RascalMeleeAttackGoal(this, 1.5, true));
        this.goalSelector.addGoal(2, new OpenDoorGoal(this, true));
        this.goalSelector.addGoal(8, new WaterAvoidingRandomStrollGoal(this, 0.8));
        this.goalSelector.addGoal(9, new LookAtPlayerGoal(this, Player.class, 3.0F, 1.0F));
        this.goalSelector.addGoal(10, new LookAtPlayerGoal(this, Mob.class, 8.0F));
        this.targetSelector.addGoal(2, new NearestAttackbleTargetRascalGoal(this, Player.class, true));
    }

    @Override
    public void tick() {
        super.tick();
        if (this.level().isClientSide) {
            setupAnimationStates();
        }
    }

    public void setAttacking(boolean attacking) {
        this.entityData.set(ATTACKING, attacking);
    }

    public boolean isAttacking() {
        return this.entityData.get(ATTACKING);
    }

    public void setCrashingOut(boolean crashingOut) {
        this.entityData.set(CRASHING_OUT, crashingOut);
    }

    public boolean isCrashingOut() {
        return this.entityData.get(CRASHING_OUT);
    }

    @Override
    protected void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(ATTACKING, false);
        this.entityData.define(CRASHING_OUT, false);
    }

    protected void updateWalkAnimation(float pPartialTick) {
        float f;
        if (this.getPose() == Pose.STANDING) {
            f = Math.min(pPartialTick * 6.0F, 1.0F);
        } else {
            f = 0.0F;
        }

        this.walkAnimation.update(f, 0.2F);
    }

    public static AttributeSupplier createRascalAttributes() {
        return Mob.createLivingAttributes()
                .add(Attributes.MAX_HEALTH, 15F)
                .add(Attributes.FOLLOW_RANGE, 12.0F)
                .add(Attributes.MOVEMENT_SPEED, 0.25F)
                .add(Attributes.ATTACK_DAMAGE, 7.0F)
                .add(Attributes.ATTACK_KNOCKBACK, 0.0F)
                .add(Attributes.KNOCKBACK_RESISTANCE, 0.1F)
                .add(Attributes.ARMOR, 0.0F)
                .add(Attributes.ARMOR_TOUGHNESS, 0.0F)
                .build();
    }
}

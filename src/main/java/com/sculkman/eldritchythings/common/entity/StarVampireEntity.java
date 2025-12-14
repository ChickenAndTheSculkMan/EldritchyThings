package com.sculkman.eldritchythings.common.entity;

import net.minecraft.world.entity.AnimationState;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.Pose;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.FloatGoal;
import net.minecraft.world.entity.ai.goal.LookAtPlayerGoal;
import net.minecraft.world.entity.ai.goal.OpenDoorGoal;
import net.minecraft.world.entity.ai.goal.RandomStrollGoal;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.animal.IronGolem;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.npc.Villager;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.raid.Raider;
import net.minecraft.world.level.Level;

public class StarVampireEntity extends Monster {
    protected StarVampireEntity(EntityType<? extends Monster> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
    }
    public static int StarVampireMenaceGauge = 0;
    public static int StarVampireBloodCounter = 0;
    public static enum StarVampireBehaviour {
        IDLE,
        FLEEING,
        TOYING,
        HUNTING_ANIMAL,
        HUNTING_PLAYER,
        ASCENDING
    }
    public final AnimationState idle = new AnimationState();
    private int idleAnimationTimeout = 0;

    private void setupAnimationStates() {
        if (this.idleAnimationTimeout <=0) {
            this.idleAnimationTimeout = this.random.nextInt(40) + 80;
            this.idle.start(this.tickCount);
        } else {
            --this.idleAnimationTimeout;
        }
    }

    protected void registerGoals() {
        super.registerGoals();
        this.goalSelector.addGoal(0, new FloatGoal(this));
        this.goalSelector.addGoal(8, new RandomStrollGoal(this, 0.6));
        this.goalSelector.addGoal(9, new LookAtPlayerGoal(this, Player.class, 3.0F, 1.0F));
        this.goalSelector.addGoal(10, new LookAtPlayerGoal(this, Mob.class, 8.0F));
    }

    @Override
    public void tick() {
        super.tick();
        if (this.level().isClientSide) {
            setupAnimationStates();
        }
    }

    @Override
    protected void updateWalkAnimation(float pPartialTick) {
        float f;
        if (this.getPose() == Pose.STANDING) {
            f = Math.min(pPartialTick * 6F, 1F);
        } else {
            f = 0f;
        }
        this.walkAnimation.update(f, pPartialTick);
    }

    public static AttributeSupplier createStarVampireAttributes() {
        return Mob.createLivingAttributes()
                .add(Attributes.MAX_HEALTH, 300F)
                .add(Attributes.FOLLOW_RANGE, 24.0F)
                .add(Attributes.MOVEMENT_SPEED, 0.15F)
                .add(Attributes.ATTACK_DAMAGE, 16.0F)
                .add(Attributes.ATTACK_KNOCKBACK, 0.0F)
                .add(Attributes.KNOCKBACK_RESISTANCE, 1.0F)
                .add(Attributes.ARMOR, 16.0F)
                .add(Attributes.ARMOR_TOUGHNESS, 3.5F)
                .build();
    }
}

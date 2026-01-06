package com.sculkman.eldritchythings.common.entity;

import com.sculkman.eldritchythings.common.entity.goals.StarVampireAttackGoal;
import com.sculkman.eldritchythings.common.entity.goals.StarVampireIdleGoal;
import com.sculkman.eldritchythings.common.entity.goals.StarVampireTargetAnimalGoal;
import com.sculkman.eldritchythings.common.entity.goals.StarVampireTargetPlayerGoal;
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
import net.minecraft.world.entity.ai.goal.RandomStrollGoal;
import net.minecraft.world.entity.ai.goal.WaterAvoidingRandomStrollGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.animal.Pig;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;

public class StarVampireEntity extends Monster {
    protected StarVampireEntity(EntityType<? extends Monster> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
    }
    public static int StarVampireMenaceGauge = 0;
    public static int StarVampireBloodCounter = 0;
    public static int StarVampireHunger = 100;

    /*
    0 = Idle
    1 = Hunting Player
    2 = Hunting Animal
    3 = Toying
    While storing these as a *Int* is a death sentence, it will make checking for this way easier.
     */
    public static int StarVampireBehaviour = 0;

    private static final EntityDataAccessor<Boolean> ATTACKING =
            SynchedEntityData.defineId(StarVampireEntity.class, EntityDataSerializers.BOOLEAN);
    public final AnimationState idle = new AnimationState();
    private int idleAnimationTimeout = 0;
    public final AnimationState attack = new AnimationState();
    public int attackAnimationTimeout = 0;

    private void setupAnimationStates() {
        if (this.idleAnimationTimeout <=0) {
            this.idleAnimationTimeout = this.random.nextInt(40) + 80;
            this.idle.start(this.tickCount);
        } else {
            --this.idleAnimationTimeout;
        }

        if (this.isAttacking() && attackAnimationTimeout <=0) {
            attackAnimationTimeout = 15;
            attack.start(this.tickCount);
        } else {
            --this.attackAnimationTimeout;
        }
        if (!this.isAttacking()) {
            attack.stop();
        }
    }

    protected void registerGoals() {
        super.registerGoals();
        this.goalSelector.addGoal(0, new FloatGoal(this));
        this.targetSelector.addGoal(1, new StarVampireAttackGoal(this, 1.0D, true));
        this.goalSelector.addGoal(8, new WaterAvoidingRandomStrollGoal(this, 1.0));
        this.goalSelector.addGoal(9, new LookAtPlayerGoal(this, Player.class, 3.0F, 1.0F));
        this.goalSelector.addGoal(10, new LookAtPlayerGoal(this, Mob.class, 8.0F));
        this.goalSelector.addGoal(0, new StarVampireIdleGoal(this));
        this.targetSelector.addGoal(5, new StarVampireTargetPlayerGoal(this, Player.class, false));
        this.targetSelector.addGoal(6, new StarVampireTargetAnimalGoal(this, Animal.class, false));
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

    @Override
    protected void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(ATTACKING, false);
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
                .add(Attributes.MOVEMENT_SPEED, 0.35F)
                .add(Attributes.ATTACK_DAMAGE, 16.0F)
                .add(Attributes.ATTACK_KNOCKBACK, 0.0F)
                .add(Attributes.KNOCKBACK_RESISTANCE, 1.0F)
                .add(Attributes.ARMOR, 16.0F)
                .add(Attributes.ARMOR_TOUGHNESS, 3.5F)
                .build();
    }
}

package com.sculkman.eldritchythings.common.entity.goals;

import com.sculkman.eldritchythings.common.entity.RascalEntity;
import com.sculkman.eldritchythings.common.entity.StarVampireEntity;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.world.entity.monster.Ravager;

public class RascalMeleeAttackGoal  extends MeleeAttackGoal {
    public RascalMeleeAttackGoal(PathfinderMob pMob, double pSpeedModifier, boolean pFollowingTargetEvenIfNotSeen) {
        super(pMob, pSpeedModifier, pFollowingTargetEvenIfNotSeen);
        entity = ((RascalEntity) pMob);
    }

    private final RascalEntity entity;
    private int ticksUntilNextAttack = 7;
    private int attackdelay = 7;
    private boolean shouldCountUntilNextAttack = false;

    @Override
    public void start() {
        super.start();
        ticksUntilNextAttack = 7;
        attackdelay = 7;
    }

    //Kaupenjoe walked so that i can walk
    @Override
    protected void checkAndPerformAttack(LivingEntity pEnemy, double pDistToEnemySqr) {
        if (isEnemyWithinAttackDistance(pEnemy, pDistToEnemySqr)) {
            shouldCountUntilNextAttack = true;
            if (isTimeToStartAttackAnimation()) {
                entity.setAttacking(true);
            }

            if (isTimeToAttack()) {
                this.mob.getLookControl().setLookAt(pEnemy.getX(), pEnemy.getEyeY(), pEnemy.getZ());
                this.resetAttackCooldown();
                this.mob.swing(InteractionHand.MAIN_HAND);
                this.mob.doHurtTarget(pEnemy);
            }
        } else {
            resetAttackCooldown();
            shouldCountUntilNextAttack = false;
            entity.setAttacking(false);
            entity.attackAnimationTimeout = 7;
        }
    }

    protected double getAttackReachSqr(LivingEntity pAttackTarget) {
        return (double)(this.mob.getBbWidth() * 5.3F * this.mob.getBbWidth() * 5.3F + pAttackTarget.getBbWidth());
    }

    private boolean isEnemyWithinAttackDistance(LivingEntity pEnemy, double pDistToEnemySqr) {
        return pDistToEnemySqr <= this.getAttackReachSqr(pEnemy);
    }

    protected void resetAttackCooldown() {
        this.ticksUntilNextAttack = this.adjustedTickDelay(attackdelay * 2);
    }

    protected boolean isTimeToAttack() {
        return this.ticksUntilNextAttack <= 0;
    }

    protected boolean isTimeToStartAttackAnimation() {
        return this.ticksUntilNextAttack <= attackdelay;
    }

    protected int getTicksUntilNextAttack() {
        return this.ticksUntilNextAttack;
    }

    @Override
    public void tick() {
        super.tick();
        if (shouldCountUntilNextAttack) {
            this.ticksUntilNextAttack = Math.max(this.ticksUntilNextAttack - 1, 0);
        }
    }

    @Override
    public void stop() {
        entity.setAttacking(false);
        super.stop();
    }
}

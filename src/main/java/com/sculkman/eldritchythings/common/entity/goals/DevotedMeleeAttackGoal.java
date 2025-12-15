package com.sculkman.eldritchythings.common.entity.goals;

import com.sculkman.eldritchythings.common.effect.EldritchyThingsEffects;
import com.sculkman.eldritchythings.common.entity.DevotedEntity;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.ai.behavior.MeleeAttack;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.world.entity.monster.Ravager;

public class DevotedMeleeAttackGoal extends MeleeAttackGoal {
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
            pEnemy.addEffect(new MobEffectInstance(EldritchyThingsEffects.MADNESS.get(), 200, 0));
            this.resetAttackCooldown();
            this.mob.swing(InteractionHand.MAIN_HAND);
            this.mob.doHurtTarget(pEnemy);
        }
    }
}

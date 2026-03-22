package com.sculkman.eldritchythings.common.entity.goals;

import com.sculkman.eldritchythings.common.entity.RascalEntity;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;

public class NearestAttackbleTargetRascalGoal extends NearestAttackableTargetGoal {
    public NearestAttackbleTargetRascalGoal(RascalEntity pMob, Class pTargetType, boolean pMustSee) {
        super(pMob, pTargetType, pMustSee);
    }
    @Override
    public void start() {
        this.mob.setTarget(this.target);
        ((RascalEntity) mob).setCrashingOut(true);
        super.start();
    }

    @Override
    public void tick() {
        ((RascalEntity) mob).setInvisibleRascal(mob.distanceTo(target) >= 8);
        super.tick();
    }

    @Override
    public void stop() {
        ((RascalEntity) mob).setCrashingOut(false);
        super.stop();
    }

    @Override
    public boolean canContinueToUse() {
        return this.mob.getHealth() >= (this.mob.getMaxHealth() / 2);
    }

    @Override
    public boolean canUse() {
        if (this.randomInterval > 0 && this.mob.getRandom().nextInt(this.randomInterval) != 0 || this.mob.getHealth() <= (this.mob.getMaxHealth() / 2)) {
            return false;
        } else {
            this.findTarget();
            return this.target != null;
        }
    }
}

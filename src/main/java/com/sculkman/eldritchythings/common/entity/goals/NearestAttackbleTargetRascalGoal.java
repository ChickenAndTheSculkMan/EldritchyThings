package com.sculkman.eldritchythings.common.entity.goals;

import com.sculkman.eldritchythings.common.entity.RascalEntity;
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
    public void stop() {
        ((RascalEntity) mob).setCrashingOut(false);
        super.stop();
    }
}

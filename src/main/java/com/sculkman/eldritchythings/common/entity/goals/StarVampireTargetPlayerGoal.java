package com.sculkman.eldritchythings.common.entity.goals;

import com.sculkman.eldritchythings.common.entity.StarVampireEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;

public class StarVampireTargetPlayerGoal extends NearestAttackableTargetGoal {
    public StarVampireTargetPlayerGoal(Mob pMob, Class pTargetType, boolean pMustSee) {
        super(pMob, pTargetType, pMustSee);
    }

    @Override
    public void start() {
        if (StarVampireEntity.StarVampireBehaviour == 1) {
            super.start();
            this.mob.setTarget(this.target);
        } else {
            super.stop();
        }
    }

    @Override
    public boolean canUse() {
        return true;
    }
}

package com.sculkman.eldritchythings.common.entity.goals;

import com.sculkman.eldritchythings.common.entity.StarVampireEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.phys.AABB;

public class StarVampireTargetAnimalGoal extends NearestAttackableTargetGoal<Animal> {
    public StarVampireTargetAnimalGoal(Mob pMob, Class pTargetType, boolean pMustSee) {
        super(pMob, pTargetType, pMustSee);
    }

    @Override
    public boolean canUse() {
        if (this.randomInterval > 0 && this.mob.getRandom().nextInt(this.randomInterval) != 0) {
            return false;
        } else if (StarVampireEntity.StarVampireHunger <= 50) {
            this.findTarget();
            return this.target != null;
        } else {
            return false;
        }
    }
}

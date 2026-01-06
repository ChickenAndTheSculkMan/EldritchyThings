package com.sculkman.eldritchythings.common.entity.goals;

import com.sculkman.eldritchythings.common.entity.DevotedEntity;
import com.sculkman.eldritchythings.common.entity.StarVampireEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.goal.Goal;
import org.lwjgl.system.MathUtil;

import java.util.EnumSet;
import java.util.Random;

public class StarVampireIdleGoal extends Goal {
    private final StarVampireEntity starVampire;

    public StarVampireIdleGoal(StarVampireEntity pStarVampire) {
        this.starVampire = pStarVampire;
    }
    @Override
    public boolean canUse() {
        return true;
    }

    @Override
    public void tick() {
        super.tick();
        this.behaviourChecker();
        int nourishment = (int)(Math.random() * StarVampireEntity.StarVampireHunger) * 5;
        if (nourishment == StarVampireEntity.StarVampireHunger) {
            StarVampireEntity.StarVampireHunger--;
        }
    }

    public void behaviourChecker() {
        if (StarVampireEntity.StarVampireHunger > 50) {
            StarVampireEntity.StarVampireBehaviour = 0;
        }
        if (StarVampireEntity.StarVampireHunger <= 50 && StarVampireEntity.StarVampireHunger >= 1) {
            StarVampireEntity.StarVampireBehaviour = 2;
        }
        if (StarVampireEntity.StarVampireHunger == 0) {
            StarVampireEntity.StarVampireBehaviour = 1;
        }
    }

    @Override
    public void start() {
        super.start();
    }

    @Override
    public void stop() {
        super.stop();
    }
}

package com.sculkman.eldritchythings.common.entity.goals;

import com.sculkman.eldritchythings.common.entity.EldritchyThingsEntities;
import com.sculkman.eldritchythings.common.entity.RascalEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.behavior.AnimalPanic;
import net.minecraft.world.entity.ai.goal.FleeSunGoal;
import net.minecraft.world.entity.ai.goal.PanicGoal;
import net.minecraft.world.entity.ai.util.DefaultRandomPos;
import net.minecraft.world.entity.monster.Evoker;
import net.minecraft.world.entity.monster.Vex;
import net.minecraft.world.entity.monster.Zombie;
import net.minecraft.world.level.NaturalSpawner;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.event.ForgeEventFactory;
import net.minecraftforge.event.entity.living.ZombieEvent;
import net.minecraftforge.eventbus.api.Event;

import java.util.Objects;

public class RascalFleeGoal extends PanicGoal {
    public RascalFleeGoal(PathfinderMob pMob, double pSpeedModifier) {
        super(pMob, pSpeedModifier);
    }

    @Override
    public boolean canUse() {
        if (shouldPanic() == true) {
            return this.findRandomPosition();
        } else {
            return false;
        }
    }

    @Override
    public void tick() {
        if (mob.getLastHurtByMob() != null) {
            ((RascalEntity) mob).setInvisibleRascal(mob.distanceTo(mob.getLastHurtByMob()) >= 6);
        }
        this.mob.heal(0.1F);
        super.tick();
    }

    @Override
    protected boolean shouldPanic() {
        return this.mob.getHealth() <= (this.mob.getMaxHealth() / 2);
    }
    //protected final RandomSource random;
    @Override
    public void stop() {
    /*    if (!this.mob.hurtMarked) {
            ServerLevel serverlevel = (ServerLevel)this.mob.level();
            for(int i = 0; i < this.random.nextInt(3); ++i) {
                BlockPos blockpos = this.mob.blockPosition().offset(-2 + this.random.nextInt(5), 0, -2 + this.random.nextInt(5));
                RascalEntity rascal = (RascalEntity)EldritchyThingsEntities.RASCAL.get().create(this.mob.level());
                if (rascal != null) {
                    rascal.setInvisible(true);
                    rascal.moveTo(blockpos, 0.0F, 0.0F);
                    rascal.finalizeSpawn(serverlevel, this.mob.level().getCurrentDifficultyAt(blockpos), MobSpawnType.REINFORCEMENT, (SpawnGroupData)null, (CompoundTag)null);
                    serverlevel.addFreshEntityWithPassengers(rascal);
                }
            }
            this.mob.heal(40F);
            }*/
        this.mob.heal(1.0F);
        super.stop();
    }
}

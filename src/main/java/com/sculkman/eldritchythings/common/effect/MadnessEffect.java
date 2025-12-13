package com.sculkman.eldritchythings.common.effect;

import com.sculkman.eldritchythings.common.entity.EldritchyThingsEntities;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.npc.Villager;
import net.minecraft.world.entity.player.Player;
import org.lwjgl.system.MathUtil;

import javax.net.ssl.KeyManager;
import java.util.Random;

public class MadnessEffect extends MobEffect {
    protected MadnessEffect(MobEffectCategory pCategory, int pColor) {
        super(pCategory, pColor);
    }

    @Override
    public void applyEffectTick(LivingEntity pLivingEntity, int pAmplifier) {
        super.applyEffectTick(pLivingEntity, pAmplifier);
        if (pLivingEntity instanceof Villager) {
            ((Villager) pLivingEntity).convertTo(EldritchyThingsEntities.DEVOTED.get(), false);
        }
        int random = (int)(Math.random() * 4) + 1;
        if (random == 4) {
            pLivingEntity.hurt(pLivingEntity.damageSources().freeze(), pAmplifier);
        }
    }

    @Override
    public boolean isDurationEffectTick(int pDuration, int pAmplifier) {
        int k = 50 >> pAmplifier;
        if (k > 0) {
            return pDuration % k == 0;
        } else {
            return true;
        }
    }
}

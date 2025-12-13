package com.sculkman.eldritchythings.common.item;

import com.sculkman.eldritchythings.common.effect.EldritchyThingsEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tier;

public class YellowDaggerItem extends SwordItem {
    public YellowDaggerItem(Tier pTier, int pAttackDamageModifier, float pAttackSpeedModifier, Properties pProperties) {
        super(pTier, pAttackDamageModifier, pAttackSpeedModifier, pProperties);
    }

    @Override
    public boolean hurtEnemy(ItemStack pStack, LivingEntity pTarget, LivingEntity pAttacker) {
        pTarget.addEffect(new MobEffectInstance(EldritchyThingsEffects.MADNESS.get(), 200, 0));
        return super.hurtEnemy(pStack, pTarget, pAttacker);
    }
}

package com.sculkman.eldritchythings.common.effect;

import com.sculkman.eldritchythings.EldritchyThings;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffects;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class EldritchyThingsEffects {
    public static final DeferredRegister<MobEffect> EFFECT =
            DeferredRegister.create(ForgeRegistries.MOB_EFFECTS, EldritchyThings.MODID);
    public static final RegistryObject<MobEffect> MADNESS = EFFECT.register("madness", () ->
            new MadnessEffect(MobEffectCategory.HARMFUL, 12624973));
}

package com.sculkman.eldritchythings.common.entity;

import com.sculkman.eldritchythings.EldritchyThings;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class EldritchyThingsEntities {
    public static final DeferredRegister<EntityType<?>> ENTITIES =
            DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, EldritchyThings.MODID);

    public static final RegistryObject<EntityType<DevotedEntity>> DEVOTED =
            ENTITIES.register("devoted", () -> EntityType.Builder.of(DevotedEntity::new, MobCategory.MONSTER)
                    .sized(0.7f, 1.9f).build("devoted"));
}

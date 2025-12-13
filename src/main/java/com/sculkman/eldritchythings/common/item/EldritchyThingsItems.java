package com.sculkman.eldritchythings.common.item;

import com.sculkman.eldritchythings.EldritchyThings;
import com.sculkman.eldritchythings.common.entity.EldritchyThingsEntities;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.*;
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class EldritchyThingsItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, EldritchyThings.MODID);

    public static final RegistryObject<Item> YELLOW_DAGGER = ITEMS.register("yellow_dagger", () ->
            new YellowDaggerItem(Tiers.IRON, 2, -1.8F, new Item.Properties().defaultDurability(950)
                    .rarity(Rarity.UNCOMMON)));
    public static final RegistryObject<Item> DEVOTED_SPAWN_EGG = ITEMS.register("devoted_spawn_egg", () ->
            new ForgeSpawnEggItem(EldritchyThingsEntities.DEVOTED, 15582019, 1973274, new Item.Properties()));
}

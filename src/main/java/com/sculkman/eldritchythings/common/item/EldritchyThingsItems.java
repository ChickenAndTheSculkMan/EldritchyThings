package com.sculkman.eldritchythings.common.item;

import com.sculkman.eldritchythings.EldritchyThings;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tiers;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class EldritchyThingsItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, EldritchyThings.MODID);

    public static final RegistryObject<Item> YELLOW_DAGGER = ITEMS.register("yellow_dagger", () -> new SwordItem(Tiers.IRON, 2, -1.8F, new Item.Properties().defaultDurability(350).rarity(Rarity.UNCOMMON)));
}

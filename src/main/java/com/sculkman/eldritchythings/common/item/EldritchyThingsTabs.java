package com.sculkman.eldritchythings.common.item;

import com.sculkman.eldritchythings.EldritchyThings;
import com.sculkman.eldritchythings.common.blocks.EldritchyThingsBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class EldritchyThingsTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, EldritchyThings.MODID);
    public static final RegistryObject<CreativeModeTab> EXAMPLE_TAB = CREATIVE_MODE_TABS.register("example_tab", () -> CreativeModeTab.builder()
            .withTabsBefore(CreativeModeTabs.COMBAT)
            .icon(() -> EldritchyThingsItems.EXAMPLE_ITEM.get().getDefaultInstance())
            .displayItems((parameters, output) -> {
                //Add ITEMS. here, do not add actual blocks!
                output.accept(EldritchyThingsItems.EXAMPLE_ITEM.get());
                output.accept(EldritchyThingsBlocks.EXAMPLE_BLOCK_ITEM.get());
            }).build());
}

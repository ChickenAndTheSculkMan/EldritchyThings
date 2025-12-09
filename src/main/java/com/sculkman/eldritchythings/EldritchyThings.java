package com.sculkman.eldritchythings;

import com.mojang.logging.LogUtils;
import com.sculkman.eldritchythings.common.blocks.EldritchyThingsBlocks;
import com.sculkman.eldritchythings.common.item.EldritchyThingsItems;
import com.sculkman.eldritchythings.common.item.EldritchyThingsTabs;
import net.minecraft.client.Minecraft;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.slf4j.Logger;

@Mod(EldritchyThings.MODID)
public class EldritchyThings
{
    public static final String MODID = "eldritchy_things";
    private static final Logger LOGGER = LogUtils.getLogger();

    public EldritchyThings(FMLJavaModLoadingContext context)
    {
        IEventBus modEventBus = context.getModEventBus();
        //Okay so lowk i gotta explain this to myself (first time forge modder)
        //CommonSetup is some wacky lil thing that registers for both client and server(?)
        //Every Content Stuff Thingy Requires a Deferred Register in the mod event bus so that it can get
        //registered (for example:
        //BLOCKS.register(modEventBus);
        //ITEMS.register(modEventBus);
        //modEventBus.addListener(this::addCreative) registers items into a creative tab
        //I hate Configs

        modEventBus.addListener(this::commonSetup);
        EldritchyThingsBlocks.BLOCKS.register(modEventBus);
        EldritchyThingsItems.ITEMS.register(modEventBus);
        EldritchyThingsTabs.CREATIVE_MODE_TABS.register(modEventBus);
        MinecraftForge.EVENT_BUS.register(this);
        //modEventBus.addListener(this::addCreative);

        // Register our mod's ForgeConfigSpec so that Forge can create and load the config file for us
        context.registerConfig(ModConfig.Type.COMMON, Config.SPEC);
    }

    private void commonSetup(final FMLCommonSetupEvent event)
    {
        LOGGER.info("Cooking up some Starry Vampires in the oven! (Eldritchy Things (Common) loaded)");
    }

    // Add the example block item to the building blocks tab
    //private void addCreative(BuildCreativeModeTabContentsEvent event)
    //{
    //    if (event.getTabKey() == CreativeModeTabs.BUILDING_BLOCKS)
    //        event.accept(EXAMPLE_BLOCK_ITEM);
    //}

    // You can use SubscribeEvent and let the Event Bus discover methods to call
    //@SubscribeEvent
    //public void onServerStarting(ServerStartingEvent event)
    //{
    //    // Do something when the server starts
    //    LOGGER.info("HELLO from server starting");
    //}
    //
    // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
    //@Mod.EventBusSubscriber(modid = MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    //public static class ClientModEvents
    //{
    //    @SubscribeEvent
    //    public static void onClientSetup(FMLClientSetupEvent event)
    //    {
    //        // Some client setup code
    //        LOGGER.info("HELLO FROM CLIENT SETUP");
    //        LOGGER.info("MINECRAFT NAME >> {}", Minecraft.getInstance().getUser().getName());
    //    }
    //}
}

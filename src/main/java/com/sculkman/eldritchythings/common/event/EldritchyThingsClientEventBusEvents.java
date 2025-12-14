package com.sculkman.eldritchythings.common.event;

import com.sculkman.eldritchythings.EldritchyThings;
import com.sculkman.eldritchythings.client.entity.EldritchyThingsModelLayer;
import com.sculkman.eldritchythings.client.entity.StarVampireModel;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = EldritchyThings.MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class EldritchyThingsClientEventBusEvents {
    @SubscribeEvent
    public static void registerLayers(EntityRenderersEvent.RegisterLayerDefinitions event) {
        event.registerLayerDefinition(EldritchyThingsModelLayer.STAR_VAMPIRE, StarVampireModel::createBodyLayer);
    }
}

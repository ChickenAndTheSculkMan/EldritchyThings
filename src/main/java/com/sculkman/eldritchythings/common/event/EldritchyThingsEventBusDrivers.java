package com.sculkman.eldritchythings.common.event;

import com.sculkman.eldritchythings.EldritchyThings;
import com.sculkman.eldritchythings.common.entity.DevotedEntity;
import com.sculkman.eldritchythings.common.entity.EldritchyThingsEntities;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = EldritchyThings.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class EldritchyThingsEventBusDrivers {
    @SubscribeEvent
    public static void registerAttributes(EntityAttributeCreationEvent event) {
        event.put(EldritchyThingsEntities.DEVOTED.get(), DevotedEntity.createDevotedAttributes());
    }
}

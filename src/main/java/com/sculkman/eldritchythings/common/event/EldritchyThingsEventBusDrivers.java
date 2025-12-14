package com.sculkman.eldritchythings.common.event;

import com.sculkman.eldritchythings.EldritchyThings;
import com.sculkman.eldritchythings.common.entity.DevotedEntity;
import com.sculkman.eldritchythings.common.entity.EldritchyThingsEntities;
import com.sculkman.eldritchythings.common.entity.StarVampireEntity;
import net.minecraft.world.entity.SpawnPlacements;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.event.entity.SpawnPlacementRegisterEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = EldritchyThings.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class EldritchyThingsEventBusDrivers {
    @SubscribeEvent
    public static void registerAttributes(EntityAttributeCreationEvent event) {
        event.put(EldritchyThingsEntities.DEVOTED.get(), DevotedEntity.createDevotedAttributes());
        event.put(EldritchyThingsEntities.STAR_VAMPIRE.get(), StarVampireEntity.createStarVampireAttributes());
    }

    @SubscribeEvent
    public static void registerSpawnPlacemenetEvents(SpawnPlacementRegisterEvent event) {
        event.register(EldritchyThingsEntities.DEVOTED.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Monster::checkMonsterSpawnRules, SpawnPlacementRegisterEvent.Operation.REPLACE);
    }
}

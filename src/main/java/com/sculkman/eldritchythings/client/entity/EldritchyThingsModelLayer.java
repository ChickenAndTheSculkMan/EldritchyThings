package com.sculkman.eldritchythings.client.entity;

import com.sculkman.eldritchythings.EldritchyThings;
import com.sculkman.eldritchythings.common.entity.EldritchyThingsEntities;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.resources.ResourceLocation;

public class EldritchyThingsModelLayer {
    public static final ModelLayerLocation DEVOTED = new ModelLayerLocation(
            new ResourceLocation(EldritchyThings.MODID, "devoted_layer"), "devoted");
    public static final ModelLayerLocation STAR_VAMPIRE = new ModelLayerLocation(
            new ResourceLocation("star_vampire_layer"), "star_vampire");
}

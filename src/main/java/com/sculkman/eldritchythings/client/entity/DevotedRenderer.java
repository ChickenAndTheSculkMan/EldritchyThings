package com.sculkman.eldritchythings.client.entity;

import com.mojang.blaze3d.vertex.PoseStack;
import com.sculkman.eldritchythings.EldritchyThings;
import com.sculkman.eldritchythings.common.entity.DevotedEntity;
import net.minecraft.client.model.IllagerModel;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.IllagerRenderer;
import net.minecraft.client.renderer.entity.layers.ItemInHandLayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.monster.Vindicator;

@SuppressWarnings("deprecated")
public class DevotedRenderer extends IllagerRenderer<DevotedEntity> {
    private static final ResourceLocation DEVOTED = new ResourceLocation(EldritchyThings.MODID,"textures/entity/devoted.png");

    public DevotedRenderer(EntityRendererProvider.Context p_174439_) {
        super(p_174439_, new IllagerModel(p_174439_.bakeLayer(ModelLayers.VINDICATOR)), 0.5F);
        this.addLayer(new ItemInHandLayer<DevotedEntity, IllagerModel<DevotedEntity>>(this, p_174439_.getItemInHandRenderer()) {
            public void render(PoseStack p_116352_, MultiBufferSource p_116353_, int p_116354_, DevotedEntity p_116355_, float p_116356_, float p_116357_, float p_116358_, float p_116359_, float p_116360_, float p_116361_) {
                if (p_116355_.isAggressive()) {
                    super.render(p_116352_, p_116353_, p_116354_, p_116355_, p_116356_, p_116357_, p_116358_, p_116359_, p_116360_, p_116361_);
                }

            }
        });
    }

    @Override
    public ResourceLocation getTextureLocation(DevotedEntity devotedEntity) {
        return DEVOTED;
    }

}

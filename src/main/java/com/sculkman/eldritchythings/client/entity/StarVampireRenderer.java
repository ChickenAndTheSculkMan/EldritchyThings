package com.sculkman.eldritchythings.client.entity;

import com.mojang.blaze3d.vertex.PoseStack;
import com.sculkman.eldritchythings.EldritchyThings;
import com.sculkman.eldritchythings.common.entity.StarVampireEntity;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.culling.Frustum;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.LivingEntityRenderer;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;

public class StarVampireRenderer extends MobRenderer<StarVampireEntity, StarVampireModel<StarVampireEntity>> {
    public StarVampireRenderer(EntityRendererProvider.Context pContext) {
        super(pContext, new StarVampireModel<>(pContext.bakeLayer(EldritchyThingsModelLayer.STAR_VAMPIRE)), 0f);
    }

    @Override
    public ResourceLocation getTextureLocation(StarVampireEntity starVampireEntity) {
        if (StarVampireEntity.StarVampireBloodCounter >=2 && StarVampireEntity.StarVampireBloodCounter <=7) {
            return new ResourceLocation(EldritchyThings.MODID, "textures/entity/star_vampire_texture2.png");
        }
        if (StarVampireEntity.StarVampireBloodCounter >=8 && StarVampireEntity.StarVampireBloodCounter <=12) {
            return new ResourceLocation(EldritchyThings.MODID, "textures/entity/star_vampire_texture3.png");
        }
        if (StarVampireEntity.StarVampireBloodCounter >=13 && StarVampireEntity.StarVampireBloodCounter <=24) {
            return new ResourceLocation(EldritchyThings.MODID, "textures/entity/star_vampire_texture4.png");
        }
        if (StarVampireEntity.StarVampireBloodCounter >=25) {
            return new ResourceLocation(EldritchyThings.MODID, "textures/entity/star_vampire_texture5.png");
        }
        else {
            //return new ResourceLocation(EldritchyThings.MODID, "textures/entity/star_vampire_texture.png");
            return new ResourceLocation(EldritchyThings.MODID, "textures/entity/star_vampire_texture.png");
        }
    }

    @Override
    public void render(StarVampireEntity pEntity, float pEntityYaw, float pPartialTicks, PoseStack pPoseStack, MultiBufferSource pBuffer, int pPackedLight) {
        super.render(pEntity, pEntityYaw, pPartialTicks, pPoseStack, pBuffer, pPackedLight);
    }
}

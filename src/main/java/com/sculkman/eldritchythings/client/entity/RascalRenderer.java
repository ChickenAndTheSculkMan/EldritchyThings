package com.sculkman.eldritchythings.client.entity;

import com.mojang.blaze3d.vertex.PoseStack;
import com.sculkman.eldritchythings.EldritchyThings;
import com.sculkman.eldritchythings.common.entity.RascalEntity;
import com.sculkman.eldritchythings.common.entity.StarVampireEntity;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.culling.Frustum;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class RascalRenderer extends MobRenderer<RascalEntity, RascalModel<RascalEntity>> {
    public RascalRenderer(EntityRendererProvider.Context pContext) {
        super(pContext, new RascalModel<>(pContext.bakeLayer(EldritchyThingsModelLayer.RASCAL)), 0.4f);
    }

    @Override
    public ResourceLocation getTextureLocation(RascalEntity rascalEntity) {
            return new ResourceLocation(EldritchyThings.MODID, "textures/entity/rascal.png");
    }

    @Override
    public boolean shouldRender(RascalEntity pLivingEntity, Frustum pCamera, double pCamX, double pCamY, double pCamZ) {
        return !pLivingEntity.isInvisbleRascal();
    }

    @Override
    public void render(RascalEntity pEntity, float pEntityYaw, float pPartialTicks, PoseStack pPoseStack, MultiBufferSource pBuffer, int pPackedLight) {
        super.render(pEntity, pEntityYaw, pPartialTicks, pPoseStack, pBuffer, pPackedLight);
    }
}

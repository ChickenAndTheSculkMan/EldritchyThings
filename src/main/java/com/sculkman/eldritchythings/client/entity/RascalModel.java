package com.sculkman.eldritchythings.client.entity;// Made with Blockbench 5.0.7
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports


import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.sculkman.eldritchythings.client.entity.animation.RascalAnim;
import com.sculkman.eldritchythings.client.entity.animation.StarVampireAnim;
import com.sculkman.eldritchythings.common.entity.RascalEntity;
import com.sculkman.eldritchythings.common.entity.StarVampireEntity;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;

public class RascalModel<T extends Entity> extends HierarchicalModel<T> {
	private final ModelPart root2;
	private final ModelPart head;
	public RascalModel(ModelPart root) {
		this.root2 = root.getChild("root2");
		this.head = this.root2.getChild("head");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition root2 = partdefinition.addOrReplaceChild("root2", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition right_leg = root2.addOrReplaceChild("right_leg", CubeListBuilder.create().texOffs(16, 30).addBox(-1.1F, 0.0F, -1.0F, 2.0F, 15.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(-1.9F, -15.0F, 0.0F));

		PartDefinition left_leg = root2.addOrReplaceChild("left_leg", CubeListBuilder.create().texOffs(24, 30).addBox(-0.9F, 0.0F, -1.0F, 2.0F, 15.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(1.9F, -15.0F, 0.0F));

		PartDefinition body = root2.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 12).addBox(-4.0F, 0.0F, -1.0F, 8.0F, 9.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -24.0F, 0.0F, 0.0436F, 0.0F, 0.0F));

		PartDefinition cube_r1 = body.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(24, 7).addBox(1.0F, -1.0F, -1.0F, 0.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.0F, 5.0F, 1.0F, -1.9635F, 0.0F, 0.0F));

		PartDefinition cube_r2 = body.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(24, 0).addBox(1.0F, -2.0F, -2.0F, 0.0F, 3.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.0F, 2.0F, 1.0F, -1.7017F, 0.0F, 0.0F));

		PartDefinition head = root2.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 0).addBox(-3.0F, -6.0F, -3.0F, 6.0F, 6.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -24.0F, 0.0F, 0.0436F, 0.0F, 0.0F));

		PartDefinition mandibles_a = head.addOrReplaceChild("mandibles_a", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition bone1 = mandibles_a.addOrReplaceChild("bone1", CubeListBuilder.create(), PartPose.offset(-3.0F, -1.0F, 0.0F));

		PartDefinition cube_r3 = bone1.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(30, 8).addBox(-0.2929F, -1.2929F, -0.05F, 3.0F, 2.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, -3.0F, 0.0F, 0.0F, 0.7854F));

		PartDefinition bone2 = mandibles_a.addOrReplaceChild("bone2", CubeListBuilder.create(), PartPose.offset(4.0F, -1.0F, 0.0F));

		PartDefinition cube_r4 = bone2.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(30, 10).addBox(-2.7071F, -1.2929F, -0.05F, 3.0F, 2.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.0F, 0.0F, -3.0F, 0.0F, 0.0F, -0.7854F));

		PartDefinition mandibles_b = head.addOrReplaceChild("mandibles_b", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition cube_r5 = mandibles_b.addOrReplaceChild("cube_r5", CubeListBuilder.create().texOffs(20, 21).addBox(-1.0F, -2.0F, -6.0F, 2.0F, 0.0F, 9.0F, new CubeDeformation(0.0F))
		.texOffs(20, 12).addBox(7.0F, -2.0F, -6.0F, 2.0F, 0.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.0F, -4.0F, 2.0F, 1.5708F, 0.0F, 0.0F));

		PartDefinition right_arm = root2.addOrReplaceChild("right_arm", CubeListBuilder.create().texOffs(0, 23).addBox(-0.7304F, 0.1134F, -1.0F, 2.0F, 17.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-5.0F, -24.0F, 0.0F, 0.0F, 0.0F, 0.1309F));

		PartDefinition claw = right_arm.addOrReplaceChild("claw", CubeListBuilder.create().texOffs(38, 0).addBox(-2.0F, 13.0F, 0.0F, 3.0F, 5.0F, 0.0F, new CubeDeformation(0.0F))
		.texOffs(38, 30).addBox(1.0F, 13.0F, 0.0F, 3.0F, 5.0F, 0.0F, new CubeDeformation(0.0F))
		.texOffs(32, 0).addBox(1.0F, 13.0F, -3.0F, 0.0F, 5.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(-0.7304F, 2.1134F, 0.0F));

		PartDefinition left_arm = root2.addOrReplaceChild("left_arm", CubeListBuilder.create().texOffs(8, 23).mirror().addBox(-1.2696F, 0.1134F, -1.0F, 2.0F, 17.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(5.0F, -24.0F, 0.0F, 0.0F, 0.0F, -0.1309F));

		PartDefinition claw2 = left_arm.addOrReplaceChild("claw2", CubeListBuilder.create().texOffs(38, 0).mirror().addBox(-1.0F, 13.0F, 0.0F, 3.0F, 5.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(38, 30).mirror().addBox(-4.0F, 13.0F, 0.0F, 3.0F, 5.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(32, 0).addBox(-1.0F, 13.0F, -3.0F, 0.0F, 5.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.7304F, 2.1134F, 0.0F));

		return LayerDefinition.create(meshdefinition, 64, 64);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.root2.getAllParts().forEach(ModelPart::resetPose);
		this.applyHeadRotation(netHeadYaw, headPitch, ageInTicks);

		this.animateWalk(RascalAnim.walk, limbSwing, limbSwingAmount, 2.5f, 1.0f);
		this.animate(((RascalEntity) entity).idle, RascalAnim.idle2, ageInTicks, 1f);
		this.animate(((RascalEntity) entity).attack, RascalAnim.attack, ageInTicks, 2f);
		this.animate(((RascalEntity) entity).crashing_out, RascalAnim.crashing_out, ageInTicks, 1f);
	}
	//Thank you kauepenjoe
	private void applyHeadRotation(float pNetHeadYaw, float pHeadPitch, float pAgeInTicks) {
		pNetHeadYaw = Mth.clamp(pNetHeadYaw, -30.0f, 30.0f);
		pHeadPitch = Mth.clamp(pHeadPitch, -25.0f, 45.0f);

		this.head.yRot = pNetHeadYaw * ((float)Math.PI / 180F);
		this.head.xRot = pHeadPitch * ((float)Math.PI / 180F);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		root2.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	@Override
	public ModelPart root() {
		return root2;
	}
}
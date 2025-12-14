package com.sculkman.eldritchythings.client.entity;// Made with Blockbench 5.0.5
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports


import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.sculkman.eldritchythings.EldritchyThings;
import com.sculkman.eldritchythings.client.entity.animation.StarVampireAnim;
import com.sculkman.eldritchythings.common.entity.EldritchyThingsEntities;
import com.sculkman.eldritchythings.common.entity.StarVampireEntity;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;

public class StarVampireModel<T extends Entity> extends HierarchicalModel<T> {
	private final ModelPart root;
	private final ModelPart head;

	public StarVampireModel(ModelPart root) {
		this.root = root.getChild("root");
		this.head = this.root.getChild("head");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition root = partdefinition.addOrReplaceChild("root", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition body = root.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 0).addBox(-12.0F, -18.0F, -13.0F, 22.0F, 10.0F, 28.0F, new CubeDeformation(0.0F))
		.texOffs(64, 38).addBox(-10.0F, -8.0F, -11.0F, 16.0F, 1.0F, 23.0F, new CubeDeformation(0.0F))
		.texOffs(30, 90).addBox(-1.0F, -8.0F, -1.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(38, 90).addBox(-7.0F, -8.0F, -5.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(46, 90).addBox(-7.0F, -8.0F, 6.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(54, 90).addBox(7.0F, -9.0F, 6.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(30, 94).addBox(7.0F, -9.0F, -7.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(38, 94).addBox(3.0F, -8.0F, -10.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(46, 94).addBox(3.0F, -13.0F, -14.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(54, 94).addBox(-13.0F, -11.0F, -3.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(102, 116).addBox(-13.0F, -14.0F, 0.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(30, 118).addBox(-13.0F, -17.0F, -4.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(38, 118).addBox(-13.0F, -17.0F, 9.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(46, 118).addBox(-13.0F, -12.0F, 5.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(54, 118).addBox(-13.0F, -12.0F, 12.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(94, 116).addBox(-11.0F, -11.0F, -14.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(100, 33).addBox(-2.0F, -13.0F, -14.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(108, 29).addBox(4.0F, -16.0F, -14.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(62, 118).addBox(-3.0F, -24.0F, -6.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(86, 120).addBox(-3.0F, -24.0F, 2.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(120, 86).addBox(-5.0F, -23.0F, 7.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(120, 90).addBox(3.0F, -21.0F, -2.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(0, 119).addBox(-8.0F, -28.0F, -6.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(8, 119).addBox(-8.0F, -24.0F, -11.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(16, 119).addBox(-13.0F, -24.0F, -8.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(70, 120).addBox(-14.0F, -15.0F, -10.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(78, 120).addBox(-13.0F, -7.0F, -7.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(112, 86).addBox(8.0F, -16.0F, -14.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(112, 90).addBox(9.0F, -16.0F, -11.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(112, 94).addBox(9.0F, -12.0F, -9.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(30, 114).addBox(9.0F, -17.0F, -6.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(38, 114).addBox(9.0F, -12.0F, 2.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(46, 114).addBox(9.0F, -15.0F, 9.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(54, 114).addBox(9.0F, -12.0F, 14.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(62, 114).addBox(4.0F, -16.0F, 14.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(116, 29).addBox(2.0F, -13.0F, 14.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(116, 33).addBox(-3.0F, -15.0F, 14.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(70, 116).addBox(-9.0F, -11.0F, 14.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(78, 116).addBox(-11.0F, -14.0F, 14.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(86, 116).addBox(-10.0F, -17.0F, 14.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(108, 33).addBox(9.0F, -15.0F, -14.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(100, 29).addBox(-8.0F, -16.0F, -14.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition cube_r1 = body.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(0, 90).addBox(-3.0F, -2.0F, -3.0F, 8.0F, 22.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-8.0F, -25.0F, -5.0F, -0.3054F, 0.5672F, 0.0F));

		PartDefinition cube_r2 = body.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(30, 99).addBox(-5.0F, -7.0F, -3.0F, 14.0F, 8.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-5.0F, -8.0F, 10.0F, 1.0173F, -1.0644F, -0.855F));

		PartDefinition cube_r3 = body.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(110, 111).addBox(-5.0F, -7.0F, -1.0F, 14.0F, 7.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(6.0F, -8.0F, 0.0F, 2.4577F, 0.8593F, 2.6891F));

		PartDefinition cube_r4 = body.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(100, 0).addBox(-9.0F, -2.0F, -1.0F, 10.0F, 8.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.0F, -17.0F, -5.0F, -0.0546F, -0.6876F, 0.4876F));

		PartDefinition cube_r5 = body.addOrReplaceChild("cube_r5", CubeListBuilder.create().texOffs(64, 86).addBox(-18.0F, -6.0F, 0.0F, 19.0F, 8.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-10.0F, -17.0F, 5.0F, -0.5711F, 0.0905F, 3.0748F));

		PartDefinition cube_r6 = body.addOrReplaceChild("cube_r6", CubeListBuilder.create().texOffs(64, 62).addBox(-18.0F, -8.0F, 0.0F, 19.0F, 14.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.0F, -17.0F, -2.0F, -2.3949F, 0.6557F, 0.5049F));

		PartDefinition cube_r7 = body.addOrReplaceChild("cube_r7", CubeListBuilder.create().texOffs(72, 99).addBox(-9.0F, -2.0F, -1.0F, 10.0F, 8.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.0F, -17.0F, 6.0F, 2.3426F, 0.4487F, -0.7453F));

		PartDefinition cube_r8 = body.addOrReplaceChild("cube_r8", CubeListBuilder.create().texOffs(110, 99).addBox(-9.0F, -2.0F, -1.0F, 10.0F, 3.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.0F, -17.0F, 6.0F, -3.0672F, -0.9684F, -2.75F));

		PartDefinition cube_r9 = body.addOrReplaceChild("cube_r9", CubeListBuilder.create().texOffs(100, 17).addBox(-9.0F, -2.0F, -1.0F, 10.0F, 3.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.0F, -17.0F, 0.0F, 0.2182F, -0.6109F, 0.0F));

		PartDefinition leg_1 = root.addOrReplaceChild("leg_1", CubeListBuilder.create().texOffs(30, 90).addBox(-20.0F, -5.0F, -22.0F, 3.0F, 5.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition cube_r10 = leg_1.addOrReplaceChild("cube_r10", CubeListBuilder.create().texOffs(54, 90).addBox(-1.0F, -2.0F, -2.0F, 2.0F, 7.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-18.0F, -8.0F, -19.0F, -0.1745F, 0.2618F, 0.0F));

		PartDefinition cube_r11 = leg_1.addOrReplaceChild("cube_r11", CubeListBuilder.create().texOffs(8, 129).addBox(-1.0F, -2.0F, -1.0F, 2.0F, 6.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-19.0F, -13.0F, -20.0F, 2.9234F, -0.9163F, 3.1416F));

		PartDefinition cube_r12 = leg_1.addOrReplaceChild("cube_r12", CubeListBuilder.create().texOffs(86, 116).addBox(-2.0F, -5.0F, -1.0F, 4.0F, 7.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-17.0F, -18.0F, -18.0F, 2.5744F, 0.7418F, 0.0F));

		PartDefinition cube_r13 = leg_1.addOrReplaceChild("cube_r13", CubeListBuilder.create().texOffs(72, 116).addBox(-2.0F, -5.0F, -1.0F, 4.0F, 7.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-14.0F, -18.0F, -15.0F, 1.0908F, 0.7418F, 0.0F));

		PartDefinition cube_r14 = leg_1.addOrReplaceChild("cube_r14", CubeListBuilder.create().texOffs(112, 86).addBox(-2.0F, -5.0F, -1.0F, 4.0F, 10.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-12.0F, -14.0F, -13.0F, 0.3927F, 0.7418F, 0.0F));

		PartDefinition leg_2 = root.addOrReplaceChild("leg_2", CubeListBuilder.create().texOffs(42, 90).addBox(17.0F, -5.0F, -22.0F, 3.0F, 5.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(-2.0F, 0.0F, 0.0F));

		PartDefinition cube_r15 = leg_2.addOrReplaceChild("cube_r15", CubeListBuilder.create().texOffs(0, 119).addBox(-2.0F, -5.0F, -1.0F, 4.0F, 7.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(14.0F, -18.0F, -15.0F, 1.0908F, -0.7418F, 0.0F));

		PartDefinition cube_r16 = leg_2.addOrReplaceChild("cube_r16", CubeListBuilder.create().texOffs(14, 119).addBox(-2.0F, -5.0F, -1.0F, 4.0F, 7.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(17.0F, -18.0F, -18.0F, 2.5744F, -0.7418F, 0.0F));

		PartDefinition cube_r17 = leg_2.addOrReplaceChild("cube_r17", CubeListBuilder.create().texOffs(88, 126).addBox(-1.0F, -2.0F, -2.0F, 2.0F, 7.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(18.0F, -8.0F, -19.0F, -0.1745F, -0.2618F, 0.0F));

		PartDefinition cube_r18 = leg_2.addOrReplaceChild("cube_r18", CubeListBuilder.create().texOffs(16, 129).addBox(-1.0F, -2.0F, -1.0F, 2.0F, 6.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(19.0F, -13.0F, -20.0F, 2.9234F, 0.9163F, -3.1416F));

		PartDefinition cube_r19 = leg_2.addOrReplaceChild("cube_r19", CubeListBuilder.create().texOffs(30, 114).addBox(-2.0F, -5.0F, -1.0F, 4.0F, 10.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(12.0F, -14.0F, -13.0F, 0.3927F, -0.7418F, 0.0F));

		PartDefinition leg_3 = root.addOrReplaceChild("leg_3", CubeListBuilder.create().texOffs(100, 29).addBox(17.0F, -5.0F, -22.0F, 3.0F, 5.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.0F, 0.0F, 4.0F, 0.0F, -1.5708F, 0.0F));

		PartDefinition cube_r20 = leg_3.addOrReplaceChild("cube_r20", CubeListBuilder.create().texOffs(122, 72).addBox(-2.0F, -5.0F, -1.0F, 4.0F, 7.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(14.0F, -18.0F, -15.0F, 1.0908F, -0.7418F, 0.0F));

		PartDefinition cube_r21 = leg_3.addOrReplaceChild("cube_r21", CubeListBuilder.create().texOffs(122, 62).addBox(-2.0F, -5.0F, -1.0F, 4.0F, 7.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(17.0F, -18.0F, -18.0F, 2.5744F, -0.7418F, 0.0F));

		PartDefinition cube_r22 = leg_3.addOrReplaceChild("cube_r22", CubeListBuilder.create().texOffs(60, 127).addBox(-1.0F, -2.0F, -2.0F, 2.0F, 7.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(18.0F, -8.0F, -19.0F, -0.1745F, -0.2618F, 0.0F));

		PartDefinition cube_r23 = leg_3.addOrReplaceChild("cube_r23", CubeListBuilder.create().texOffs(68, 130).addBox(-1.0F, -2.0F, -1.0F, 2.0F, 6.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(19.0F, -13.0F, -20.0F, 2.9234F, 0.9163F, -3.1416F));

		PartDefinition cube_r24 = leg_3.addOrReplaceChild("cube_r24", CubeListBuilder.create().texOffs(44, 114).addBox(-2.0F, -5.0F, -1.0F, 4.0F, 10.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(12.0F, -14.0F, -13.0F, 0.3927F, -0.7418F, 0.0F));

		PartDefinition leg_4 = root.addOrReplaceChild("leg_4", CubeListBuilder.create().texOffs(112, 29).addBox(-20.0F, -5.0F, -22.0F, 3.0F, 5.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 4.0F, 0.0F, 1.5708F, 0.0F));

		PartDefinition cube_r25 = leg_4.addOrReplaceChild("cube_r25", CubeListBuilder.create().texOffs(114, 123).addBox(-2.0F, -5.0F, -1.0F, 4.0F, 7.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-14.0F, -18.0F, -15.0F, 1.0908F, 0.7418F, 0.0F));

		PartDefinition cube_r26 = leg_4.addOrReplaceChild("cube_r26", CubeListBuilder.create().texOffs(100, 123).addBox(-2.0F, -5.0F, -1.0F, 4.0F, 7.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-17.0F, -18.0F, -18.0F, 2.5744F, 0.7418F, 0.0F));

		PartDefinition cube_r27 = leg_4.addOrReplaceChild("cube_r27", CubeListBuilder.create().texOffs(0, 129).addBox(-1.0F, -2.0F, -2.0F, 2.0F, 7.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-18.0F, -8.0F, -19.0F, -0.1745F, 0.2618F, 0.0F));

		PartDefinition cube_r28 = leg_4.addOrReplaceChild("cube_r28", CubeListBuilder.create().texOffs(76, 130).addBox(-1.0F, -2.0F, -1.0F, 2.0F, 6.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-19.0F, -13.0F, -20.0F, 2.9234F, -0.9163F, 3.1416F));

		PartDefinition cube_r29 = leg_4.addOrReplaceChild("cube_r29", CubeListBuilder.create().texOffs(58, 114).addBox(-2.0F, -5.0F, -1.0F, 4.0F, 10.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-12.0F, -14.0F, -13.0F, 0.3927F, 0.7418F, 0.0F));

		PartDefinition tentacle_1 = root.addOrReplaceChild("tentacle_1", CubeListBuilder.create(), PartPose.offset(9.0F, -17.0F, 0.0F));

		PartDefinition cube_r30 = tentacle_1.addOrReplaceChild("cube_r30", CubeListBuilder.create().texOffs(122, 82).addBox(-2.0F, -4.02F, -2.0F, 4.0F, 0.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(24, 131).addBox(-1.0F, -4.0F, -1.0F, 2.0F, 6.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0F, -8.0F, -2.0F, 2.8938F, -0.9996F, -3.1391F));

		PartDefinition cube_r31 = tentacle_1.addOrReplaceChild("cube_r31", CubeListBuilder.create().texOffs(136, 131).addBox(-1.0F, -4.0F, -1.0F, 2.0F, 5.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0F, -4.0F, 0.0F, 0.9467F, -0.7128F, -0.3947F));

		PartDefinition cube_r32 = tentacle_1.addOrReplaceChild("cube_r32", CubeListBuilder.create().texOffs(100, 116).addBox(-1.0F, -4.0F, -1.0F, 2.0F, 5.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -1.0F, 0.0F, 0.0F, 0.0F, 0.2618F));

		PartDefinition tentacle_2 = root.addOrReplaceChild("tentacle_2", CubeListBuilder.create(), PartPose.offsetAndRotation(-8.0F, -16.0F, 8.0F, 0.3054F, 0.5672F, 0.0F));

		PartDefinition cube_r33 = tentacle_2.addOrReplaceChild("cube_r33", CubeListBuilder.create().texOffs(124, 29).addBox(-2.0F, -4.02F, -2.0F, 4.0F, 0.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(32, 131).addBox(-1.0F, -4.0F, -1.0F, 2.0F, 6.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.7907F, -8.1043F, -1.6218F, 2.8938F, -0.9996F, -3.1391F));

		PartDefinition cube_r34 = tentacle_2.addOrReplaceChild("cube_r34", CubeListBuilder.create().texOffs(16, 137).addBox(-1.0F, -4.0F, -1.0F, 2.0F, 5.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.7907F, -4.1043F, 0.3782F, 0.9467F, -0.7128F, -0.3947F));

		PartDefinition cube_r35 = tentacle_2.addOrReplaceChild("cube_r35", CubeListBuilder.create().texOffs(8, 137).addBox(-1.0F, -4.0F, -1.0F, 2.0F, 5.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.7907F, -1.1043F, 0.3782F, 0.0F, 0.0F, 0.2618F));

		PartDefinition tentacle_3 = root.addOrReplaceChild("tentacle_3", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, -18.0F, 13.0F, -0.4363F, 0.5672F, 0.0F));

		PartDefinition cube_r36 = tentacle_3.addOrReplaceChild("cube_r36", CubeListBuilder.create().texOffs(124, 33).addBox(-2.0F, -4.02F, -2.0F, 4.0F, 0.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(40, 131).addBox(-1.0F, -4.0F, -1.0F, 2.0F, 6.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.1105F, -5.0217F, -2.2521F, 2.8938F, -0.9996F, -3.1391F));

		PartDefinition cube_r37 = tentacle_3.addOrReplaceChild("cube_r37", CubeListBuilder.create().texOffs(138, 0).addBox(-1.0F, -4.0F, -1.0F, 2.0F, 5.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.1105F, -1.0217F, -0.2521F, 0.9467F, -0.7128F, -0.3947F));

		PartDefinition cube_r38 = tentacle_3.addOrReplaceChild("cube_r38", CubeListBuilder.create().texOffs(0, 138).addBox(-1.0F, -4.0F, -1.0F, 2.0F, 5.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.8895F, 1.9783F, -0.2521F, 0.0F, 0.0F, 0.2618F));

		PartDefinition spear_1 = root.addOrReplaceChild("spear_1", CubeListBuilder.create(), PartPose.offset(6.0F, -17.0F, -10.0F));

		PartDefinition cube_r39 = spear_1.addOrReplaceChild("cube_r39", CubeListBuilder.create().texOffs(126, 86).addBox(-3.0F, -5.0F, -2.02F, 4.0F, 0.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(104, 133).addBox(-2.0F, -5.0F, -1.0F, 2.0F, 6.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.0F, -10.0F, -1.0F, 1.4151F, 0.3835F, 2.0275F));

		PartDefinition cube_r40 = spear_1.addOrReplaceChild("cube_r40", CubeListBuilder.create().texOffs(126, 94).addBox(-2.04F, -5.0F, -2.0F, 4.0F, 0.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(96, 133).addBox(-1.0F, -5.0F, -1.0F, 2.0F, 6.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.0F, -10.0F, -1.0F, 3.0295F, 0.3835F, 2.0275F));

		PartDefinition cube_r41 = spear_1.addOrReplaceChild("cube_r41", CubeListBuilder.create().texOffs(112, 133).addBox(-1.0F, -5.0F, -1.0F, 2.0F, 6.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(72, 126).addBox(-2.0F, -5.02F, -2.0F, 4.0F, 0.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.0F, -10.0F, -1.0F, -2.7569F, -0.4542F, -2.7774F));

		PartDefinition cube_r42 = spear_1.addOrReplaceChild("cube_r42", CubeListBuilder.create().texOffs(126, 90).addBox(-2.05F, -5.0F, -2.0F, 4.0F, 0.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(128, 131).addBox(-1.0F, -5.0F, -1.0F, 2.0F, 6.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.0F, -8.0F, -1.0F, 1.9519F, -0.784F, -2.9194F));

		PartDefinition cube_r43 = spear_1.addOrReplaceChild("cube_r43", CubeListBuilder.create().texOffs(48, 131).addBox(-1.0F, -5.0F, -1.0F, 2.0F, 6.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -5.0F, 0.0F, 2.8449F, -1.1288F, 3.0246F));

		PartDefinition cube_r44 = spear_1.addOrReplaceChild("cube_r44", CubeListBuilder.create().texOffs(138, 7).addBox(-1.0F, -5.0F, -1.0F, 2.0F, 5.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.1415F, -0.8197F, 0.1925F));

		PartDefinition spear_2 = root.addOrReplaceChild("spear_2", CubeListBuilder.create(), PartPose.offsetAndRotation(-10.0F, -15.0F, 4.0F, 2.8397F, 1.2884F, 2.649F));

		PartDefinition cube_r45 = spear_2.addOrReplaceChild("cube_r45", CubeListBuilder.create().texOffs(128, 127).addBox(-3.0F, -5.0F, -2.02F, 4.0F, 0.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(136, 70).addBox(-2.0F, -5.0F, -1.0F, 2.0F, 6.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.302F, -9.2248F, -1.36F, 1.4151F, 0.3835F, 2.0275F));

		PartDefinition cube_r46 = spear_2.addOrReplaceChild("cube_r46", CubeListBuilder.create().texOffs(128, 123).addBox(-2.04F, -5.0F, -2.0F, 4.0F, 0.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(136, 62).addBox(-1.0F, -5.0F, -1.0F, 2.0F, 6.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.302F, -9.2248F, -1.36F, 3.0295F, 0.3835F, 2.0275F));

		PartDefinition cube_r47 = spear_2.addOrReplaceChild("cube_r47", CubeListBuilder.create().texOffs(56, 136).addBox(-1.0F, -5.0F, -1.0F, 2.0F, 6.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(44, 127).addBox(-2.0F, -5.02F, -2.0F, 4.0F, 0.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.302F, -9.2248F, -1.36F, -2.7569F, -0.4542F, -2.7774F));

		PartDefinition cube_r48 = spear_2.addOrReplaceChild("cube_r48", CubeListBuilder.create().texOffs(28, 127).addBox(-2.05F, -5.0F, -2.0F, 4.0F, 0.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(84, 135).addBox(-1.0F, -5.0F, -1.0F, 2.0F, 6.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.302F, -7.2248F, -1.36F, 1.9519F, -0.784F, -2.9194F));

		PartDefinition cube_r49 = spear_2.addOrReplaceChild("cube_r49", CubeListBuilder.create().texOffs(120, 133).addBox(-1.0F, -5.0F, -1.0F, 2.0F, 6.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.698F, -4.2248F, -0.36F, 2.8449F, -1.1288F, 3.0246F));

		PartDefinition cube_r50 = spear_2.addOrReplaceChild("cube_r50", CubeListBuilder.create().texOffs(138, 14).addBox(-1.0F, -5.0F, -1.0F, 2.0F, 5.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.698F, 0.7752F, -0.36F, -0.1415F, -0.8197F, 0.1925F));

		PartDefinition head = root.addOrReplaceChild("head", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition cube_r51 = head.addOrReplaceChild("cube_r51", CubeListBuilder.create().texOffs(0, 38).addBox(-9.0F, -32.0F, -10.0F, 15.0F, 35.0F, 17.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -18.0F, 2.0F, -0.1309F, 0.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 256, 256);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.root.getAllParts().forEach(ModelPart::resetPose);
		this.applyHeadRotation(netHeadYaw, headPitch, ageInTicks);

		this.animateWalk(StarVampireAnim.walk, limbSwing, limbSwingAmount, 2f, 2.5f);
		this.animate(((StarVampireEntity) entity).idle, StarVampireAnim.idle, ageInTicks, 1f);
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
		root.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	@Override
	public ModelPart root() {
		return root;
	}
}
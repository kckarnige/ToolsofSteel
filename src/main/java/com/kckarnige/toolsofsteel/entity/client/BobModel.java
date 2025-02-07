package com.kckarnige.toolsofsteel.entity.client;

import com.kckarnige.toolsofsteel.entity.custom.BobEntity;
import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.BipedEntityModel;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.client.render.entity.model.ModelWithArms;
import net.minecraft.client.render.entity.model.SinglePartEntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Arm;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.MathHelper;

import static com.kckarnige.toolsofsteel.Toolsofsteel.MOD_ID;

public class BobModel<T extends BobEntity> extends SinglePartEntityModel<T> implements ModelWithArms {
    public static final EntityModelLayer JURY = new EntityModelLayer(Identifier.of(MOD_ID,"jury"), "main");
    private final ModelPart root;
    private final ModelPart bob;
    private final ModelPart body;
    private final ModelPart head;
    private final ModelPart headwear;
    private final ModelPart helmet;
    private final ModelPart left_arm;
    private final ModelPart left_shoulder;
    private final ModelPart right_arm;
    private final ModelPart right_shoulder;
    private final ModelPart chestplate;
    private final ModelPart left_leg;
    private final ModelPart left_shoe;
    private final ModelPart right_leg;
    private final ModelPart right_shoe;

    public BipedEntityModel.ArmPose leftArmPose = BipedEntityModel.ArmPose.EMPTY;
    public BipedEntityModel.ArmPose rightArmPose = BipedEntityModel.ArmPose.EMPTY;
    public BobModel(ModelPart root) {
        this.root = root.getChild("root");
        this.bob = this.root.getChild("bob");
        this.body = this.bob.getChild("body");
        this.head = this.body.getChild("head");
        this.headwear = this.head.getChild("headwear");
        this.helmet = this.head.getChild("helmet");
        this.left_arm = this.body.getChild("left_arm");
        this.left_shoulder = this.left_arm.getChild("left_shoulder");
        this.right_arm = this.body.getChild("right_arm");
        this.right_shoulder = this.right_arm.getChild("right_shoulder");
        this.chestplate = this.body.getChild("chestplate");
        this.left_leg = this.bob.getChild("left_leg");
        this.left_shoe = this.left_leg.getChild("left_shoe");
        this.right_leg = this.bob.getChild("right_leg");
        this.right_shoe = this.right_leg.getChild("right_shoe");
    }
    public static TexturedModelData getTexturedModelData() {
        ModelData modelData = new ModelData();
        ModelPartData modelPartData = modelData.getRoot();
        ModelPartData root = modelPartData.addChild("root", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 24.0F, 0.0F));

        ModelPartData bob = root.addChild("bob", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

        ModelPartData body = bob.addChild("body", ModelPartBuilder.create().uv(16, 16).cuboid(-4.0F, 0.0F, -2.0F, 8.0F, 12.0F, 4.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -23.0F, -2.0F, 0.2182F, 0.0F, 0.0F));

        ModelPartData head = body.addChild("head", ModelPartBuilder.create().uv(0, 0).cuboid(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 0.0F, -0.1308F, -0.0057F, -0.0433F));

        ModelPartData headwear = head.addChild("headwear", ModelPartBuilder.create().uv(32, 0).cuboid(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, new Dilation(0.25F)), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

        ModelPartData helmet = head.addChild("helmet", ModelPartBuilder.create().uv(32, 32).cuboid(-4.0F, -31.0F, -4.0F, 8.0F, 8.0F, 8.0F, new Dilation(0.75F)), ModelTransform.pivot(0.0F, 23.0F, 0.0F));

        ModelPartData left_arm = body.addChild("left_arm", ModelPartBuilder.create().uv(16, 32).cuboid(-1.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, new Dilation(0.0F)), ModelTransform.of(5.0F, 3.0F, 0.0F, -0.22F, 0.1278F, -0.0285F));

        ModelPartData left_shoulder = left_arm.addChild("left_shoulder", ModelPartBuilder.create().uv(48, 48).mirrored().cuboid(4.0F, -24.0F, -2.0F, 4.0F, 12.0F, 4.0F, new Dilation(0.75F)).mirrored(false), ModelTransform.pivot(-5.0F, 22.0F, 0.0F));

        ModelPartData right_arm = body.addChild("right_arm", ModelPartBuilder.create().uv(40, 16).cuboid(-3.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, new Dilation(0.0F)), ModelTransform.of(-5.0F, 2.0F, 0.0F, -1.4856F, -0.0189F, 0.2174F));

        ModelPartData right_shoulder = right_arm.addChild("right_shoulder", ModelPartBuilder.create().uv(48, 48).cuboid(-8.0F, -24.0F, -2.0F, 4.0F, 12.0F, 4.0F, new Dilation(0.75F)), ModelTransform.pivot(5.0F, 22.0F, 0.0F));

        ModelPartData chestplate = body.addChild("chestplate", ModelPartBuilder.create().uv(24, 48).cuboid(-4.0F, -24.0F, -2.0F, 8.0F, 12.0F, 4.0F, new Dilation(0.75F)), ModelTransform.pivot(0.0F, 23.0F, 0.0F));

        ModelPartData left_leg = bob.addChild("left_leg", ModelPartBuilder.create().uv(0, 32).cuboid(-1.9F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new Dilation(0.0F)), ModelTransform.pivot(1.9F, -12.0F, 0.0F));

        ModelPartData left_shoe = left_leg.addChild("left_shoe", ModelPartBuilder.create().uv(0, 48).mirrored().cuboid(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new Dilation(0.75F)).mirrored(false), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

        ModelPartData right_leg = bob.addChild("right_leg", ModelPartBuilder.create().uv(0, 16).cuboid(-2.1F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new Dilation(0.0F)), ModelTransform.pivot(-1.9F, -12.0F, 0.0F));

        ModelPartData right_shoe = right_leg.addChild("right_shoe", ModelPartBuilder.create().uv(0, 48).cuboid(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new Dilation(0.75F)), ModelTransform.pivot(0.0F, 0.0F, 0.0F));
        return TexturedModelData.of(modelData, 64, 64);
    }
    @Override
    public void setAngles(BobEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.getPart().traverse().forEach(ModelPart::resetTransform);
        this.setHeadAngles(netHeadYaw, headPitch);

        this.animateMovement(BobAnimations.WALKING, limbSwing, limbSwingAmount, 2f, 2.5f);
        this.updateAnimation(entity.idleAnimationState, BobAnimations.IDLE, ageInTicks, 1f);
        this.updateAnimation(entity.attackAnimationState, BobAnimations.ATTACK, ageInTicks, 1f);
    }

    @Override
    public void render(MatrixStack matrices, VertexConsumer vertexConsumer, int light, int overlay, int color) {
        root.render(matrices, vertexConsumer, light, overlay, color);
    }

    private void setHeadAngles(float headYaw, float headPitch) {
        headYaw = MathHelper.clamp(headYaw, -30.0F, 30.0F);
        headPitch = MathHelper.clamp(headPitch, -25.0F, 45.0F);

        this.head.yaw = headYaw * 0.017453292F;
        this.head.pitch = headPitch * 0.017453292F;
    }

    @Override
    public ModelPart getPart() {
        return root;
    }

    @Override
    public void setArmAngle(Arm arm, MatrixStack matrices) {
        this.getArm(arm).rotate(matrices);
    }
    protected ModelPart getArm(Arm arm) {
        return arm == Arm.LEFT ? this.left_arm : this.right_arm;
    }
}
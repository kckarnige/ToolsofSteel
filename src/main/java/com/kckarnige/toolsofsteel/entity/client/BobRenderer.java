package com.kckarnige.toolsofsteel.entity.client;

import com.kckarnige.toolsofsteel.entity.custom.BobEntity;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.render.entity.feature.FeatureRenderer;
import net.minecraft.client.render.entity.feature.FeatureRendererContext;
import net.minecraft.client.render.entity.feature.HeldItemFeatureRenderer;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.LivingEntity;
import net.minecraft.util.Identifier;

import static com.kckarnige.toolsofsteel.Toolsofsteel.MOD_ID;

public class BobRenderer extends MobEntityRenderer<BobEntity, BobModel<BobEntity>> {

    public BobRenderer(EntityRendererFactory.Context context) {
        super(context, new BobModel<>(context.getPart(BobModel.JURY)), 0.5f);
        this.addFeature(
                new HeldItemFeatureRenderer<>(this, context.getHeldItemRenderer()) {
                    public void render(
                            MatrixStack matrixStack,
                            VertexConsumerProvider vertexConsumerProvider,
                            int i,
                            BobEntity bob,
                            float f,
                            float g,
                            float h,
                            float j,
                            float k,
                            float l
                    ) {
                        super.render(matrixStack, vertexConsumerProvider, i, bob, f, g, h, j, k, l);
                    }
                }
        );
    }

    @Override
    public Identifier getTexture(BobEntity entity) {
        return Identifier.of(MOD_ID, "textures/entity/judge/bob.png");
    }

    private static class EmissiveLayer<T extends LivingEntity, M extends EntityModel<T>> extends FeatureRenderer<T, M> {
        private final Identifier emissiveTexture;

        public EmissiveLayer(FeatureRendererContext<T, M> context) {
            super(context);
            this.emissiveTexture = Identifier.of(MOD_ID, "textures/entity/judge/bob_e.png");
        }

        @Override
        public void render(MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light, T entity, float limbAngle, float limbDistance, float tickDelta, float animationProgress, float headYaw, float headPitch) {
            // Use full brightness for emissive effect
            int glowLight = 15728880; // Maximum light value (glow effect)

            renderModel(this.getContextModel(), this.emissiveTexture, matrices, vertexConsumers, glowLight, entity, 1);
        }
    }
}

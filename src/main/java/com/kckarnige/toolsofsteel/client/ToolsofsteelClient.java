package com.kckarnige.toolsofsteel.client;

import com.kckarnige.toolsofsteel.config.MidnightConfigStuff;
import com.kckarnige.toolsofsteel.entity.EntityRegister;
import com.kckarnige.toolsofsteel.entity.client.BobModel;
import com.kckarnige.toolsofsteel.entity.client.BobRenderer;
import com.kckarnige.toolsofsteel.utils.PackRegister;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.fabricmc.fabric.api.resource.ResourcePackActivationType;
import net.minecraft.text.Text;


public class ToolsofsteelClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        EntityModelLayerRegistry.registerModelLayer(BobModel.JURY, BobModel::getTexturedModelData);
        EntityRendererRegistry.register(EntityRegister.JURY, BobRenderer::new);

        if (!MidnightConfigStuff.remove_tweaks_rp) {
            PackRegister.register("visual_tweaks", ResourcePackActivationType.DEFAULT_ENABLED, Text.translatable("pack.toolsofsteel.visual_tweaks.name"));
        }
        if (!MidnightConfigStuff.remove_knows_rp) {
            PackRegister.register("consistent_helms", ResourcePackActivationType.NORMAL, Text.translatable("pack.toolsofsteel.consistent_helms.name"));
        }
    }
}

package com.kckarnige.toolsofsteel.client;

import com.kckarnige.toolsofsteel.config.MidnightConfigStuff;
import com.kckarnige.toolsofsteel.utils.PackRegister;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.resource.ResourcePackActivationType;
import net.minecraft.text.Text;


public class ToolsofsteelClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        if (!MidnightConfigStuff.REMOVE_RPS) {
            PackRegister.registerPack("visual_tweaks", ResourcePackActivationType.DEFAULT_ENABLED, Text.translatable("pack.toolsofsteel.visual_tweaks.name"));
            PackRegister.registerPack("consistent_helms", ResourcePackActivationType.NORMAL, Text.translatable("pack.toolsofsteel.consistent_helms.name"));
        }
    }
}

package com.kckarnige.toolsofsteel.client;

import com.kckarnige.toolsofsteel.config.MidnightConfigStuff;
import com.kckarnige.toolsofsteel.utils.PackRegister;
import net.fabricmc.api.ClientModInitializer;
import net.minecraft.text.Text;

import static net.fabricmc.fabric.api.resource.ResourcePackActivationType.DEFAULT_ENABLED;

public class ToolsofsteelClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        if (!MidnightConfigStuff.REMOVE_RPS) {
            PackRegister.registerPack("visual_tweaks", DEFAULT_ENABLED, Text.translatable("pack.toolsofsteel.visual_tweaks.name"));
        }
    }
}

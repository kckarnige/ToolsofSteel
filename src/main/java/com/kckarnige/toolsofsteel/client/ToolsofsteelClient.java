package com.kckarnige.toolsofsteel.client;

import com.kckarnige.toolsofsteel.config.MidnightConfigStuff;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.resource.ResourceManagerHelper;
import net.fabricmc.fabric.api.resource.ResourcePackActivationType;
import net.fabricmc.loader.api.FabricLoader;
import net.fabricmc.loader.api.ModContainer;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

import static com.kckarnige.toolsofsteel.Toolsofsteel.MOD_ID;
import static net.fabricmc.fabric.api.resource.ResourcePackActivationType.DEFAULT_ENABLED;

public class ToolsofsteelClient implements ClientModInitializer {
    public <string> void registerResourcePack(string Path, ResourcePackActivationType ResourcePackType, Text PackName) {
        ModContainer container = FabricLoader.getInstance().getModContainer(MOD_ID).orElseThrow();
        ResourceManagerHelper.registerBuiltinResourcePack(Identifier.of(MOD_ID, (String) Path), container, PackName, ResourcePackType);
    }

    @Override
    public void onInitializeClient() {
        if (!MidnightConfigStuff.REMOVE_RPS) {
            registerResourcePack("visual_tweaks", DEFAULT_ENABLED, Text.translatable("pack.toolsofsteel.visual_tweaks.name"));
        }
    }
}

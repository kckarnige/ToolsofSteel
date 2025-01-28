package com.kckarnige.toolsofsteel;

import com.kckarnige.toolsofsteel.blocks.BlockRegister;
import com.kckarnige.toolsofsteel.items.ItemRegister;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.resource.ResourceManagerHelper;
import net.fabricmc.fabric.api.resource.ResourcePackActivationType;
import net.fabricmc.loader.api.FabricLoader;
import net.fabricmc.loader.api.ModContainer;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static net.fabricmc.fabric.api.resource.ResourcePackActivationType.*;

public class Toolsofsteel implements ModInitializer {
    public <string> void registerResourcePack(string Path, ResourcePackActivationType ResourcePackType, Text PackName) {
        ModContainer container = FabricLoader.getInstance().getModContainer(MOD_ID).orElseThrow();
        ResourceManagerHelper.registerBuiltinResourcePack(Identifier.of(MOD_ID, (String) Path), container, PackName, ResourcePackType);
    }

    public static final String MOD_ID = "toolsofsteel";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    @Override
    public void onInitialize() {
        registerResourcePack("visual_tweaks", DEFAULT_ENABLED, Text.translatable("pack.toolsofsteel.visual_tweaks.name"));
        ItemRegister.registerModItems();
        BlockRegister.registerModBlocks();
    }
}

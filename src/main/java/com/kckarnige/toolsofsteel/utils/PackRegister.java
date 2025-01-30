package com.kckarnige.toolsofsteel.utils;

import net.fabricmc.fabric.api.resource.ResourceManagerHelper;
import net.fabricmc.fabric.api.resource.ResourcePackActivationType;
import net.fabricmc.loader.api.FabricLoader;
import net.fabricmc.loader.api.ModContainer;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

import static com.kckarnige.toolsofsteel.Toolsofsteel.MOD_ID;


public class PackRegister {

    public static void registerPack(String Path, ResourcePackActivationType ResourcePackType, Text PackName) {
        ModContainer container = FabricLoader.getInstance().getModContainer(MOD_ID).orElseThrow();
        ResourceManagerHelper.registerBuiltinResourcePack(Identifier.of(MOD_ID, Path), container, PackName, ResourcePackType);
    }
}

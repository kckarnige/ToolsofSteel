package com.kckarnige.toolsofsteel;

import com.kckarnige.toolsofsteel.blocks.BlockRegister;
import com.kckarnige.toolsofsteel.config.MidnightConfigStuff;
import com.kckarnige.toolsofsteel.items.ItemRegister;
import eu.midnightdust.lib.config.MidnightConfig;
import net.fabricmc.api.ModInitializer;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Toolsofsteel implements ModInitializer {

    public static final String MOD_ID = "toolsofsteel";
    public static final Logger LOGGER = LoggerFactory.getLogger("Tools of Steel");

    @Override
    public void onInitialize() {
        MidnightConfig.init(MOD_ID, MidnightConfigStuff.class);
        ItemRegister.registerModItems();
        BlockRegister.registerModBlocks();
        Registry.register(Registries.ITEM_GROUP, Identifier.of(MOD_ID, MOD_ID), SteelItemGroup.makeItemGroup());
    }
}

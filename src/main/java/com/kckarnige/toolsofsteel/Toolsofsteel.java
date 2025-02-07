package com.kckarnige.toolsofsteel;

import com.kckarnige.toolsofsteel.blocks.BlockRegister;
import com.kckarnige.toolsofsteel.config.MidnightConfigStuff;
import com.kckarnige.toolsofsteel.items.ItemRegister;
import com.kckarnige.toolsofsteel.utils.LootTableModifier;
import com.kckarnige.toolsofsteel.utils.PackRegister;
import eu.midnightdust.lib.config.MidnightConfig;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.minecraft.util.crash.CrashReport;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static net.fabricmc.fabric.api.resource.ResourcePackActivationType.ALWAYS_ENABLED;

public class Toolsofsteel implements ModInitializer {

    public static final String MOD_ID = "toolsofsteel";
    public static final Logger LOGGER = LoggerFactory.getLogger("Tools of Steel");

    @Override
    public void onInitialize() {
        MidnightConfig.init(MOD_ID, MidnightConfigStuff.class);
        ItemRegister.registerModItems();
        BlockRegister.registerModBlocks();

        if (!MidnightConfigStuff.remove_loot_table_changes) {
            LootTableModifier.init();
        }
        Registry.register(Registries.ITEM_GROUP, Identifier.of(MOD_ID, MOD_ID), SteelItemGroup.makeItemGroup());
        if (FabricLoader.getInstance().isModLoaded("slowyourroll")) {
            PackRegister.register("syr_compat", ALWAYS_ENABLED, Text.literal("SYRCompat"));
            LOGGER.info("Slow and steady..");
        } else if (FabricLoader.getInstance().isModLoaded("divergeprog")) {
            PackRegister.register("divprog_compat", ALWAYS_ENABLED, Text.literal("DivProgCompat"));
            LOGGER.info("Diverging..");
        } else if (FabricLoader.getInstance().isModLoaded("bettercombat")) {
            PackRegister.register("bettercombat_compat", ALWAYS_ENABLED, Text.literal("BetterCombatCompat"));
            LOGGER.info("Getting better..");
        }
        if (FabricLoader.getInstance().isModLoaded("slowyourroll") && FabricLoader.getInstance().isModLoaded("divergeprog")) {
            if (!MidnightConfigStuff.bypass_crash) {
                new CrashReport("Quenching can be a delicate process...",
                        new Throwable("'Slow your Roll' and 'Divergent Progression' cannot be used together!"));
                LOGGER.error("https://youtu.be/qJI-nRg1WBI?t=60");
                throw new RuntimeException("\n\n" +
                        "!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!\n" +
                        "!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!\n" +
                        "\n" +
                        "\n" +
                        "      'Slow your Roll' and 'Divergent Progression' are incompatible with each other!\n" +
                        "\n" +
                        "                            https://youtu.be/qJI-nRg1WBI?t=60\n" +
                        "\n" +
                        "                                  Uninstall one of them!\n" +
                        "\n" +
                        "                   If you want to bypass this, edit the config file.\n" +
                        "\n" +
                        "\n" +
                        "!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!\n" +
                        "!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!\n");
            }
        }
    }
}

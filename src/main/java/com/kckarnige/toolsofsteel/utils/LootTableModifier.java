package com.kckarnige.toolsofsteel.utils;

import com.kckarnige.toolsofsteel.items.ItemRegister;
import net.fabricmc.fabric.api.loot.v3.LootTableEvents;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.entry.LootPoolEntry;

import java.util.Arrays;
import java.util.List;

import static com.seacroak.bronze.registry.LootTableModification.addItems;
import static net.minecraft.loot.LootTables.*;

public class LootTableModifier {

    private static final List<LootPoolEntry> village_smith = Arrays.asList(
            ItemEntry.builder(ItemRegister.STEEL_INGOT).weight(1).quality(3).build(),
            ItemEntry.builder(ItemRegister.STEEL_NUGGET).weight(2).quality(1).build(),
            ItemEntry.builder(ItemRegister.DIAMOND_INGOT).weight(0).quality(2).build()
    );

    private static final List<LootPoolEntry> ancient_cities = Arrays.asList(
            ItemEntry.builder(ItemRegister.STEEL_HELMET).weight(0).quality(1).build(),
            ItemEntry.builder(ItemRegister.STEEL_CHESTPLATE).weight(0).quality(1).build(),
            ItemEntry.builder(ItemRegister.BATTLE_AXE).weight(1).quality(1).build()
    );
    
    public static void init () {
        LootTableEvents.MODIFY.register((key, tableBuilder, source, registries) -> {
            if (source.isBuiltin() && VILLAGE_ARMORER_CHEST.equals(key)) {
                addItems(village_smith, tableBuilder, false);
            }
            if (source.isBuiltin() && VILLAGE_TOOLSMITH_CHEST.equals(key)) {
                addItems(village_smith, tableBuilder, false);
            }
            if (source.isBuiltin() && VILLAGE_WEAPONSMITH_CHEST.equals(key)) {
                addItems(village_smith, tableBuilder, false);
            }
            if (source.isBuiltin() && ANCIENT_CITY_CHEST.equals(key)) {
                addItems(ancient_cities, tableBuilder, true);
            }
        });
    }
}

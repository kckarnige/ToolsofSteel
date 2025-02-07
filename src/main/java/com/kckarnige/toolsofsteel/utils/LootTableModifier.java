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

    private static final List<LootPoolEntry> village_weaponsmith = Arrays.asList(
            ItemEntry.builder(ItemRegister.STEEL_INGOT).weight(1).build(),
            ItemEntry.builder(ItemRegister.STEEL_NUGGET).weight(2).build(),
            ItemEntry.builder(ItemRegister.DIAMOND_INGOT).weight(1).build()
    );

    private static final List<LootPoolEntry> ancient_cities = Arrays.asList(
            ItemEntry.builder(ItemRegister.STEEL_NUGGET).weight(1).build(),
            ItemEntry.builder(ItemRegister.STEEL_HELMET).weight(1).build(),
            ItemEntry.builder(ItemRegister.STEEL_SHOVEL).weight(1).build()
    );
    
    public static void init () {
        LootTableEvents.MODIFY.register((key, tableBuilder, source, registries) -> {
            if (source.isBuiltin() && VILLAGE_WEAPONSMITH_CHEST.equals(key)) {
                addItems(village_weaponsmith, tableBuilder, false);
            }
            if (source.isBuiltin() && ANCIENT_CITY_CHEST.equals(key)) {
                addItems(ancient_cities, tableBuilder, false);
            }
        });
    }
}

package com.kckarnige.toolsofsteel.items.armor;

import com.kckarnige.toolsofsteel.utils.TrimMaterialRegister;
import net.minecraft.item.trim.ArmorTrimMaterial;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.Registries;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.text.Style;
import net.minecraft.text.TextColor;
import net.minecraft.util.Identifier;

import static com.kckarnige.toolsofsteel.Toolsofsteel.MOD_ID;
import static com.kckarnige.toolsofsteel.items.ItemRegister.*;

public class TrimMaterials {
    public static final RegistryKey<ArmorTrimMaterial> STEEL_TRIM = RegistryKey.of(RegistryKeys.TRIM_MATERIAL,
            Identifier.of(MOD_ID, "steel"));

    public static final RegistryKey<ArmorTrimMaterial> DIAMOND_TRIM = RegistryKey.of(RegistryKeys.TRIM_MATERIAL,
            Identifier.of(MOD_ID, "shiny_diamond"));

    public static void registerModTrims (Registerable<ArmorTrimMaterial> registerable) {
        TrimMaterialRegister.register(registerable, STEEL_TRIM, Registries.ITEM.getEntry(STEEL_INGOT),
                Style.EMPTY.withColor(TextColor.parse("#48464F").getOrThrow()), 0.3f);
        TrimMaterialRegister.register(registerable, DIAMOND_TRIM, Registries.ITEM.getEntry(DIAMOND_INGOT),
                Style.EMPTY.withColor(TextColor.parse("#6EDFEC").getOrThrow()), 0.8f);
    }
}

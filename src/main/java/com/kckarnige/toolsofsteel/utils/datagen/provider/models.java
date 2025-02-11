package com.kckarnige.toolsofsteel.utils.datagen.provider;

import com.kckarnige.toolsofsteel.blocks.BlockRegister;
import com.kckarnige.toolsofsteel.items.ItemRegister;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Models;
import net.minecraft.item.ArmorItem;

public class models extends FabricModelProvider {

    public models(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        blockStateModelGenerator.registerSimpleCubeAll(BlockRegister.STEEL_BLOCK);
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        // Ingredients
        itemModelGenerator.register(ItemRegister.TIN_NUGGET, Models.GENERATED);
        itemModelGenerator.register(ItemRegister.DIAMOND_INGOT, Models.GENERATED);
        itemModelGenerator.register(ItemRegister.STEEL_NUGGET, Models.GENERATED);
        itemModelGenerator.register(ItemRegister.STEEL_INGOT, Models.GENERATED);
        // Tools
        itemModelGenerator.register(ItemRegister.BATTLE_AXE, Models.HANDHELD_MACE);
        itemModelGenerator.register(ItemRegister.NETHERITE_BATTLE_AXE, Models.HANDHELD_MACE);
        itemModelGenerator.register(ItemRegister.STEEL_SWORD, Models.HANDHELD);
        itemModelGenerator.register(ItemRegister.STEEL_AXE, Models.HANDHELD);
        itemModelGenerator.register(ItemRegister.STEEL_PICKAXE, Models.HANDHELD);
        itemModelGenerator.register(ItemRegister.STEEL_SHOVEL, Models.HANDHELD);
        itemModelGenerator.register(ItemRegister.STEEL_HOE, Models.HANDHELD);
        // Armor
        itemModelGenerator.registerArmor((ArmorItem) ItemRegister.STEEL_HELMET);
        itemModelGenerator.registerArmor((ArmorItem) ItemRegister.STEEL_CHESTPLATE);
        itemModelGenerator.registerArmor((ArmorItem) ItemRegister.STEEL_LEGGINGS);
        itemModelGenerator.registerArmor((ArmorItem) ItemRegister.STEEL_BOOTS);
        // Misc / Mod Compat Items
        itemModelGenerator.register(ItemRegister.BRONZE_PLATE, Models.GENERATED);
        itemModelGenerator.register(ItemRegister.STEEL_PLATE, Models.GENERATED);
        itemModelGenerator.register(ItemRegister.STEEL_BAR, Models.GENERATED);
    }
}

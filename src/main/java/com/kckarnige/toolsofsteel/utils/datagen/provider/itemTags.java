package com.kckarnige.toolsofsteel.utils.datagen.provider;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.ItemTags;

import java.util.concurrent.CompletableFuture;

import static com.kckarnige.toolsofsteel.items.ItemRegister.*;

public class itemTags extends FabricTagProvider.ItemTagProvider {
    public itemTags(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> completableFuture) {
        super(output, completableFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
        // Tools
        getOrCreateTagBuilder(ItemTags.SWORDS)
                .add(STEEL_SWORD);
        getOrCreateTagBuilder(ItemTags.AXES)
                .add(STEEL_AXE);
        getOrCreateTagBuilder(ItemTags.PICKAXES)
                .add(STEEL_PICKAXE);
        getOrCreateTagBuilder(ItemTags.SHOVELS)
                .add(STEEL_SHOVEL);
        getOrCreateTagBuilder(ItemTags.HOES)
                .add(STEEL_HOE);
        // Armor
        getOrCreateTagBuilder(ItemTags.HEAD_ARMOR)
                .add(STEEL_HELMET);
        getOrCreateTagBuilder(ItemTags.CHEST_ARMOR)
                .add(STEEL_CHESTPLATE);
        getOrCreateTagBuilder(ItemTags.LEG_ARMOR)
                .add(STEEL_LEGGINGS);
        getOrCreateTagBuilder(ItemTags.FOOT_ARMOR)
                .add(STEEL_BOOTS);
        // Trimmables
        getOrCreateTagBuilder(ItemTags.TRIMMABLE_ARMOR)
                .add(STEEL_HELMET)
                .add(STEEL_CHESTPLATE)
                .add(STEEL_LEGGINGS)
                .add(STEEL_BOOTS);
        // Beacon Payment
        getOrCreateTagBuilder(ItemTags.BEACON_PAYMENT_ITEMS)
                .add(STEEL_INGOT)
                .add(DIAMOND_INGOT);
        // Trim Material
        getOrCreateTagBuilder(ItemTags.TRIM_MATERIALS)
                .add(DIAMOND_INGOT)
                .add(STEEL_INGOT);
    }
}

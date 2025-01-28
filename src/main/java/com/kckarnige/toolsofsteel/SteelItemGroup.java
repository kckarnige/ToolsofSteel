package com.kckarnige.toolsofsteel;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;

import static com.kckarnige.toolsofsteel.blocks.BlockRegister.*;
import static com.kckarnige.toolsofsteel.items.ItemRegister.*;

public class SteelItemGroup {
    public static ItemGroup makeItemGroup () {
        return FabricItemGroup.builder()
                .icon(() -> new ItemStack(STEEL_INGOT))
                .displayName(Text.translatable("toolsofsteel.itemGroup"))
                .entries((displayContext, entries) -> {
                    entries.add(new ItemStack(STEEL_SWORD));
                    entries.add(new ItemStack(STEEL_AXE));
                    entries.add(new ItemStack(STEEL_PICKAXE));
                    entries.add(new ItemStack(STEEL_SHOVEL));
                    entries.add(new ItemStack(STEEL_HOE));

                    entries.add(new ItemStack(STEEL_HELMET));
                    entries.add(new ItemStack(STEEL_CHESTPLATE));
                    entries.add(new ItemStack(STEEL_LEGGINGS));
                    entries.add(new ItemStack(STEEL_BOOTS));

                    entries.add(new ItemStack(STEEL_NUGGET));
                    entries.add(new ItemStack(STEEL_INGOT));
                    entries.add(new ItemStack(STEEL_BLOCK));

                    entries.add(new ItemStack(DIAMOND_INGOT));
                }).build();
    }
}

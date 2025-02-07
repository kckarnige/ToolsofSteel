package com.kckarnige.toolsofsteel.items;

import com.kckarnige.toolsofsteel.Toolsofsteel;
import com.kckarnige.toolsofsteel.items.armor.SteelSet;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;


public class ItemRegister {

    public static final Item STEEL_INGOT = registerItem("steel_ingot", new Item(new Item.Settings()));
    public static final Item STEEL_NUGGET = registerItem("steel_nugget", new Item(new Item.Settings()));
    public static final Item DIAMOND_INGOT = registerItem("diamond_ingot", new Item(new Item.Settings()));
    public static final Item TIN_NUGGET = registerItem("tin_nugget", new Item(new Item.Settings()));
    public static Item BRONZE_PLATE = registerItem("bronze_plate", new Item(new Item.Settings()));
    public static Item STEEL_PLATE = registerItem("steel_plate", new Item(new Item.Settings()));

    // Sorta taken from AdventureZ's src code
    public static final Item STEEL_HELMET = registerItem("steel_helmet",
            new ArmorItem(SteelSet.STEEL, ArmorItem.Type.HELMET, new Item.Settings().maxDamage(ArmorItem.Type.HELMET.getMaxDamage(26))));
    public static final Item STEEL_CHESTPLATE = registerItem("steel_chestplate",
            new ArmorItem(SteelSet.STEEL, ArmorItem.Type.CHESTPLATE, new Item.Settings().maxDamage(ArmorItem.Type.CHESTPLATE.getMaxDamage(26))));
    public static final Item STEEL_LEGGINGS = registerItem("steel_leggings",
            new ArmorItem(SteelSet.STEEL, ArmorItem.Type.LEGGINGS, new Item.Settings().maxDamage(ArmorItem.Type.LEGGINGS.getMaxDamage(26))));
    public static final Item STEEL_BOOTS = registerItem("steel_boots",
            new ArmorItem(SteelSet.STEEL, ArmorItem.Type.BOOTS, new Item.Settings().maxDamage(ArmorItem.Type.BOOTS.getMaxDamage(26))));

    // Also sorta taken from AdventureZ's src code
    public static final Item NETHERITE_BATTLE_AXE = registerItem("netherite_battle_axe", new AxeItem(ToolMaterials.NETHERITE, (new Item.Settings().rarity(Rarity.EPIC)).attributeModifiers(AxeItem.createAttributeModifiers(ToolMaterials.NETHERITE, 7.0F, -3.4F))));
    public static final Item BATTLE_AXE = registerItem("steel_battle_axe", new AxeItem(SteelToolMaterial.INSTANCE, (new Item.Settings().rarity(Rarity.RARE)).attributeModifiers(AxeItem.createAttributeModifiers(SteelToolMaterial.INSTANCE, 7.0F, -3.4F))));
    public static final Item STEEL_SWORD = registerItem("steel_sword", new SwordItem(SteelToolMaterial.INSTANCE, (new Item.Settings()).attributeModifiers(SwordItem.createAttributeModifiers(SteelToolMaterial.INSTANCE, 3, -2.8F))));
    public static final Item STEEL_SHOVEL = registerItem("steel_shovel", new ShovelItem(SteelToolMaterial.INSTANCE, (new Item.Settings()).attributeModifiers(ShovelItem.createAttributeModifiers(SteelToolMaterial.INSTANCE, 1.5F, -3.2F))));
    public static final Item STEEL_PICKAXE = registerItem("steel_pickaxe", new PickaxeItem(SteelToolMaterial.INSTANCE, (new Item.Settings()).attributeModifiers(PickaxeItem.createAttributeModifiers(SteelToolMaterial.INSTANCE, 1.0F, -3.0F))));
    public static final Item STEEL_AXE = registerItem("steel_axe", new AxeItem(SteelToolMaterial.INSTANCE, (new Item.Settings()).attributeModifiers(AxeItem.createAttributeModifiers(SteelToolMaterial.INSTANCE, 5.0F, -3.4F))));
    public static final Item STEEL_HOE = registerItem("steel_hoe", new HoeItem(SteelToolMaterial.INSTANCE, (new Item.Settings()).attributeModifiers(HoeItem.createAttributeModifiers(SteelToolMaterial.INSTANCE, -3.0F, -1.0F))));


    private static Item registerItem (String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(Toolsofsteel.MOD_ID, name), item);
    }

    public static void registerModItems () {
        Toolsofsteel.LOGGER.info("Forging metals..");

        // Based off the Bronze mod's src code
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.TOOLS).register(content -> {
            content.addBefore(Items.GOLDEN_SHOVEL,
                    STEEL_SHOVEL,
                    STEEL_PICKAXE,
                    STEEL_AXE,
                    STEEL_HOE);
        });
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.COMBAT).register(content -> {
            content.addBefore(Items.GOLDEN_SWORD,
                    STEEL_SWORD);
            content.addBefore(Items.GOLDEN_AXE,
                    STEEL_AXE);
            content.addAfter(Items.MACE,
                    BATTLE_AXE);
            content.addAfter(BATTLE_AXE,
                    NETHERITE_BATTLE_AXE);

            content.addBefore(Items.GOLDEN_HELMET,
                    STEEL_HELMET,
                    STEEL_CHESTPLATE,
                    STEEL_LEGGINGS,
                    STEEL_BOOTS);
        });
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(content -> {
            content.addBefore(Items.COPPER_INGOT,
                    STEEL_INGOT);
            content.addBefore(Items.GOLD_NUGGET,
                    TIN_NUGGET,
                    STEEL_NUGGET);
            content.addAfter(Items.DIAMOND,
                    DIAMOND_INGOT);
        });

    }
}

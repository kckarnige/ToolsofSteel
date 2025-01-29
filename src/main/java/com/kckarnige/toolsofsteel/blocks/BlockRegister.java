package com.kckarnige.toolsofsteel.blocks;

import com.kckarnige.toolsofsteel.Toolsofsteel;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.MapColor;
import net.minecraft.block.enums.NoteBlockInstrument;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;

import static com.kckarnige.toolsofsteel.Toolsofsteel.MOD_ID;

public class BlockRegister {
    public static final Block STEEL_BLOCK = registerBlock("steel_block", new Item.Settings(), AbstractBlock.Settings.create()
            .mapColor(MapColor.STONE_GRAY)
            .instrument(NoteBlockInstrument.IRON_XYLOPHONE)
            .requiresTool()
            .strength(12.5F, 300.0F)
            .sounds(BlockSoundGroup.METAL));
    


    private static void registerBlockItem (String id, Item.Settings item, Block block) {
        //1.21.2+ block reg still sucks, but thank god it's backwards compatible with 1.21
        RegistryKey<Item> itemKey = RegistryKey.of(RegistryKeys.ITEM, Identifier.of(MOD_ID, id));
        Registry.register(Registries.ITEM, itemKey, new BlockItem(block, item));
    }

    private static Block registerBlock(String id, Item.Settings itemSettings, AbstractBlock.Settings blockSettings) {
        RegistryKey<Block> blockKey = RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(MOD_ID, id));
        Block block = new Block(blockSettings);
        registerBlockItem(id, itemSettings, block);
        return Registry.register(Registries.BLOCK, blockKey, block);
    }

    public static void registerModBlocks () {
        Toolsofsteel.LOGGER.info("Flattening Earth..");

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register(content -> {
            content.addAfter(Items.IRON_BLOCK,
                    STEEL_BLOCK);
        });
    }
}

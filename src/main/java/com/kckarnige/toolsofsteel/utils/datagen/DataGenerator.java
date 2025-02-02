package com.kckarnige.toolsofsteel.utils.datagen;

import com.kckarnige.toolsofsteel.items.armor.TrimMaterials;
import com.kckarnige.toolsofsteel.utils.datagen.provider.models;
import com.kckarnige.toolsofsteel.utils.datagen.provider.itemTags;
import com.kckarnige.toolsofsteel.utils.datagen.provider.blockTags;
import com.kckarnige.toolsofsteel.utils.datagen.provider.registryData;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.minecraft.registry.RegistryBuilder;
import net.minecraft.registry.RegistryKeys;

public class DataGenerator implements DataGeneratorEntrypoint {
    @Override
    public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
        FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();
        pack.addProvider(models::new);
        pack.addProvider(itemTags::new);
        pack.addProvider(blockTags::new);
        pack.addProvider(registryData::new);
    }

    @Override
    public void buildRegistry(RegistryBuilder registryBuilder) {
        registryBuilder.addRegistry(RegistryKeys.TRIM_MATERIAL, TrimMaterials::registerModTrims);
    }
}

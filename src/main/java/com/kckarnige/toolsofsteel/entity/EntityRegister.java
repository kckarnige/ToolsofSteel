package com.kckarnige.toolsofsteel.entity;

import com.kckarnige.toolsofsteel.entity.custom.BobEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

import static com.kckarnige.toolsofsteel.Toolsofsteel.MOD_ID;

public class EntityRegister {
    public static final EntityType<BobEntity> JURY = Registry.register(Registries.ENTITY_TYPE,
            Identifier.of(MOD_ID, "jury"),
            EntityType.Builder.create(BobEntity::new, SpawnGroup.MISC)
                    .dimensions(1.0f, 1.85f).build());

    public static void register () {

    }
}

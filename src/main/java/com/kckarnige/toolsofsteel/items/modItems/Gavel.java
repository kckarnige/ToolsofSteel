package com.kckarnige.toolsofsteel.items.modItems;

import com.kckarnige.toolsofsteel.items.ItemRegister;
import com.seacroak.bronze.registry.MainRegistry;
import net.minecraft.entity.*;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.entity.mob.SkeletonEntity;
import net.minecraft.entity.mob.ZombieEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import static com.kckarnige.toolsofsteel.entity.EntityRegister.JURY;

public class Gavel extends Item {
    public Gavel(Settings settings) {
        super(settings);
    }


    @Override
    public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        if (attacker.isPlayer()) {
            PlayerEntity player = (PlayerEntity) attacker;
            if (!player.getWorld().isClient && target instanceof ZombieEntity || target instanceof SkeletonEntity) {
                if (player.getWorld().getTimeOfDay() % 24000 >= 13000) {
                    World world = player.getWorld();

                    Entity lightingBolt = EntityType.LIGHTNING_BOLT.create(world);
                    for (int i = 0; i < 3; i++) {
                        HostileEntity summonJury = JURY.create(world);
                        assert summonJury != null;
                        summonJury.refreshPositionAndAngles(target.getX(), target.getY(), target.getZ(), 0, 0);

                        summonJury.equipStack(EquipmentSlot.MAINHAND, ItemRegister.BATTLE_AXE.getDefaultStack());
                        summonJury.equipStack(EquipmentSlot.OFFHAND, MainRegistry.SICKLE.getDefaultStack());
                        summonJury.equipStack(EquipmentSlot.HEAD, ItemRegister.STEEL_HELMET.getDefaultStack());
                        summonJury.equipStack(EquipmentSlot.CHEST, MainRegistry.BRONZE_CHESTPLATE.getDefaultStack());
                        summonJury.equipStack(EquipmentSlot.FEET, ItemRegister.STEEL_BOOTS.getDefaultStack());
                        summonJury.setHealth(40);

                        world.spawnEntity(summonJury);
                        if (i+1 == 3) {
                            world.spawnEntity(lightingBolt);
                            target.discard();
                        }
                    }

                    // Optionally consume the item (if not in creative mode)
                    if (!player.getAbilities().creativeMode) {
                        stack.decrement(1);
                    }
                } else {
                    player.swingHand(player.getActiveHand(), true);
                }
            }
        }
        super.postHit(stack, target, attacker);
        return true;
    }
}

package com.kckarnige.toolsofsteel.mixin;

import com.kckarnige.toolsofsteel.config.MidnightConfigStuff;
import net.minecraft.item.ToolMaterials;
import net.minecraft.recipe.Ingredient;
import org.spongepowered.asm.mixin.*;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.function.Supplier;

import static com.kckarnige.toolsofsteel.items.ItemRegister.DIAMOND_INGOT;

@Mixin(ToolMaterials.class)
public class VanillaToolChanges {

    @Mutable
    @Final
    @Shadow private int itemDurability;
    @Mutable
    @Final
    @Shadow private Supplier<Ingredient> repairIngredient;

    @Inject(method = "<clinit>", at = @At("TAIL"))
    private static void modifyDiamondMaterial(CallbackInfo ci) {
        replaceDiamondMaterial();
    }

    @Unique
    private static void replaceDiamondMaterial() {
        ToolMaterials diamondMaterial = ToolMaterials.DIAMOND;
        ToolMaterials netheriteMaterial = ToolMaterials.NETHERITE;

        if (!MidnightConfigStuff.REMOVE_DURABILITY_CHANGES) {
            ((VanillaToolChanges) (Object) diamondMaterial).itemDurability = 550;
            ((VanillaToolChanges) (Object) netheriteMaterial).itemDurability = 650;
        }

        if (!MidnightConfigStuff.REMOVE_REPAIR_CHANGES) {
            ((VanillaToolChanges) (Object) diamondMaterial).repairIngredient = () -> Ingredient.ofStacks(DIAMOND_INGOT.getDefaultStack());
        }
    }
}
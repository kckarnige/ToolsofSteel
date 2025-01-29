package com.kckarnige.toolsofsteel.mixin;

import com.kckarnige.toolsofsteel.config.MidnightConfigStuff;
import net.minecraft.item.*;
import net.minecraft.recipe.Ingredient;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.*;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.lang.reflect.Field;
import java.util.function.Supplier;

import static com.kckarnige.toolsofsteel.items.ItemRegister.DIAMOND_INGOT;

@Mixin(ToolMaterials.class)
public class VanillaToolChanges {
    @Inject(method = "<clinit>", at = @At("TAIL"))
    private static void modifyDiamondMaterial(CallbackInfo ci) {
        replaceDiamondMaterial();
    }

    @Unique
    private static void replaceDiamondMaterial() {
        try {
            // Access the material info
            Field diamondField = ToolMaterials.class.getDeclaredField("DIAMOND");
            Field netheriteField = ToolMaterials.class.getDeclaredField("NETHERITE");
            diamondField.setAccessible(true);
            netheriteField.setAccessible(true);

            // Make the material info editable
            ToolMaterials diamondMaterial = (ToolMaterials) diamondField.get(null);
            ToolMaterials netheriteMaterial = (ToolMaterials) netheriteField.get(null);



            if (!MidnightConfigStuff.REMOVE_DURABILITY_CHANGES) {
                // Access itemDurability variable in ToolMaterials class
                Field durabilityField = ToolMaterials.class.getDeclaredField("itemDurability");
                durabilityField.setAccessible(true);

                durabilityField.set(diamondMaterial, 550);
                durabilityField.set(netheriteMaterial, 650);
            }

            if (!MidnightConfigStuff.REMOVE_REPAIR_CHANGES) {
                // Access repairIngredient variable in ToolMaterials class
                Field repairIngredientField = ToolMaterials.class.getDeclaredField("repairIngredient");
                repairIngredientField.setAccessible(true);

                repairIngredientField.set(diamondMaterial, (Supplier<Ingredient>) () -> Ingredient.ofStacks(DIAMOND_INGOT.getDefaultStack()));
            }

        } catch (Exception e) {
            throw new RuntimeException("Failed to replace Diamond and Netherite tool durability", e);
        }
    }
}

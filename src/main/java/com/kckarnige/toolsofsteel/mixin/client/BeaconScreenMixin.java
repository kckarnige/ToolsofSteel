package com.kckarnige.toolsofsteel.mixin.client;

import com.llamalad7.mixinextras.sugar.Local;
import static com.kckarnige.toolsofsteel.items.ItemRegister.STEEL_INGOT;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.ingame.BeaconScreen;
import net.minecraft.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(BeaconScreen.class)
public abstract class BeaconScreenMixin {
    @Inject(method = "drawBackground", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/util/math/MatrixStack;pop()V", shift = At.Shift.BEFORE))
    private void drawBeforeIron(DrawContext context, float delta, int mouseX, int mouseY, CallbackInfo ci,
                               @Local(ordinal = 2) int i,
                               @Local(ordinal = 3) int j) {
        context.drawItem(new ItemStack(STEEL_INGOT), i + 42 + 62, j + 115);
    }
}
package com.kckarnige.toolsofsteel.mixin.client;

import com.llamalad7.mixinextras.sugar.Local;

import static com.kckarnige.toolsofsteel.items.ItemRegister.DIAMOND_INGOT;
import static com.kckarnige.toolsofsteel.items.ItemRegister.STEEL_INGOT;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.ingame.BeaconScreen;
import net.minecraft.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

// Taken from the Bronze mod's src code
@Mixin(BeaconScreen.class)
public abstract class BeaconScreenMixin {
    @Inject(method = "drawBackground", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/util/math/MatrixStack;pop()V", shift = At.Shift.BEFORE))
    private void drawAfterGold(DrawContext context, float delta, int mouseX, int mouseY, CallbackInfo ci,
                               @Local(ordinal = 2) int i,
                               @Local(ordinal = 3) int j) {
        context.drawItem(new ItemStack(DIAMOND_INGOT), i + 42 + 42, j + 112);
    }
    @Inject(method = "drawBackground", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/util/math/MatrixStack;pop()V", shift = At.Shift.AFTER))
    private void drawBeforeGold(DrawContext context, float delta, int mouseX, int mouseY, CallbackInfo ci,
                                @Local(ordinal = 2) int i,
                                @Local(ordinal = 3) int j) {
        context.drawItem(new ItemStack(STEEL_INGOT), i + 42 + 46, j + 106);
    }
}
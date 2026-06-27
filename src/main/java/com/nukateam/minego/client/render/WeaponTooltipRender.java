package com.nukateam.minego.client.render;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import org.joml.Quaternionf;
import org.joml.Vector3f;

@OnlyIn(Dist.CLIENT)
public class WeaponTooltipRender {
    private final GuiGraphics CONTEXT;
    private ItemStack stack = ItemStack.EMPTY;
    public WeaponTooltipRender(GuiGraphics context) {
        this.CONTEXT = context;
    }

    public void define(ItemStack stack) {
        this.stack = stack;
    }

    public ItemStack stack() {
        return this.stack;
    }


    public GuiGraphics context() {
        return this.CONTEXT;
    }

    public PoseStack pose() {
        return context().pose();
    }

    public MultiBufferSource.BufferSource bufferSource() {
        return context().bufferSource();
    }


    public void drawManaged(Runnable runnable) {
        context().drawManaged(runnable);
    }

    public void blit(ResourceLocation texture, int x, int y, int xTex, int yTex, int width, int height, int widthTex, int heightTex) {
        context().blit(texture, x, y, xTex, yTex, width, height, widthTex, heightTex);
    }



    public void fillGradient(int x, int y, int width, int height, int start, int end) {
        context().fillGradient(x, y, x + width, y + height, start, end);
    }

    public int width() {
        return context().guiWidth();
    }
    public int height() {
        return context().guiHeight();
    }

    public void push(Runnable runnable) {
        context().pose().pushPose();
        try { runnable.run(); } catch (Exception ignored) {}
        context().pose().popPose();
    }
    public void scale(float x, float y, float z) {
        context().pose().scale(x, y, z);
    }
    public void translate(float x, float y, float z) {
        context().pose().translate(x, y, z);
    }
    public void mul(Quaternionf quat) {
        context().pose().mulPose(quat);
    }

    public void flush() {
        context().flush();
    }
}

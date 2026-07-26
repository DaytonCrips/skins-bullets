package com.nukateam.minego.client.render;

import com.nukateam.minego.client.render.layers.tooltips.TooltipFormat;
import com.nukateam.minego.common.util.WeaponTooltipBuilder;
import com.nukateam.minego.utils.StackUtils;
import com.nukateam.ntgl.common.foundation.item.WeaponItem;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Font;
import net.minecraft.client.gui.screens.inventory.tooltip.ClientTooltipComponent;
import net.minecraft.client.gui.screens.inventory.tooltip.ClientTooltipPositioner;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.phys.Vec2;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import net.neoforged.fml.common.EventBusSubscriber;
import org.joml.Vector2ic;

import javax.annotation.Nullable;
import java.awt.*;
import java.util.List;

@OnlyIn(Dist.CLIENT)
@EventBusSubscriber(value = Dist.CLIENT)
public class WeaponTooltip {
    @Nullable
    private static TooltipFormat renderStyle = null;

    private static ItemStack renderStack = ItemStack.EMPTY;



    public static boolean build(WeaponTooltipRender renderer, ItemStack stack, Font font, List<ClientTooltipComponent> components, int x, int y, ClientTooltipPositioner positioner) {
        if (stack.getItem() instanceof WeaponItem && !StackUtils.getCollection(stack).equals("default")) {
            updateStyle(stack);
        } else return false;
        if (renderStyle == null || components.isEmpty()) return false;

        renderer.define(renderStack);
        String collectionString = StackUtils.getCollection(stack);
        final Component wear = Component.translatable("tooltip.sign." + collectionString);
        final Point size = calcSize(font, components, wear);
        final Vector2ic rawPos = positioner.positionTooltip(renderer.width(), renderer.height(), x, y, size.x, size.y);
        final Vec2 pos = new Vec2(rawPos.x(), rawPos.y());

        renderer.pose().pushPose();
        renderer.drawManaged(() -> renderStyle.renderBack(renderer, pos, size, true));
        renderer.pose().translate(0F, 0F, 400F);
        renderer.context().drawString(Minecraft.getInstance().font, wear, (int) pos.x + 26, (int) pos.y + 13, 0xff505050);
        renderText(renderer, font, components, pos);
        renderImages(renderer, font, components, pos);
        renderer.drawManaged(() -> renderStyle.renderFront(renderer, pos, size));
        renderer.pose().popPose();
        renderer.context().renderItem(stack, 0, 0);
        renderer.flush();
        return true;
    }



    private static Point calcSize(Font font, List<ClientTooltipComponent> components, Component wear) {
        int width = 26 + components.get(0).getWidth(font);
        int height = 14;
        for (ClientTooltipComponent component : components) {
            int componentWidth = component.getWidth(font);
            if (componentWidth > width) width = componentWidth;
            height += component.getHeight();
        }
        final int SummaryWidth = 26 + font.width(wear.getString());
        if (SummaryWidth > width) width = SummaryWidth;
        return new Point(width, height);
    }

    private static void renderText(WeaponTooltipRender renderer, Font font, List<ClientTooltipComponent> components, Vec2 pos) {
        int offset = (int) pos.y + 3;
        for (int i = 0; i < components.size(); ++i) {
            ClientTooltipComponent component = components.get(i);
            component.renderText(font, (int) pos.x + (i == 0 ? 26 : 0), offset, renderer.pose().last().pose(), renderer.bufferSource());
            offset += component.getHeight() + (i == 0 ? 13 : 0);
        }
    }

    private static void renderImages(WeaponTooltipRender renderer, Font font, List<ClientTooltipComponent> components, Vec2 pos) {
        int offset = (int) pos.y + 4;
        for (int i = 0; i < components.size(); ++i) {
            ClientTooltipComponent component = components.get(i);
            component.renderImage(font, (int) pos.x, offset, renderer.context());
            offset += component.getHeight() + (i == 0 ? 13 : 0);
        }
    }
    private static void resetTooltip() {
        if (renderStyle != null) renderStyle.reset();
        renderStyle = null;
    }

    private static void updateStyle(ItemStack stack) {
        if (stack.isEmpty()) resetTooltip();
        else {
            if (stack == renderStack) return;
            resetTooltip();
            renderStack = stack;
            renderStyle = WeaponTooltipBuilder.defaultStyle(stack).orElse(null);
            if (renderStyle != null) renderStyle.reset();
        }
        renderStack = stack;
    }

}

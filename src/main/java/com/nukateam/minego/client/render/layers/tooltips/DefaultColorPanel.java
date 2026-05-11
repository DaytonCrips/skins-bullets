package com.nukateam.minego.client.render.layers.tooltips;

import com.nukateam.minego.client.render.WeaponTooltipRender;
import com.nukateam.minego.utils.SkinManager;
import com.nukateam.minego.utils.StackUtils;
import net.minecraft.client.gui.screens.inventory.tooltip.TooltipRenderUtil;
import net.minecraft.network.chat.Style;
import net.minecraft.world.phys.Vec2;

import java.awt.*;

public class DefaultColorPanel implements WeaponPanels {

    public DefaultColorPanel() {
    }

    @Override
    public void render(WeaponTooltipRender renderer, Vec2 pos, Point size, boolean slot) {
        final int x = (int) pos.x, y = (int) pos.y;
        int rarityColor = SkinManager.setRarityAlphaColor(StackUtils.getRarity(renderer.stack()));
        TooltipRenderUtil.renderTooltipBackground(renderer.context(), x, y, size.x, size.y, 400, 0xf0100010, 0xf0100010, rarityColor, rarityColor);
        if (!slot) return;
        renderer.push(() -> {
            renderer.translate(0, 0, 400);
            renderer.fillGradient(x + 2, y + 1, 20, 1, 0x20FFFFFF, 0x20FFFFFF);
            renderer.fillGradient(x + 1, y + 2, 22, 20, 0x20FFFFFF, 0x20FFFFFF);
            renderer.fillGradient(x + 2, y + 22, 20, 1, 0x20FFFFFF, 0x20FFFFFF);
        });
    }
}

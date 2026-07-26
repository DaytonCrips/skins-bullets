package com.nukateam.minego.client.render.layers.tooltips;

import com.nukateam.minego.client.render.WeaponTooltipRender;
import com.nukateam.minego.common.registry.WeaponTooltipRegistry;
import net.minecraft.world.phys.Vec2;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;

import java.awt.*;

@OnlyIn(Dist.CLIENT)
public final class TooltipFormat {
    //private final ImmutableList<TooltipEffect> EFFECTS;
    private final WeaponPanels PANEL;
    private final WeaponFrames FRAME;
    private final WeaponCollection ICON;

    private TooltipFormat(WeaponPanels panel, WeaponFrames frame, WeaponCollection icon) {
        PANEL = panel;
        FRAME = frame;
        ICON = icon;
    }

    public void renderBack(WeaponTooltipRender renderer, Vec2 pos, Point size, boolean slot) {
        PANEL.render(renderer, pos, size, slot);
    }

    public void renderFront(WeaponTooltipRender renderer, Vec2 pos, Point size) {
        FRAME.render(renderer, pos, size);
        renderer.push(() -> {
            renderer.translate(pos.x + 12, pos.y + 12, 500);
            renderer.push(() -> ICON.render(renderer, -8, -8));
        });
    }

//    public void renderEffects(Effects.Order order, WeaponTooltipRender renderer, Vec2 pos, Point size) {
//        renderer.push(() -> {
//            renderer.translate(0, 0, switch (order) {
//                case LAYER_1_BACK -> 0;
//                case LAYER_2_BACK$TEXT -> 100;
//                case LAYER_3_TEXT$FRAME -> 400;
//                case LAYER_4_FRAME$ICON -> 500;
//                case LAYER_5_FRONT -> 1000;
//            });
//            for (TooltipEffect effect : EFFECTS)
//                if (effect.order().equals(order))
//                    effect.render(renderer, pos, size);
//        });
//    }

    public void reset() {
        PANEL.reset();
        ICON.reset();
        FRAME.reset();
    }

    public static class Builder {
        private WeaponPanels panel = WeaponTooltipRegistry.BUILTIN_PANEL_DEFAULT.get();
        private WeaponFrames frame = WeaponTooltipRegistry.BUILTIN_FRAME_BLANK.get();
        private WeaponCollection icon = WeaponTooltipRegistry.BUILTIN_ICON_COMMON.get();

        public Builder() {}

        public TooltipFormat.Builder withPanel(WeaponPanels panel) {
            this.panel = panel;
            return this;
        }

        public TooltipFormat.Builder withFrame(WeaponFrames frame) {
            this.frame = frame;
            return this;
        }

        public TooltipFormat.Builder withIcon(WeaponCollection icon) {
            this.icon = icon;
            return this;
        }

        public TooltipFormat build() {
            return new TooltipFormat(panel, frame, icon);
        }
    }

}

package com.nukateam.minego.common.util;

import com.nukateam.minego.client.render.layers.tooltips.CollectionIcon;
import com.nukateam.minego.client.render.layers.tooltips.TooltipFormat;
import com.nukateam.minego.client.render.layers.tooltips.WeaponFrames;
import com.nukateam.minego.client.render.layers.tooltips.WeaponPanels;
import com.nukateam.minego.common.registry.WeaponTooltipRegistry;
import net.minecraft.world.item.ItemStack;

import java.util.Optional;

public class WeaponTooltipBuilder {

    public static Optional<TooltipFormat> defaultStyle(ItemStack stack) {
        return Optional.of(new TooltipFormat.Builder()
                .withPanel(defaultPanel(stack))
                .withFrame(defaultFrame(stack))
                .withIcon(defaultIcon(stack))
                .build());
    }

    public static WeaponPanels defaultPanel(ItemStack stack) {
        return WeaponTooltipRegistry.BUILTIN_PANEL_DEFAULT.get();
//        return searchPreset(new ArrayList<>(PRESET_PANELS), stack)
//                .map(tooltipPanelPreset -> tooltipPanelPreset.ELEMENT)
//                .orElse(TooltipsRegistry.BUILTIN_PANEL_DEFAULT.get());
    }
    public static WeaponFrames defaultFrame(ItemStack stack) {
        return WeaponTooltipRegistry.BUILTIN_FRAME_BLANK.get();
//        return searchPreset(new ArrayList<>(PRESET_FRAMES), stack)
//                .map(tooltipPanelPreset -> tooltipPanelPreset.ELEMENT)
//                .orElse(TooltipsRegistry.BUILTIN_FRAME_BLANK.get());
    }
    public static CollectionIcon defaultIcon(ItemStack stack) {
        return WeaponTooltipRegistry.BUILTIN_ICON_COMMON.get();
//        return searchPreset(new ArrayList<>(PRESET_ICONS), stack)
//                .map(tooltipPanelPreset -> tooltipPanelPreset.ELEMENT)
//                .orElse(TooltipsRegistry.BUILTIN_ICON_COMMON.get());
    }
}

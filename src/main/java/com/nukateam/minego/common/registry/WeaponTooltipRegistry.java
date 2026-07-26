package com.nukateam.minego.common.registry;

import com.nukateam.minego.MinecraftGo;
import com.nukateam.minego.client.render.layers.tooltips.*;

import net.minecraft.resources.ResourceLocation;

import java.util.HashMap;

import static com.nukateam.minego.MinecraftGo.mineGoResource;

public class WeaponTooltipRegistry {
    private static final HashMap<ResourceLocation, WeaponElement<? extends WeaponPanels>> PANELS = new HashMap<>();
    private static final HashMap<ResourceLocation, WeaponElement<? extends WeaponFrames>> FRAMES = new HashMap<>();
    private static final HashMap<ResourceLocation, WeaponElement<? extends WeaponCollection>> ICONS = new HashMap<>();

    public static final WeaponElement<DefaultColorPanel> BUILTIN_PANEL_DEFAULT;
    public static final WeaponElement<WeaponFrames> BUILTIN_FRAME_BLANK;
    public static final WeaponElement<CollectionIcon> BUILTIN_ICON_COMMON;

    static {
        BUILTIN_PANEL_DEFAULT = registerPanel(builtinKey("default"),
                params -> new DefaultColorPanel());

        BUILTIN_FRAME_BLANK = registerFrame(builtinKey("blank"),
                params -> (renderer, pos, size) -> {});

        BUILTIN_ICON_COMMON = registerIcon(builtinKey("common"),
                params -> new CollectionIcon());
    }

    public static <T extends WeaponPanels> WeaponElement<T> registerPanel(ResourceLocation key, WeaponElement<T> factory) {
        PANELS.put(key, factory);
        return factory;
    }
    public static <T extends WeaponFrames> WeaponElement<T> registerFrame(ResourceLocation key, WeaponElement<T> factory) {
        FRAMES.put(key, factory);
        return factory;
    }

    public static <T extends CollectionIcon> WeaponElement<T> registerIcon(ResourceLocation key, WeaponElement<T> factory) {
        ICONS.put(key, factory);
        return factory;
    }

    private static ResourceLocation builtinKey(String key) {
        return mineGoResource("builtin_" + key);
    }
    public static void setup() {}
}

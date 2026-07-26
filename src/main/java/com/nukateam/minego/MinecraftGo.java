package com.nukateam.minego;

import com.mojang.logging.LogUtils;
import com.nukateam.minego.client.render.layers.tooltips.TooltipPresets;
import com.nukateam.minego.common.registry.*;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.loading.FMLEnvironment;
import org.jetbrains.annotations.NotNull;
import org.slf4j.Logger;

@Mod(MinecraftGo.MOD_ID)
public class MinecraftGo {
    public static final String MOD_ID = "minego";
    public static final Logger LOGGER = LogUtils.getLogger();

    public MinecraftGo(IEventBus MOD_EVENT_BUS, ModContainer container) {
        ModWeapons.register(MOD_EVENT_BUS);
        ModItems.register(MOD_EVENT_BUS);
        ModSounds.register(MOD_EVENT_BUS);
        ModTabsRegistry.register(MOD_EVENT_BUS);
        ModDataComponents.register(MOD_EVENT_BUS);

        if (FMLEnvironment.dist == Dist.CLIENT) {
            WeaponTooltipRegistry.setup();
        }
        final var bones = new TooltipPresets.Builder()
                .withFrame(WeaponTooltipRegistry.BUILTIN_FRAME_BLANK.get())
                .build();
    }

    public static @NotNull ResourceLocation mineGoResource(String name) {
        return ResourceLocation.fromNamespaceAndPath(MinecraftGo.MOD_ID, name);
    }
}

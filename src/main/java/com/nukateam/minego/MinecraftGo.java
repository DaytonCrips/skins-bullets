package com.nukateam.minego;

import com.mojang.logging.LogUtils;
import com.nukateam.minego.client.render.layers.tooltips.TooltipPresets;
import com.nukateam.minego.common.registry.*;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.loading.FMLEnvironment;
import org.slf4j.Logger;


@Mod(MinecraftGo.MOD_ID)
public class MinecraftGo {
    public static final String MOD_ID = "minego";
    public static final Logger LOGGER = LogUtils.getLogger();
    public static final IEventBus MOD_EVENT_BUS = FMLJavaModLoadingContext.get().getModEventBus();

    public MinecraftGo() {
        ModWeapons.register(MOD_EVENT_BUS);
        ModItems.register(MOD_EVENT_BUS);
        ModSounds.register(MOD_EVENT_BUS);
        ModTabsRegistry.register(MOD_EVENT_BUS);

        if (FMLEnvironment.dist == Dist.CLIENT) {
            WeaponTooltipRegistry.setup();
        }
        final TooltipPresets bones = new TooltipPresets.Builder().withFrame(WeaponTooltipRegistry.BUILTIN_FRAME_BLANK.get()).build();

    }

}

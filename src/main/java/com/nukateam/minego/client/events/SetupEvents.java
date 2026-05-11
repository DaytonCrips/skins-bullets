package com.nukateam.minego.client.events;

import com.nukateam.minego.MinecraftGo;
import com.nukateam.minego.client.models.GunIconBake;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.ModelEvent;
import net.minecraftforge.client.event.RegisterClientTooltipComponentFactoriesEvent;
import net.minecraftforge.client.gui.ClientTooltipComponentManager;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@Mod.EventBusSubscriber(modid = MinecraftGo.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class SetupEvents {


    @SubscribeEvent
    public static void registerModels(ModelEvent.RegisterGeometryLoaders event) {
        event.register("gun_icon_loader", GunIconBake.Loader.INSTANCE);
    }
}

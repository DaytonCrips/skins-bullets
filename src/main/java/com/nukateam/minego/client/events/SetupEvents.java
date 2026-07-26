package com.nukateam.minego.client.events;

import com.nukateam.minego.MinecraftGo;
import com.nukateam.minego.client.models.GunIconBake;

import net.minecraft.resources.ResourceLocation;
import net.neoforged.api.distmarker.Dist;

import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.ModelEvent;
import org.jetbrains.annotations.NotNull;

import static com.nukateam.minego.MinecraftGo.mineGoResource;

@EventBusSubscriber(modid = MinecraftGo.MOD_ID, value = Dist.CLIENT)
public class SetupEvents {
    @SubscribeEvent
    public static void registerModels(ModelEvent.RegisterGeometryLoaders event) {
        event.register(mineGoResource("gun_icon_loader"), GunIconBake.Loader.INSTANCE);
    }
}

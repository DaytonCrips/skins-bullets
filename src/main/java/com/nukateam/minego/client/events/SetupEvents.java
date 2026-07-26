package com.nukateam.minego.client.events;

import com.nukateam.minego.MinecraftGo;
import com.nukateam.minego.client.models.GunIconBake;
import com.nukateam.minego.client.render.*;
import com.nukateam.minego.common.foundation.CaseWeaponItem;
import com.nukateam.minego.common.registry.ModWeapons;
import com.nukateam.ntgl.client.registry.WeaponRegistry;
import net.neoforged.api.distmarker.Dist;
import com.nukateam.minego.client.render.animators.*;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.neoforge.client.event.ModelEvent;

import static com.nukateam.minego.MinecraftGo.mineGoResource;

@EventBusSubscriber(modid = MinecraftGo.MOD_ID, value = Dist.CLIENT)
public class SetupEvents {
    @SubscribeEvent
    public static void registerModels(ModelEvent.RegisterGeometryLoaders event) {
        event.register(mineGoResource("gun_icon_loader"), GunIconBake.Loader.INSTANCE);
    }

    @SubscribeEvent
    public static void onCommonSetup(FMLClientSetupEvent event) {
        ModWeapons.ITEMS.getEntries().forEach((entry) -> {
            if(entry.get() instanceof CaseWeaponItem weaponItem){
                WeaponRegistry.registerRenderer(weaponItem, new CustomWeaponRendererGeo());
            }
        });

        WeaponRegistry.registerAnimator(ModWeapons.GUTKNIFE   .get(), KnifesAnimator::new);
        WeaponRegistry.registerAnimator(ModWeapons.FLIPKNIFE  .get(), KnifesAnimator::new);
        WeaponRegistry.registerAnimator(ModWeapons.SPIRITKNIFE.get(), KnifesAnimator::new);
    }
}

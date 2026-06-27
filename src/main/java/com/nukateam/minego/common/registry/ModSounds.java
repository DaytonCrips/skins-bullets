package com.nukateam.minego.common.registry;

import com.nukateam.minego.MinecraftGo;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModSounds {
    public static final DeferredRegister<SoundEvent> SOUNDS = DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, MinecraftGo.MOD_ID);





    public static final RegistryObject<SoundEvent> ITEM_KNIFE_INSPECT = register("item.knife.inspect");
    public static final RegistryObject<SoundEvent> ITEM_KNIFE_SLASH = register("item.knife.slash");
    public static final RegistryObject<SoundEvent> ITEM_KNIFE_CLICK = register("item.knife.click");
    public static final RegistryObject<SoundEvent> ITEM_KNIFE_EQUIP = register("item.knife.equip");


    public static final RegistryObject<SoundEvent> ITEM_ZEUS_FIRE = register("item.zeus.fire");

    public static final RegistryObject<SoundEvent> ITEM_CZ75_FIRE = register("item.cz75.fire");
    public static final RegistryObject<SoundEvent> ITEM_DEAGLE_FIRE = register("item.deagle.fire");
    public static final RegistryObject<SoundEvent> ITEM_DEAGLE_DRAW = register("item.deagle.draw");
    public static final RegistryObject<SoundEvent> ITEM_DEAGLE_CLIPOUT = register("item.deagle.clipout");
    public static final RegistryObject<SoundEvent> ITEM_DEAGLE_CLIPIN = register("item.deagle.clipin");

    public static final RegistryObject<SoundEvent> ITEM_FAMAS_FIRE = register("item.famas.fire");
    public static final RegistryObject<SoundEvent> ITEM_FAMAS_DRAW = register("item.famas.draw");
    public static final RegistryObject<SoundEvent> ITEM_FAMAS_CLIPOUT = register("item.famas.clipout");
    public static final RegistryObject<SoundEvent> ITEM_FAMAS_CLIPIN = register("item.famas.clipin");
    public static final RegistryObject<SoundEvent> ITEM_FAMAS_BOLFFORWARD = register("item.famas.boltforward");

    public static final RegistryObject<SoundEvent> ITEM_AK47_FIRE = register("item.ak47.fire");
    public static final RegistryObject<SoundEvent> ITEM_AK47_DRAW = register("item.ak47.draw");
    public static final RegistryObject<SoundEvent> ITEM_AK47_CLIPOUT = register("item.ak47.clipout");
    public static final RegistryObject<SoundEvent> ITEM_AK47_CLIPIN = register("item.ak47.clipin");
    public static final RegistryObject<SoundEvent> ITEM_AK47_BOLTPULL = register("item.ak47.boltpull");



    public static final RegistryObject<SoundEvent> ITEM_P250_FIRE = register("item.p250.fire");
    public static final RegistryObject<SoundEvent> ITEM_P250_CLIP = register("item.p250.clip");
    public static final RegistryObject<SoundEvent> ITEM_P250_CLIPOUT = register("item.p250.clipout");
    public static final RegistryObject<SoundEvent> ITEM_P250_SLIDE= register("item.p250.slide");

    public static final RegistryObject<SoundEvent> ITEM_TEC9_FIRE= register("item.tec9.fire");
    public static final RegistryObject<SoundEvent> ITEM_TEC9_CLIPIN = register("item.tec9.clipin");
    public static final RegistryObject<SoundEvent> ITEM_TEC9_CLIPOUT = register("item.tec9.clipout");
    public static final RegistryObject<SoundEvent> ITEM_TEC9_EQUIP = register("item.tec9.equip");
    public static final RegistryObject<SoundEvent> ITEM_TEC9_BOLTPULL = register("item.tec9.boltpull");


    public static final RegistryObject<SoundEvent> ITEM_M4A1S_BOLTPULL = register("item.m4a1s.boltpull");
    public static final RegistryObject<SoundEvent> ITEM_M4A1S_FIRE = register("item.m4a1s.fire");
    public static final RegistryObject<SoundEvent> ITEM_M4A1S_SILENCEFIRE = register("item.m4a1s.silenced_fire");
    public static final RegistryObject<SoundEvent> ITEM_M4A1S_CLIPIN = register("item.m4a1s.clipin");
    public static final RegistryObject<SoundEvent> ITEM_M4A1S_CLIPOUT= register("item.m4a1s.clipout");
    public static final RegistryObject<SoundEvent> ITEM_M4A1S_EQUIP = register("item.m4a1s.equip");

    public static final RegistryObject<SoundEvent> ITEM_BERRETA_CLIPIN = register("item.berreta.clipin");
    public static final RegistryObject<SoundEvent> ITEM_BERRETA_CLIPOUT = register("item.berreta.clipout");
    public static final RegistryObject<SoundEvent> ITEM_BERRETA_FIRE = register("item.berreta.fire");
    public static final RegistryObject<SoundEvent> ITEM_BERRETA_EQUIP = register("item.berreta.equip");
    public static final RegistryObject<SoundEvent> ITEM_BERRETA_SLIDE = register("item.berreta.slide");


    public static final RegistryObject<SoundEvent> ITEM_NOVA_SLIDE = register("item.nova.slide");
    public static final RegistryObject<SoundEvent> ITEM_NOVA_FIRE = register("item.nova.fire");
    public static final RegistryObject<SoundEvent> ITEM_NOVA_SHELL = register("item.nova.shell");
    public static final RegistryObject<SoundEvent> ITEM_NOVA_EQUIP = register("item.nova.equip");

    public static final RegistryObject<SoundEvent> ITEM_FSEVEN_EQUIP = register("item.fiveseven.equip");
    public static final RegistryObject<SoundEvent> ITEM_FSEVEN_FIRE = register("item.fiveseven.fire");
    public static final RegistryObject<SoundEvent> ITEM_FSEVEN_CLIPOUT = register("item.fiveseven.clipout");
    public static final RegistryObject<SoundEvent> ITEM_FSEVEN_CLIPIN = register("item.fiveseven.clipin");
    public static final RegistryObject<SoundEvent> ITEM_FSEVEN_SLIDE = register("item.fiveseven.slide");

    public static final RegistryObject<SoundEvent> ITEM_USP_SLIDE = register("item.usp.slide");
    public static final RegistryObject<SoundEvent> ITEM_USP_SILENCEFIRE = register("item.usp.silenced_fire");
    public static final RegistryObject<SoundEvent> ITEM_USP_CLIPIN = register("item.usp.clipin");
    public static final RegistryObject<SoundEvent> ITEM_USP_CLIPOUT = register("item.usp.clipout");
    public static final RegistryObject<SoundEvent> ITEM_USP_EQUIP = register("item.usp.equip");

    public static final RegistryObject<SoundEvent> ITEM_MP9_EQUIP = register("item.mp9.equip");
    public static final RegistryObject<SoundEvent> ITEM_MP9_FIRE = register("item.mp9.fire");
    public static final RegistryObject<SoundEvent> ITEM_MP9_CLIPIN = register("item.mp9.clipin");
    public static final RegistryObject<SoundEvent> ITEM_MP9_CLIPOUT = register("item.mp9.clipout");
    public static final RegistryObject<SoundEvent> ITEM_MP9_SLIDE = register("item.mp9.boltforward");

    public static final RegistryObject<SoundEvent> ITEM_P90_FIRE = register("item.p90.fire");
    public static final RegistryObject<SoundEvent> ITEM_P90_CLIPIN = register("item.p90.clipin");
    public static final RegistryObject<SoundEvent> ITEM_P90_CLIPOUT = register("item.p90.clipout");
    public static final RegistryObject<SoundEvent> ITEM_P90_SLIDE = register("item.p90.slide");
    public static final RegistryObject<SoundEvent> ITEM_P90_EQUIP = register("item.p90.equip");

    public static final RegistryObject<SoundEvent> ITEM_SCAR20_EQUIP = register("item.scar20.draw");
    public static final RegistryObject<SoundEvent> ITEM_SCAR20_FIRE = register("item.scar20.fire");
    public static final RegistryObject<SoundEvent> ITEM_SCAR20_CLIPIN = register("item.scar20.clipin");
    public static final RegistryObject<SoundEvent> ITEM_SCAR20_CLIPOUT  = register("item.scar20.clipout");
    public static final RegistryObject<SoundEvent> ITEM_SCAR20_BOLFFORWARD  = register("item.scar20.boltforward");

    public static final RegistryObject<SoundEvent> ITEM_SSG08_EQUIP = register("item.ssg08.draw");
    public static final RegistryObject<SoundEvent> ITEM_SSG08_FIRE = register("item.ssg08.fire");
    public static final RegistryObject<SoundEvent> ITEM_SSG08_CLIPIN = register("item.ssg08.clipin");
    public static final RegistryObject<SoundEvent> ITEM_SSG08_CLIPOUT  = register("item.ssg08.clipout");
    public static final RegistryObject<SoundEvent> ITEM_SSG08_BOLFFORWARD  = register("item.ssg08.boltforward");

    public static final RegistryObject<SoundEvent> ITEM_AWP_EQUIP = register("item.awp.draw");
    public static final RegistryObject<SoundEvent> ITEM_AWP_FIRE = register("item.awp.fire");
    public static final RegistryObject<SoundEvent> ITEM_AWP_CLIPIN = register("item.awp.clipin");
    public static final RegistryObject<SoundEvent> ITEM_AWP_CLIPOUT  = register("item.awp.clipout");
    public static final RegistryObject<SoundEvent> ITEM_AWP_BOLFFORWARD  = register("item.awp.boltforward");
    public static final RegistryObject<SoundEvent> ITEM_PISTOL_SILENCED = register("item.default.pistol_silencedfire");
    public static final RegistryObject<SoundEvent> ITEM_SHOTGUN_SILENCED = register("item.default.shotgun_silencedfire");
    public static final RegistryObject<SoundEvent> ITEM_SMG_SILENCED = register("item.default.smg_silencedfire");
    public static final RegistryObject<SoundEvent> ITEM_SNIPER_SILENCED = register("item.default.sniper_silencedfire");
    public static RegistryObject<SoundEvent> register(String key) {
        return SOUNDS.register(key, () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(MinecraftGo.MOD_ID, key)));
    }

    public static void register(IEventBus eventBus) {
        SOUNDS.register(eventBus);
    }
}

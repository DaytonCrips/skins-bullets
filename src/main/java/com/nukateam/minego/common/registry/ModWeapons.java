package com.nukateam.minego.common.registry;

import com.nukateam.minego.MinecraftGo;
import com.nukateam.minego.common.foundation.CaseMeleeItem;
import com.nukateam.minego.common.foundation.CaseWeaponItem;
import com.nukateam.ntgl.common.foundation.item.WeaponItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModWeapons {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, MinecraftGo.MOD_ID);

    public static final RegistryObject<WeaponItem> AK47 = registerGun("ak47");

    public static final RegistryObject<WeaponItem> FAMAS = registerGun("famas");
    public static final RegistryObject<WeaponItem> P250 = registerGun("p250");
    public static final RegistryObject<WeaponItem> CZ75 = registerGun("cz75");
    public static final RegistryObject<WeaponItem> P2000 = registerGun("p2000");
    public static final RegistryObject<WeaponItem> SAWED = registerGun("sawedoff");
    public static final RegistryObject<WeaponItem> DEAGLE = registerGun("deagle");
    public static final RegistryObject<WeaponItem> GLOCK = registerGun("glock");
    public static final RegistryObject<WeaponItem> BERRETA = registerGun("berreta");
    public static final RegistryObject<WeaponItem> TEC9 = registerGun("tec9");
    public static final RegistryObject<WeaponItem> M4A1S = registerGun("m4a1s");
    public static final RegistryObject<WeaponItem> NOVA = registerGun("nova");
    public static final RegistryObject<WeaponItem> FIVESEVEN = registerGun("fiveseven");
    public static final RegistryObject<WeaponItem> USP = registerGun("usp");
    public static final RegistryObject<WeaponItem> MP9 = registerGun("mp9");
    public static final RegistryObject<WeaponItem> P90 = registerGun("p90");
    public static final RegistryObject<WeaponItem> SCAR20 = registerGun("scar20");
    public static final RegistryObject<WeaponItem> SSG08 = registerGun("ssg08");
    public static final RegistryObject<WeaponItem> AWP = registerGun("awp");
    public static final RegistryObject<WeaponItem> AUG = registerGun("aug");
    public static final RegistryObject<WeaponItem> SG553 = registerGun("sg553");
    public static final RegistryObject<WeaponItem> GUTKNIFE = registerMelee("gutknife");

    public static final RegistryObject<WeaponItem> FLIPKNIFE = registerMelee("flipknife");

    public static final RegistryObject<WeaponItem> SPIRITKNIFE = registerMelee("spiritknife");

    public static RegistryObject<WeaponItem> registerGun(String name) {
        return ITEMS.register(name, () -> new CaseWeaponItem(new Item.Properties().stacksTo(1)));
    }
    public static RegistryObject<WeaponItem> registerMelee(String name) {
        return ITEMS.register(name, () -> new CaseMeleeItem(new Item.Properties().stacksTo(1)));
    }

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}

package com.nukateam.minego.common.registry;

import com.nukateam.minego.MinecraftGo;
import com.nukateam.minego.common.foundation.CaseMeleeItem;
import com.nukateam.minego.common.foundation.CaseWeaponItem;
import com.nukateam.ntgl.common.foundation.item.WeaponItem;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModWeapons {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(Registries.ITEM, MinecraftGo.MOD_ID);

    public static final DeferredHolder<Item, WeaponItem> AK47 = registerGun("ak47");
    public static final DeferredHolder<Item, WeaponItem> GALIL = registerGun("galil");
    public static final DeferredHolder<Item, WeaponItem> MP5SD = registerGun("mp5sd");
    public static final DeferredHolder<Item, WeaponItem> G3SG1 = registerGun("g3sg1");
    public static final DeferredHolder<Item, WeaponItem> R8 = registerGun("r8");
    public static final DeferredHolder<Item, WeaponItem> BIZON = registerGun("bizon");
    public static final DeferredHolder<Item, WeaponItem> NEGEV = registerGun("negev");
    public static final DeferredHolder<Item, WeaponItem> M249 = registerGun("m249");
    public static final DeferredHolder<Item, WeaponItem> FAMAS = registerGun("famas");
    public static final DeferredHolder<Item, WeaponItem> P250 = registerGun("p250");
    public static final DeferredHolder<Item, WeaponItem> CZ75 = registerGun("cz75");
    public static final DeferredHolder<Item, WeaponItem> UMP45 = registerGun("ump45");
    public static final DeferredHolder<Item, WeaponItem> ZEUS = registerGun("zeus");
    public static final DeferredHolder<Item, WeaponItem> P2000 = registerGun("p2000");
    public static final DeferredHolder<Item, WeaponItem> SAWED = registerGun("sawedoff");
    public static final DeferredHolder<Item, WeaponItem> DEAGLE = registerGun("deagle");
    public static final DeferredHolder<Item, WeaponItem> GLOCK = registerGun("glock");
    public static final DeferredHolder<Item, WeaponItem> BERRETA = registerGun("berreta");
    public static final DeferredHolder<Item, WeaponItem> TEC9 = registerGun("tec9");
    public static final DeferredHolder<Item, WeaponItem> M4A1S = registerGun("m4a1s");
    public static final DeferredHolder<Item, WeaponItem> M4A4 = registerGun("m4a4");
    public static final DeferredHolder<Item, WeaponItem> MAG7 = registerGun("mag7");
    public static final DeferredHolder<Item, WeaponItem> NOVA = registerGun("nova");
    public static final DeferredHolder<Item, WeaponItem> XM1014 = registerGun("xm1014");
    public static final DeferredHolder<Item, WeaponItem> FIVESEVEN = registerGun("fiveseven");
    public static final DeferredHolder<Item, WeaponItem> USP = registerGun("usp");
    public static final DeferredHolder<Item, WeaponItem> MP9 = registerGun("mp9");
    public static final DeferredHolder<Item, WeaponItem> MAC10 = registerGun("mac10");
    public static final DeferredHolder<Item, WeaponItem> MP7 = registerGun("mp7");
    public static final DeferredHolder<Item, WeaponItem> P90 = registerGun("p90");
    public static final DeferredHolder<Item, WeaponItem> SCAR20 = registerGun("scar20");
    public static final DeferredHolder<Item, WeaponItem> SSG08 = registerGun("ssg08");
    public static final DeferredHolder<Item, WeaponItem> AWP = registerGun("awp");
    public static final DeferredHolder<Item, WeaponItem> AUG = registerGun("aug");
    public static final DeferredHolder<Item, WeaponItem> SG553 = registerGun("sg553");
    public static final DeferredHolder<Item, WeaponItem> GUTKNIFE = registerMelee("gutknife");
    public static final DeferredHolder<Item, WeaponItem> FLIPKNIFE = registerMelee("flipknife");
    public static final DeferredHolder<Item, WeaponItem> SPIRITKNIFE = registerMelee("spiritknife");

    public static DeferredHolder<Item, WeaponItem> registerGun(String name) {
        return ITEMS.register(name, () -> new CaseWeaponItem(new Item.Properties().stacksTo(1)));
    }
    public static DeferredHolder<Item, WeaponItem> registerMelee(String name) {
        return ITEMS.register(name, () -> new CaseMeleeItem(new Item.Properties().stacksTo(1)));
    }

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}

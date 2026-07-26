package com.nukateam.minego.common.registry;

import com.nukateam.minego.MinecraftGo;
import com.nukateam.minego.common.foundation.CharmAttachment;
import com.nukateam.minego.common.foundation.EraserItem;
import com.nukateam.minego.common.foundation.LootBoxItem;
import com.nukateam.minego.common.foundation.StickerItem;
import com.nukateam.minego.common.util.CsMineAttachmentTypes;
import com.nukateam.minego.common.util.CsMineGunModifiers;
import com.nukateam.ntgl.common.data.attachment.impl.*;
import com.nukateam.ntgl.common.foundation.item.AmmoItem;
import com.nukateam.ntgl.common.foundation.item.attachment.*;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.entity.monster.Skeleton;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(Registries.ITEM, MinecraftGo.MOD_ID);

    public static final DeferredHolder<Item, Item> COMMON_AMMO = ITEMS.register("common_ammo",
            () -> new AmmoItem(new Item.Properties().rarity(Rarity.COMMON)));

    public static final DeferredHolder<Item, Item> primary_ammo = ITEMS.register("primary_ammo",
            () -> new AmmoItem(new Item.Properties().rarity(Rarity.COMMON)));

    public static final DeferredHolder<Item, Item> STICKER = ITEMS.register("sticker",
            () -> new StickerItem(new Item.Properties()));

    public static final DeferredHolder<Item, Item> ERASER = ITEMS.register("eraser",
            () -> new EraserItem(new Item.Properties().durability(10)));

//    public static final DeferredHolder<Item, Item> TOKEN_ARMS_DEAL1 = ITEMS.register("armsdeal1",
//            () -> new Item(new Item.Properties().rarity(Rarity.EPIC)));
//    public static final DeferredHolder<Item, Item> TOKEN_ARMS_DEAL2 = ITEMS.register("armsdeal2",
//            () -> new Item(new Item.Properties().rarity(Rarity.EPIC)));
//    public static final DeferredHolder<Item, Item> TOKEN_ARMS_DEAL3 = ITEMS.register("armsdeal3",
//            () -> new Item(new Item.Properties().rarity(Rarity.EPIC)));
//    public static final DeferredHolder<Item, Item> TOKEN_ARMS_DEAL4 = ITEMS.register("armsdeal4",
//            () -> new Item(new Item.Properties().rarity(Rarity.EPIC)));

    public static final DeferredHolder<Item, Item> CAPSULE_DREAMHACK14 = ITEMS.register("capsule_dreamhack2014",
            () -> new Item(new Item.Properties().rarity(Rarity.EPIC)));
    public static final DeferredHolder<Item, Item> CAPSULE_KATOWICE14 = ITEMS.register("capsule_katowice2014",
            () -> new Item(new Item.Properties().rarity(Rarity.EPIC)));
    public static final DeferredHolder<Item, Item> CAPSULE_KATOWICE15 = ITEMS.register("capsule_katowice2015",
            () -> new Item(new Item.Properties().rarity(Rarity.EPIC)));
    public static final DeferredHolder<Item, Item> CAPSULE_STICKER1 = ITEMS.register("capsule_sticker1",
            () -> new Item(new Item.Properties().rarity(Rarity.EPIC)));
    public static final DeferredHolder<Item, Item> CAPSULE_STICKER2 = ITEMS.register("capsule_sticker2",
            () -> new Item(new Item.Properties().rarity(Rarity.EPIC)));

    public static final DeferredHolder<Item, Item> CASE_ = ITEMS.register("case_",
            () -> new LootBoxItem("vertigo", new Item.Properties().rarity(Rarity.RARE)));
    public static final DeferredHolder<Item, Item> CASE_1 = ITEMS.register("case_1",
            () -> new LootBoxItem("esport1", new Item.Properties().rarity(Rarity.RARE)));
    public static final DeferredHolder<Item, Item> CASE_ARMS_DEAL1 = ITEMS.register("case_armsdeal1",
            () -> new LootBoxItem("armsdeal1", new Item.Properties().rarity(Rarity.RARE)));
    public static final DeferredHolder<Item, Item> CASE_ARMS_DEAL2 = ITEMS.register("case_armsdeal2",
            () -> new LootBoxItem("armsdeal2", new Item.Properties().rarity(Rarity.RARE)));
    public static final DeferredHolder<Item, Item> CASE_ARMS_DEAL3 = ITEMS.register("case_armsdeal3",
            () -> new LootBoxItem("armsdeal3", new Item.Properties().rarity(Rarity.RARE)));
//    public static final DeferredHolder<Item, Item> CASE_ARMS_DEAL3 = ITEMS.register("case_armsdeal3",
//            () -> new LootBoxItem("knifes_1t_1s", new Item.Properties().rarity(Rarity.RARE)));
//    public static final DeferredHolder<Item, Item> CASE_ARMS_DEAL4 = ITEMS.register("case_armsdeal4",
//            () -> new LootBoxItem("knifes_1t_1s", new Item.Properties().rarity(Rarity.RARE)));

    public static final DeferredHolder<Item, Item> SILENCER = ITEMS.register("silencer",
            () -> new BarrelItem(Barrel.create(6.0F, CsMineGunModifiers.SILENCED),
                    new Item.Properties().stacksTo(1)));

//    public static final DeferredHolder<Item, Item> LONG_BARREL = ITEMS.register("long_barrel",
//            () -> new BarrelItem(Barrel.create(3.0F, CsMineGunModifiers.LONG_BARREL),
//                    new Item.Properties().stacksTo(1)));

//    public static final DeferredHolder<Item, Item> TANK_BARREL = ITEMS.register("tank_barrel",
//            () -> new BarrelItem(Barrel.create(3.0F, CsMineGunModifiers.TANK_BARREL),
//                    new Item.Properties().stacksTo(1)));
//    public static final DeferredHolder<Item, Item> FLASH_HIDDER = ITEMS.register("flash_hidder",
//            () -> new BarrelItem(Barrel.create(0.0F, CsMineGunModifiers.FLASH_HIDER),
//                    new Item.Properties().stacksTo(1)));
//    public static final DeferredHolder<Item, Item> SCOPE = ITEMS.register("scope",
//            () -> new ScopeItem(CsMineGunModifiers.SCOPE,
//                    new Item.Properties().stacksTo(1)));
    public static final DeferredHolder<Item, Item> ADV_SCOPE = ITEMS.register("advanced_scope",
            () -> new ScopeItem(CsMineGunModifiers.ADV_SCOPE,
                    new Item.Properties().stacksTo(1)));

    public static final DeferredHolder<Item, Item> HUNT_SCOPE = ITEMS.register("hunt_scope",
            () -> new ScopeItem(CsMineGunModifiers.HUNT_SCOPE,
                    new Item.Properties().stacksTo(1)));

//    public static final DeferredHolder<Item, Item> SMALL_SCOPE = ITEMS.register("small_scope",
//            () -> new ScopeItem(CsMineGunModifiers.SHORT_SCOPE,
//                    new Item.Properties().stacksTo(1)));
//    public static final DeferredHolder<Item, Item> RIFLE_MAG = ITEMS.register("rifle_mag",
//            () -> new MagazineItem(Magazine.create(10, CsMineGunModifiers.RIFLE_MAG), new Item.Properties().stacksTo(1)));
//    public static final DeferredHolder<Item, Item> PISTOL_MAG = ITEMS.register("pistol_mag",
//            () -> new MagazineItem(Magazine.create(10, CsMineGunModifiers.PISTOL_MAG), new Item.Properties().stacksTo(1)));
//
//    public static final DeferredHolder<Item, Item> TRIPOD = ITEMS.register("tripod",
//            () -> new UnderBarrelItem(UnderBarrel.create(),
//                    new Item.Properties().stacksTo(1)));
//    public static final DeferredHolder<Item, Item> SPEC_GRIP = ITEMS.register("spec_grip",
//            () -> new UnderBarrelItem(UnderBarrel.create(),
//                    new Item.Properties().stacksTo(1)));
//    public static final DeferredHolder<Item, Item> TACTICAL_GRIP = ITEMS.register("tactical_grip",
//            () -> new UnderBarrelItem(UnderBarrel.create(),
//                    new Item.Properties().stacksTo(1)));
//
//    public static final DeferredHolder<Item, Item> TACTICAL_STOCK = ITEMS.register("tactical_stock",
//            () -> new GripItem(Grip.create(),
//                    new Item.Properties().stacksTo(1)));
//    public static final DeferredHolder<Item, Item> HEAVY_STOCK = ITEMS.register("heavy_stock",
//            () -> new GripItem(Grip.create(),
//                    new Item.Properties().stacksTo(1)));
//    public static final DeferredHolder<Item, Item> LIGHT_STOCK = ITEMS.register("light_stock",
//            () -> new GripItem(Grip.create(),
//                    new Item.Properties().stacksTo(1)));
    public static final DeferredHolder<Item, Item> STATTRAK = ITEMS.register("stattrak",
            () -> new AttachmentItem(CsMineAttachmentTypes.STATTRAK,
                    GenericAttachment.create(),
                    new Item.Properties().stacksTo(1)));

    public static final DeferredHolder<Item, Item> FLAT_CHARM = ITEMS.register("flat_charm",
            () -> new CharmAttachment(GenericAttachment.create(),
                    new Item.Properties().stacksTo(1)));

    public static final DeferredHolder<Item, Item> CHICKEN_CHARM = ITEMS.register("chicken_charm",
            () -> new CharmAttachment(GenericAttachment.create(),
                    new Item.Properties().stacksTo(1)));

    public static final DeferredHolder<Item, Item> LILBRO_CHARM = ITEMS.register("lilbro_charm",
            () -> new CharmAttachment(GenericAttachment.create(),
                    new Item.Properties().stacksTo(1)));

    public static final DeferredHolder<Item, Item> LILFRAG_CHARM = ITEMS.register("lilfrag_charm",
            () -> new CharmAttachment(GenericAttachment.create(),
                    new Item.Properties().stacksTo(1)));

    public static final DeferredHolder<Item, Item> ACRYL_CHARM = ITEMS.register("acryl_charm",
            () -> new CharmAttachment(GenericAttachment.create(),
                    new Item.Properties().stacksTo(1)));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}

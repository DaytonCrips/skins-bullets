package com.nukateam.minego.common.registry;

import com.nukateam.minego.MinecraftGo;
import com.nukateam.ntgl.common.util.helpers.RegistrationHelper;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ItemLike;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import java.util.function.BiConsumer;
import java.util.function.Supplier;

import static net.minecraft.world.item.CreativeModeTab.builder;

public class ModTabsRegistry {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, MinecraftGo.MOD_ID);

    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> CSMINE_TAB = createTab("csmine_items",
            ModItems.CAPSULE_DREAMHACK14::get, ModTabsRegistry::getWeaponTab);

    private static void getWeaponTab(CreativeModeTab.ItemDisplayParameters itemDisplayParameters, CreativeModeTab.Output output) {
        registerGuns(output, ModWeapons.ITEMS);
        registerItems(output, ModItems.ITEMS);
    }

    private static void registerItems(CreativeModeTab.Output output, DeferredRegister<Item> register) {
        for (var entry : register.getEntries()) {
            output.accept(entry.get());
        }
    }

    private static void registerGuns(CreativeModeTab.Output output, DeferredRegister<Item> register) {
        for (var entry : register.getEntries()) {
            RegistrationHelper.registerGunOrDefault(output, entry.get());
        }
    }

    private static DeferredHolder<CreativeModeTab, CreativeModeTab> createTab(
            String name, Supplier<ItemLike> icon,
            BiConsumer<CreativeModeTab.ItemDisplayParameters, CreativeModeTab.Output> getItems) {
        return CREATIVE_MODE_TABS.register(name,
                () -> builder().icon(() -> new ItemStack(icon.get()))
                        .title(Component.translatable("itemGroup." + name))
                        .displayItems(getItems::accept)
                        .build());
    }

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}

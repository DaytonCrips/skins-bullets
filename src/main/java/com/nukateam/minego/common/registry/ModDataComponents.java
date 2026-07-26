package com.nukateam.minego.common.registry;

import com.mojang.serialization.Codec;
import com.nukateam.minego.MinecraftGo;
import net.minecraft.core.component.DataComponentType;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.codec.ByteBufCodecs;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModDataComponents {
    public static final DeferredRegister.DataComponents DATA_COMPONENTS =
            DeferredRegister.createDataComponents(Registries.DATA_COMPONENT_TYPE, MinecraftGo.MOD_ID);

    public static final Supplier<DataComponentType<String>> VARIANT = DATA_COMPONENTS.registerComponentType(
            "variant",
            builder -> builder
                    .persistent(Codec.STRING)
                    .networkSynchronized(ByteBufCodecs.STRING_UTF8)
    );

    public static final Supplier<DataComponentType<String>> WEAR_TYPE = DATA_COMPONENTS.registerComponentType(
            "wear_type",
            builder -> builder
                    .persistent(Codec.STRING)
                    .networkSynchronized(ByteBufCodecs.STRING_UTF8)
    );

    public static final Supplier<DataComponentType<String>> WEAR_VALUE = DATA_COMPONENTS.registerComponentType(
            "wear_value",
            builder -> builder
                    .persistent(Codec.STRING)
                    .networkSynchronized(ByteBufCodecs.STRING_UTF8)
    );

    public static final Supplier<DataComponentType<String>> RARITY = DATA_COMPONENTS.registerComponentType(
            "rarity",
            builder -> builder
                    .persistent(Codec.STRING)
                    .networkSynchronized(ByteBufCodecs.STRING_UTF8)
    );

    public static final Supplier<DataComponentType<String>> STICKER = DATA_COMPONENTS.registerComponentType(
            "sticker",
            builder -> builder
                    .persistent(Codec.STRING)
                    .networkSynchronized(ByteBufCodecs.STRING_UTF8)
    );

    public static final Supplier<DataComponentType<String>> COLLECTION = DATA_COMPONENTS.registerComponentType(
            "collection",
            builder -> builder
                    .persistent(Codec.STRING)
                    .networkSynchronized(ByteBufCodecs.STRING_UTF8)
    );

    public static void register(IEventBus eventBus) {
        DATA_COMPONENTS.register(eventBus);
    }
}
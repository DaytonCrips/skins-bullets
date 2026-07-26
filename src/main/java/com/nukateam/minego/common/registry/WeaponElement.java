package com.nukateam.minego.common.registry;

import com.google.gson.JsonObject;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
@FunctionalInterface
@SuppressWarnings("all")
public interface WeaponElement<T> {
    T build(JsonObject element);
    default T get() {
        return build(null);
    }
}

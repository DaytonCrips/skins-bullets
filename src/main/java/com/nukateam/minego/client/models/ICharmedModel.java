package com.nukateam.minego.client.models;

import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.core.animatable.GeoAnimatable;

public interface ICharmedModel<T extends GeoAnimatable> {
    ResourceLocation getCharmTextureResource(T var1);
}

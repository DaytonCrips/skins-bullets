package com.nukateam.minego.client.models;


import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.core.animatable.GeoAnimatable;

public interface IStickeredModel<T extends GeoAnimatable> {
    ResourceLocation getStickerTextureResource(T var1);
}

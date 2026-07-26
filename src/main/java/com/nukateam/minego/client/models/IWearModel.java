package com.nukateam.minego.client.models;


import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.animatable.GeoAnimatable;

public interface IWearModel<T extends GeoAnimatable>  {
    ResourceLocation getWearTextureResource(T var1);
}

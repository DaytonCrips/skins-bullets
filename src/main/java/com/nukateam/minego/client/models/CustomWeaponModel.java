package com.nukateam.minego.client.models;

import com.nukateam.minego.MinecraftGo;
import com.nukateam.minego.common.util.CsMineAttachmentTypes;
import com.nukateam.minego.utils.StackUtils;
import com.nukateam.ntgl.client.animators.WeaponAnimator;
import com.nukateam.ntgl.client.model.IGlowingModel;
import com.nukateam.ntgl.client.util.helpers.GeoModelHelper;
import com.nukateam.ntgl.common.data.WeaponData;
import com.nukateam.ntgl.common.util.util.WeaponStateHelper;
import net.minecraft.client.Minecraft;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

import java.util.Map;

public class CustomWeaponModel<T extends WeaponAnimator> extends GeoModel<T> implements IStickeredModel<T>, IGlowingModel<T>, ICharmedModel<T>, IWearModel<T> {
    public static final CustomWeaponModel<WeaponAnimator> INSTANCE = new CustomWeaponModel();

    @Override
    public ResourceLocation getCharmTextureResource(T animatable) {
        var stack = animatable.getStack();
        var player = Minecraft.getInstance().player;
        var charm = WeaponStateHelper.getAttachmentItem(CsMineAttachmentTypes.CHARM, new WeaponData(stack, player));
        var skin = StackUtils.getVariant(charm);
        var charmName = BuiltInRegistries.ITEM.getKey(charm.getItem());
        return ResourceLocation.tryBuild(MinecraftGo.MOD_ID, "textures/charms/" + charmName.getPath() + "_" + skin + ".png");
    }

    @Override
    public ResourceLocation getStickerTextureResource(T animatable) {
        String sticker = StackUtils.getSticker(animatable.getStack());
        return ResourceLocation.tryBuild(MinecraftGo.MOD_ID, "textures/stickers/" + sticker + ".png");
    }

    @Override
    public ResourceLocation getWearTextureResource(T animatable) {
        String wear_type = StackUtils.getWearType(animatable.getStack());
        String wear_value = StackUtils.getWearValue(animatable.getStack());
        String name = animatable.getId().getPath();
        return ResourceLocation.tryBuild(MinecraftGo.MOD_ID, "textures/guns/" + name + "/layers/" + name + "_" + wear_type + "_" + wear_value + ".png" );

    }

    @Override
    public ResourceLocation getGlowingTextureResource(T animator) {
        String name = animator.getId().getPath();
        return ResourceLocation.tryBuild(MinecraftGo.MOD_ID, "textures/guns/" + name + "/" + name + "_glowmask.png");
    }

    @Override
    public ResourceLocation getModelResource(T animator) {
        return GeoModelHelper.getGunResource(animator, "geo/guns/", ".geo.json");
    }

    public ResourceLocation getTextureResource(T animator) {
        Map<String, ResourceLocation> textures = animator.getConfig().getTextures();
        var variant = StackUtils.getVariant(animator.getStack());
        var path = "textures/guns/" + animator.getStack().getDisplayName().getString() + "/";
        var resource = textures.containsKey(variant) ?
                textures.get(variant) :
                GeoModelHelper.getGunResource(animator, path, ".png".formatted());
        return resource;
    }

    public ResourceLocation getAnimationResource(T animator) {
        return GeoModelHelper.getGunResource(animator, "animations/weapons/", ".animation.json");
    }
}

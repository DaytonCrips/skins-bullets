package com.nukateam.minego.client.models;

import com.nukateam.minego.MinecraftGo;
import com.nukateam.minego.client.render.animators.SkinGunAnimator;
import com.nukateam.minego.common.util.CsMineAttachmentTypes;
import com.nukateam.minego.utils.StackUtils;
import com.nukateam.ntgl.client.animators.WeaponAnimator;
import com.nukateam.ntgl.client.model.IGlowingModel;
import com.nukateam.ntgl.client.model.gun.GeoWeaponModel;
import com.nukateam.ntgl.client.util.helpers.GeoModelHelper;
import com.nukateam.ntgl.common.foundation.item.WeaponItem;
import com.nukateam.ntgl.common.util.util.WeaponStateHelper;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.registries.ForgeRegistries;
import software.bernie.geckolib.model.GeoModel;

import java.util.Map;

public class CustomWeaponModel<T extends WeaponAnimator> extends GeoModel<T> implements IStickeredModel<T>, IGlowingModel<T>, ICharmedModel<T>, IWearModel<T> {
    public static final CustomWeaponModel<WeaponAnimator> INSTANCE = new CustomWeaponModel();

    @Override
    public ResourceLocation getCharmTextureResource(T animatable) {
        var stack = animatable.getStack();
        var charm = WeaponStateHelper.getAttachmentItem(CsMineAttachmentTypes.CHARM, stack);
        var skin = StackUtils.getVariant(charm);
        ResourceLocation charm_name = ForgeRegistries.ITEMS.getKey(charm.getItem());
        assert charm_name != null;
        return ResourceLocation.tryBuild(MinecraftGo.MOD_ID, "textures/charms/" + charm_name.getPath() + "_" + skin + ".png");
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
        String variant = WeaponItem.getVariant(animator.getStack());
        ResourceLocation resource = textures.containsKey(variant) ? textures.get(variant) : GeoModelHelper.getGunResource(animator, "textures/guns/" + animator.getStack().getDisplayName().getString() + "/", ".png".formatted());
        return resource;
    }

    public ResourceLocation getAnimationResource(T animator) {
        return GeoModelHelper.getGunResource(animator, "animations/weapons/", ".animation.json");
    }
}

package com.nukateam.minego.client.render.animators;

import com.mojang.blaze3d.vertex.PoseStack;
import com.nukateam.ntgl.client.animators.WeaponAnimator;
import com.nukateam.ntgl.client.render.renderers.weapon.DynamicWeaponRenderer;
import net.minecraft.world.item.ItemDisplayContext;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.core.animation.RawAnimation;

public class SkinGunAnimator extends WeaponAnimator {
    private PoseStack attachedModelTransform = new PoseStack();

    public SkinGunAnimator(ItemDisplayContext transformType, DynamicWeaponRenderer<WeaponAnimator> renderer) {
        super(transformType, renderer);
    }

    public void setAttachedModelTransform(PoseStack poseStack) {
        this.attachedModelTransform = poseStack;
    }

    @Override
    protected RawAnimation getShootingAnimation(AnimationState<WeaponAnimator> event) {
        return super.getShootingAnimation(event);
    }

    public PoseStack getAttachedModelTransform() {
        return this.attachedModelTransform;
    }
}

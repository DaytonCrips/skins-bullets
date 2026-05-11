package com.nukateam.minego.client.render;

import com.nukateam.ntgl.client.animators.WeaponAnimator;
import com.nukateam.ntgl.client.render.renderers.weapon.DynamicWeaponRenderer;
import net.minecraft.world.item.ItemDisplayContext;

public class KnifesAnimator extends WeaponAnimator {
    public KnifesAnimator(ItemDisplayContext transformType, DynamicWeaponRenderer<WeaponAnimator> renderer) {
        super(transformType, renderer);
    }
}

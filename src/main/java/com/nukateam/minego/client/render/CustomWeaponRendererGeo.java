package com.nukateam.minego.client.render;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.nukateam.minego.client.models.CustomWeaponModel;
import com.nukateam.minego.client.render.animators.SkinGunAnimator;
import com.nukateam.minego.client.render.layers.CharmedLayer;
import com.nukateam.minego.client.render.layers.StickeredLayer;
import com.nukateam.minego.client.render.layers.WearLayer;
import com.nukateam.ntgl.client.animators.WeaponAnimator;
import com.nukateam.ntgl.client.render.renderers.weapon.DynamicWeaponRenderer;
import com.nukateam.ntgl.common.util.data.Rgba;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.cache.object.GeoBone;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.renderer.layer.AutoGlowingGeoLayer;

public class CustomWeaponRendererGeo extends DynamicWeaponRenderer<WeaponAnimator> {

    public CustomWeaponRendererGeo() {
        super(new CustomWeaponModel());
        addRenderLayer(new StickeredLayer<>(this));
        addRenderLayer(new CharmedLayer<>(this));
        addRenderLayer(new WearLayer<>(this));
    }

    @Override
    public void render(LivingEntity entity, ItemStack stack, ItemDisplayContext transformType, PoseStack poseStack, @Nullable MultiBufferSource bufferSource, @Nullable RenderType renderType, @Nullable VertexConsumer buffer, int packedLight) {
        super.render(entity, stack, transformType, poseStack, bufferSource, renderType, buffer, packedLight);
    }

    @Override
    protected void renderRecursivelyPost(PoseStack poseStack, WeaponAnimator animatable, GeoBone bone, RenderType renderType, MultiBufferSource bufferSource, VertexConsumer buffer, boolean isReRender, float partialTick, int packedLight, int packedOverlay, Rgba rgba) {
        if (!animatable.getStack().hasCustomHoverName()) {
            hide(bone, "nametag");
        }
    }

    private static void hide(GeoBone bone, String name) {
        if (bone.getName().equals(name)) {
            bone.setHidden(true);
        }
    }
}

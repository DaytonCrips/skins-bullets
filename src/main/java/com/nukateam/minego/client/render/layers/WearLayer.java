package com.nukateam.minego.client.render.layers;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.nukateam.minego.client.models.IWearModel;
import com.nukateam.ntgl.client.util.ClientDebug;
import com.nukateam.ntgl.common.util.util.ResourceUtils;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.cache.object.BakedGeoModel;
import software.bernie.geckolib.cache.texture.AutoGlowingTexture;
import software.bernie.geckolib.core.animatable.GeoAnimatable;
import software.bernie.geckolib.renderer.GeoRenderer;
import software.bernie.geckolib.renderer.layer.GeoRenderLayer;

import java.util.HashMap;

public class WearLayer<T extends GeoAnimatable> extends GeoRenderLayer<T> {
    public static HashMap<ResourceLocation, Boolean> textures = new HashMap();
    public  WearLayer(GeoRenderer<T> entityRendererIn) {
        super(entityRendererIn);
    }

    protected boolean resourceExists(ResourceLocation location) {
        return textures.computeIfAbsent(location, ResourceUtils::resourceExists);
    }



    public void render(PoseStack poseStack, T animatable, BakedGeoModel bakedModel, RenderType renderType, MultiBufferSource bufferSource, VertexConsumer buffer, float partialTick, int packedLight, int packedOverlay) {
        IWearModel<T> model = (IWearModel)this.getRenderer().getGeoModel();
        ResourceLocation texture = model.getWearTextureResource(animatable);

        if (this.resourceExists(texture)) {
            this.renderLayer(poseStack, animatable, bakedModel, bufferSource, partialTick, packedLight, texture);
        }
    }



    protected void renderLayer(PoseStack poseStack, T animatable, BakedGeoModel bakedModel, MultiBufferSource bufferSource, float partialTick, int packedLight, ResourceLocation texture) {
//        RenderType renderTypeNew = RenderType.entityTranslucent(texture);
//        poseStack.pushPose();
//
//        poseStack.translate(-0.5, -0.5, -0.5);
//        poseStack.translate(-5.0 / 100.0 / 16.0, -21.0 / 100.0 / 16.0, -1.0 / 100.0 / 16.0);
//        poseStack.scale(1.005f, 1.005f, 1.007f);
//        poseStack.translate((double) ClientDebug.X / 100.0 / 16.0, (double)ClientDebug.Y / 100.0 / 16.0, (double)ClientDebug.Z / 100.0 / 16.0);
//        this.getRenderer().reRender(bakedModel, poseStack, bufferSource, animatable, renderTypeNew, bufferSource.getBuffer(renderTypeNew), partialTick, packedLight, OverlayTexture.NO_OVERLAY, 1.0F, 1.0F, 1.0F, 1.0F);
//        poseStack.popPose();
        RenderType renderTypeNew = RenderType.entityTranslucent(texture);
        poseStack.pushPose();
        poseStack.translate(-0.5, -0.5, -0.5);
        poseStack.translate(0.0, -0.01, 0.0);
        poseStack.translate((double) ClientDebug.X / 100.0 / 16.0, (double)ClientDebug.Y / 100.0 / 16.0, (double)ClientDebug.Z / 10.0 / 16.0);
        this.getRenderer().reRender(bakedModel, poseStack, bufferSource, animatable, renderTypeNew, bufferSource.getBuffer(renderTypeNew), partialTick, packedLight, OverlayTexture.NO_OVERLAY, 1.0F, 1.0F, 1.0F, 1.0F);
        poseStack.popPose();
    }
}

package com.nukateam.minego.client.models;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonObject;
import com.nukateam.minego.MinecraftGo;
import com.nukateam.minego.utils.StackUtils;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.block.model.ItemOverrides;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.client.resources.model.*;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.inventory.InventoryMenu;
import net.minecraft.world.item.ItemStack;
import net.neoforged.neoforge.client.NeoForgeRenderTypes;
import net.neoforged.neoforge.client.RenderTypeGroup;
import net.neoforged.neoforge.client.model.CompositeModel;
import net.neoforged.neoforge.client.model.geometry.*;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.function.Function;

import static com.nukateam.minego.MinecraftGo.mineGoResource;

public class GunIconBake implements IUnbakedGeometry<GunIconBake> {
    @Nonnull
    private final ItemStack stack;

    public GunIconBake(ItemStack stack) {
        this.stack = stack;
    }

    public GunIconBake withStack(ItemStack stack) {
        return new GunIconBake(stack);
    }

    // resourceLocation больше не приходит в bake() — используем свой идентификатор для контекста
    private static final ResourceLocation CONTEXT_NAME = mineGoResource("gun_icon_dynamic");

    @Override
    public BakedModel bake(IGeometryBakingContext context, ModelBaker modelBaker,
                           Function<Material, TextureAtlasSprite> function, ModelState modelState,
                           ItemOverrides itemOverrides)
    {
        var particleLocation = getMaterial(context, "particle");
        var particleSprite = particleLocation != null ? function.apply(particleLocation) : null;

        var itemContext = StandaloneGeometryBakingContext.builder(context)
                .withGui3d(false).withUseBlockLight(false).build(CONTEXT_NAME);

        var builder = CompositeModel.Baked.builder(itemContext, particleSprite,
                new GunIconBake.ItemOverrideHandler(itemOverrides, modelBaker, itemContext, this),
                context.getTransforms());

        var skin = StackUtils.getVariant(stack);
        var baseMaterial = new Material(InventoryMenu.BLOCK_ATLAS, getTexture(getItemName(stack), skin));
        var baseLocation = getMaterial(context, "base");
        var sprite = !stack.isEmpty() ?
                function.apply(baseMaterial) :
                function.apply(baseLocation);

        var unbaked = UnbakedGeometryHelper.createUnbakedItemElements(0, sprite);
        // bakeElements больше не принимает ResourceLocation
        var quads = UnbakedGeometryHelper.bakeElements(unbaked, $ -> sprite, modelState);

        builder.addQuads(getLayerRenderTypes(), quads);

        builder.setParticle(particleSprite);
        return builder.build();
    }

    private static String getItemName(ItemStack stack) {
        return BuiltInRegistries.ITEM.getKey(stack.getItem()).getPath();
    }

    private static ResourceLocation getTexture(String nameItem, String skin) {
        return mineGoResource("item/dynamic/" + nameItem + "/" + nameItem + "_" + skin);
    }

    public static RenderTypeGroup getLayerRenderTypes() {
        return new RenderTypeGroup(RenderType.translucent(), NeoForgeRenderTypes.ITEM_UNSORTED_TRANSLUCENT.get());
    }

    public enum Loader implements IGeometryLoader<GunIconBake> {
        INSTANCE;

        @Override
        public GunIconBake read(JsonObject jsonObject, JsonDeserializationContext deserializationContext) {
            return new GunIconBake(ItemStack.EMPTY);
        }
    }

    @Nullable
    private static Material getMaterial(IGeometryBakingContext context, String base) {
        return context.hasMaterial(base) ? context.getMaterial(base) : null;
    }

    private static final class ItemOverrideHandler extends ItemOverrides {
        private final ItemOverrides nested;
        private final ModelBaker baker;
        private final IGeometryBakingContext owner;
        private final GunIconBake parent;

        private ItemOverrideHandler(ItemOverrides nested, ModelBaker baker, IGeometryBakingContext owner, GunIconBake parent) {
            this.nested = nested;
            this.baker = baker;
            this.owner = owner;
            this.parent = parent;
        }

        @Override
        public BakedModel resolve(BakedModel originalModel, ItemStack stack, @Nullable ClientLevel level, @Nullable LivingEntity entity, int integer) {
            var overriden = nested.resolve(originalModel, stack, level, entity, integer);
            if (overriden != originalModel) return overriden;
            if (!StackUtils.getVariant(stack).equals("default")) {
                GunIconBake unbaked = this.parent.withStack(stack);
                // bake() теперь без ResourceLocation-параметра
                BakedModel bakedModel = unbaked.bake(owner, baker, Material::sprite, BlockModelRotation.X0_Y0, this);
                return bakedModel;
            }
            return originalModel;
        }
    }
}
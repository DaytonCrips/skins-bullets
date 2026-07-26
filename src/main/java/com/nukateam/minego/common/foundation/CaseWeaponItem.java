package com.nukateam.minego.common.foundation;

import com.nukateam.geo.render.DynamicGeoItemRenderer;
import com.nukateam.minego.client.render.CustomWeaponRendererGeo;
import com.nukateam.minego.client.render.animators.SkinGunAnimator;
import com.nukateam.minego.common.registry.ModItems;
import com.nukateam.minego.utils.SkinManager;
import com.nukateam.minego.utils.StackUtils;
import com.nukateam.ntgl.client.animators.WeaponAnimator;
import com.nukateam.ntgl.client.render.renderers.weapon.DynamicWeaponRenderer;

import com.nukateam.ntgl.client.tooltip.ItemsTooltipData;
import com.nukateam.ntgl.common.foundation.item.WeaponItem;

import com.nukateam.ntgl.common.util.interfaces.IWeaponModifier;
import net.minecraft.ChatFormatting;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.Tag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Style;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import net.neoforged.jarjar.nio.util.Lazy;
import org.jetbrains.annotations.Nullable;
import java.util.List;
import java.util.Optional;
import java.util.function.BiFunction;

public class CaseWeaponItem extends WeaponItem {
    private final Lazy<CustomWeaponRendererGeo> RENDERER = Lazy.of(() -> new CustomWeaponRendererGeo());
    public CaseWeaponItem(Properties properties, IWeaponModifier... modifiers) {
        super(properties, modifiers);
    }

    public CaseWeaponItem(String skin, String collection, String rarity, String wear, String wear_type, Properties properties, IWeaponModifier... modifiers) {
        super(properties, modifiers);
        StackUtils.setVariant(this.getDefaultInstance(), skin);
        StackUtils.setCollection(this.getDefaultInstance(), collection);
        StackUtils.setRarity(this.getDefaultInstance(), rarity);
        StackUtils.setWearValue(this.getDefaultInstance(), wear);
        StackUtils.setWearType(this.getDefaultInstance(), wear_type);
    }


    public static boolean hasStattrak(ItemStack stack) {
        if (stack.isEmpty() || !stack.hasTag()) return false;

        CompoundTag tag = stack.getTag();

        if (tag.contains("Attachments", Tag.TAG_COMPOUND)) {
            CompoundTag attachments = tag.getCompound("Attachments");
            if (attachments.contains("minego:stattrak", Tag.TAG_COMPOUND)) {
                CompoundTag stattrak = attachments.getCompound("minego:stattrak");
                if (stattrak.contains("id", Tag.TAG_STRING)) {
                    return "minego:stattrak".equals(stattrak.getString("id"));
                }
            }
        }

        return false;
    }

    @Override
    public DynamicGeoItemRenderer getRenderer() {
        return RENDERER.get();
    }
    @Override
    public BiFunction<ItemDisplayContext, DynamicWeaponRenderer<WeaponAnimator>, WeaponAnimator> getAnimatorFactory() {
        return WeaponAnimator::new;
    }

    @Override
    public Component getName(ItemStack stack) {
        return getCustomName(stack);
    }

    public Component getCustomName(ItemStack pStack) {
        String base_name = (Component.translatable(this.getDescriptionId(pStack)).getString());
        String skin_name = (Component.translatable("skin." + StackUtils.getVariant(pStack)).getString());
        if (StackUtils.getVariant(pStack).equals("default")) {
            if (hasStattrak(pStack)) {
                return Component.literal("ST™ ").append(base_name).withStyle(Style.EMPTY.withColor(0xf25a21));
            } else
                return Component.literal("").append(base_name);

        } else if (hasStattrak(pStack)) {
            return Component.literal("ST™ ").append(base_name).append(" | ").append(skin_name).withStyle(Style.EMPTY.withColor(0xf25a21));
        } else {
            return Component.literal("").append(base_name).append(" | ").append(skin_name).withStyle(SkinManager.setRarityColor(StackUtils.getRarity(pStack)));
        }

    }

//    public Optional<TooltipComponent> getTooltipImage(ItemStack stack) {
//        List<ItemStack> weapons = this.sticker;
//        return Optional.of(new ItemsTooltipData(weapons));
//    }

    @Override
    public void appendHoverText(ItemStack item, TooltipContext context, List<Component> list, TooltipFlag flag) {
        super.appendHoverText(item, context, list, flag);
        String wear = StackUtils.getWearValue(item);
        String paint = StackUtils.getWearType(item);
        list.add(Component.translatable("tooltip.paintjob." + paint).withStyle(ChatFormatting.GRAY));
        list.add(Component.translatable("tooltip.wear." + wear).withStyle(ChatFormatting.GRAY));
//        if (Screen.hasShiftDown()) {
//            list.add(Component.translatable("tooltip.paintjob." + paint).withStyle(ChatFormatting.GRAY));
//            list.add(Component.translatable("tooltip.wear." + wear).withStyle(ChatFormatting.GRAY));
//        } else list.add(Component.translatable("tooltip.csmine.details").withStyle(ChatFormatting.DARK_GRAY));
        list.add(Component.translatable("rarity." + StackUtils.getRarity(item)).withStyle(SkinManager.setRarityColor(StackUtils.getRarity(item))));
        if (hasStattrak(item)) {
            list.add(Component.translatable("tooltip.csmine.stattrak").append("0").withStyle(Style.EMPTY.withColor(0xf25a21)));
        }
    }
}

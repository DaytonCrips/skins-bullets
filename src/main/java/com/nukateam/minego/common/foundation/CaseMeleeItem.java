package com.nukateam.minego.common.foundation;

import com.nukateam.minego.client.render.KnifesAnimator;
import com.nukateam.minego.utils.SkinManager;
import com.nukateam.minego.utils.StackUtils;
import com.nukateam.ntgl.client.animators.WeaponAnimator;
import com.nukateam.ntgl.client.render.renderers.weapon.DynamicWeaponRenderer;
import com.nukateam.ntgl.common.foundation.item.WeaponItem;
import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Style;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;

import java.util.List;
import java.util.function.BiFunction;

public class CaseMeleeItem extends WeaponItem {
    public CaseMeleeItem(Properties properties) {
        super(properties);
    }

    public CaseMeleeItem(String skin, String collection, String rarity, String wear, String wear_type, Properties properties) {
        super(properties);
        StackUtils.setVariant(this.getDefaultInstance(), skin);
        StackUtils.setCollection(this.getDefaultInstance(), collection);
        StackUtils.setRarity(this.getDefaultInstance(), rarity);
        StackUtils.setWearValue(this.getDefaultInstance(), wear);
        StackUtils.setWearType(this.getDefaultInstance(), wear_type);
    }

    @Override
    public BiFunction<ItemDisplayContext, DynamicWeaponRenderer<WeaponAnimator>, WeaponAnimator> getAnimatorFactory() {
        return KnifesAnimator::new;
    }

    @Override
    public Component getName(ItemStack stack) {
        return getCustomName(stack);
    }

    public Component getCustomName(ItemStack pStack) {
        String base_name = (Component.translatable(this.getDescriptionId(pStack)).getString());
        String skin_name = (Component.translatable("skin." + StackUtils.getVariant(pStack)).getString());
        if (StackUtils.getVariant(pStack).equals("default")) {
            if (StackUtils.hasStattrak(pStack)) {
                return Component.literal("ST™ ").append(base_name).withStyle(Style.EMPTY.withColor(0xf25a21));
            } else
                return Component.literal("").append(base_name).withStyle(SkinManager.setRarityColor("ultra_rare"));

        } else if (StackUtils.hasStattrak(pStack)) {
            return Component.literal("ST™ ").append(base_name).append(" | ").append(skin_name).withStyle(Style.EMPTY.withColor(0xf25a21));
        } else {
            return Component.literal("").append(base_name).append(" | ").append(skin_name).withStyle(SkinManager.setRarityColor(StackUtils.getRarity(pStack)));
        }
    }

    @Override
    public void appendHoverText(ItemStack item, TooltipContext context, List<Component> list, TooltipFlag flag) {
        super.appendHoverText(item, context, list, flag);
        if (Screen.hasShiftDown()) {
            list.add(Component.translatable("tooltip.csmine.wear").withStyle(ChatFormatting.GRAY));
        } else list.add(Component.translatable("tooltip.csmine.details").withStyle(ChatFormatting.DARK_GRAY));
        list.add(Component.translatable("rarity." + StackUtils.getRarity(item)).withStyle(SkinManager.setRarityColor(StackUtils.getRarity(item))));
        if (StackUtils.hasStattrak(item)) {
            list.add(Component.translatable("tooltip.csmine.stattrak").append("0").withStyle(Style.EMPTY.withColor(0xf25a21)));
        }
    }
}

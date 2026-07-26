package com.nukateam.minego.utils;

import com.nukateam.minego.common.registry.ModDataComponents;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.Tag;
import net.minecraft.world.item.ItemStack;

public class StackUtils {
    public static String getVariant(ItemStack stack) {
        return stack.getOrDefault(ModDataComponents.VARIANT.get(), "default");
    }

    public static void setVariant(ItemStack stack, String variant) {
        stack.set(ModDataComponents.VARIANT.get(), variant);
    }

    public static String getWearType(ItemStack stack) {
        return stack.getOrDefault(ModDataComponents.WEAR_TYPE.get(), "none");
    }

    public static void setWearType(ItemStack stack, String variant) {
        stack.set(ModDataComponents.WEAR_TYPE.get(), variant);
    }

    public static String getWearValue(ItemStack stack) {
        return stack.getOrDefault(ModDataComponents.WEAR_VALUE.get(), "gn");
    }

    public static void setWearValue(ItemStack stack, String variant) {
        stack.set(ModDataComponents.WEAR_VALUE.get(), variant);
    }

    public static String getRarity(ItemStack stack) {
        return stack.getOrDefault(ModDataComponents.RARITY.get(), "consumer");
    }

    public static void setRarity(ItemStack stack, String variant) {
        stack.set(ModDataComponents.RARITY.get(), variant);
    }

    public static String getSticker(ItemStack stack) {
        return stack.getOrDefault(ModDataComponents.STICKER.get(), "default");
    }

    public static void setSticker(ItemStack stack, String variant) {
        stack.set(ModDataComponents.STICKER.get(), variant);
    }

    public static String getCollection(ItemStack stack) {
        return stack.getOrDefault(ModDataComponents.COLLECTION.get(), "default");
    }

    public static void setCollection(ItemStack stack, String variant) {
        stack.set(ModDataComponents.COLLECTION.get(), variant);
    }

    public static boolean hasStattrak(ItemStack stack) {
//        if (stack.isEmpty() || !stack.hasTag()) return false;
//
//        CompoundTag tag = stack.getTag();
//
//        // Проверка пути: Attachments -> minego:stattrak -> id
//        if (tag.contains("Attachments", Tag.TAG_COMPOUND)) {
//            CompoundTag attachments = tag.getCompound("Attachments");
//            if (attachments.contains("minego:stattrak", Tag.TAG_COMPOUND)) {
//                CompoundTag stattrak = attachments.getCompound("minego:stattrak");
//                if (stattrak.contains("id", Tag.TAG_STRING)) {
//                    return "minego:stattrak".equals(stattrak.getString("id"));
//                }
//            }
//        }

        return false;
    }
}
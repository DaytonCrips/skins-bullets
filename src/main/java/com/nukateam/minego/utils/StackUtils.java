package com.nukateam.minego.utils;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.item.ItemStack;

public class StackUtils {


    public static final String EMPTY = "empty";
    public static String getVariant(ItemStack stack) {
        CompoundTag tag = stack.getOrCreateTag();
        return tag.contains("variant") ? tag.getString("variant") : "default";
    }

    public static String getWearType(ItemStack stack) {
        CompoundTag tag = stack.getOrCreateTag();
        return tag.contains("wear_type") ? tag.getString("wear_type") : "none";
    }

    public static void setWearType(ItemStack stack, String variant) {
        CompoundTag tag = stack.getOrCreateTag();
        tag.putString("wear_type", variant);
        stack.setTag(tag);
    }

    public static String getWearValue(ItemStack stack) {
        CompoundTag tag = stack.getOrCreateTag();
        return tag.contains("wear_value") ? tag.getString("wear_value") : "gn";
    }

    public static void setWearValue(ItemStack stack, String variant) {
        CompoundTag tag = stack.getOrCreateTag();
        tag.putString("wear_value", variant);
        stack.setTag(tag);
    }

    public static String getRarity(ItemStack stack) {
        CompoundTag tag = stack.getOrCreateTag();
        return tag.contains("rarity") ? tag.getString("rarity") : "consumer";
    }
    public static String getSticker(ItemStack stack) {
        CompoundTag tag = stack.getOrCreateTag();
        return tag.contains("sticker") ? tag.getString("sticker") : "default";
    }
    public static void setSticker(ItemStack stack, String variant) {
        CompoundTag tag = stack.getOrCreateTag();
        tag.putString("sticker", variant);
        stack.setTag(tag);
    }
    public static String getCollection(ItemStack stack) {
        CompoundTag tag = stack.getOrCreateTag();
        return tag.contains("collection") ? tag.getString("collection") : "default";
    }
    public static void setRarity(ItemStack stack, String variant) {
        CompoundTag tag = stack.getOrCreateTag();
        tag.putString("rarity", variant);
        stack.setTag(tag);
    }
    public static void setCollection(ItemStack stack, String variant) {
        CompoundTag tag = stack.getOrCreateTag();
        tag.putString("collection", variant);
        stack.setTag(tag);
    }
    public static void setVariant(ItemStack stack, String variant) {
        CompoundTag tag = stack.getOrCreateTag();
        tag.putString("variant", variant);
        stack.setTag(tag);
    }

}

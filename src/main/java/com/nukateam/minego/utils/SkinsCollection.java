package com.nukateam.minego.utils;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class SkinsCollection {

    private static final String[] WEARS = {"fn", "ft", "bs"};
    private static final Random RANDOM = new Random();
    public final List<GunSkin> SKINS = new ArrayList<>();
    private final String name;

    public SkinsCollection(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
    public void addEntry(GunSkin skin) {
        SKINS.add(skin);
    }
    public GunSkin getEntry(int index) {
        return SKINS.get(index);
    }
    public int getSize() {
        return SKINS.size();
    }



    public ItemStack getRandomSkin(){
        GunSkin skin = getWeightItem();
        assert skin != null;
        if (skin.getGun().equals("gold")) {
            SkinsCollection collection = SkinManager.getCollection(skin.getSkin_name());
            ItemStack knife = collection.getRandomSkin();
            return knife;
        } else {
            Item item = ForgeRegistries.ITEMS.getValue(new ResourceLocation(skin.getGun()));
            ItemStack gun = new ItemStack(item);
            StackUtils.setVariant(gun, skin.getSkin_name());
            StackUtils.setRarity(gun, skin.getRarity());
            StackUtils.setCollection(gun, getName());
            StackUtils.setWearType(gun, skin.getWear_type());
            StackUtils.setWearValue(gun, getRandomWear());
            return gun;
        }
    }

    public static String getRandomWear() {
        //return WEARS[RANDOM.nextInt(WEARS.length)];
        return "gn";
    }

    private GunSkin getWeightItem() {
        if (SKINS.isEmpty()) {
            return null;
        }

        double[] weights = new double[SKINS.size()];
        double totalWeight = 0;

        for (int i = 0; i < SKINS.size(); i++) {

            weights[i] = Math.pow(0.75, i);
            totalWeight += weights[i];
        }

        double random = Math.random() * totalWeight;
        double current = 0;

        for (int i = 0; i < weights.length; i++) {
            current += weights[i];
            if (random <= current) {
                return SKINS.get(i);
            }
        }
        return SKINS.get(0);
    }

    private GunSkin getRandomItem() {
        if (SKINS.isEmpty()) {
            return null;
        }
        return SKINS.get(RANDOM.nextInt(SKINS.size()));
    }

}

package com.nukateam.minego.utils;

import com.nukateam.minego.MinecraftGo;
import net.minecraft.network.chat.Component;

public class GunSkin {
    private final String gun;
    private final String rarity;
    private final String skin_name;
    private final Boolean contracted;
    private final Boolean secret;
    private final String wear_type;

    public GunSkin(String gun, String rarity, String skinName, Boolean contracted, Boolean secret, String wear) {
        this.gun = gun;
        this.rarity = rarity;
        skin_name = skinName;
        this.contracted = contracted;
        this.secret = secret;
        this.wear_type = wear;
    }

    public String getWear_type() {
        return wear_type;
    }

    public Boolean getSecret() {
        return secret;
    }

    public String getGun() {
        return gun;
    }

    public Boolean getContracted() {
        return contracted;
    }


    public String getRarity() {
        return rarity;
    }

    public String getSkin_name() {
        return skin_name;
    }
}

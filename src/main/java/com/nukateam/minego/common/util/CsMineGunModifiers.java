package com.nukateam.minego.common.util;


import com.nukateam.example.common.registery.WeaponModifiers;
import com.nukateam.minego.MinecraftGo;
import com.nukateam.ntgl.common.data.WeaponData;
import com.nukateam.ntgl.common.data.attachment.impl.Scope;
import com.nukateam.ntgl.common.util.interfaces.IWeaponModifier;
import net.minecraft.resources.ResourceLocation;

public class CsMineGunModifiers {

    public static final ResourceLocation SCOPE_LOCATION =  new ResourceLocation(MinecraftGo.MOD_ID, "textures/misc/scope_overlay.png");
    public static final ResourceLocation ADVSCOPE_LOCATION =  new ResourceLocation(MinecraftGo.MOD_ID, "textures/misc/adv_scope_overlay.png");
    public static final ResourceLocation HUNTSCOPE_LOCATION =  new ResourceLocation(MinecraftGo.MOD_ID, "textures/misc/hunt_scope_overlay.png");

    public static final IWeaponModifier SILENCED = new IWeaponModifier() {
        @Override
        public boolean silencedFire(boolean silenced, WeaponData data) {
            return true;
        }

        @Override
        public double modifyFireSoundRadius(double radius, WeaponData data) {
            return radius * 0.25;
        }

        @Override
        public float modifyProjectileDamage(float damage, ResourceLocation ammo, WeaponData data) {
            return damage - 1;
        }


    };

    public static final Scope SHORT_SCOPE = Scope.builder().aimFovModifier(0.7F)
            .modifiers(WeaponModifiers.SLOW_ADS).build();
    public static final Scope SCOPE = Scope.builder().aimFovModifier(0.75F)
            .modifiers(WeaponModifiers.SLOWER_ADS).overlay(SCOPE_LOCATION).build();

    public static final Scope ADV_SCOPE = Scope.builder().aimFovModifier(0.85F)
            .modifiers(WeaponModifiers.BETTER_CONTROL).overlay(ADVSCOPE_LOCATION).build();
    public static final Scope HUNT_SCOPE = Scope.builder().aimFovModifier(0.55F)
            .modifiers(WeaponModifiers.SLOW_ADS).overlay(HUNTSCOPE_LOCATION).build();

    public static final IWeaponModifier FLASH_HIDER = new IWeaponModifier() {
        @Override
        public float modifyProjectileSpread(float spread, WeaponData data) {
            return spread * 1.2F;
        }
        @Override
        public float recoilModifier(WeaponData data) {
            return 1.2F;
        }
    };

    public static final IWeaponModifier RIFLE_MAG = new IWeaponModifier() {
        @Override
        public int modifyMaxAmmo(int maxAmmo, WeaponData data) {
            return (int) (maxAmmo * 2);
        }
    };

    public static final IWeaponModifier PISTOL_MAG = new IWeaponModifier() {
        @Override
        public int modifyMaxAmmo(int maxAmmo, WeaponData data) {
            return (int) (maxAmmo * 1.5);
        }
    };
    public static final IWeaponModifier TANK_BARREL = new IWeaponModifier() {
        @Override
        public float modifyProjectileSpread(float spread, WeaponData data) {
            return spread * 2F;
        }
        @Override
        public float recoilModifier(WeaponData data) {
            return 1.6F;
        }

        @Override
        public float modifyProjectileDamage(float damage, ResourceLocation ammo, WeaponData data) {
            return damage + 3;
        }
    };

    public static final IWeaponModifier LONG_BARREL = new IWeaponModifier() {
        @Override
        public float modifyProjectileSpread(float spread, WeaponData data) {
            return spread * 1.3F;
        }
        @Override
        public float recoilModifier(WeaponData data) {
            return 2.0F;
        }
    };
}

package com.nukateam.minego.common.util;

import com.nukateam.minego.MinecraftGo;
import com.nukateam.ntgl.common.data.holders.AttachmentType;
import net.minecraft.resources.ResourceLocation;

import static com.nukateam.minego.MinecraftGo.mineGoResource;
import static com.nukateam.ntgl.common.data.holders.AttachmentType.registerType;

public class CsMineAttachmentTypes {
    public static AttachmentType STATTRAK = new AttachmentType(mineGoResource("stattrak"));
    public static AttachmentType CHARM = new AttachmentType(mineGoResource("charm"));

    static {
        registerType(STATTRAK);
        registerType(CHARM);
    }
}

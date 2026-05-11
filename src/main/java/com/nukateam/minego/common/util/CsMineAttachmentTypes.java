package com.nukateam.minego.common.util;

import com.nukateam.minego.MinecraftGo;
import com.nukateam.ntgl.common.data.holders.AttachmentType;
import net.minecraft.resources.ResourceLocation;

import static com.nukateam.ntgl.common.data.holders.AttachmentType.registerType;

public class CsMineAttachmentTypes {
    public static AttachmentType STATTRAK = new AttachmentType(new ResourceLocation(MinecraftGo.MOD_ID,"stattrak"));
    public static AttachmentType CHARM = new AttachmentType(new ResourceLocation(MinecraftGo.MOD_ID,"charm"));
    static {
        registerType(STATTRAK);
        registerType(CHARM);
    }
}

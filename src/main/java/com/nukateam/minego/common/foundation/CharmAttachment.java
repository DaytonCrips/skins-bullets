package com.nukateam.minego.common.foundation;

import com.nukateam.minego.common.util.CsMineAttachmentTypes;
import com.nukateam.minego.utils.StackUtils;
import com.nukateam.ntgl.common.data.attachment.impl.Attachment;
import com.nukateam.ntgl.common.foundation.item.attachment.AttachmentItem;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class CharmAttachment extends AttachmentItem {
    public CharmAttachment(Attachment attachmentData, Properties properties) {
        super(CsMineAttachmentTypes.CHARM, attachmentData, properties);
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable Level pLevel, List tooltip, TooltipFlag pIsAdvanced) {
        super.appendHoverText(stack, pLevel, tooltip, pIsAdvanced);
        tooltip.add(Component.translatable("charm." + StackUtils.getVariant(stack)));
        tooltip.add(Component.translatable("tooltip.charm.use"));
    }
}

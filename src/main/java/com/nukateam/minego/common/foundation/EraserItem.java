package com.nukateam.minego.common.foundation;

import com.nukateam.minego.utils.StackUtils;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.ClickAction;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.Objects;

public class EraserItem extends Item {
    public EraserItem(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public boolean overrideStackedOnOther(ItemStack stack, Slot pSlot, ClickAction pAction, Player pPlayer) {
        var slotItem = pSlot.getItem();
        if (pAction == ClickAction.SECONDARY) {
            var isEmpty = Objects.equals(StackUtils.getSticker(slotItem), "default");
            if (slotItem.getItem() instanceof CaseWeaponItem && !isEmpty) {
                StackUtils.setSticker(slotItem, "default");
                if(!pPlayer.isCreative()) {
                    if (stack.getDamageValue() == 10)
                        stack.shrink(1);
                    else stack.setDamageValue(stack.getDamageValue() + 1);
                }
            }
            return true;
        }
        return false;
    }

    @Override
    public void appendHoverText(ItemStack item, TooltipContext context, List<Component> list, TooltipFlag flag) {
        super.appendHoverText(item, context, list, flag);        list.add(Component.translatable("tooltip.eraser.use"));
    }
}

package com.nukateam.minego.common.foundation;

import com.nukateam.minego.MinecraftGo;
import com.nukateam.minego.common.registry.ModWeapons;
import com.nukateam.minego.utils.GunSkin;
import com.nukateam.minego.utils.SkinManager;
import com.nukateam.minego.utils.SkinsCollection;
import com.nukateam.minego.utils.StackUtils;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;

import org.jetbrains.annotations.Nullable;

import java.util.List;

public class LootBoxItem extends Item {
    private final String case_collection;
    public LootBoxItem(String collection, Properties pProperties) {
        super(pProperties);
        this.case_collection = collection;
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, InteractionHand pUsedHand) {
        ItemStack itemStack = pPlayer.getItemInHand(pUsedHand);
        SkinsCollection collection = SkinManager.getCollection(case_collection);
        if (!pLevel.isClientSide()) {
            ItemStack gun = collection.getRandomSkin();
            pPlayer.sendSystemMessage(Component.translatable("csmine.drop.chat").append(gun.getDisplayName()));
            if (!pPlayer.getInventory().add(gun)) {
                pPlayer.drop(gun, false);
            }
        }
        itemStack.shrink(1);
        return super.use(pLevel, pPlayer, pUsedHand);
    }

    @Override
    public void appendHoverText(ItemStack item, TooltipContext context, List<Component> list, TooltipFlag flag) {
        super.appendHoverText(item, context, list, flag);
        SkinsCollection collection = SkinManager.getCollection(case_collection);
        list.add(Component.translatable("case.collection.desc"));

        if (collection != null && !collection.SKINS.isEmpty()) {
            list.add(Component.empty());
            for (GunSkin skin : collection.SKINS) {
                if (!skin.getSecret()) {
                    String gunKey = convertToItemKey(skin.getGun());
                    Component skinName = Component.translatable("skin." + skin.getSkin_name());
                    if (gunKey.equals("item.gold")) {
                        list.add(Component.translatable("case.collection.gold_item")
                                .withStyle(SkinManager.setRarityColor("contraband")));
                    } else {
                        Component gunName = Component.translatable(gunKey);

                        list.add(Component.translatable("tooltip.case.collection.entry",
                                        gunName, skinName)
                                .withStyle(SkinManager.setRarityColor(skin.getRarity())));
                    }

                }
            }
        }
    }

    private String convertToItemKey(String gunName) {
        if (gunName.contains(":")) {
            String[] parts = gunName.split(":");
            if (parts.length == 2) {
                return "item." + parts[0] + "." + parts[1];
            }
        }
        return "item." + gunName.replace(":", ".");
    }
}

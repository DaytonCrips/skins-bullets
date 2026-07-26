package com.nukateam.minego.client.render.layers.tooltips;

import com.nukateam.minego.client.render.WeaponTooltipRender;
import com.nukateam.minego.common.registry.ModItems;
import com.nukateam.minego.utils.StackUtils;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;


public class CollectionIcon implements WeaponCollection {
    @Override
    public void render(WeaponTooltipRender renderer, int x, int y) {
        if (!StackUtils.getCollection(renderer.stack()).equals("default")) {
            ItemStack sign = ModItems.STICKER.get().getDefaultInstance();
            StackUtils.setVariant(sign, StackUtils.getCollection(renderer.stack()));
            renderer.context().renderItem(sign, x, y);
        } else renderer.context().renderItem(renderer.stack(), x, y);
    }

}

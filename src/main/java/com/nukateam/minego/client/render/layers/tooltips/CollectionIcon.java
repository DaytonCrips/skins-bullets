package com.nukateam.minego.client.render.layers.tooltips;

import com.nukateam.minego.client.render.WeaponTooltipRender;
import com.nukateam.minego.utils.StackUtils;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.registries.ForgeRegistries;

public class CollectionIcon implements WeaponCollection {
    @Override
    public void render(WeaponTooltipRender renderer, int x, int y) {
        if (!StackUtils.getCollection(renderer.stack()).equals("default")) {
            Item item = ForgeRegistries.ITEMS.getValue(new ResourceLocation("minego:" + StackUtils.getCollection(renderer.stack())));
            ItemStack gun = new ItemStack(item);
            renderer.context().renderItem(gun, x, y);
        } else renderer.context().renderItem(renderer.stack(), x, y);
    }

}

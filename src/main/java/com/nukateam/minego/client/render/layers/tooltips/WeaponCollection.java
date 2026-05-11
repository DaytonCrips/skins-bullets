package com.nukateam.minego.client.render.layers.tooltips;

import com.nukateam.minego.client.render.WeaponTooltipRender;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public interface WeaponCollection {
    void render(WeaponTooltipRender renderer, int x, int y);
    default void reset() {}
}

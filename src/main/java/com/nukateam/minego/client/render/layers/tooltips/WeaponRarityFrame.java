package com.nukateam.minego.client.render.layers.tooltips;

import com.nukateam.minego.MinecraftGo;
import com.nukateam.minego.client.render.WeaponTooltipRender;
import com.nukateam.minego.utils.StackUtils;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.phys.Vec2;

import java.awt.*;

import static com.nukateam.minego.MinecraftGo.mineGoResource;

public class WeaponRarityFrame implements WeaponFrames {
    protected ResourceLocation TEXTURE;
    public WeaponRarityFrame(ResourceLocation texture) {
        this.TEXTURE = texture;
    }

    @Override
    public void render(WeaponTooltipRender renderer, Vec2 pos, Point size) {
        TEXTURE = mineGoResource("textures/frames/" + StackUtils.getRarity(renderer.stack()) + ".png");
        renderer.blit(TEXTURE, (int) pos.x + size.x / 2 - 30, (int) pos.y - 10, 10, 0, 60, 16, 80, 32);
        renderer.blit(TEXTURE, (int) pos.x + size.x / 2 - 30, (int) pos.y + size.y - 6, 10, 16, 60, 16, 80, 32);
        renderer.blit(TEXTURE, (int) pos.x - 5, (int) pos.y - 5, 0, 0, 10, 10, 80, 32);
        renderer.blit(TEXTURE, (int) pos.x + size.x - 5, (int) pos.y - 5, 70, 0, 10, 10, 80, 32);
        renderer.blit(TEXTURE, (int) pos.x - 5, (int) pos.y + size.y - 5, 0, 22, 10, 10, 80, 32);
        renderer.blit(TEXTURE, (int) pos.x + size.x - 5, (int) pos.y + size.y - 5, 70, 22, 10, 10, 80, 32);
    }
}

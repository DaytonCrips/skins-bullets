package com.nukateam.minego.client.render.layers.tooltips;

import javax.annotation.Nullable;
import java.util.Optional;

public class TooltipPresets {
    @Nullable
    private final WeaponPanels PANEL;
    @Nullable
    private final WeaponFrames FRAME;
    @Nullable
    private final CollectionIcon ICON;

    private TooltipPresets(@Nullable WeaponPanels panel, @Nullable WeaponFrames frame, @Nullable CollectionIcon icon) {
        this.PANEL = panel;
        this.FRAME = frame;
        this.ICON = icon;
    }

    public Optional<WeaponPanels> getPanel() {
        return PANEL == null ? Optional.empty() : Optional.of(PANEL);
    }
    public Optional<WeaponFrames> getFrame() {
        return FRAME == null ? Optional.empty() : Optional.of(FRAME);
    }
    public Optional<CollectionIcon> getIcon() {
        return ICON == null ? Optional.empty() : Optional.of(ICON);
    }
    public static class Builder {
        @Nullable private WeaponPanels panel;
        @Nullable private WeaponFrames frame;
        @Nullable private CollectionIcon icon;

        public Builder() {}

        public TooltipPresets.Builder withPanel(@Nullable WeaponPanels panel) {
            this.panel = panel;
            return this;
        }

        public TooltipPresets.Builder withFrame(@Nullable WeaponFrames frame) {
            this.frame = frame;
            return this;
        }

        public TooltipPresets.Builder withIcon(@Nullable CollectionIcon icon) {
            this.icon = icon;
            return this;
        }


        public TooltipPresets build() {
            return new TooltipPresets(panel, frame, icon);
        }
    }
}

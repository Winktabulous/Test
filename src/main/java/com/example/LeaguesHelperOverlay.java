package com.example;

import net.runelite.client.ui.overlay.OverlayPanel;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.components.LineComponent;
import javax.inject.Inject;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Color;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class LeaguesHelperOverlay extends OverlayPanel {
    private final LeaguesHelperPlugin plugin;
    private final LeaguesHelperConfig config;

    @Inject
    private LeaguesHelperOverlay(LeaguesHelperPlugin plugin, LeaguesHelperConfig config) {
        super(plugin);
        setPosition(OverlayPosition.TOP_LEFT);
        this.plugin = plugin;
        this.config = config;

        // Set panel size
        panelComponent.setPreferredSize(new Dimension(400, 150));
    }

    @Override
    public Dimension render(Graphics2D graphics) {
        if (!config.showOverlay()) {
            return null;
        }

        panelComponent.getChildren().clear();

        LeaguesTask currentTask = plugin.getCurrentTask();
        if (currentTask == null) {
            panelComponent.getChildren().add(LineComponent.builder()
                    .left("All tasks completed!")
                    .leftColor(Color.GREEN)
                    .build());
            return super.render(graphics);
        }

        panelComponent.getChildren().add(LineComponent.builder()
                .left("Current Task:")
                .build());

        panelComponent.getChildren().add(LineComponent.builder()
                .left(currentTask.getName())
                .right("[" + currentTask.getArea() + "]")
                .build());

        panelComponent.getChildren().add(LineComponent.builder()
                .left(currentTask.getDescription())
                .leftColor(Color.LIGHT_GRAY)
                .build());

        // Add coordinates if available
        if (currentTask.hasCoordinates()) {
            int[] coords = currentTask.getCoordinates();
            panelComponent.getChildren().add(LineComponent.builder()
                    .left("Location:")
                    .right("X: " + coords[0] + ", Y: " + coords[1])
                    .rightColor(Color.YELLOW)
                    .build());
        }

        return super.render(graphics);
    }
}

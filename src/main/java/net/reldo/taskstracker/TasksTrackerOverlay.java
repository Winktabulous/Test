package net.reldo.taskstracker;

import java.awt.Dimension;
import java.awt.Graphics2D;

import javax.inject.Inject;

import net.reldo.taskstracker.tasktypes.Task;
import net.runelite.api.Client;
import net.runelite.client.ui.overlay.OverlayPanel;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.components.LineComponent;
import net.runelite.client.ui.overlay.components.TitleComponent;

public class TasksTrackerOverlay extends OverlayPanel
{
	private final Client client;
	private final TasksTrackerPlugin plugin;
	private final TasksTrackerConfig config;

	@Inject
	public TasksTrackerOverlay(TasksTrackerPlugin plugin, Client client, TasksTrackerConfig config)
	{
		super(plugin);
		this.client = client;
		this.plugin = plugin;
		this.config = config;
		setPosition(OverlayPosition.TOP_LEFT);
	}

	@Override
	public Dimension render(Graphics2D graphics)
	{
		if (client.getGameState() != net.runelite.api.GameState.LOGGED_IN || plugin.getCurrentTask() == null)
		{
			return null;
		}

		Task currentTask = plugin.getCurrentTask();

		// Display current task
		panelComponent.getChildren().add(TitleComponent.builder()
			.text("Current Task")
			.build());

		panelComponent.getChildren().add(LineComponent.builder()
			.left(currentTask.getName())
			.build());

		// Add description
		panelComponent.getChildren().add(LineComponent.builder()
			.left(currentTask.getDescription())
			.build());

		// Add world position if available
		if (currentTask.getWorldPosition() != null &&
			(currentTask.getWorldPosition().getX() != 0 || 
			currentTask.getWorldPosition().getY() != 0 || 
			currentTask.getWorldPosition().getZ() != 0)) {
			panelComponent.getChildren().add(LineComponent.builder()
				.left("Location: ")
				.right(String.format("X: %d, Y: %d, Z: %d",
					currentTask.getWorldPosition().getX(),
					currentTask.getWorldPosition().getY(),
					currentTask.getWorldPosition().getZ()))
				.build());
		}

		// Add required items if available
		if (currentTask.getRequiredItems() != null && currentTask.getRequiredItems().length > 0) {
			panelComponent.getChildren().add(LineComponent.builder()
				.left("Required Items: ")
				.right(String.join(", ", currentTask.getRequiredItems()))
				.build());
		}

		// Add NPC if available
		if (currentTask.getNpc() != null && !currentTask.getNpc().isEmpty()) {
			panelComponent.getChildren().add(LineComponent.builder()
				.left("NPC: ")
				.right(currentTask.getNpc())
				.build());
		}

		return super.render(graphics);
	}
}

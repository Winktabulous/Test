package net.reldo.taskstracker;

import java.awt.*;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;
import java.util.function.Predicate;

import javax.inject.Inject;

import net.reldo.taskstracker.tasktypes.Task;
import net.runelite.api.Client;
import net.runelite.api.NPC;
import net.runelite.api.NPCComposition;
import net.runelite.api.Perspective;
import net.runelite.api.coords.LocalPoint;
import net.runelite.client.game.npcoverlay.HighlightedNpc;
import net.runelite.client.ui.overlay.OverlayPanel;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.OverlayUtil;
import net.runelite.client.ui.overlay.components.LineComponent;
import net.runelite.client.ui.overlay.components.TitleComponent;
import net.runelite.client.util.Text;

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
		if (currentTask.getNPC() != null && !currentTask.getNPC().isEmpty()) {
			panelComponent.getChildren().add(LineComponent.builder()
				.left("NPC: ")
				.right(currentTask.getNPC())
				.build());
		}

		if(currentTask.getNPC() != null) {
			HashMap<NPC, HighlightedNpc> npcs = plugin.getHighlightedNpcs();

			if(npcs != null) {
				npcs.forEach((npc, highlightedNpc) -> {
					if(Objects.requireNonNull(npc.getName()).equalsIgnoreCase(currentTask.getNPC())) {
						renderNpcOverlay(graphics, highlightedNpc);
					}
				});
			}
		}

		return super.render(graphics);
	}

	private void renderNpcOverlay(Graphics2D graphics, HighlightedNpc highlightedNpc)
	{
		NPC actor = highlightedNpc.getNpc();
		NPCComposition npcComposition = actor.getTransformedComposition();
		if (npcComposition == null || !npcComposition.isInteractible())
		{
			return;
		}

		Predicate<NPC> render = highlightedNpc.getRender();
		if (render != null && !render.test(actor))
		{
			return;
		}

		final Color borderColor = highlightedNpc.getHighlightColor();
		float borderWidth = highlightedNpc.getBorderWidth();
		final Color fillColor = highlightedNpc.getFillColor();

		if (highlightedNpc.isHull())
		{
			Shape objectClickbox = actor.getConvexHull();
			renderPoly(graphics, borderColor, borderWidth, fillColor, objectClickbox);
		}

		if (highlightedNpc.isTile())
		{
			Polygon tilePoly = actor.getCanvasTilePoly();
			renderPoly(graphics, borderColor, borderWidth, fillColor, tilePoly);
		}

		if (highlightedNpc.isTrueTile())
		{
			LocalPoint lp = LocalPoint.fromWorld(client, actor.getWorldLocation()); // centered on sw tile
			if (lp != null)
			{
				final int size = npcComposition.getSize();
				final LocalPoint centerLp = lp.plus(
						Perspective.LOCAL_TILE_SIZE * (size - 1) / 2,
						Perspective.LOCAL_TILE_SIZE * (size - 1) / 2);
				Polygon tilePoly = Perspective.getCanvasTileAreaPoly(client, centerLp, size);
				renderPoly(graphics, borderColor, borderWidth, fillColor, tilePoly);
			}
		}

		if (highlightedNpc.isSwTile())
		{
			int size = npcComposition.getSize();
			LocalPoint lp = actor.getLocalLocation().plus(
					-((size - 1) * Perspective.LOCAL_TILE_SIZE / 2),
					-((size - 1) * Perspective.LOCAL_TILE_SIZE / 2));

			Polygon southWestTilePoly = Perspective.getCanvasTilePoly(client, lp);
			renderPoly(graphics, borderColor, borderWidth, fillColor, southWestTilePoly);
		}

		if (highlightedNpc.isSwTrueTile())
		{
			LocalPoint lp = LocalPoint.fromWorld(client, actor.getWorldLocation());
			if (lp != null)
			{
				Polygon tilePoly = Perspective.getCanvasTilePoly(client, lp);
				renderPoly(graphics, borderColor, borderWidth, fillColor, tilePoly);
			}
		}

		if (highlightedNpc.isOutline())
		{
//			modelOutlineRenderer.drawOutline(actor, (int) highlightedNpc.getBorderWidth(), borderColor, highlightedNpc.getOutlineFeather());
		}

//		if (highlightedNpc.isName() && actor.getName() != null)
//		{
//			String npcName = Text.removeTags(actor.getName());
//			Point textLocation = actor.getCanvasTextLocation(graphics, npcName, actor.getLogicalHeight() + 40);
//
//			if (textLocation != null)
//			{
//				OverlayUtil.renderTextLocation(graphics, textLocation, npcName, borderColor);
//			}
//		}
	}

	private void renderPoly(Graphics2D graphics, Color borderColor, float borderWidth, Color fillColor, Shape polygon)
	{
		if (polygon != null)
		{
			graphics.setColor(borderColor);
			graphics.setStroke(new BasicStroke(borderWidth));
			graphics.draw(polygon);
			graphics.setColor(fillColor);
			graphics.fill(polygon);
		}
	}
}

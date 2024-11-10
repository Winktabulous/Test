package net.reldo.taskstracker.tasktypes;

import java.time.Instant;

import com.google.gson.annotations.Expose;

import lombok.Data;
import net.reldo.taskstracker.TasksTrackerPlugin;
import net.reldo.taskstracker.data.reldo.ReldoTaskSave;
import net.reldo.taskstracker.panel.TaskPanel;
import net.runelite.api.coords.WorldPoint;
import net.runelite.client.callback.ClientThread;
import net.runelite.client.game.SkillIconManager;
import net.runelite.client.game.SpriteManager;

@Data
public abstract class Task
{
	@Expose
	private final int id;
	private final String name;
	private final String description;
	private final String tier;
	private final int clientSortId;

	@Expose
	private long completedOn;
	@Expose
	private long trackedOn;
	@Expose
	private long ignoredOn;

	private RequiredSkill[] skills = null;

	private String area;
	private String taskCategory;
	
	// New fields to match JSON format
	private WorldPosition worldPosition;
	private String[] requiredItems;

	private String NPC;

	 @Data
	 public static class WorldPosition {
	 	private int x;
	 	private int y;
	 	private int z;
	 }

	 public WorldPoint getWorldLocation()
	 {
	 	if (worldPosition == null)
	 	{
	 		return null;
	 	}
	 	return new WorldPoint(worldPosition.x, worldPosition.y, worldPosition.z);
	 }

	public boolean isCompleted()
	{
		return completedOn > 0;
	}

	public int getPoints()
	{
		return 0;
	}

	public void setCompleted(boolean completed)
	{
		long now = Instant.now().toEpochMilli();
		if (completed && completedOn > 0 && completedOn <= now)
		{
			return;
		}
		completedOn = completed ? now : 0;
	}

	public boolean isTracked()
	{
		return trackedOn > 0;
	}

	public void setTracked(boolean state)
	{
		long now = Instant.now().toEpochMilli();
		if (state && trackedOn > 0 && trackedOn <= now)
		{
			return;
		}
		trackedOn = state ? now : 0;
	}

	public boolean isIgnored()
	{
		return ignoredOn > 0;
	}

	public void setIgnored(boolean state)
	{
		long now = Instant.now().toEpochMilli();
		if (state && ignoredOn > 0 && ignoredOn <= now)
		{
			return;
		}
		ignoredOn = state ? now : 0;
	}

	public void loadConfigSave(Task loadedData)
	{
		setDates(loadedData.getCompletedOn(), loadedData.getIgnoredOn(), loadedData.getTrackedOn());
	}

	public void loadReldoSave(ReldoTaskSave loadedData)
	{
		setMostRecentDates(loadedData.getCompleted(), loadedData.getIgnored(), loadedData.getTodo());
	}

	private void setDates(long completedOn, long ignoredOn, long trackedOn)
	{
		// Set all dates regardless of how they compare
		this.setCompletedOn(completedOn);
		this.setIgnoredOn(ignoredOn);
		this.setTrackedOn(trackedOn);
	}

	private void setMostRecentDates(long completedOn, long ignoredOn, long trackedOn)
	{
		// Older completions take priority; incomplete (0) also takes priority
		if (completedOn < this.getCompletedOn())
		{
			this.setCompletedOn(completedOn);
		}
		// Newer ignores take priority
		if (ignoredOn > this.getIgnoredOn())
		{
			this.setIgnoredOn(ignoredOn);
		}
		// Newer tracks take priority
		if (trackedOn > this.getTrackedOn())
		{
			this.setTrackedOn(trackedOn);
		}
	}

	public abstract TaskType getType();

	public abstract TaskPanel generatePanel(TasksTrackerPlugin plugin, ClientThread clientThread, SpriteManager spriteManager, SkillIconManager skillIconManager);
}

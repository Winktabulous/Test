package net.reldo.taskstracker.tasktypes.league5;

import net.reldo.taskstracker.TasksTrackerPlugin;
import net.reldo.taskstracker.panel.TaskPanel;
import net.reldo.taskstracker.tasktypes.Task;
import net.reldo.taskstracker.tasktypes.TaskType;
import net.runelite.client.callback.ClientThread;
import net.runelite.client.game.SkillIconManager;
import net.runelite.client.game.SpriteManager;

public class LeagueTask extends Task
{
	// Basic constructor for backward compatibility
	public LeagueTask(int id, String name, String description, String tier, int clientSortId)
	{
		super(id, name, description, tier, clientSortId);
	}

	// Full constructor with all fields
	public LeagueTask(int id, String name, String description, String tier, int clientSortId, 
			WorldPosition worldPosition, String[] requiredItems, String npc)
	{
		super(id, name, description, tier, clientSortId);
		this.setWorldPosition(worldPosition);
		this.setRequiredItems(requiredItems);
		this.setNPC(npc);
	}

	@Override
	public int getPoints()
	{
		LeagueTaskTier tierType = LeagueTaskTier.tiersByName.get(this.getTier().toLowerCase());
		return tierType != null ? tierType.points : 0;
	}

	@Override
	public TaskType getType()
	{
		return TaskType.LEAGUE_5;
	}

	@Override
	public TaskPanel generatePanel(TasksTrackerPlugin plugin, ClientThread clientThread, SpriteManager spriteManager, SkillIconManager skillIconManager)
	{
		return new LeagueTaskPanel(plugin, clientThread, spriteManager, this);
	}
}

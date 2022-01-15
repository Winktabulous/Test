package com.tylerthardy.taskstracker.tasktypes.league2;

import com.tylerthardy.taskstracker.TasksTrackerPlugin;
import com.tylerthardy.taskstracker.tasktypes.RequiredSkill;
import com.tylerthardy.taskstracker.tasktypes.Task;
import com.tylerthardy.taskstracker.panel.TaskPanel;
import com.tylerthardy.taskstracker.tasktypes.TaskType;
import net.runelite.client.callback.ClientThread;
import net.runelite.client.game.SkillIconManager;
import net.runelite.client.game.SpriteManager;

public class League2Task extends Task
{
    public String area;
    public RequiredSkill[] skills;
    public String other;

    public League2Task(String name, String description, String tier)
    {
        super(TaskType.LEAGUE_2, name, description, tier);
    }

    @Override
    public TaskPanel generatePanel(TasksTrackerPlugin plugin, ClientThread clientThread, SpriteManager spriteManager, SkillIconManager skillIconManager) {
        return new League2TaskPanel(plugin, clientThread, spriteManager, this);
    }
}

package net.reldo.taskstracker.tasktypes;

import java.lang.reflect.Type;

import lombok.AllArgsConstructor;
import lombok.Getter;
import net.reldo.taskstracker.tasktypes.combattask.CombatTask;
import net.reldo.taskstracker.tasktypes.league5.LeagueTask;

@AllArgsConstructor
@Getter
public enum TaskType
{

	COMBAT("Combat Tasks", "combat_tasks.min.json", CombatTask.class),
	LEAGUE_5("League V: Dickerino", "league5_tasks.min.json", LeagueTask.class);
	public final String displayString;
	public final String dataFileName;
	public final Type classType;

	@Override
	public String toString()
	{
		return displayString;
	}
}

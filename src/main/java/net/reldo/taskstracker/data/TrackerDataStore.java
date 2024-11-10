package net.reldo.taskstracker.data;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import com.google.gson.Gson;

import lombok.extern.slf4j.Slf4j;
import net.reldo.taskstracker.TasksTrackerPlugin;
import net.reldo.taskstracker.tasktypes.Task;
import net.runelite.client.config.ConfigManager;

@Singleton
@Slf4j
public class TrackerDataStore
{
	@Inject
	private ConfigManager configManager;

	@Inject
	private Gson gson;

	public void save(List<Task> tasks)
	{
		if (tasks == null || tasks.isEmpty())
		{
			return;
		}

		try
		{
			String json = gson.toJson(tasks);
			configManager.setConfiguration(TasksTrackerPlugin.CONFIG_GROUP_NAME, "taskData", json);
			log.debug("Saved task data successfully");
		}
		catch (Exception e)
		{
			log.error("Failed to save task data", e);
		}
	}

	public List<Task> load()
	{
		String json = configManager.getConfiguration(TasksTrackerPlugin.CONFIG_GROUP_NAME, "taskData");
		if (json == null || json.isEmpty())
		{
			return null;
		}

		try
		{
			return gson.fromJson(json, List.class);
		}
		catch (Exception e)
		{
			log.error("Failed to load task data", e);
			return null;
		}
	}
}

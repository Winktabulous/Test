package net.reldo.taskstracker.tasktypes;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.stream.Collectors;

import javax.inject.Inject;

import com.google.gson.Gson;

import lombok.extern.slf4j.Slf4j;
import net.reldo.taskstracker.data.CallbackCommand;
import net.reldo.taskstracker.data.TaskDataClient;

@Slf4j
public class TaskManager
{
	private final TaskDataClient taskDataClient;
	public TaskType taskType;
	public HashMap<Integer, Task> tasks = new HashMap<>();

	private final Gson gson;

	public TaskManager(TaskType taskType, TaskDataClient taskDataClient)
	{
		this.taskType = taskType;
		this.taskDataClient = taskDataClient;
		this.gson = taskDataClient.getGson(); // Get Gson from TaskDataClient
	}

	public void asyncLoadTaskSourceData(CallbackCommand<ArrayList<Task>> callback)
	{
		taskDataClient.loadTaskSourceData(taskType, (tasks) -> {
			this.tasks = tasks.stream().collect(Collectors.toMap(Task::getId, v -> v, (prev, next) -> next, HashMap::new));
			callback.execute(tasks);
		});
	}

	public void applyTrackerSave(HashMap<Integer, Task> loadedTasks)
	{
		log.debug("applyTrackerSave");
		if (loadedTasks == null)
		{
			return;
		}

		tasks.values().forEach(task -> {
			Task loadedTask = loadedTasks.get(task.getId());
			if (loadedTask == null)
			{
				return;
			}
			task.loadConfigSave(loadedTask);
		});
	}

	public TasksSummary getSummary()
	{
		return new TasksSummary(tasks.values());
	}

	public String toJson()
	{
		try
		{
			ArrayList<Task> taskList = new ArrayList<>(tasks.values());
			return gson != null ? gson.toJson(taskList) : "";
		}
		catch (Exception e)
		{
			log.error("Failed to convert tasks to JSON", e);
			return "";
		}
	}
}

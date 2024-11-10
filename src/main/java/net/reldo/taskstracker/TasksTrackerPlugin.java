package net.reldo.taskstracker;

import com.google.inject.Provides;
import javax.inject.Inject;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import net.reldo.taskstracker.data.TaskDataClient;
import net.reldo.taskstracker.data.TrackerDataStore;
import net.reldo.taskstracker.panel.TasksTrackerPluginPanel;
import net.reldo.taskstracker.tasktypes.Task;
import net.reldo.taskstracker.tasktypes.TaskManager;
import net.reldo.taskstracker.tasktypes.TaskType;
import net.runelite.api.Client;
import net.runelite.api.GameState;
import net.runelite.api.events.GameStateChanged;
import net.runelite.api.events.GameTick;
import net.runelite.client.callback.ClientThread;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.EventBus;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.game.SkillIconManager;
import net.runelite.client.game.SpriteManager;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.ui.ClientToolbar;
import net.runelite.client.ui.NavigationButton;
import net.runelite.client.ui.overlay.OverlayManager;
import net.runelite.client.util.ImageUtil;
import net.runelite.client.util.Text;

import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@PluginDescriptor(
	name = "Tasks Tracker"
)
public class TasksTrackerPlugin extends Plugin
{
	public static final String CONFIG_GROUP_NAME = "tasksTracker";

	@Inject
	private Client client;

	@Inject
	private ClientThread clientThread;

	@Inject
	private ClientToolbar clientToolbar;

	@Inject
	private SpriteManager spriteManager;

	@Inject
	private SkillIconManager skillIconManager;

	@Inject
	private ConfigManager configManager;

	@Inject
	private TasksTrackerConfig config;

	@Inject
	private TaskDataClient taskDataClient;

	@Inject
	private TrackerDataStore trackerDataStore;

	@Inject
	private EventBus eventBus;

	@Inject
	private OverlayManager overlayManager;

	@Inject
	private TasksTrackerOverlay overlay;

	private NavigationButton navButton;
	public TasksTrackerPluginPanel pluginPanel;

	public int[] playerSkills;
	public String taskTextFilter;

	@Getter @Setter
	private Task currentTask;

	@Getter
	public final Map<TaskType, TaskManager> taskManagers = new HashMap<>();

	@Override
	protected void startUp()
	{
		// Create plugin panel first so it's ready when task data loads
		pluginPanel = new TasksTrackerPluginPanel(this, config, clientThread, spriteManager, skillIconManager);

		navButton = NavigationButton.builder()
			.tooltip("Tasks Tracker")
			.icon(ImageUtil.loadImageResource(getClass(), "panel_icon.png"))
			.priority(5)
			.panel(pluginPanel)
			.build();

		clientToolbar.addNavigation(navButton);
		overlayManager.add(overlay);

		// Initialize task managers for each task type
		for (TaskType taskType : TaskType.values()) {
			TaskManager manager = new TaskManager(taskType, taskDataClient);
			taskManagers.put(taskType, manager);
			
			// Load task data for this manager
			manager.asyncLoadTaskSourceData(tasks -> {
				if (taskType == config.taskType()) {
					clientThread.invokeLater(() -> {
						pluginPanel.refreshAll();
					});
				}
			});
		}
	}

	@Override
	protected void shutDown()
	{
		clientToolbar.removeNavigation(navButton);
		overlayManager.remove(overlay);
		taskManagers.clear();
		clearShortestPath();
	}

	@Subscribe
	public void onGameStateChanged(GameStateChanged gameStateChanged)
	{
		if (gameStateChanged.getGameState() == GameState.LOGGED_IN)
		{
			pluginPanel.handleLogin();
		}
		else if (gameStateChanged.getGameState() == GameState.LOGIN_SCREEN)
		{
			pluginPanel.handleLogout();
		}
	}

	@Subscribe
	public void onGameTick(GameTick tick)
	{
		if (client.getGameState() != GameState.LOGGED_IN)
		{
			return;
		}

		int[] newSkills = client.getRealSkillLevels();
		if (playerSkills == null || !java.util.Arrays.equals(playerSkills, newSkills))
		{
			playerSkills = newSkills;
			pluginPanel.refreshAll();
		}

		// Update shortest path if current task has a world position
		if (currentTask != null && currentTask.getWorldPosition() != null &&
			(currentTask.getWorldPosition().getX() != 0 || 
			currentTask.getWorldPosition().getY() != 0 || 
			currentTask.getWorldPosition().getZ() != 0)) {
			setShortestPath();
		}
	}

	public void saveCurrentTaskData()
	{
		List<Task> tasks = pluginPanel.getTasks();
		if (tasks != null) {
			trackerDataStore.save(tasks);
		}
	}

	public void setCurrentTask(Task task) {
		if (currentTask != task) {
			clearShortestPath();
			
			// Untrack previous current task if it exists and isn't completed
			if (currentTask != null && !currentTask.isCompleted()) {
				currentTask.setTracked(false);
			}
			currentTask = task;
			// Track new current task
			if (currentTask != null) {
				currentTask.setTracked(true);
				// Set shortest path if task has world position
				if (currentTask.getWorldPosition() != null &&
					(currentTask.getWorldPosition().getX() != 0 || 
					currentTask.getWorldPosition().getY() != 0 || 
					currentTask.getWorldPosition().getZ() != 0)) {
					setShortestPath();
				}
			}
			// Refresh the panel to show changes
			pluginPanel.refreshAll();
			saveCurrentTaskData();
		}
	}

	public void setShortestPath() {
		if (currentTask != null && client.getLocalPlayer() != null) {
			Map<String, Object> message = new HashMap<>();
			message.put("pluginName", "shortestpath");
			message.put("action", "path");
			
			Map<String, Object> data = new HashMap<>();
			data.put("start", client.getLocalPlayer().getWorldLocation());
			data.put("target", currentTask.getWorldPosition().toWorldPoint());
			message.put("data", data);
			
			eventBus.post(message);
		}
	}

	public void clearShortestPath() {
		Map<String, Object> message = new HashMap<>();
		message.put("pluginName", "shortestpath");
		message.put("action", "clear");
		eventBus.post(message);
	}

	public void refresh() {
		pluginPanel.refreshAll();
	}

	public void openImportJsonDialog() {
		// Implementation for opening import dialog
		log.debug("Opening import dialog...");
	}

	public void sendTotalsToChat() {
		// Implementation for sending totals to chat
		log.debug("Sending totals to chat...");
	}

	public void copyJsonToClipboard(TaskType taskType) {
		if (taskType == null) return;
		
		TaskManager manager = taskManagers.get(taskType);
		if (manager != null) {
			String json = manager.toJson();
			StringSelection stringSelection = new StringSelection(json);
			Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);
		}
	}

	public TasksTrackerConfig getConfig() {
		return config;
	}

	public ConfigManager getConfigManager() {
		return configManager;
	}

	@Provides
	TasksTrackerConfig provideConfig(ConfigManager configManager)
	{
		return configManager.getConfig(TasksTrackerConfig.class);
	}
}

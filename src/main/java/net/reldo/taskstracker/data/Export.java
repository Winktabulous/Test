package net.reldo.taskstracker.data;

import com.google.gson.annotations.Expose;

import java.time.Instant;
import java.util.HashMap;
import java.util.List;

import lombok.Getter;
import lombok.Setter;
import net.reldo.taskstracker.bosses.BossData;
import net.reldo.taskstracker.quests.DiaryData;
import net.reldo.taskstracker.quests.QuestData;
import net.reldo.taskstracker.tasktypes.Task;
import net.reldo.taskstracker.tasktypes.TaskType;
import net.reldo.taskstracker.tasktypes.league5.LeagueVarbits;
import net.runelite.api.Actor;
import net.runelite.api.Client;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.plugins.PluginManager;

@Getter
public class Export {
    private final Client client;

    @Expose
    private final QuestData quests;
    @Expose
    private final DiaryData diaries;
    @Expose
    private final BossData bosses;
    @Expose
    private String displayName;
    @Expose
    private final int runescapeVersion;
    @Expose
    private final String runeliteVersion;
    @Expose
    private final long timestamp;
    @Expose
    private final String taskType;
    @Expose
    private final HashMap<Integer, Integer> varbits;
    @Expose
    private final HashMap<Integer, Integer> varps;
    // TODO: Setter until property is ready to deprecate when web accepts varbits
    @Setter
    @Expose
    private HashMap<String, Task> tasks;

    public Export(TaskType taskType, String runeliteVersion, Client client, PluginManager pluginManager, ConfigManager configManager) {
        this.client = client;
        Actor localPlayer = client.getLocalPlayer();
        if (localPlayer != null) {
            this.displayName = localPlayer.getName();
        }
        quests = new QuestData(client);
        diaries = new DiaryData(client);
        bosses = new BossData(pluginManager, configManager);
        runescapeVersion = client.getRevision();
        this.runeliteVersion = runeliteVersion;
        timestamp = Instant.now().toEpochMilli();
        this.taskType = taskType.name();
        varbits = getVarbits(taskType);
        varps = getVarps(taskType);
    }

    private HashMap<Integer, Integer> getVarbits(TaskType taskType) {
//
        return null;
    }

    public HashMap<Integer, Integer> getVarps(TaskType taskType) {
        return null;
    }
}

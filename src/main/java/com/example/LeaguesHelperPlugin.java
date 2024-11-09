package com.example;

import com.google.inject.Provides;
import javax.inject.Inject;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Client;
import net.runelite.api.GameState;
import net.runelite.api.events.GameStateChanged;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.events.ConfigChanged;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.ui.overlay.OverlayManager;
import net.runelite.client.events.PluginMessage; // Import PluginMessage
import java.util.HashMap; // Import HashMap
import java.util.Map; // Import Map
import net.runelite.api.coords.WorldPoint; // Import WorldPoint for coordinates
import net.runelite.client.eventbus.EventBus; // Import EventBus

@Slf4j
@PluginDescriptor(
        name = "Leagues Helper",
        description = "Helps track and complete OSRS Leagues tasks",
        tags = {"leagues", "tasks", "helper"}
)
public class LeaguesHelperPlugin extends Plugin {
    @Inject
    private Client client;

    @Inject
    private LeaguesHelperConfig config;

    @Inject
    private OverlayManager overlayManager;

    @Inject
    private LeaguesHelperOverlay overlay;

    @Inject
    private EventBus eventBus; // Inject EventBus

    @Getter
    private LeaguesTask currentTask;

    @Override
    protected void startUp() throws Exception {
        log.info("Leagues Helper started!");
        overlayManager.add(overlay);
        updateCurrentTask();
    }

    @Override
    protected void shutDown() throws Exception {
        log.info("Leagues Helper stopped!");
        overlayManager.remove(overlay);
        currentTask = null;
    }

    @Subscribe
    public void onGameStateChanged(GameStateChanged gameStateChanged) {
        if (gameStateChanged.getGameState() == GameState.LOGGED_IN) {
            updateCurrentTask();
        }
    }

    @Subscribe
    public void onConfigChanged(ConfigChanged event) {
        if (event.getGroup().equals("leagueshelper")) {
            log.info("Config changed: {} = {}", event.getKey(), event.getNewValue());
            updateCurrentTask();
        }
    }

    @Provides
    LeaguesHelperConfig provideConfig(ConfigManager configManager) {
        return configManager.getConfig(LeaguesHelperConfig.class);
    }

    private void updateCurrentTask() {
        LeaguesTask oldTask = currentTask;

        for (LeaguesTask task : LeaguesTask.values()) {
            if (!isTaskCompleted(task)) {
                currentTask = task;
                if (oldTask != currentTask) {
                    log.info("Current task updated from {} to {}", oldTask, currentTask);
                    if (currentTask.hasCoordinates()) {
                        // Use the Shortest Path plugin to calculate the path
                        WorldPoint destination = new WorldPoint(currentTask.getCoordinates()[0], currentTask.getCoordinates()[1], currentTask.getCoordinates()[2]);
                        // Send a plugin message to the Shortest Path plugin
                        Map<String, Object> data = new HashMap<>();
                        data.put("start", new WorldPoint(client.getLocalPlayer().getWorldLocation().getX(), client.getLocalPlayer().getWorldLocation().getY(), 0));
                        data.put("target", destination);
                        eventBus.post(new PluginMessage("shortestpath", "path", data));
                        log.info("Shortest path message sent from {} to {}", data.get("start"), data.get("target"));
                    }
                }
                return;
            }
        }

        // All tasks completed
        currentTask = null;
        if (oldTask != null) {
            log.info("All tasks completed");
        }
    }

    private boolean isTaskCompleted(LeaguesTask task) {
        boolean completed = false;
        switch (task) {
            case LUMBRIDGE_OPEN_LEAGUES_MENU:
                completed = config.lumbridgeOpenLeaguesMenu();
                break;
            case LUMBRIDGE_COMPLETE_TUTORIAL:
                completed = config.lumbridgeCompleteTutorial();
                break;
            case LUMBRIDGE_CLAIM_ITEMS_FROM_SAGE:
                completed = config.lumbridgeClaimItemsFromSage();
                break;
            case LUMBRIDGE_ADJUST_SETTINGS:
                completed = config.lumbridgeAdjustSettings();
                break;
            case LUMBRIDGE_START_RUNE_MYSTERIES:
                completed = config.lumbridgeStartRuneMysteries();
                break;
            case LUMBRIDGE_SET_BANK_PIN:
                completed = config.lumbridgeSetBankPin();
                break;
            case LUMBRIDGE_PICKPOCKET_CITIZEN:
                completed = config.lumbridgePickpocketCitizen();
                break;
            case LUMBRIDGE_OPEN_28_COIN_POUCHES:
                completed = config.lumbridgeOpen28CoinPouches();
                break;
            case LUMBRIDGE_ACHIEVE_FIRST_LEVEL_UP:
                completed = config.lumbridgeAchieveFirstLevelUp();
                break;
            case LUMBRIDGE_ACHIEVE_FIRST_LEVEL_5:
                completed = config.lumbridgeAchieveFirstLevel5();
                break;
            case LUMBRIDGE_ACHIEVE_FIRST_LEVEL_10:
                completed = config.lumbridgeAchieveFirstLevel10();
                break;
            case LUMBRIDGE_DEFEAT_GOBLIN:
                completed = config.lumbridgeDefeatGoblin();
                break;
            case LUMBRIDGE_BURY_BONES:
                completed = config.lumbridgeBuryBones();
                break;
            case LUMBRIDGE_VISIT_DEATHS_DOMAIN:
                completed = config.lumbridgeVisitDeathsDomain();
                break;
            case LUMBRIDGE_DANCE_IN_GRAVEYARD:
                completed = config.lumbridgeDanceInGraveyard();
                break;
            case LUMBRIDGE_SUPPLY_RUN:
                completed = config.lumbridgeSupplyRun();
                break;
            case LUMBRIDGE_SUPPLY_RUN_PT2:
                completed = config.lumbridgeSupplyRunPt2();
                break;
            case LUMBRIDGE_RUNE_MYSTERY_MAGE_TOWER:
                completed = config.lumbridgeRuneMysteryMageTower();
                break;
            case LUMBRIDGE_USE_FAIRY_RING:
                completed = config.lumbridgeUseFairyRing();
                break;
            case LUMBRIDGE_ENTER_ZANARIS:
                completed = config.lumbridgeEnterZanaris();
                break;
        }
        if (completed) {
            log.info("Task {} is completed", task);
        }
        return completed;
    }
}

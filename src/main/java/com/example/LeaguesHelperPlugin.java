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
import net.runelite.client.events.PluginMessage;
import java.util.HashMap;
import java.util.Map;
import net.runelite.api.coords.WorldPoint;
import net.runelite.client.eventbus.EventBus;

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
    private EventBus eventBus;

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
            // Process Lumbridge Part 1, Varrock Part 1, Draynor Part 1, and Lumbridge Part 2 tasks
            if ((task.getArea().equals("Lumbridge Part 1") ||
                    task.getArea().equals("Varrock Part 1") ||
                    task.getArea().equals("Draynor Part 1") ||
                    task.getArea().equals("Lumbridge Part 2")) && !isTaskCompleted(task)) {
                currentTask = task;
                if (oldTask != currentTask) {
                    log.info("Current task updated from {} to {}", oldTask, currentTask);
                    if (currentTask.hasCoordinates()) {
                        WorldPoint destination = new WorldPoint(currentTask.getCoordinates()[0], currentTask.getCoordinates()[1], currentTask.getCoordinates()[2]);
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
            log.info("All Lumbridge Part 1, Varrock Part 1, Draynor Part 1, and Lumbridge Part 2 tasks completed");
        }
    }

    private boolean isTaskCompleted(LeaguesTask task) {
        boolean completed = false;
        switch (task) {
            // Lumbridge Part 1
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

            // Varrock Part 1
            case VARROCK_GO_TO_EDGEVILLE:
                completed = config.varrockGoToEdgeville();
                break;
            case VARROCK_STRONGHOLD_SECURITY:
                completed = config.varrockStrongholdSecurity();
                break;
            case VARROCK_WEAR_FANCY_BOOTS:
                completed = config.varrockWearFancyBoots();
                break;
            case VARROCK_BUY_STEEL_HELM:
                completed = config.varrockBuySteelHelm();
                break;
            case VARROCK_BUY_FIRE_STAFF:
                completed = config.varrockBuyFireStaff();
                break;
            case VARROCK_STEAL_TEA_STALL:
                completed = config.varrockStealTeaStall();
                break;
            case VARROCK_PURCHASE_RUNES:
                completed = config.varrockPurchaseRunes();
                break;
            case VARROCK_DEFEAT_GUARD:
                completed = config.varrockDefeatGuard();
                break;
            case VARROCK_PET_STRAY_DOG:
                completed = config.varrockPetStrayDog();
                break;
            case VARROCK_FEED_STRAY_DOG:
                completed = config.varrockFeedStrayDog();
                break;
            case VARROCK_PURCHASE_POH:
                completed = config.varrockPurchasePOH();
                break;
            case VARROCK_ELSIE_STORY:
                completed = config.varrockElsieStory();
                break;
            case VARROCK_SLASH_WEB:
                completed = config.varrockSlashWeb();
                break;
            case VARROCK_CHOP_LOGS:
                completed = config.varrockChopLogs();
                break;
            case VARROCK_BURN_LOGS:
                completed = config.varrockBurnLogs();
                break;
            case VARROCK_CHOP_STEEL_AXE:
                completed = config.varrockChopSteelAxe();
                break;
            case VARROCK_BURN_OAK_LOGS:
                completed = config.varrockBurnOakLogs();
                break;
            case VARROCK_FLETCH_ARROW_SHAFTS:
                completed = config.varrockFletchArrowShafts();
                break;
            case VARROCK_FLETCH_1000_SHAFTS:
                completed = config.varrockFletch1000Shafts();
                break;
            case VARROCK_MAKE_PLANK:
                completed = config.varrockMakePlank();
                break;
            case VARROCK_GO_TO_FOSSIL_ISLAND:
                completed = config.varrockGoToFossilIsland();
                break;
            case VARROCK_PET_FOSSIL_DOG:
                completed = config.varrockPetFossilDog();
                break;
            case VARROCK_MINE_COPPER:
                completed = config.varrockMineCopper();
                break;
            case VARROCK_MINE_TIN:
                completed = config.varrockMineTin();
                break;
            case VARROCK_RAKE_PATCHES:
                completed = config.varrockRakePatches();
                break;
            case VARROCK_PLANT_HOPS:
                completed = config.varrockPlantHops();
                break;
            case VARROCK_ACHIEVE_LEVEL_20:
                completed = config.varrockAchieveLevel20();
                break;

            // Draynor Part 1
            case DRAYNOR_BURN_FOOD:
                completed = config.draynorBurnFood();
                break;
            case DRAYNOR_COOK_5_FOOD:
                completed = config.draynorCook5Food();
                break;
            case DRAYNOR_COMPLETE_ROOFTOP_COURSE:
                completed = config.draynorCompleteRooftopCourse();
                break;
            case DRAYNOR_OBTAIN_MARK_OF_GRACE:
                completed = config.draynorObtainMarkOfGrace();
                break;
            case DRAYNOR_COMPLETE_AGILITY_COURSE:
                completed = config.draynorCompleteAgilityCourse();
                break;
            case DRAYNOR_10_LAPS_AGILITY:
                completed = config.draynor10LapsAgility();
                break;
            case DRAYNOR_ACHIEVE_LEVEL_30:
                completed = config.draynorAchieveLevel30();
                break;
            case DRAYNOR_WISE_OLD_MAN_TASK:
                completed = config.draynorWiseOldManTask();
                break;
            case DRAYNOR_CHOP_100_WILLOW:
                completed = config.draynorChop100Willow();
                break;
            case DRAYNOR_BURN_100_WILLOW:
                completed = config.draynorBurn100Willow();
                break;
            case DRAYNOR_CHOP_RISING_ROOTS:
                completed = config.draynorChopRisingRoots();
                break;
            case DRAYNOR_STRUGGLING_SAPLING:
                completed = config.draynorStrugglingSapling();
                break;
            case DRAYNOR_STEAL_WINE_OR_HAM:
                completed = config.draynorStealWineOrHam();
                break;
            case DRAYNOR_PICKPOCKET_MASTER_FARMER:
                completed = config.draynorPickpocketMasterFarmer();
                break;
            case DRAYNOR_PICKPOCKET_RANNAR:
                completed = config.draynorPickpocketRannar();
                break;
            case DRAYNOR_NED_ROPE:
                completed = config.draynorNedRope();
                break;
            case DRAYNOR_INSULT_AGGIE:
                completed = config.draynorInsultAggie();
                break;

            // Lumbridge Part 2
            case LUMBRIDGE_CHOP_POTATO_TREE:
                completed = config.lumbridgeChopPotatoTree();
                break;
            case LUMBRIDGE_ENTER_DRAYNOR_MANOR:
                completed = config.lumbridgeEnterDraynorManor();
                break;
            case LUMBRIDGE_GET_CHAIR_FOLLOW:
                completed = config.lumbridgeGetChairFollow();
                break;
            case LUMBRIDGE_CRY_IN_WHEAT_FIELD:
                completed = config.lumbridgeCryInWheatField();
                break;
            case LUMBRIDGE_MAKE_FLOUR:
                completed = config.lumbridgeMakeFlour();
                break;
            case LUMBRIDGE_MILK_COW:
                completed = config.lumbridgeMilkCow();
                break;
            case LUMBRIDGE_GRAB_EGG:
                completed = config.lumbridgeGrabEgg();
                break;
            case LUMBRIDGE_USE_RANGE_CASTLE:
                completed = config.lumbridgeUseRangeCastle();
                break;
            case LUMBRIDGE_COMPLETE_COOKS_ASSISTANT:
                completed = config.lumbridgeCompleteCooksAssistant();
                break;
            case LUMBRIDGE_SPIN_WOOL:
                completed = config.lumbridgeSpinWool();
                break;
            case LUMBRIDGE_COMPLETE_SHEEP_SHEARER:
                completed = config.lumbridgeCompleteSheepShearer();
                break;
        }
        if (completed) {
            log.info("Task {} is completed", task);
        }
        return completed;
    }
}

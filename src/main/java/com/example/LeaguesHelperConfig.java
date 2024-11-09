package com.example;

import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;
import net.runelite.client.config.ConfigSection;

@ConfigGroup("leagueshelper")
public interface LeaguesHelperConfig extends Config {
    @ConfigSection(
            name = "Lumbridge Part 1",
            description = "Tasks in the Lumbridge area",
            position = 0
    )
    String lumbridgeSection = "lumbridgeSection";

    @ConfigItem(
            keyName = "lumbridgeOpenLeaguesMenu",
            name = "Open the Leagues Menu",
            description = "Open the Leagues menu",
            section = lumbridgeSection,
            position = 0
    )
    default boolean lumbridgeOpenLeaguesMenu() { return false; }

    @ConfigItem(
            keyName = "lumbridgeCompleteTutorial",
            name = "Complete the Leagues Tutorial",
            description = "Complete the Leagues tutorial",
            section = lumbridgeSection,
            position = 1
    )
    default boolean lumbridgeCompleteTutorial() { return false; }

    @ConfigItem(
            keyName = "lumbridgeClaimItemsFromSage",
            name = "Claim items from sage",
            description = "Claim items from the sage",
            section = lumbridgeSection,
            position = 2
    )
    default boolean lumbridgeClaimItemsFromSage() { return false; }

    @ConfigItem(
            keyName = "lumbridgeAdjustSettings",
            name = "Settings adjust",
            description = "Adjust the game settings",
            section = lumbridgeSection,
            position = 3
    )
    default boolean lumbridgeAdjustSettings() { return false; }

    @ConfigItem(
            keyName = "lumbridgeStartRuneMysteries",
            name = "Start Rune Mysteries",
            description = "Start the Rune Mysteries quest",
            section = lumbridgeSection,
            position = 4
    )
    default boolean lumbridgeStartRuneMysteries() { return false; }

    @ConfigItem(
            keyName = "lumbridgeSetBankPin",
            name = "Set bank pin",
            description = "Set a bank pin",
            section = lumbridgeSection,
            position = 5
    )
    default boolean lumbridgeSetBankPin() { return false; }

    @ConfigItem(
            keyName = "lumbridgePickpocketCitizen",
            name = "Pickpocket a Citizen",
            description = "Pickpocket a citizen",
            section = lumbridgeSection,
            position = 6
    )
    default boolean lumbridgePickpocketCitizen() { return false; }

    @ConfigItem(
            keyName = "lumbridgeOpen28CoinPouches",
            name = "Open 28 Coin Pouches At Once",
            description = "Open 28 coin pouches at once",
            section = lumbridgeSection,
            position = 7
    )
    default boolean lumbridgeOpen28CoinPouches() { return false; }

    @ConfigItem(
            keyName = "lumbridgeAchieveFirstLevelUp",
            name = "Achieve Your First Level Up",
            description = "Achieve your first level up",
            section = lumbridgeSection,
            position = 8
    )
    default boolean lumbridgeAchieveFirstLevelUp() { return false; }

    @ConfigItem(
            keyName = "lumbridgeAchieveFirstLevel5",
            name = "Achieve Your First Level 5",
            description = "Achieve your first level 5",
            section = lumbridgeSection,
            position = 9
    )
    default boolean lumbridgeAchieveFirstLevel5() { return false; }

    @ConfigItem(
            keyName = "lumbridgeAchieveFirstLevel10",
            name = "Achieve Your First Level 10",
            description = "Achieve your first level 10",
            section = lumbridgeSection,
            position = 10
    )
    default boolean lumbridgeAchieveFirstLevel10() { return false; }

    @ConfigItem(
            keyName = "lumbridgeDefeatGoblin",
            name = "Defeat a Goblin",
            description = "Defeat a goblin",
            section = lumbridgeSection,
            position = 11
    )
    default boolean lumbridgeDefeatGoblin() { return false; }

    @ConfigItem(
            keyName = "lumbridgeBuryBones",
            name = "Bury Some Bones",
            description = "Bury some bones",
            section = lumbridgeSection,
            position = 12
    )
    default boolean lumbridgeBuryBones() { return false; }

    @ConfigItem(
            keyName = "lumbridgeVisitDeathsDomain",
            name = "Visit Death's Domain",
            description = "Visit Death's domain",
            section = lumbridgeSection,
            position = 13
    )
    default boolean lumbridgeVisitDeathsDomain() { return false; }

    @ConfigItem(
            keyName = "lumbridgeDanceInGraveyard",
            name = "Dance in a graveyard",
            description = "Dance in a graveyard",
            section = lumbridgeSection,
            position = 14
    )
    default boolean lumbridgeDanceInGraveyard() { return false; }

    @ConfigItem(
            keyName = "lumbridgeSupplyRun",
            name = "Supply Run",
            description = "Complete the Supply Run task",
            section = lumbridgeSection,
            position = 15
    )
    default boolean lumbridgeSupplyRun() { return false; }

    @ConfigItem(
            keyName = "lumbridgeSupplyRunPt2",
            name = "Supply Run Pt 2",
            description = "Complete the Supply Run Pt 2 task",
            section = lumbridgeSection,
            position = 16
    )
    default boolean lumbridgeSupplyRunPt2() { return false; }

    @ConfigItem(
            keyName = "lumbridgeRuneMysteryMageTower",
            name = "Rune Mystery Step @ Mage Tower",
            description = "Complete the Rune Mystery step at the Mage Tower",
            section = lumbridgeSection,
            position = 17
    )
    default boolean lumbridgeRuneMysteryMageTower() { return false; }

    @ConfigItem(
            keyName = "lumbridgeUseFairyRing",
            name = "Use a Fairy Ring",
            description = "Use a Fairy Ring",
            section = lumbridgeSection,
            position = 18
    )
    default boolean lumbridgeUseFairyRing() { return false; }

    @ConfigItem(
            keyName = "lumbridgeEnterZanaris",
            name = "Enter Zanaris",
            description = "Enter Zanaris",
            section = lumbridgeSection,
            position = 19
    )
    default boolean lumbridgeEnterZanaris() { return false; }

    @ConfigItem(
            keyName = "showOverlay",
            name = "Show Overlay",
            description = "Toggle the task overlay display",
            position = 20
    )
    default boolean showOverlay() { return true; }
}

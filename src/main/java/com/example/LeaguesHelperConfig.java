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

    @ConfigSection(
            name = "Varrock Part 1",
            description = "Tasks in the Varrock area",
            position = 1
    )
    String varrockSection = "varrockSection";

    @ConfigSection(
            name = "Draynor Part 1",
            description = "Tasks in the Draynor area",
            position = 2
    )
    String draynorSection = "draynorSection";

    @ConfigSection(
            name = "Lumbridge Part 2",
            description = "Additional tasks in the Lumbridge area",
            position = 3
    )
    String lumbridgeSection2 = "lumbridgeSection2";

    @ConfigSection(
            name = "Karamja",
            description = "Tasks in the Karamja area",
            position = 4
    )
    String karamjaSection = "karamjaSection";

    @ConfigSection(
            name = "Varrock Part 2",
            description = "Additional tasks in the Varrock area",
            position = 5
    )
    String varrockSection2 = "varrockSection2";


    // Lumbridge Part 1 Tasks
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

    // Varrock Part 1 Tasks
    @ConfigItem(
            keyName = "varrockGoToEdgeville",
            name = "Go to Edgeville",
            description = "Go to Edgeville using Dramen/Lunar staff Kingdom ring",
            section = varrockSection,
            position = 0
    )
    default boolean varrockGoToEdgeville() { return false; }

    @ConfigItem(
            keyName = "varrockStrongholdSecurity",
            name = "Stronghold Security",
            description = "Complete Stronghold of Security for 10k",
            section = varrockSection,
            position = 1
    )
    default boolean varrockStrongholdSecurity() { return false; }

    @ConfigItem(
            keyName = "varrockWearFancyBoots",
            name = "Wear fancy boots",
            description = "Equip the fancy boots",
            section = varrockSection,
            position = 2
    )
    default boolean varrockWearFancyBoots() { return false; }

    @ConfigItem(
            keyName = "varrockBuySteelHelm",
            name = "Buy Steel Full helm",
            description = "Purchase a Steel full helm",
            section = varrockSection,
            position = 3
    )
    default boolean varrockBuySteelHelm() { return false; }

    @ConfigItem(
            keyName = "varrockBuyFireStaff",
            name = "Buy fire staff",
            description = "Purchase a fire staff",
            section = varrockSection,
            position = 4
    )
    default boolean varrockBuyFireStaff() { return false; }

    @ConfigItem(
            keyName = "varrockStealTeaStall",
            name = "Steal From Tea Stall",
            description = "Steal from the tea stall in Varrock",
            section = varrockSection,
            position = 5
    )
    default boolean varrockStealTeaStall() { return false; }

    @ConfigItem(
            keyName = "varrockPurchaseRunes",
            name = "Purchase runes",
            description = "Buy runes and continue Rune Mysteries",
            section = varrockSection,
            position = 6
    )
    default boolean varrockPurchaseRunes() { return false; }

    @ConfigItem(
            keyName = "varrockDefeatGuard",
            name = "Defeat a Guard",
            description = "Defeat a Varrock guard",
            section = varrockSection,
            position = 7
    )
    default boolean varrockDefeatGuard() { return false; }

    @ConfigItem(
            keyName = "varrockPetStrayDog",
            name = "Pet a Stray Dog",
            description = "Pet one of Varrock's stray dogs",
            section = varrockSection,
            position = 8
    )
    default boolean varrockPetStrayDog() { return false; }

    @ConfigItem(
            keyName = "varrockFeedStrayDog",
            name = "Feed Stray Dog",
            description = "Feed bones to a stray dog",
            section = varrockSection,
            position = 9
    )
    default boolean varrockFeedStrayDog() { return false; }

    @ConfigItem(
            keyName = "varrockPurchasePOH",
            name = "Purchase POH",
            description = "Purchase a Player Owned House",
            section = varrockSection,
            position = 10
    )
    default boolean varrockPurchasePOH() { return false; }

    @ConfigItem(
            keyName = "varrockElsieStory",
            name = "Elsie Story",
            description = "Listen to Elsie's story",
            section = varrockSection,
            position = 11
    )
    default boolean varrockElsieStory() { return false; }

    @ConfigItem(
            keyName = "varrockSlashWeb",
            name = "Slash Web",
            description = "Slash a web in the Varrock sewers",
            section = varrockSection,
            position = 12
    )
    default boolean varrockSlashWeb() { return false; }

    @ConfigItem(
            keyName = "varrockChopLogs",
            name = "Chop Logs",
            description = "Cut down a tree for logs",
            section = varrockSection,
            position = 13
    )
    default boolean varrockChopLogs() { return false; }

    @ConfigItem(
            keyName = "varrockBurnLogs",
            name = "Burn Logs",
            description = "Burn normal logs",
            section = varrockSection,
            position = 14
    )
    default boolean varrockBurnLogs() { return false; }

    @ConfigItem(
            keyName = "varrockChopSteelAxe",
            name = "Chop with Steel Axe",
            description = "Cut down a tree using a steel axe",
            section = varrockSection,
            position = 15
    )
    default boolean varrockChopSteelAxe() { return false; }

    @ConfigItem(
            keyName = "varrockBurnOakLogs",
            name = "Burn Oak Logs",
            description = "Burn oak logs",
            section = varrockSection,
            position = 16
    )
    default boolean varrockBurnOakLogs() { return false; }

    @ConfigItem(
            keyName = "varrockFletchArrowShafts",
            name = "Fletch Arrow Shafts",
            description = "Create arrow shafts from logs",
            section = varrockSection,
            position = 17
    )
    default boolean varrockFletchArrowShafts() { return false; }

    @ConfigItem(
            keyName = "varrockFletch1000Shafts",
            name = "Fletch 1000 Shafts",
            description = "Create 1000 arrow shafts from logs",
            section = varrockSection,
            position = 18
    )
    default boolean varrockFletch1000Shafts() { return false; }

    @ConfigItem(
            keyName = "varrockMakePlank",
            name = "Make Plank",
            description = "Convert logs into planks",
            section = varrockSection,
            position = 19
    )
    default boolean varrockMakePlank() { return false; }

    @ConfigItem(
            keyName = "varrockGoToFossilIsland",
            name = "Go to Fossil Island",
            description = "Travel to Fossil Island",
            section = varrockSection,
            position = 20
    )
    default boolean varrockGoToFossilIsland() { return false; }

    @ConfigItem(
            keyName = "varrockPetFossilDog",
            name = "Pet Fossil Dog",
            description = "Pet the dog on Fossil Island",
            section = varrockSection,
            position = 21
    )
    default boolean varrockPetFossilDog() { return false; }

    @ConfigItem(
            keyName = "varrockMineCopper",
            name = "Mine Copper",
            description = "Mine copper ore",
            section = varrockSection,
            position = 22
    )
    default boolean varrockMineCopper() { return false; }

    @ConfigItem(
            keyName = "varrockMineTin",
            name = "Mine Tin",
            description = "Mine 10 tin ore",
            section = varrockSection,
            position = 23
    )
    default boolean varrockMineTin() { return false; }

    @ConfigItem(
            keyName = "varrockRakePatches",
            name = "Rake Patches",
            description = "Rake two farming patches near Champions' Guild",
            section = varrockSection,
            position = 24
    )
    default boolean varrockRakePatches() { return false; }

    @ConfigItem(
            keyName = "varrockPlantHops",
            name = "Plant Hops",
            description = "Plant hops and pay the farmer",
            section = varrockSection,
            position = 25
    )
    default boolean varrockPlantHops() { return false; }

    @ConfigItem(
            keyName = "varrockAchieveLevel20",
            name = "Achieve Level 20",
            description = "Get any skill to level 20",
            section = varrockSection,
            position = 26
    )
    default boolean varrockAchieveLevel20() { return false; }

    // Draynor Part 1 Tasks
    @ConfigItem(
            keyName = "draynorBurnFood",
            name = "Burn Food",
            description = "Burn a piece of food",
            section = draynorSection,
            position = 0
    )
    default boolean draynorBurnFood() { return false; }

    @ConfigItem(
            keyName = "draynorCook5Food",
            name = "Cook 5 Food",
            description = "Successfully cook 5 different food items",
            section = draynorSection,
            position = 1
    )
    default boolean draynorCook5Food() { return false; }

    @ConfigItem(
            keyName = "draynorCompleteRooftopCourse",
            name = "Complete Rooftop Course",
            description = "Complete any rooftop agility course",
            section = draynorSection,
            position = 2
    )
    default boolean draynorCompleteRooftopCourse() { return false; }

    @ConfigItem(
            keyName = "draynorObtainMarkOfGrace",
            name = "Obtain Mark of Grace",
            description = "Obtain a Mark of Grace from an agility course",
            section = draynorSection,
            position = 3
    )
    default boolean draynorObtainMarkOfGrace() { return false; }

    @ConfigItem(
            keyName = "draynorCompleteAgilityCourse",
            name = "Complete Agility Course",
            description = "Complete the Draynor Village Agility Course",
            section = draynorSection,
            position = 4
    )
    default boolean draynorCompleteAgilityCourse() { return false; }

    @ConfigItem(
            keyName = "draynor10LapsAgility",
            name = "10 Laps Agility",
            description = "Complete 10 laps of the Draynor Village Agility Course",
            section = draynorSection,
            position = 5
    )
    default boolean draynor10LapsAgility() { return false; }

    @ConfigItem(
            keyName = "draynorAchieveLevel30",
            name = "Achieve Level 30",
            description = "Get any skill to level 30",
            section = draynorSection,
            position = 6
    )
    default boolean draynorAchieveLevel30() { return false; }

    @ConfigItem(
            keyName = "draynorWiseOldManTask",
            name = "Wise Old Man Task",
            description = "Complete a task for the Wise Old Man in Draynor",
            section = draynorSection,
            position = 7
    )
    default boolean draynorWiseOldManTask() { return false; }

    @ConfigItem(
            keyName = "draynorChop100Willow",
            name = "Chop 100 Willow",
            description = "Chop 100 willow logs",
            section = draynorSection,
            position = 8
    )
    default boolean draynorChop100Willow() { return false; }

    @ConfigItem(
            keyName = "draynorBurn100Willow",
            name = "Burn 100 Willow",
            description = "Burn 100 willow logs",
            section = draynorSection,
            position = 9
    )
    default boolean draynorBurn100Willow() { return false; }

    @ConfigItem(
            keyName = "draynorChopRisingRoots",
            name = "Chop Rising Roots",
            description = "Chop rising roots",
            section = draynorSection,
            position = 10
    )
    default boolean draynorChopRisingRoots() { return false; }

    @ConfigItem(
            keyName = "draynorStrugglingSapling",
            name = "Struggling Sapling",
            description = "Complete the Struggling Sapling event",
            section = draynorSection,
            position = 11
    )
    default boolean draynorStrugglingSapling() { return false; }

    @ConfigItem(
            keyName = "draynorStealWineOrHam",
            name = "Steal Wine or Ham",
            description = "Steal from the wine stall or Ham members",
            section = draynorSection,
            position = 12
    )
    default boolean draynorStealWineOrHam() { return false; }

    @ConfigItem(
            keyName = "draynorPickpocketMasterFarmer",
            name = "Pickpocket Master Farmer",
            description = "Pickpocket a Master Farmer",
            section = draynorSection,
            position = 13
    )
    default boolean draynorPickpocketMasterFarmer() { return false; }

    @ConfigItem(
            keyName = "draynorPickpocketRannar",
            name = "Pickpocket Rannar",
            description = "Pickpocket a Rannar",
            section = draynorSection,
            position = 14
    )
    default boolean draynorPickpocketRannar() { return false; }

    @ConfigItem(
            keyName = "draynorNedRope",
            name = "Ned Rope",
            description = "Ask Ned to make you a rope",
            section = draynorSection,
            position = 15
    )
    default boolean draynorNedRope() { return false; }

    @ConfigItem(
            keyName = "draynorInsultAggie",
            name = "Insult Aggie",
            description = "Insult Aggie the Witch",
            section = draynorSection,
            position = 16
    )
    default boolean draynorInsultAggie() { return false; }

    // Lumbridge Part 2 Tasks
    @ConfigItem(
            keyName = "lumbridgeChopPotatoTree",
            name = "Chop Potato Tree",
            description = "Chop a log from a potato tree",
            section = lumbridgeSection2,
            position = 0
    )
    default boolean lumbridgeChopPotatoTree() { return false; }

    @ConfigItem(
            keyName = "lumbridgeEnterDraynorManor",
            name = "Enter Draynor Manor",
            description = "Enter Draynor Manor",
            section = lumbridgeSection2,
            position = 1
    )
    default boolean lumbridgeEnterDraynorManor() { return false; }

    @ConfigItem(
            keyName = "lumbridgeGetChairFollow",
            name = "Chair Follow",
            description = "Get a chair to follow you",
            section = lumbridgeSection2,
            position = 2
    )
    default boolean lumbridgeGetChairFollow() { return false; }

    @ConfigItem(
            keyName = "lumbridgeCryInWheatField",
            name = "Cry in Wheat Field",
            description = "Cry in the wheat field",
            section = lumbridgeSection2,
            position = 3
    )
    default boolean lumbridgeCryInWheatField() { return false; }

    @ConfigItem(
            keyName = "lumbridgeMakeFlour",
            name = "Make Flour",
            description = "Make some flour",
            section = lumbridgeSection2,
            position = 4
    )
    default boolean lumbridgeMakeFlour() { return false; }

    @ConfigItem(
            keyName = "lumbridgeMilkCow",
            name = "Milk Cow",
            description = "Milk a cow",
            section = lumbridgeSection2,
            position = 5
    )
    default boolean lumbridgeMilkCow() { return false; }

    @ConfigItem(
            keyName = "lumbridgeGrabEgg",
            name = "Grab Egg",
            description = "Grab an egg for cook assist",
            section = lumbridgeSection2,
            position = 6
    )
    default boolean lumbridgeGrabEgg() { return false; }

    @ConfigItem(
            keyName = "lumbridgeUseRangeCastle",
            name = "Use Range Castle",
            description = "Use Range in Lumbridge Castle",
            section = lumbridgeSection2,
            position = 7
    )
    default boolean lumbridgeUseRangeCastle() { return false; }

    @ConfigItem(
            keyName = "lumbridgeCompleteCooksAssistant",
            name = "Complete Cooks Assistant",
            description = "Complete cooks assistant",
            section = lumbridgeSection2,
            position = 8
    )
    default boolean lumbridgeCompleteCooksAssistant() { return false; }

    @ConfigItem(
            keyName = "lumbridgeSpinWool",
            name = "Spin Wool",
            description = "Spin a ball of wool",
            section = lumbridgeSection2,
            position = 9
    )
    default boolean lumbridgeSpinWool() { return false; }

    @ConfigItem(
            keyName = "lumbridgeCompleteSheepShearer",
            name = "Complete Sheep Shearer",
            description = "Complete Sheep Shearer",
            section = lumbridgeSection2,
            position = 10
    )
    default boolean lumbridgeCompleteSheepShearer() { return false; }

    // Karamja Tasks
    @ConfigItem(
            keyName = "karamjaBuyFromTraders",
            name = "Buy From Traders",
            description = "Buy a knife and a torch",
            section = karamjaSection,
            position = 0
    )
    default boolean karamjaBuyFromTraders() { return false; }

    @ConfigItem(
            keyName = "karamjaTpToBrimhaven",
            name = "Teleport to Brimhaven",
            description = "Teleport to Brimhaven",
            section = karamjaSection,
            position = 1
    )
    default boolean karamjaTpToBrimhaven() { return false; }

    @ConfigItem(
            keyName = "karamjaKeepSardine",
            name = "Keep a Sardine",
            description = "Keep a sardine for Gertrude's cat later",
            section = karamjaSection,
            position = 2
    )
    default boolean karamjaKeepSardine() { return false; }

    @ConfigItem(
            keyName = "karamjaBuyFromCrew",
            name = "Buy From Crew",
            description = "Buy Something From Trader Crewmembers",
            section = karamjaSection,
            position = 3
    )
    default boolean karamjaBuyFromCrew() { return false; }

    @ConfigItem(
            keyName = "karamjaPickPineapple",
            name = "Pick a Pineapple",
            description = "Pick a Pineapple on Karamja",
            section = karamjaSection,
            position = 4
    )
    default boolean karamjaPickPineapple() { return false; }

    @ConfigItem(
            keyName = "karamjaEnterBrimhavenDungeon",
            name = "Enter Brimhaven Dungeon",
            description = "Enter the Brimhaven Dungeon",
            section = karamjaSection,
            position = 5
    )
    default boolean karamjaEnterBrimhavenDungeon() { return false; }

    @ConfigItem(
            keyName = "karamjaCatchKarambwanji",
            name = "Catch Karambwanji",
            description = "Catch a Karambwanji",
            section = karamjaSection,
            position = 6
    )
    default boolean karamjaCatchKarambwanji() { return false; }

    @ConfigItem(
            keyName = "karamjaLightTorch",
            name = "Light a Torch",
            description = "Light a Torch",
            section = karamjaSection,
            position = 7
    )
    default boolean karamjaLightTorch() { return false; }

    @ConfigItem(
            keyName = "karamjaCartToShilo",
            name = "Cart to Shilo",
            description = "Take the cart to shilo | Buy bait, Feathers",
            section = karamjaSection,
            position = 8
    )
    default boolean karamjaCartToShilo() { return false; }

    @ConfigItem(
            keyName = "karamjaCatchHerring",
            name = "Catch a Herring",
            description = "Catch a Herring",
            section = karamjaSection,
            position = 9
    )
    default boolean karamjaCatchHerring() { return false; }

    @ConfigItem(
            keyName = "karamjaUseHerringOnTree",
            name = "Use Herring on Tree",
            description = "Use a Herring on a tree",
            section = karamjaSection,
            position = 10
    )
    default boolean karamjaUseHerringOnTree() { return false; }

    @ConfigItem(
            keyName = "karamjaCatchSalmon",
            name = "Catch Salmon",
            description = "Catch a Salmon on Karamja",
            section = karamjaSection,
            position = 11
    )
    default boolean karamjaCatchSalmon() { return false; }

    @ConfigItem(
            keyName = "karamjaCatch50Salmon",
            name = "Catch 50 Salmon",
            description = "Catch 50 Salmon",
            section = karamjaSection,
            position = 12
    )
    default boolean karamjaCatch50Salmon() { return false; }

    @ConfigItem(
            keyName = "karamjaGetDuradelTask",
            name = "Get Duradel Task",
            description = "Get slayer task from Duradel",
            section = karamjaSection,
            position = 13
    )
    default boolean karamjaGetDuradelTask() { return false; }

    @ConfigItem(
            keyName = "karamjaReceiveSlayerTask",
            name = "Receive Slayer Task",
            description = "Receive a Slayer Task",
            section = karamjaSection,
            position = 14
    )
    default boolean karamjaReceiveSlayerTask() { return false; }

    @ConfigItem(
            keyName = "karamjaEquipSpinyHelm",
            name = "Equip Spiny Helm",
            description = "Equip spiny helm",
            section = karamjaSection,
            position = 15
    )
    default boolean karamjaEquipSpinyHelm() { return false; }

    @ConfigItem(
            keyName = "karamjaCheckSlayerTask",
            name = "Check Slayer Task",
            description = "Check your slayer task",
            section = karamjaSection,
            position = 16
    )
    default boolean karamjaCheckSlayerTask() { return false; }

    @ConfigItem(
            keyName = "karamjaFillBananaCrate",
            name = "Fill Banana Crate",
            description = "Fill a Crate With Bananas",
            section = karamjaSection,
            position = 17
    )
    default boolean karamjaFillBananaCrate() { return false; }

    @ConfigItem(
            keyName = "karamjaDefeatTzhaar",
            name = "Defeat Tzhaar",
            description = "Defeat a Tzhaar",
            section = karamjaSection,
            position = 18
    )
    default boolean karamjaDefeatTzhaar() { return false; }

    @ConfigItem(
            keyName = "karamjaReach10Combat",
            name = "Reach 10 Combat",
            description = "Reach 10 Combat",
            section = karamjaSection,
            position = 19
    )
    default boolean karamjaReach10Combat() { return false; }

    @ConfigItem(
            keyName = "karamjaReachTotal100",
            name = "Reach Total 100",
            description = "Reach Total Level 100",
            section = karamjaSection,
            position = 20
    )

    default boolean karamjaReachTotal100() { return false; }
    // Varrock Part 2 Tasks
    @ConfigItem(
            keyName = "varrockCompleteGertrudesCat",
            name = "Complete Gertrude's Cat",
            description = "Complete Gertrude's Cat",
            section = varrockSection2,
            position = 0
    )
    default boolean varrockCompleteGertrudesCat() { return false; }

    @ConfigItem(
            keyName = "varrockCompleteAgilityCourse",
            name = "Complete Varrock Agility Course",
            description = "Complete the Varrock Agility Course",
            section = varrockSection2,
            position = 1
    )
    default boolean varrockCompleteAgilityCourse() { return false; }

    @ConfigItem(
            keyName = "varrockComplete10Laps",
            name = "Complete 10 Laps",
            description = "Complete 10 Laps of the Varrock Agility Course",
            section = varrockSection2,
            position = 2
    )
    default boolean varrockComplete10Laps() { return false; }

    @ConfigItem(
            keyName = "varrockComplete50RooftopLaps",
            name = "Complete 50 Rooftop Laps",
            description = "Complete 50 Laps of a Rooftop Agility Course",
            section = varrockSection2,
            position = 3
    )
    default boolean varrockComplete50RooftopLaps() { return false; }

    @ConfigItem(
            keyName = "varrockAchieveLevel40",
            name = "Achieve Level 40",
            description = "Achieve Your First Level 40",
            section = varrockSection2,
            position = 4
    )
    default boolean varrockAchieveLevel40() { return false; }

    @ConfigItem(
            keyName = "varrockAchieveLevel50",
            name = "Achieve Level 50",
            description = "Achieve Your First Level 50",
            section = varrockSection2,
            position = 5
    )
    default boolean varrockAchieveLevel50() { return false; }

    @ConfigItem(
            keyName = "varrockPickpocketGuard",
            name = "Pickpocket Guard",
            description = "Pickpocket a Guard",
            section = varrockSection2,
            position = 6
    )
    default boolean varrockPickpocketGuard() { return false; }

    @ConfigItem(
            keyName = "varrockObtain800Coins",
            name = "Obtain 800 Coins",
            description = "Obtain 800 Coins From Coin Pouches At Once",
            section = varrockSection2,
            position = 7
    )
    default boolean varrockObtain800Coins() { return false; }

    @ConfigItem(
            keyName = "varrockSmeltBronzeBar",
            name = "Smelt Bronze Bar",
            description = "Smelt a Bronze Bar",
            section = varrockSection2,
            position = 8
    )
    default boolean varrockSmeltBronzeBar() { return false; }

    @ConfigItem(
            keyName = "varrockSmithBronzeHelm",
            name = "Smith Bronze Full Helm",
            description = "Smith a Bronze full helm",
            section = varrockSection2,
            position = 9
    )
    default boolean varrockSmithBronzeHelm() { return false; }

    @ConfigItem(
            keyName = "varrockSmeltIronBar",
            name = "Smelt Iron Bar",
            description = "Smelt an Iron Bar",
            section = varrockSection2,
            position = 10
    )
    default boolean varrockSmeltIronBar() { return false; }

    @ConfigItem(
            keyName = "varrockSmithBronzePlateskirt",
            name = "Smith Bronze Plateskirt",
            description = "Smith a Bronze plateskirt",
            section = varrockSection2,
            position = 11
    )
    default boolean varrockSmithBronzePlateskirt() { return false; }

    @ConfigItem(
            keyName = "varrockMine50Iron",
            name = "Mine 50 Iron Ore",
            description = "Mine 50 Iron Ore",
            section = varrockSection2,
            position = 12
    )
    default boolean varrockMine50Iron() { return false; }

    @ConfigItem(
            keyName = "varrockMine15Coal",
            name = "Mine 15 Coal",
            description = "Mine 15 coal",
            section = varrockSection2,
            position = 13
    )
    default boolean varrockMine15Coal() { return false; }

    @ConfigItem(
            keyName = "varrockSmeltSteelBar",
            name = "Smelt Steel Bar",
            description = "Smelt a Steel Bar",
            section = varrockSection2,
            position = 14
    )
    default boolean varrockSmeltSteelBar() { return false; }

    @ConfigItem(
            keyName = "varrockSmith10SteelBolts",
            name = "Smith Steel Bolts",
            description = "Smith 10 Steel bolts (unf)",
            section = varrockSection2,
            position = 15
    )
    default boolean varrockSmith10SteelBolts() { return false; }

    @ConfigItem(
            keyName = "varrockSmith150IronArrowtips",
            name = "Smith Iron Arrowtips",
            description = "Smith 150 Iron Arrowtips",
            section = varrockSection2,
            position = 16
    )
    default boolean varrockSmith150IronArrowtips() { return false; }

    @ConfigItem(
            keyName = "varrockFletch150IronArrows",
            name = "Fletch Iron Arrows",
            description = "Fletch 150 Iron Arrows",
            section = varrockSection2,
            position = 17
    )
    default boolean varrockFletch150IronArrows() { return false; }

    @ConfigItem(
            keyName = "varrockPanForJade",
            name = "Pan for Jade",
            description = "Pan for an Uncut Jade",
            section = varrockSection2,
            position = 18
    )
    default boolean varrockPanForJade() { return false; }

    @ConfigItem(
            keyName = "varrockRestorePrayer",
            name = "Restore Prayer Points",
            description = "Restore 5 Prayer Points at an Altar",
            section = varrockSection2,
            position = 19
    )
    default boolean varrockRestorePrayer() { return false; }

    @ConfigItem(
            keyName = "varrockReachTotal250",
            name = "Reach Total 250",
            description = "Reach Total Level 250",
            section = varrockSection2,
            position = 20
    )
    default boolean varrockReachTotal250() { return false; }
    @ConfigItem(
            keyName = "showOverlay",
            name = "Show Overlay",
            description = "Toggle the task overlay display",
            position = 21
    )
    default boolean showOverlay() { return true; }
}

package com.example;

public enum LeaguesTask {
    // Lumbridge Part 1
    LUMBRIDGE_OPEN_LEAGUES_MENU("Open the Leagues Menu", "Lumbridge Part 1", "Open the Leagues menu", null),
    LUMBRIDGE_COMPLETE_TUTORIAL("Complete the Leagues Tutorial", "Lumbridge Part 1", "Complete the Leagues tutorial", null),
    LUMBRIDGE_CLAIM_ITEMS_FROM_SAGE("Claim items from sage", "Lumbridge Part 1", "Claim items from the sage", new int[]{3222, 3218, 0}), // Ground floor
    LUMBRIDGE_ADJUST_SETTINGS("Settings adjust", "Lumbridge Part 1", "Adjust the game settings", null),
    LUMBRIDGE_START_RUNE_MYSTERIES("Start Rune Mysteries", "Lumbridge Part 1", "Start the Rune Mysteries quest", new int[]{3212, 3225, 1}), // Second floor
    LUMBRIDGE_SET_BANK_PIN("Set bank pin", "Lumbridge Part 1", "Set a bank pin", new int[]{3208, 3219, 0}), // Ground floor
    LUMBRIDGE_PICKPOCKET_CITIZEN("Pickpocket a Citizen", "Lumbridge Part 1", "Pickpocket a citizen", new int[]{3222, 3218, 0}), // Ground floor
    LUMBRIDGE_OPEN_28_COIN_POUCHES("Open 28 Coin Pouches At Once", "Lumbridge Part 1", "Open 28 coin pouches at once", null),
    LUMBRIDGE_ACHIEVE_FIRST_LEVEL_UP("Achieve Your First Level Up", "Lumbridge Part 1", "Achieve your first level up", null),
    LUMBRIDGE_ACHIEVE_FIRST_LEVEL_5("Achieve Your First Level 5", "Lumbridge Part 1", "Achieve your first level 5", null),
    LUMBRIDGE_ACHIEVE_FIRST_LEVEL_10("Achieve Your First Level 10", "Lumbridge Part 1", "Achieve your first level 10", null),
    LUMBRIDGE_DEFEAT_GOBLIN("Defeat a Goblin", "Lumbridge Part 1", "Defeat a goblin", new int[]{3245, 3235, 0}), // Goblin area near Lumbridge
    LUMBRIDGE_BURY_BONES("Bury Some Bones", "Lumbridge Part 1", "Bury some bones", new int[]{3222, 3218, 0}), // Ground floor
    LUMBRIDGE_VISIT_DEATHS_DOMAIN("Visit Death's Domain", "Lumbridge Part 1", "Visit Death's domain", new int[]{3081, 5346, 0}), // Ground floor
    LUMBRIDGE_DANCE_IN_GRAVEYARD("Dance in a graveyard", "Lumbridge Part 1", "Dance in a graveyard", new int[]{3242, 3259, 0}), // Ground floor
    LUMBRIDGE_SUPPLY_RUN("Supply Run", "Lumbridge Part 1", "Complete the Supply Run task", null),
    LUMBRIDGE_SUPPLY_RUN_PT2("Supply Run Pt 2", "Lumbridge Part 1", "Complete the Supply Run Pt 2 task", null),
    LUMBRIDGE_RUNE_MYSTERY_MAGE_TOWER("Rune Mystery Step @ Mage Tower", "Lumbridge Part 1", "Complete the Rune Mystery step at the Mage Tower", new int[]{3212, 3225, 1}), // Second floor
    LUMBRIDGE_USE_FAIRY_RING("Use a Fairy Ring", "Lumbridge Part 1", "Use a Fairy Ring", new int[]{3202, 3169, 0}), // Ground floor
    LUMBRIDGE_ENTER_ZANARIS("Enter Zanaris", "Lumbridge Part 1", "Enter Zanaris", new int[]{3202, 3169, 0}), // Ground floor

    // Varrock Part 1
    VARROCK_GO_TO_EDGEVILLE("Go to Edgeville (DKR)", "Varrock Part 1", "Go to Edgeville using Dramen/Lunar staff Kingdom ring", new int[]{3087, 3496, 0}),
    VARROCK_STRONGHOLD_SECURITY("Stronghold Security f/10k", "Varrock Part 1", "Complete Stronghold of Security for 10k", new int[]{3081, 3420, 0}),
    VARROCK_WEAR_FANCY_BOOTS("Wear fancy boots", "Varrock Part 1", "Equip the fancy boots", null),
    VARROCK_BUY_STEEL_HELM("Buy Steel Full helm", "Varrock Part 1", "Purchase a Steel full helm", new int[]{3228, 3441, 0}),
    VARROCK_BUY_FIRE_STAFF("Buy fire staff", "Varrock Part 1", "Purchase a fire staff", new int[]{3253, 3401, 0}),
    VARROCK_STEAL_TEA_STALL("Steal From the Varrock Tea Stall", "Varrock Part 1", "Steal from the tea stall in Varrock", new int[]{3271, 3411, 0}),
    VARROCK_PURCHASE_RUNES("Purchase runes + rune mysteries", "Varrock Part 1", "Buy runes and continue Rune Mysteries", new int[]{3253, 3401, 0}),
    VARROCK_DEFEAT_GUARD("Defeat a Guard", "Varrock Part 1", "Defeat a Varrock guard", new int[]{3222, 3395, 0}),
    VARROCK_PET_STRAY_DOG("Pet a Stray Dog in Varrock", "Varrock Part 1", "Pet one of Varrock's stray dogs", new int[]{3235, 3420, 0}),
    VARROCK_FEED_STRAY_DOG("Feed Stray Dog bones", "Varrock Part 1", "Feed bones to a stray dog", new int[]{3235, 3420, 0}),
    VARROCK_PURCHASE_POH("Purchase POH", "Varrock Part 1", "Purchase a Player Owned House", new int[]{3240, 3475, 0}),
    VARROCK_ELSIE_STORY("Have Elsie tell you a story", "Varrock Part 1", "Listen to Elsie's story", new int[]{3228, 3382, 0}),
    VARROCK_SLASH_WEB("Slash a web in varrock sewers", "Varrock Part 1", "Slash a web in the Varrock sewers", new int[]{3237, 3458, 0}),
    VARROCK_CHOP_LOGS("Chop Some Logs", "Varrock Part 1", "Cut down a tree for logs", new int[]{3275, 3428, 0}),
    VARROCK_BURN_LOGS("Burn Some Normal Logs", "Varrock Part 1", "Burn normal logs", null),
    VARROCK_CHOP_STEEL_AXE("Chop logs with a Steel Axe", "Varrock Part 1", "Cut down a tree using a steel axe", new int[]{3275, 3428, 0}),
    VARROCK_BURN_OAK_LOGS("Burn Some Oak Logs", "Varrock Part 1", "Burn oak logs", null),
    VARROCK_FLETCH_ARROW_SHAFTS("Fletch Some Arrow Shafts", "Varrock Part 1", "Create arrow shafts from logs", null),
    VARROCK_FLETCH_1000_SHAFTS("Fletch 1000 arrow shafts (OPTIONAL)", "Varrock Part 1", "Create 1000 arrow shafts from logs", null),
    VARROCK_MAKE_PLANK("Turn any Logs Into a Plank", "Varrock Part 1", "Convert logs into planks", new int[]{3302, 3491, 0}),
    VARROCK_GO_TO_FOSSIL_ISLAND("Go to Fossil Island", "Varrock Part 1", "Travel to Fossil Island", new int[]{3362, 3445, 0}),
    VARROCK_PET_FOSSIL_DOG("Pet dog on fossil island", "Varrock Part 1", "Pet the dog on Fossil Island", null),
    VARROCK_MINE_COPPER("Mine some Copper Ore", "Varrock Part 1", "Mine copper ore", new int[]{3288, 3363, 0}),
    VARROCK_MINE_TIN("Mine 10 Tin Ore", "Varrock Part 1", "Mine 10 tin ore", new int[]{3282, 3363, 0}),
    VARROCK_RAKE_PATCHES("Rake a Farming Patch * 2 f/3 farm @ Champions guild", "Varrock Part 1", "Rake two farming patches near Champions' Guild", new int[]{3230, 3371, 0}),
    VARROCK_PLANT_HOPS("Plant hops running toward draynor AND pay farmer the 3 compost for task", "Varrock Part 1", "Plant hops and pay the farmer", new int[]{3230, 3371, 0}),
    VARROCK_ACHIEVE_LEVEL_20("Achieve Your First Level 20", "Varrock Part 1", "Get any skill to level 20", null),

    // Draynor Part 1
    DRAYNOR_BURN_FOOD("Burn Some Food", "Draynor Part 1", "Burn a piece of food", null),
    DRAYNOR_COOK_5_FOOD("Successfully Cook 5 Pieces of Food", "Draynor Part 1", "Successfully cook 5 different food items", null),
    DRAYNOR_COMPLETE_ROOFTOP_COURSE("Complete a Rooftop Agility Course", "Draynor Part 1", "Complete any rooftop agility course", new int[]{3104, 3279, 0}),
    DRAYNOR_OBTAIN_MARK_OF_GRACE("Obtain a Mark of Grace", "Draynor Part 1", "Obtain a Mark of Grace from an agility course", null),
    DRAYNOR_COMPLETE_AGILITY_COURSE("Complete the Draynor Agility Course", "Draynor Part 1", "Complete the Draynor Village Agility Course", new int[]{3104, 3279, 0}),
    DRAYNOR_10_LAPS_AGILITY("Complete 10 Laps of the Draynor Agility Course", "Draynor Part 1", "Complete 10 laps of the Draynor Village Agility Course", new int[]{3104, 3279, 0}),
    DRAYNOR_ACHIEVE_LEVEL_30("Achieve Your First Level 30", "Draynor Part 1", "Get any skill to level 30", null),
    DRAYNOR_WISE_OLD_MAN_TASK("Complete a task for the Wise Old Man", "Draynor Part 1", "Complete a task for the Wise Old Man in Draynor", new int[]{3088, 3253, 0}),
    DRAYNOR_CHOP_100_WILLOW("Chop 100 Willow Logs", "Draynor Part 1", "Chop 100 willow logs", new int[]{3082, 3235, 0}),
    DRAYNOR_BURN_100_WILLOW("Burn 100 Willow Logs", "Draynor Part 1", "Burn 100 willow logs", null),
    DRAYNOR_CHOP_RISING_ROOTS("Chop some Rising Roots", "Draynor Part 1", "Chop rising roots", null),
    DRAYNOR_STRUGGLING_SAPLING("Complete the Struggling Sapling event", "Draynor Part 1", "Complete the Struggling Sapling event", null),
    DRAYNOR_STEAL_WINE_OR_HAM("Steal from wine stall until 38 OR Ham members if Trickster is option", "Draynor Part 1", "Steal from the wine stall or Ham members", new int[]{3080, 3250, 0}),
    DRAYNOR_PICKPOCKET_MASTER_FARMER("Pickpocket a Master Farmer", "Draynor Part 1", "Pickpocket a Master Farmer", new int[]{3078, 3260, 0}),
    DRAYNOR_PICKPOCKET_RANNAR("Pickpocket a Rannar", "Draynor Part 1", "Pickpocket a Rannar", new int[]{3078, 3260, 0}),
    DRAYNOR_NED_ROPE("Have Ned make you some rope", "Draynor Part 1", "Ask Ned to make you a rope", new int[]{3087, 3266, 0}),
    DRAYNOR_INSULT_AGGIE("Insult Aggie the Witch", "Draynor Part 1", "Insult Aggie the Witch", new int[]{3090, 3256, 0}),

    // Lumbridge Part 2
    LUMBRIDGE_CHOP_POTATO_TREE("Chop a log from a potato tree", "Lumbridge Part 2", "Chop a log from a potato tree", null),
    LUMBRIDGE_ENTER_DRAYNOR_MANOR("Enter Draynor Manor", "Lumbridge Part 2", "Enter Draynor Manor", null),
    LUMBRIDGE_GET_CHAIR_FOLLOW("Get a chair to follow you", "Lumbridge Part 2", "Get a chair to follow you", null),
    LUMBRIDGE_CRY_IN_WHEAT_FIELD("Cry in wheat field", "Lumbridge Part 2", "Cry in the wheat field", null),
    LUMBRIDGE_MAKE_FLOUR("Make some Flour", "Lumbridge Part 2", "Make some flour", null),
    LUMBRIDGE_MILK_COW("Milk a cow", "Lumbridge Part 2", "Milk a cow", null),
    LUMBRIDGE_GRAB_EGG("Grab an egg for cook assist", "Lumbridge Part 2", "Grab an egg for cook assist", null),
    LUMBRIDGE_USE_RANGE_CASTLE("Use Range in Lumbridge Castle", "Lumbridge Part 2", "Use Range in Lumbridge Castle", null),
    LUMBRIDGE_COMPLETE_COOKS_ASSISTANT("Complete cooks assistant", "Lumbridge Part 2", "Complete cooks assistant", null),
    LUMBRIDGE_SPIN_WOOL("Spin a Ball of Wool", "Lumbridge Part 2", "Spin a ball of wool", null),
    LUMBRIDGE_COMPLETE_SHEEP_SHEARER("Complete Sheep Shearer", "Lumbridge Part 2", "Complete Sheep Shearer", null),

    // Karamja
    KARAMJA_BUY_FROM_TRADERS("Buy Something From Traders", "Karamja", "Buy a knife and a torch", null);

    private final String name;
    private final String area;
    private final String description;
    private final int[] coordinates;

    LeaguesTask(String name, String area, String description, int[] coordinates) {
        this.name = name;
        this.area = area;
        this.description = description;
        this.coordinates = coordinates;
    }

    public String getName() {
        return name;
    }

    public String getArea() {
        return area;
    }

    public String getDescription() {
        return description;
    }

    public int[] getCoordinates() {
        return coordinates;
    }

    public boolean hasCoordinates() {
        return coordinates != null;
    }
}

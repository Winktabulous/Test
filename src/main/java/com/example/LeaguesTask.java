package com.example;

public enum LeaguesTask {
    // Lumbridge Part 1
    LUMBRIDGE_OPEN_LEAGUES_MENU("Open the Leagues Menu", "Lumbridge", "Open the Leagues menu", null),
    LUMBRIDGE_COMPLETE_TUTORIAL("Complete the Leagues Tutorial", "Lumbridge", "Complete the Leagues tutorial", null),
    LUMBRIDGE_CLAIM_ITEMS_FROM_SAGE("Claim items from sage", "Lumbridge", "Claim items from the sage", new int[]{3222, 3218, 0}), // Ground floor
    LUMBRIDGE_ADJUST_SETTINGS("Settings adjust", "Lumbridge", "Adjust the game settings", null),
    LUMBRIDGE_START_RUNE_MYSTERIES("Start Rune Mysteries", "Lumbridge", "Start the Rune Mysteries quest", new int[]{3212, 3225, 1}), // Second floor
    LUMBRIDGE_SET_BANK_PIN("Set bank pin", "Lumbridge", "Set a bank pin", new int[]{3208, 3219, 0}), // Ground floor
    LUMBRIDGE_PICKPOCKET_CITIZEN("Pickpocket a Citizen", "Lumbridge", "Pickpocket a citizen", new int[]{3222, 3218, 0}), // Ground floor
    LUMBRIDGE_OPEN_28_COIN_POUCHES("Open 28 Coin Pouches At Once", "Lumbridge", "Open 28 coin pouches at once", null),
    LUMBRIDGE_ACHIEVE_FIRST_LEVEL_UP("Achieve Your First Level Up", "Lumbridge", "Achieve your first level up", null),
    LUMBRIDGE_ACHIEVE_FIRST_LEVEL_5("Achieve Your First Level 5", "Lumbridge", "Achieve your first level 5", null),
    LUMBRIDGE_ACHIEVE_FIRST_LEVEL_10("Achieve Your First Level 10", "Lumbridge", "Achieve your first level 10", null),
    LUMBRIDGE_DEFEAT_GOBLIN("Defeat a Goblin", "Lumbridge", "Defeat a goblin", new int[]{3245, 3235, 0}), // Goblin area near Lumbridge
    LUMBRIDGE_BURY_BONES("Bury Some Bones", "Lumbridge", "Bury some bones", new int[]{3222, 3218, 0}), // Ground floor
    LUMBRIDGE_VISIT_DEATHS_DOMAIN("Visit Death's Domain", "Lumbridge", "Visit Death's domain", new int[]{3081, 5346, 0}), // Ground floor
    LUMBRIDGE_DANCE_IN_GRAVEYARD("Dance in a graveyard", "Lumbridge", "Dance in a graveyard", new int[]{3242, 3259, 0}), // Ground floor
    LUMBRIDGE_SUPPLY_RUN("Supply Run", "Lumbridge", "Complete the Supply Run task", null),
    LUMBRIDGE_SUPPLY_RUN_PT2("Supply Run Pt 2", "Lumbridge", "Complete the Supply Run Pt 2 task", null),
    LUMBRIDGE_RUNE_MYSTERY_MAGE_TOWER("Rune Mystery Step @ Mage Tower", "Lumbridge", "Complete the Rune Mystery step at the Mage Tower", new int[]{3212, 3225, 1}), // Second floor
    LUMBRIDGE_USE_FAIRY_RING("Use a Fairy Ring", "Lumbridge", "Use a Fairy Ring", new int[]{3202, 3169, 0}), // Ground floor
    LUMBRIDGE_ENTER_ZANARIS("Enter Zanaris", "Lumbridge", "Enter Zanaris", new int[]{3202, 3169, 0}); // Ground floor

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

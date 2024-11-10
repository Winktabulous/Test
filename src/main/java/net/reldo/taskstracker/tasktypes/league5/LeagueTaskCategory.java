package net.reldo.taskstracker.tasktypes.league5;

public enum LeagueTaskCategory
{
    //@todo Add sprite IDs
    ACHIEVEMENT(0),
    COMBAT(0),
    QUEST(0),
    SKILL(0),
    MINIGAME(0),
    OTHER(0);

    public final int spriteId;

    LeagueTaskCategory(int spriteId)
    {
        this.spriteId = spriteId;
    }

    public static LeagueTaskCategory getCategoryByName(String name)
    {
        for (LeagueTaskCategory value : values())
        {
            if (value.name().equalsIgnoreCase(name))
            {
                return value;
            }
        }

        return null;
    }
}

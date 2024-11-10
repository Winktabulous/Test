package net.reldo.taskstracker.tasktypes.league5;

public enum LeagueTaskArea
{
    //@todo Add sprite IDs
    GLOBAL(0),
    MISTHALIN(0),
    KARAMJA(0),
    ASGARNIA(0),
    FREMENNIK(0),
    KANDARIN(0),
    DESERT(0),
    KOUREND(0),
    MORYTANIA(0),
    TIRANNWN(0),
    WILDERNESS(0);

    public final int spriteId;

    LeagueTaskArea(int spriteId)
    {
        this.spriteId = spriteId;
    }

    public static LeagueTaskArea getAreaByName(String name)
    {
        for (LeagueTaskArea value : values())
        {
            if (value.name().equalsIgnoreCase(name))
            {
                return value;
            }
        }

        return null;
    }
}

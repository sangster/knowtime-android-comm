package ca.knowtime.comm.models.gtfs.enums;

public enum RouteType
{
    /**
     * 0 - Tram, Streetcar, Light rail. Any light rail or street level system within a metropolitan
     * area.
     */
    tram,

    /** 1 - Subway, Metro. Any underground rail system within a metropolitan area. */
    subway,

    /** 2 - Rail. Used for intercity or long-distance travel. */
    rail,

    /** 3 - Bus. Used for short- and long-distance bus routes. */
    bus,

    /** 4 - Ferry. Used for short- and long-distance boat service. */
    ferry,

    /** 5 - Cable car. Used for street-level cable cars where the cable runs beneath the car. */
    cableCar,

    /**
     * 6 - Gondola, Suspended cable car. Typically used for aerial cable cars where the car is
     * suspended from the cable.
     */
    gondola,

    /** 7 - Funicular. Any rail system designed for steep inclines. */
    funicular
}

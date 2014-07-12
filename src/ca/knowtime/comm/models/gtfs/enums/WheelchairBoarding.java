package ca.knowtime.comm.models.gtfs.enums;

public enum WheelchairBoarding
{
    /** 0 (or empty) - indicates that there is no accessibility information for the stop */
    unknown,

    /**
     * 1 - indicates that at least some vehicles at this stop can be boarded by a rider in a
     * wheelchair
     */
    yes,

    /** 2 - wheelchair boarding is not possible at this stop */
    no,

    /**
     * 0 (or empty) - the stop will inherit its wheelchair_boarding value from the parent station,
     * if specified in the parent
     */
    inherit,

    /**
     * 1 - there exists some accessible path from outside the station to the specific stop /
     * platform
     */
    some_path,

    /** 2 - there exists no accessible path from outside the station to the specific stop / platform */
    no_path
}

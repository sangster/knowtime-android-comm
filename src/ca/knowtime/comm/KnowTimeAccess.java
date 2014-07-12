package ca.knowtime.comm;

/** Provides access to the KNOWtime server. */
public interface KnowTimeAccess
        extends RestAccess
{
    GtfsAccess gtfs();
}


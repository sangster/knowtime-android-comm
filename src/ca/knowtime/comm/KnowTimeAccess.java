package ca.knowtime.comm;

import ca.knowtime.comm.exceptions.HttpIoException;
import ca.knowtime.comm.exceptions.ParseException;
import ca.knowtime.comm.types.Estimate;
import ca.knowtime.comm.types.Location;
import ca.knowtime.comm.types.Path;
import ca.knowtime.comm.types.RouteName;
import ca.knowtime.comm.types.RouteStopTimes;
import ca.knowtime.comm.types.Stop;
import ca.knowtime.comm.types.User;

import java.util.List;
import java.util.UUID;

/**
 * Provides access to the KNOWtime server. All of these methods are synchronous and will block until the request is
 * completed.
 */
public interface KnowTimeAccess
{
    User createUser( int routeId )
            throws HttpIoException;

    void postLocation( UUID userId, Location location )
            throws HttpIoException;

    List<Stop> stops()
            throws HttpIoException, ParseException;

    float pollRate()
            throws HttpIoException, ParseException;

    List<RouteStopTimes> routesStopTimes( final int stopNumber, final int year, final int month, final int day )
            throws HttpIoException, ParseException;

    List<RouteName> routeNames()
            throws HttpIoException, ParseException;

    List<Path> routePaths( final UUID routeId, final int year, final int month, final int day )
            throws HttpIoException, ParseException;

    List<Estimate> estimatesForShortName( final String shortName )
            throws HttpIoException, ParseException;
}

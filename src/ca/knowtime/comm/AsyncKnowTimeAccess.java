package ca.knowtime.comm;

import ca.knowtime.comm.async.AsyncGet;
import ca.knowtime.comm.types.Estimate;
import ca.knowtime.comm.types.Path;
import ca.knowtime.comm.types.RouteName;
import ca.knowtime.comm.types.RouteStopTimes;
import ca.knowtime.comm.types.Stop;
import ca.knowtime.comm.types.User;

import java.util.List;
import java.util.UUID;

/**
 * Provides asynchronous access to the KNOWtime server.
 */
public interface AsyncKnowTimeAccess
{
    AsyncGet<User> createUser( int routeId );

    AsyncGet<List<Stop>> stops();

    AsyncGet<Float> pollRate();

    AsyncGet<List<RouteStopTimes>> routesStopTimes( final int stopNumber, final int year, final int month,
                                                    final int day );

    AsyncGet<List<RouteName>> routeNames();

    AsyncGet<List<Path>> routePaths( final UUID routeId, final int year, final int month, final int day );

    AsyncGet<List<Estimate>> estimatesForShortName( final String shortName );
}

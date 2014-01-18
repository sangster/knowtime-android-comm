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

import static ca.knowtime.comm.async.AsyncGet.Action;

public class AsyncKnowTimeAccessImpl
        implements AsyncKnowTimeAccess
{
    private final KnowTimeAccess mKnowTime;


    public AsyncKnowTimeAccessImpl( final KnowTimeAccess knowTime ) {
        mKnowTime = knowTime;
    }


    @Override
    public AsyncGet<User> createUser( final int routeId ) {
        return AsyncGet.create( new Action<User>()
        {
            @Override
            public User doRequest() {
                return mKnowTime.createUser( routeId );
            }
        } );
    }


    @Override
    public AsyncGet<List<Stop>> stops() {
        return AsyncGet.create( new Action<List<Stop>>()
        {
            @Override
            public List<Stop> doRequest() {
                return mKnowTime.stops();
            }
        } );
    }


    @Override
    public AsyncGet<Float> pollRate() {
        return AsyncGet.create( new Action<Float>()
        {
            @Override
            public Float doRequest() {
                return mKnowTime.pollRate();
            }
        } );
    }


    @Override
    public AsyncGet<List<RouteStopTimes>> routesStopTimes( final int stopNumber, final int year, final int month,
                                                           final int day ) {
        return AsyncGet.create( new Action<List<RouteStopTimes>>()
        {
            @Override
            public List<RouteStopTimes> doRequest() {
                return mKnowTime.routesStopTimes( stopNumber, year, month, day );
            }
        } );
    }


    @Override
    public AsyncGet<List<RouteName>> routeNames() {
        return AsyncGet.create( new Action<List<RouteName>>()
        {
            @Override
            public List<RouteName> doRequest() {
                return mKnowTime.routeNames();
            }
        } );
    }


    @Override
    public AsyncGet<List<Path>> routePaths( final UUID routeId, final int year, final int month, final int day ) {
        return AsyncGet.create( new Action<List<Path>>()
        {
            @Override
            public List<Path> doRequest() {
                return mKnowTime.routePaths( routeId, year, month, day );
            }
        } );
    }


    @Override
    public AsyncGet<List<Estimate>> estimatesForShortName( final String shortName ) {
        return AsyncGet.create( new Action<List<Estimate>>()
        {
            @Override
            public List<Estimate> doRequest() {
                return mKnowTime.estimatesForShortName( shortName );
            }
        } );
    }
}

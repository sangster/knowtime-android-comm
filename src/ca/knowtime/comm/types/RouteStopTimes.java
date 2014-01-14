package ca.knowtime.comm.types;

import java.util.Collections;
import java.util.List;
import java.util.UUID;

public class RouteStopTimes
{
    private final UUID mRouteId;
    private final String mShortName;
    private final String mLongName;
    private final List<StopTimePair> mStopTimes;


    public RouteStopTimes( final UUID routeId, final String shortName, final String longName,
                           final List<StopTimePair> stopTimes ) {
        mRouteId = routeId;
        mShortName = shortName;
        mLongName = longName;
        mStopTimes = Collections.unmodifiableList( stopTimes );
    }


    public UUID getRouteId() {
        return mRouteId;
    }


    public String getShortName() {
        return mShortName;
    }


    public String getLongName() {
        return mLongName;
    }


    public List<StopTimePair> getStopTimes() {
        return mStopTimes;
    }


    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder( "RouteStopTimes{" );
        sb.append( "short='" ).append( mShortName ).append( '\'' );
        sb.append( ", long='" ).append( mLongName ).append( '\'' );
        sb.append( ", id=" ).append( mRouteId );
        sb.append( '}' );
        return sb.toString();
    }
}

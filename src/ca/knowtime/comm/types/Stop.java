package ca.knowtime.comm.types;

import ca.knowtime.comm.KnowTimeAccess;
import org.json.JSONException;

import java.io.IOException;
import java.util.List;

public class Stop
{
    private final KnowTimeAccess mKnowTime;
    private final int mStopNumber;
    private final String mName;
    private final Location mLocation;


    public Stop( final KnowTimeAccess knowTime, final int stopNumber, final String name, final Location location ) {
        mKnowTime = knowTime;
        mStopNumber = stopNumber;
        mName = name;
        mLocation = location;
    }


    public int getStopNumber() {
        return mStopNumber;
    }


    public String getName() {
        return mName;
    }


    public Location getLocation() {
        return mLocation;
    }


    public List<RouteStopTimes> stopTimes( final int year, final int month, final int day )
            throws IOException, JSONException {
        return mKnowTime.routesStopTimes( mStopNumber, year, month, day );
    }


    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder( "Stop{" );
        sb.append( "number=" ).append( mStopNumber );
        sb.append( ", '" ).append( mName ).append( '\'' );
        sb.append( ", " ).append( mLocation );
        sb.append( '}' );
        return sb.toString();
    }
}

package ca.knowtime.comm.types;

import ca.knowtime.comm.KnowTimeAccess;

import java.io.IOException;
import java.util.UUID;

public class User
{
    private final UUID mUserId;
    private final int mRouteId;
    private final KnowTimeAccess mKnowTime;


    public User( final UUID userId, final int routeId, final KnowTimeAccess knowTime ) {
        mUserId = userId;
        mRouteId = routeId;
        mKnowTime = knowTime;
    }


    public void postLocation( final Location location )
            throws IOException {
        mKnowTime.postLocation( mUserId, location );
    }


    public UUID getUserId() {
        return mUserId;
    }


    public int getRouteId() {
        return mRouteId;
    }


    public KnowTimeAccess getKnowTime() {
        return mKnowTime;
    }
}

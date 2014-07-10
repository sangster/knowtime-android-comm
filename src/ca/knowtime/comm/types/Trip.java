package ca.knowtime.comm.types;


import ca.knowtime.comm.KnowTimeAccess;
import ca.knowtime.comm.types.ids.TripId;
import com.google.common.base.Optional;
import com.google.common.base.Preconditions;

public class Trip
        extends TripId
{
    private final String mRouteId;
    private final String mServiceId;
    private final Optional<String> mHeadsign;
    private final Optional<String> mShortName;
    private final Optional<Integer> mDirectionId;
    private final Optional<String> mBlockId;
    private final Optional<String> mShapeId;
    private final Optional<Integer> mWheelchairAccessible;
    private final Optional<Integer> mBikesAllowed;


    public Trip( final KnowTimeAccess knowTime, final String id, final String routeId,
                 final String serviceId, final Optional<String> headsign,
                 final Optional<String> shortName, final Optional<Integer> directionId,
                 final Optional<String> blockId, final Optional<String> shapeId,
                 final Optional<Integer> wheelchairAccessible,
                 final Optional<Integer> bikesAllowed ) {
        super( knowTime, id );
        mRouteId = Preconditions.checkNotNull( routeId );
        mServiceId = Preconditions.checkNotNull( serviceId );
        mHeadsign = Preconditions.checkNotNull( headsign );
        mShortName = Preconditions.checkNotNull( shortName );
        mDirectionId = Preconditions.checkNotNull( directionId );
        mBlockId = Preconditions.checkNotNull( blockId );
        mShapeId = Preconditions.checkNotNull( shapeId );
        mWheelchairAccessible = Preconditions.checkNotNull( wheelchairAccessible );
        mBikesAllowed = Preconditions.checkNotNull( bikesAllowed );
    }


    public String getRouteId() {
        return mRouteId;
    }


    public String getServiceId() {
        return mServiceId;
    }


    public Optional<String> getHeadsign() {
        return mHeadsign;
    }


    public Optional<String> getShortName() {
        return mShortName;
    }


    public Optional<Integer> getDirectionId() {
        return mDirectionId;
    }


    public Optional<String> getBlockId() {
        return mBlockId;
    }


    public Optional<String> getShapeId() {
        return mShapeId;
    }


    public Optional<Integer> getWheelchairAccessible() {
        return mWheelchairAccessible;
    }


    public Optional<Integer> getBikesAllowed() {
        return mBikesAllowed;
    }
}

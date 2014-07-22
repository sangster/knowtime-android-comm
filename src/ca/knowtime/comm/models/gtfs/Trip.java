package ca.knowtime.comm.models.gtfs;


import ca.knowtime.comm.models.gtfs.ids.TripId;
import com.google.common.base.Objects;
import com.google.common.base.Optional;
import com.google.common.base.Preconditions;

public class Trip
        extends TripId
{
    private final String mRouteId;
    private final String mServiceId;
    private final Optional<String> mTripHeadsign;
    private final Optional<String> mTripShortName;
    private final Optional<Integer> mDirectionId;
    private final Optional<String> mBlockId;
    private final Optional<String> mShapeId;
    private final Optional<Integer> mWheelchairAccessible;
    private final Optional<Integer> mBikesAllowed;


    public Trip( final String tripId,
                 final String routeId,
                 final String serviceId,
                 final Optional<String> tripHeadsign,
                 final Optional<String> tripShortName,
                 final Optional<Integer> directionId,
                 final Optional<String> blockId,
                 final Optional<String> shapeId,
                 final Optional<Integer> wheelchairAccessible,
                 final Optional<Integer> bikesAllowed ) {
        super( tripId );
        mRouteId = Preconditions.checkNotNull( routeId );
        mServiceId = Preconditions.checkNotNull( serviceId );
        mTripHeadsign = Preconditions.checkNotNull( tripHeadsign );
        mTripShortName = Preconditions.checkNotNull( tripShortName );
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


    public Optional<String> getTripHeadsign() {
        return mTripHeadsign;
    }


    public Optional<String> getTripShortName() {
        return mTripShortName;
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


    @Override
    public String toString() {
        return Objects.toStringHelper( this )
                      .add( "Id", mId )
                      .add( "RouteId", mRouteId )
                      .add( "ServiceId", mServiceId )
                      .add( "Headsign", mTripHeadsign )
                      .add( "ShortName", mTripShortName )
                      .add( "DirectionId", mDirectionId )
                      .add( "BlockId", mBlockId )
                      .add( "ShapeId", mShapeId )
                      .add( "WheelchairAccessible", mWheelchairAccessible )
                      .add( "BikesAllowed", mBikesAllowed )
                      .toString();
    }
}

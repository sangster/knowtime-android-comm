package ca.knowtime.comm.types;


import ca.knowtime.comm.KnowTimeAccess;
import com.google.common.base.Optional;
import com.google.common.base.Preconditions;

public class StopTime
        extends KnowtimeModel
{
    private final String mTripId;
    private final String mArrivalTime;
    private final String mDepartureTime;
    private final String mStopId;
    private final int mStopSequence;
    private final Optional<String> mStopHeadsign;
    private final Optional<Integer> mPickupType;
    private final Optional<Integer> mDropOffType;
    private final Optional<Float> mShapeDistTraveled;


    public StopTime( final KnowTimeAccess knowTime, final String tripId, final String arrivalTime,
                     final String departureTime, final String stopId, final int stopSequence,
                     final Optional<String> stopHeadsign, final Optional<Integer> pickupType,
                     final Optional<Integer> dropOffType,
                     final Optional<Float> shapeDistTraveled ) {
        super( knowTime );
        mTripId = Preconditions.checkNotNull( tripId );
        mArrivalTime = Preconditions.checkNotNull( arrivalTime );
        mDepartureTime = Preconditions.checkNotNull( departureTime );
        mStopId = Preconditions.checkNotNull( stopId );
        mStopSequence = Preconditions.checkNotNull( stopSequence );
        mStopHeadsign = Preconditions.checkNotNull( stopHeadsign );
        mPickupType = Preconditions.checkNotNull( pickupType );
        mDropOffType = Preconditions.checkNotNull( dropOffType );
        mShapeDistTraveled = Preconditions.checkNotNull( shapeDistTraveled );
    }


    public String getTripId() {
        return mTripId;
    }


    public String getArrivalTime() {
        return mArrivalTime;
    }


    public String getDepartureTime() {
        return mDepartureTime;
    }


    public String getStopId() {
        return mStopId;
    }


    public int getStopSequence() {
        return mStopSequence;
    }


    public Optional<String> getStopHeadsign() {
        return mStopHeadsign;
    }


    public Optional<Integer> getPickupType() {
        return mPickupType;
    }


    public Optional<Integer> getDropOffType() {
        return mDropOffType;
    }


    public Optional<Float> getShapeDistTraveled() {
        return mShapeDistTraveled;
    }
}

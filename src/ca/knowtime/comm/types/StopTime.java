package ca.knowtime.comm.types;


import com.google.common.base.Optional;

public class StopTime
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


    public StopTime( final String tripId, final String arrivalTime, final String departureTime,
                     final String stopId, final int stopSequence,
                     final Optional<String> stopHeadsign, final Optional<Integer> pickupType,
                     final Optional<Integer> dropOffType,
                     final Optional<Float> shapeDistTraveled ) {
        mTripId = tripId;
        mArrivalTime = arrivalTime;
        mDepartureTime = departureTime;
        mStopId = stopId;
        mStopSequence = stopSequence;
        mStopHeadsign = stopHeadsign;
        mPickupType = pickupType;
        mDropOffType = dropOffType;
        mShapeDistTraveled = shapeDistTraveled;
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

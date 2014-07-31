package ca.knowtime.comm.models.gtfs;

import ca.knowtime.comm.models.gtfs.enums.LocationType;
import ca.knowtime.comm.models.gtfs.enums.WheelchairBoarding;
import ca.knowtime.comm.models.gtfs.ids.StopId;
import com.google.common.base.Objects;
import com.google.common.base.Optional;
import com.google.common.base.Preconditions;

public class Stop
        extends StopId
{
    private final String mStopName;
    private final float mStopLat;
    private final float mStopLon;
    private final Optional<String> mStopCode;
    private final Optional<String> mStopDesc;
    private final Optional<String> mZoneId;
    private final Optional<String> mStopUrl;
    private final Optional<LocationType> mLocationType;
    private final Optional<Integer> mParentStation;
    private final Optional<String> mStopTimezone;
    private final Optional<WheelchairBoarding> mWheelchairBoarding;


    public Stop( final String stopId,
                 final String stopName,
                 final float stopLat,
                 final float stopLon,
                 final Optional<String> stopCode,
                 final Optional<String> stopDesc,
                 final Optional<String> zoneId,
                 final Optional<String> stopUrl,
                 final Optional<LocationType> locationType,
                 final Optional<Integer> parentStation,
                 final Optional<String> stopTimezone,
                 final Optional<WheelchairBoarding> wheelchairBoarding ) {
        super( stopId );
        mStopName = Preconditions.checkNotNull( stopName );
        mStopLat = Preconditions.checkNotNull( stopLat );
        mStopLon = Preconditions.checkNotNull( stopLon );
        mStopCode = Preconditions.checkNotNull( stopCode );
        mStopDesc = Preconditions.checkNotNull( stopDesc );
        mZoneId = Preconditions.checkNotNull( zoneId );
        mStopUrl = Preconditions.checkNotNull( stopUrl );
        mLocationType = Preconditions.checkNotNull( locationType );
        mParentStation = Preconditions.checkNotNull( parentStation );
        mStopTimezone = Preconditions.checkNotNull( stopTimezone );
        mWheelchairBoarding = Preconditions.checkNotNull( wheelchairBoarding );
    }


    public String getStopName() {
        return mStopName;
    }


    public float getStopLat() {
        return mStopLat;
    }


    public float getStopLon() {
        return mStopLon;
    }


    public Optional<String> getStopCode() {
        return mStopCode;
    }


    public Optional<String> getStopDesc() {
        return mStopDesc;
    }


    public Optional<String> getZoneId() {
        return mZoneId;
    }


    public Optional<String> getStopUrl() {
        return mStopUrl;
    }


    public Optional<LocationType> getLocationType() {
        return mLocationType;
    }


    public Optional<Integer> getParentStation() {
        return mParentStation;
    }


    public Optional<String> getStopTimezone() {
        return mStopTimezone;
    }


    public Optional<WheelchairBoarding> getWheelchairBoarding() {
        return mWheelchairBoarding;
    }


    @Override
    public boolean equals( final Object o ) {
        if( this == o ) {
            return true;
        }
        if( !(o instanceof Stop) ) {
            return false;
        }

        final Stop stop = (Stop) o;
        return mId.equals( stop.mId );
    }


    @Override
    public int hashCode() {
        return mId.hashCode();
    }


    @Override
    public String toString() {
        return Objects.toStringHelper( this )
                      .add( "StopId", mId )
                      .add( "StopName", mStopName )
                      .add( "StopLat", mStopLat )
                      .add( "StopLon", mStopLon )
                      .add( "StopCode", mStopCode )
                      .add( "StopDesc", mStopDesc )
                      .add( "ZoneId", mZoneId )
                      .add( "StopUrl", mStopUrl )
                      .add( "LocationType", mLocationType )
                      .add( "ParentStation", mParentStation )
                      .add( "StopTimezone", mStopTimezone )
                      .add( "WheelchairBoarding", mWheelchairBoarding )
                      .toString();
    }
}

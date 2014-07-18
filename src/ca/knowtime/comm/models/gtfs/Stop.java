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
    private final String mName;
    private final float mLatitude;
    private final float mLongitude;
    private final Optional<String> mCode;
    private final Optional<String> mDescription;
    private final Optional<String> mZoneId;
    private final Optional<String> mUrl;
    private final Optional<LocationType> mLocationType;
    private final Optional<Integer> mParentStation;
    private final Optional<String> mTimezone;
    private final Optional<WheelchairBoarding> mWheelchairBoarding;


    public Stop( final String id,
                 final String name,
                 final float latitude,
                 final float longitude,
                 final Optional<String> code,
                 final Optional<String> description,
                 final Optional<String> zoneId,
                 final Optional<String> url,
                 final Optional<LocationType> locationType,
                 final Optional<Integer> parentStation,
                 final Optional<String> timezone,
                 final Optional<WheelchairBoarding> wheelchairBoarding ) {
        super( id );
        mName = Preconditions.checkNotNull( name );
        mLatitude = Preconditions.checkNotNull( latitude );
        mLongitude = Preconditions.checkNotNull( longitude );
        mCode = Preconditions.checkNotNull( code );
        mDescription = Preconditions.checkNotNull( description );
        mZoneId = Preconditions.checkNotNull( zoneId );
        mUrl = Preconditions.checkNotNull( url );
        mLocationType = Preconditions.checkNotNull( locationType );
        mParentStation = Preconditions.checkNotNull( parentStation );
        mTimezone = Preconditions.checkNotNull( timezone );
        mWheelchairBoarding = Preconditions.checkNotNull( wheelchairBoarding );
    }


    public String getName() {
        return mName;
    }


    public float getLatitude() {
        return mLatitude;
    }


    public float getLongitude() {
        return mLongitude;
    }


    public Optional<String> getCode() {
        return mCode;
    }


    public Optional<String> getDescription() {
        return mDescription;
    }


    public Optional<String> getZoneId() {
        return mZoneId;
    }


    public Optional<String> getUrl() {
        return mUrl;
    }


    public Optional<LocationType> getLocationType() {
        return mLocationType;
    }


    public Optional<Integer> getParentStation() {
        return mParentStation;
    }


    public Optional<String> getTimezone() {
        return mTimezone;
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
                      .add( "Id", mId )
                      .add( "Name", mName )
                      .add( "Latitude", mLatitude )
                      .add( "Longitude", mLongitude )
                      .add( "Code", mCode )
                      .add( "Description", mDescription )
                      .add( "ZoneId", mZoneId )
                      .add( "Url", mUrl )
                      .add( "LocationType", mLocationType )
                      .add( "ParentStation", mParentStation )
                      .add( "Timezone", mTimezone )
                      .add( "WheelchairBoarding", mWheelchairBoarding )
                      .toString();
    }
}

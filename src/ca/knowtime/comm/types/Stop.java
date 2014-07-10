package ca.knowtime.comm.types;

import ca.knowtime.comm.KnowTimeAccess;
import ca.knowtime.comm.types.ids.StopId;
import com.google.common.base.Optional;
import com.google.common.base.Preconditions;

public class Stop
        extends StopId
{
    private final String mId;
    private final String mName;
    private final float mLatitude;
    private final float mLongitude;
    private final Optional<String> mCode;
    private final Optional<String> mDescription;
    private final Optional<String> mZoneId;
    private final Optional<String> mUrl;
    private final Optional<Integer> mLocationType;
    private final Optional<Integer> mParentStation;
    private final Optional<String> mTimezone;
    private final Optional<Integer> mWheelchairBoarding;


    public Stop( final KnowTimeAccess knowTime, final String id, final String name,
                 final float latitude, final float longitude, final Optional<String> code,
                 final Optional<String> description, final Optional<String> zoneId,
                 final Optional<String> url, final Optional<Integer> locationType,
                 final Optional<Integer> parentStation, final Optional<String> timezone,
                 final Optional<Integer> wheelchairBoarding ) {
        super( knowTime, id );
        mId = Preconditions.checkNotNull( id );
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


    public String getId() {
        return mId;
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


    public Optional<Integer> getLocationType() {
        return mLocationType;
    }


    public Optional<Integer> getParentStation() {
        return mParentStation;
    }


    public Optional<String> getTimezone() {
        return mTimezone;
    }


    public Optional<Integer> getWheelchairBoarding() {
        return mWheelchairBoarding;
    }
}

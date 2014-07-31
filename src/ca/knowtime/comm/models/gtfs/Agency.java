package ca.knowtime.comm.models.gtfs;


import com.google.common.base.Objects;
import com.google.common.base.Optional;
import com.google.common.base.Preconditions;

public class Agency
        extends GtfsModel
{
    private final String mAgencyName;
    private final String mAgencyUrl;
    private final String mAgencyTimezone;
    private final Optional<String> mAgencyId;
    private final Optional<String> mAgencyLang;
    private final Optional<String> mAgencyPhone;
    private final Optional<String> mAgencyFareUrl;


    public Agency( final String agencyName,
                   final String agencyUrl,
                   final String agencyTimezone,
                   final Optional<String> agencyId,
                   final Optional<String> agencyLang,
                   final Optional<String> agencyPhone,
                   final Optional<String> agencyFareUrl ) {
        mAgencyName = Preconditions.checkNotNull( agencyName );
        mAgencyUrl = Preconditions.checkNotNull( agencyUrl );
        mAgencyTimezone = Preconditions.checkNotNull( agencyTimezone );
        mAgencyId = Preconditions.checkNotNull( agencyId );
        mAgencyLang = Preconditions.checkNotNull( agencyLang );
        mAgencyPhone = Preconditions.checkNotNull( agencyPhone );
        mAgencyFareUrl = Preconditions.checkNotNull( agencyFareUrl );
    }


    public String getAgencyName() {
        return mAgencyName;
    }


    public String getAgencyUrl() {
        return mAgencyUrl;
    }


    public String getAgencyTimezone() {
        return mAgencyTimezone;
    }


    public Optional<String> getAgencyId() {
        return mAgencyId;
    }


    public Optional<String> getAgencyLang() {
        return mAgencyLang;
    }


    public Optional<String> getAgencyPhone() {
        return mAgencyPhone;
    }


    public Optional<String> getAgencyFareUrl() {
        return mAgencyFareUrl;
    }


    @Override
    public String toString() {
        return Objects.toStringHelper( this )
                      .add( "AgencyName", mAgencyName )
                      .add( "AgencyUrl", mAgencyUrl )
                      .add( "AgencyTimezone", mAgencyTimezone )
                      .add( "AgencyId", mAgencyId )
                      .add( "AgencyLang", mAgencyLang )
                      .add( "AgencyPhone", mAgencyPhone )
                      .add( "AgencyFareUrl", mAgencyFareUrl )
                      .toString();
    }
}

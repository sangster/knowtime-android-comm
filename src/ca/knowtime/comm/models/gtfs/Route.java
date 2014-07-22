package ca.knowtime.comm.models.gtfs;


import ca.knowtime.comm.models.gtfs.enums.RouteType;
import ca.knowtime.comm.models.gtfs.ids.RouteId;
import com.google.common.base.Objects;
import com.google.common.base.Optional;
import com.google.common.base.Preconditions;

public class Route
        extends RouteId
{
    private final String mRouteShortName;
    private final String mRouteLongName;
    private final RouteType mRouteType;
    private final Optional<String> mAgencyId;
    private final Optional<String> mRouteDesc;
    private final Optional<String> mRouteUrl;
    private final Optional<String> mRouteColor;
    private final Optional<String> mRouteTextColor;


    public Route( final String routeId,
                  final String routeShortName,
                  final String routeLongName,
                  final RouteType routeType,
                  final Optional<String> agencyId,
                  final Optional<String> routeDesc,
                  final Optional<String> routeUrl,
                  final Optional<String> routeColor,
                  final Optional<String> routeTextColor ) {
        super( routeId );
        mRouteShortName = Preconditions.checkNotNull( routeShortName );
        mRouteLongName = Preconditions.checkNotNull( routeLongName );
        mRouteType = Preconditions.checkNotNull( routeType );
        mAgencyId = Preconditions.checkNotNull( agencyId );
        mRouteDesc = Preconditions.checkNotNull( routeDesc );
        mRouteUrl = Preconditions.checkNotNull( routeUrl );
        mRouteColor = Preconditions.checkNotNull( routeColor );
        mRouteTextColor = Preconditions.checkNotNull( routeTextColor );
    }


    public String getRouteShortName() {
        return mRouteShortName;
    }


    public String getRouteLongName() {
        return mRouteLongName;
    }


    public RouteType getRouteType() {
        return mRouteType;
    }


    public Optional<String> getAgencyId() {
        return mAgencyId;
    }


    public Optional<String> getRouteDesc() {
        return mRouteDesc;
    }


    public Optional<String> getRouteUrl() {
        return mRouteUrl;
    }


    public Optional<String> getRouteColor() {
        return mRouteColor;
    }


    public Optional<String> getRouteTextColor() {
        return mRouteTextColor;
    }


    @Override
    public String toString() {
        return Objects.toStringHelper( this )
                      .add( "RouteId", mId )
                      .add( "RouteShortName", mRouteShortName )
                      .add( "RouteLongName", mRouteLongName )
                      .add( "RouteType", mRouteType )
                      .add( "AgencyId", mAgencyId )
                      .add( "RouteDesc", mRouteDesc )
                      .add( "RouteUrl", mRouteUrl )
                      .add( "RouteColor", mRouteColor )
                      .add( "RouteTextColor", mRouteTextColor )
                      .toString();
    }
}

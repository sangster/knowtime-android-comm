package ca.knowtime.comm.models.gtfs;

import ca.knowtime.comm.models.gtfs.ids.FareId;
import com.google.common.base.Objects;
import com.google.common.base.Optional;
import com.google.common.base.Preconditions;

public class FareRule
        extends FareId
{
    private final Optional<String> mRouteId;
    private final Optional<String> mOriginId;
    private final Optional<String> mDestinationId;
    private final Optional<String> mContainsId;


    public FareRule( final String fareId,
                     final Optional<String> routeId,
                     final Optional<String> originId,
                     final Optional<String> destinationId,
                     final Optional<String> containsId ) {
        super( fareId );
        mRouteId = Preconditions.checkNotNull( routeId );
        mOriginId = Preconditions.checkNotNull( originId );
        mDestinationId = Preconditions.checkNotNull( destinationId );
        mContainsId = Preconditions.checkNotNull( containsId );
    }


    public Optional<String> getRouteId() {
        return mRouteId;
    }


    public Optional<String> getOriginId() {
        return mOriginId;
    }


    public Optional<String> getDestinationId() {
        return mDestinationId;
    }


    public Optional<String> getContainsId() {
        return mContainsId;
    }


    @Override
    public String toString() {
        return Objects.toStringHelper( this )
                      .add( "FareId", mId )
                      .add( "RouteId", mRouteId )
                      .add( "OriginId", mOriginId )
                      .add( "DestinationId", mDestinationId )
                      .add( "ContainsId", mContainsId )
                      .toString();
    }
}

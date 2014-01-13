package ca.knowtime.comm.types;


public class Location
{
    private final float mLat;
    private final float mLng;


    public Location( final float lat, final float lng ) {
        mLat = lat;
        mLng = lng;
    }


    public float getLat() {
        return mLat;
    }


    public float getLng() {
        return mLng;
    }


    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder( "Location{" );
        sb.append( mLat );
        sb.append( ", " ).append( mLng );
        sb.append( '}' );
        return sb.toString();
    }
}

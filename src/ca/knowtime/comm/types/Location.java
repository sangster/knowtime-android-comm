package ca.knowtime.comm.types;


import org.json.JSONException;
import org.json.JSONObject;

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


    public boolean isValid() {
        return !isZero( mLat ) && !isZero( mLng );
    }


    private boolean isZero( final float val ) {
        return Math.abs( val ) < 0.00000001;
    }


    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder( "Location{" );
        sb.append( mLat );
        sb.append( ", " ).append( mLng );
        sb.append( '}' );
        return sb.toString();
    }


    public JSONObject toJson() {
        try {
            final JSONObject obj = new JSONObject();
            obj.put( "lat", mLat );
            obj.put( "lng", mLng );
            return obj;
        } catch( final JSONException e ) {
            throw new RuntimeException( e );
        }
    }
}

package ca.knowtime.comm.types;


import org.json.JSONException;
import org.json.JSONObject;

public class Agency
        implements KnowtimeModel
{
    private final String mName;
    private final String mUrl;
    private final String mTimezone;
    private final String mLang;


    public Agency( final String name, final String url, final String timezone, final String lang ) {
        mName = name;
        mUrl = url;
        mTimezone = timezone;
        mLang = lang;
    }


    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder( "Agency{" );
        sb.append( "Name='" ).append( mName ).append( '\'' );
        sb.append( ", Url='" ).append( mUrl ).append( '\'' );
        sb.append( ", Timezone='" ).append( mTimezone ).append( '\'' );
        sb.append( ", Lang='" ).append( mLang ).append( '\'' );
        sb.append( '}' );
        return sb.toString();
    }


    @Override
    public JSONObject toJson() {

        try {
            final JSONObject obj = new JSONObject();
            obj.put( "name", mName );
            obj.put( "url", mUrl );
            obj.put( "timezone", mTimezone );
            obj.put( "lang", mLang );
            return obj;
        } catch( final JSONException e ) {
            throw new RuntimeException( e );
        }
    }
}

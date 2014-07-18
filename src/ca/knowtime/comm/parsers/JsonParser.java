package ca.knowtime.comm.parsers;

import ca.knowtime.comm.exceptions.ParseException;
import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import org.json.JSONObject;

/**
 * @param <T>
 *         The type of object being deserialized
 */
public abstract class JsonParser<T>
{
    protected final String mPrefix;
    protected final JSONObject mJson;


    protected JsonParser( final String prefix, final JSONObject json ) {
        mPrefix = Preconditions.checkNotNull( prefix );
        mJson = Preconditions.checkNotNull( json );
    }


    /** @return the requestComplete of deserializing the given JSON string */
    public abstract T get()
            throws ParseException;


    protected Optional<String> unalias( final String key ) {
        return unaliasIntern( key, false );
    }


    protected Optional<String> unaliasIntern( final String key ) {
        return unaliasIntern( key, true );
    }


    private Optional<String> unaliasIntern( final String key,
                                            final boolean intern ) {
        final String str;
        if( mJson.has( key ) ) {
            str = mJson.optString( key );
        } else {
            str = mJson.optString( alias( key ), null );
        }
        if( str == null ) {
            return Optional.absent();
        }
        return Optional.of( intern ? str.intern() : str );
    }


    private String alias( final String key ) {
        return mPrefix + '_' + key;
    }


    protected Optional<String> opt( final String key ) {
        return optIntern( key, false );
    }


    protected Optional<String> optIntern( final String key ) {
        return optIntern( key, true );
    }


    private Optional<String> optIntern( final String key,
                                        final boolean intern ) {
        if( mJson.has( key ) ) {
            final String str = mJson.optString( key );
            return Optional.of( intern ? str.intern() : str );
        }
        return Optional.absent();
    }


    protected Optional<Float> unaliasFloat( final String key ) {
        return optFloat( key ).or( optFloat( alias( key ) ) );
    }


    protected Optional<Float> optFloat( final String key ) {
        if( mJson.has( key ) ) {
            return Optional.of( (float) mJson.optDouble( key ) );
        }
        return Optional.absent();
    }


    protected Optional<Integer> unaliasInteger( final String key ) {
        return optInteger( key ).or( optInteger( alias( key ) ) );
    }


    protected Optional<Integer> optInteger( final String key ) {
        if( mJson.has( key ) ) {
            return Optional.of( mJson.optInt( key ) );
        }
        return Optional.absent();
    }
}

package ca.knowtime.comm;

import android.net.Uri;
import ca.knowtime.comm.cache.KnowTimeCache;

public class KnowTime
{
    public static KnowTimeAccess connect( final Uri baseUrl, final KnowTimeCache cache ) {
        return new KnowTimeAccessImpl( baseUrl, cache );
    }
}

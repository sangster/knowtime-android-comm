package ca.knowtime.comm;

import java.net.URI;

public class KnowTime
{
    public static KnowTimeAccess connect( final URI baseUrl ) {
        return new KnowTimeAccessImpl( baseUrl );
    }
}

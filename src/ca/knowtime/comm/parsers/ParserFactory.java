package ca.knowtime.comm.parsers;

import ca.knowtime.comm.RestAccess;
import org.json.JSONObject;

public abstract class ParserFactory<T, Access extends RestAccess>
{
    protected final Access mAccess;


    protected ParserFactory( final Access access ) {
        mAccess = access;
    }


    public abstract JsonParser<T, Access> parser( JSONObject res );
}

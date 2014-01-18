package ca.knowtime.comm.exceptions;

public class InvalidPathPartException
        extends InvalidArgumentException
{
    private final String mPart;


    public InvalidPathPartException( final String part ) {
        mPart = part;
    }


    public String getPart() {
        return mPart;
    }


    @Override
    public String getMessage() {
        return "Invalid URL path part: \'" + mPart + '\'';
    }
}

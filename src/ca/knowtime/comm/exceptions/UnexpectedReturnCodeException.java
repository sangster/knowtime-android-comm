package ca.knowtime.comm.exceptions;

public class UnexpectedReturnCodeException
        extends KnowTimeException
{
    private final int mReturnCode;


    public UnexpectedReturnCodeException( final int returnCode ) {
        mReturnCode = returnCode;
    }


    public int getReturnCode() {
        return mReturnCode;
    }


    @Override
    public String getMessage() {
        return "Unexpected return code: " + mReturnCode;
    }
}

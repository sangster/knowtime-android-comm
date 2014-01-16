package ca.knowtime.comm.exceptions;

import java.io.IOException;

public class HttpIoException
        extends KnowTimeException
{
    private final IOException mIoException;


    public HttpIoException( final IOException ioException ) {

        mIoException = ioException;
    }


    public IOException getIoException() {
        return mIoException;
    }


    @Override
    public String getMessage() {
        return "KNOWtime HTTP IO Exception: " + mIoException.getMessage();
    }
}

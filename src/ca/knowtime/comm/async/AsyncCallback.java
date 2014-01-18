package ca.knowtime.comm.async;

public interface AsyncCallback<T>
{
    void requestComplete( T result );
}

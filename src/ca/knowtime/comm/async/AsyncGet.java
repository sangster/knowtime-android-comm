package ca.knowtime.comm.async;

import android.os.AsyncTask;

/**
 * An asynchronous method of fetching the an object of the given type from the KNOWtime server.
 *
 * @param <T>
 *         the type of object this class with fetch from the KNOWtime server
 */
public class AsyncGet<T>
{
    private final Action<T> mAction;

    /**
     * Classes of this type are responsible for actually fetching the data from the KNOWtime server
     *
     * @param <T>
     *         the type of object this class with fetch from the KNOWtime server
     */
    public interface Action<T>
    {
        /**
         * This method will block until the request is complete
         *
         * @return the given object from the KNOWtime server
         */
        T doRequest();
    }


    /** A helper for {@link #AsyncGet(Action)} so you don't have to specify the type twice in a single call */
    public static <T> AsyncGet<T> create( final Action<T> action ) {
        return new AsyncGet<T>( action );
    }


    public AsyncGet( final Action<T> action ) {
        mAction = action;
    }


    /**
     * Executes this action asynchronously
     *
     * @param callback
     *         invoked on the UI thread once the action is complete
     */
    public void execute( final AsyncCallback<T> callback ) {
        new AsyncTask<Void, Void, T>()
        {
            @Override
            protected T doInBackground( final Void... params ) {
                return mAction.doRequest();
            }


            @Override
            protected void onPostExecute( final T obj ) {
                callback.requestComplete( obj );
            }
        }.execute();
    }
}

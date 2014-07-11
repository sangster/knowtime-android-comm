package ca.knowtime.comm.types;


import ca.knowtime.comm.KnowTimeAccess;

public class DataSet
        extends DataSetSummary
{
    public DataSet( final KnowTimeAccess knowTime, final String id, final String name,
                    final String url, final String etag, final String createdAt ) {
        super( knowTime, id, name, url, etag, createdAt );
    }
}

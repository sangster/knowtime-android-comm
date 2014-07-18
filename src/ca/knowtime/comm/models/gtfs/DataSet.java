package ca.knowtime.comm.models.gtfs;


public class DataSet
        extends DataSetSummary
{
    public DataSet( final String id,
                    final String name,
                    final String url,
                    final String etag,
                    final String createdAt ) {
        super( id, name, url, etag, createdAt );
    }
}

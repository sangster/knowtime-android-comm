package ca.knowtime.comm.models.gtfs;


import ca.knowtime.comm.GtfsAccess;

public class DataSet
        extends DataSetSummary
{
    public DataSet( final GtfsAccess access,
                    final String id,
                    final String name,
                    final String url,
                    final String etag,
                    final String createdAt ) {
        super( access, id, name, url, etag, createdAt );
    }
}

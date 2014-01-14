package ca.knowtime.comm;

import ca.knowtime.comm.types.Location;
import ca.knowtime.comm.types.Stop;
import ca.knowtime.comm.types.User;
import org.json.JSONException;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

public interface KnowTimeAccess
{
    User createUser( int routeId )
            throws IOException;

    void postLocation( UUID userId, Location location )
            throws IOException;

    List<Stop> stops()
            throws IOException, JSONException;
}

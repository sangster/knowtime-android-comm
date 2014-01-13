package ca.knowtime.comm;

import ca.knowtime.comm.types.Stop;
import org.json.JSONException;

import java.io.IOException;
import java.util.List;

public interface KnowTimeAccess
{
    List<Stop> stops()
            throws IOException, JSONException;
}

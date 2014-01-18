package ca.knowtime.comm.types;

import java.util.List;
import java.util.UUID;

public class Path
{
    private final UUID mPathId;
    private final List<Location> mPathPoints;


    public Path( final UUID pathId, final List<Location> pathPoints ) {
        mPathId = pathId;
        mPathPoints = pathPoints;
    }


    public UUID getPathId() {
        return mPathId;
    }


    public List<Location> getPathPoints() {
        return mPathPoints;
    }
}

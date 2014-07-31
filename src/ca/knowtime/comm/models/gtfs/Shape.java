package ca.knowtime.comm.models.gtfs;

import ca.knowtime.comm.models.gtfs.ids.ShapeId;
import com.google.common.base.Optional;
import com.google.common.base.Preconditions;

public class Shape
        extends ShapeId
{
    private final float mShapePtLat;
    private final float mShapePtLon;
    private final int mShapePtSequence;
    private final Optional<Float> mShapeDistTraveled;


    public Shape( final String shapeId,
                  final float shapePtLat,
                  final float shapePtLon,
                  final int shapePtSequence,
                  final Optional<Float> shapeDistTraveled ) {
        super( shapeId );
        mShapePtLat = Preconditions.checkNotNull( shapePtLat );
        mShapePtLon = Preconditions.checkNotNull( shapePtLon );
        mShapePtSequence = Preconditions.checkNotNull( shapePtSequence );
        mShapeDistTraveled = Preconditions.checkNotNull( shapeDistTraveled );
    }


    public float getShapePtLat() {
        return mShapePtLat;
    }


    public float getShapePtLon() {
        return mShapePtLon;
    }


    public int getShapePtSequence() {
        return mShapePtSequence;
    }


    public Optional<Float> getShapeDistTraveled() {
        return mShapeDistTraveled;
    }
}

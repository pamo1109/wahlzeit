package org.wahlzeit.work;

public interface Coordinate {

	public CartesianCoordinate asCartesianCoordinates();
	
	public double getCartesianDistance(Coordinate other);
	
	public SphericCoordinate asSphericCoordinate();
	
	public double getCentralAngle(Coordinate other);
	
	public default boolean isEqual(Coordinate other) {
		return this == other;
	}
}

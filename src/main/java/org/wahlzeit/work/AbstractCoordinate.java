/**
 * 
 */
package org.wahlzeit.work;

/**
 * @author patrickmoritz
 *
 */
public abstract class AbstractCoordinate implements Coordinate {
	
	protected final double EPSILON = 0.0001;

	protected AbstractCoordinate() {}
	
	@Override
	abstract public CartesianCoordinate asCartesianCoordinates();
	
	@Override
	abstract public SphericCoordinate asSphericCoordinate();
	
	@Override
	abstract public boolean isEqual(Coordinate other);
	
	/*
	 * non-abstract methods
	 */
	@Override
	public double getCartesianDistance(Coordinate other) throws NullPointerException, IllegalStateException {
		assertCoordinateIsDefined(other);
		CartesianCoordinate otherAsCartesian = other.asCartesianCoordinates();
		double result = this.doComputeCartesianDistance(otherAsCartesian);
		assertGreaterZero(result);
		return result;
	}

	@Override
	public double getCentralAngle(Coordinate other) throws NullPointerException, IllegalStateException {
		assertCoordinateIsDefined(other);
		SphericCoordinate otherAsSpheric = other.asSphericCoordinate();
		double result = this.doComputeCentralAngle(otherAsSpheric);
		assertGreaterZero(result);
		return result;
	}
	
	protected void assertGreaterZero(double value) throws IllegalStateException {
		if (value < 0) throw new IllegalStateException("the given value should not be less than zero!");
	}
	
	protected void assertCoordinateIsDefined(Coordinate coord) throws NullPointerException {
		if (coord == null) throw new NullPointerException("given variable is not defined!");
	}
	
	/*
	 * primitives
	 */
	private double doComputeCentralAngle(SphericCoordinate other) {
		SphericCoordinate sphericCoordinate = this.asSphericCoordinate();
		double deltaPhi = Math.abs(sphericCoordinate.phi - other.phi);
		return Math.acos(Math.sin(sphericCoordinate.theta) * Math.sin(other.theta) 
				+ Math.cos(sphericCoordinate.theta) * Math.cos(other.theta) * Math.cos(deltaPhi)
				);
	}
	
	private double doComputeCartesianDistance(CartesianCoordinate other) {
		CartesianCoordinate asCartesian = this.asCartesianCoordinates();
		double deltaX = asCartesian.x - other.x;
		double deltaY = asCartesian.y - other.y;
		double deltaZ = asCartesian.z - other.z;
		double cartesianDistance = Math.sqrt(deltaX * deltaX + deltaY * deltaY + deltaZ * deltaZ);
		
		return cartesianDistance;
	}
}

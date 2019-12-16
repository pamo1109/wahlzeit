package org.wahlzeit.work;

public class CartesianCoordinate extends AbstractCoordinate {

	final double x;
	final double y;
	final double z;
	
	private CartesianCoordinate(double x, double y, double z) throws IllegalStateException {
		super();
		this.x = x;
		this.y = y;
		this.z = z;
		assertCoordinatesAreValid();
	}
	
	public static CartesianCoordinate newInstance(double x, double y, double z) {
		return new CartesianCoordinate(x, y, z);
	}

	@Override
	public CartesianCoordinate asCartesianCoordinates() throws IllegalStateException {
		assertCoordinatesAreValid();
		return this;
	}

	@Override
	public SphericCoordinate asSphericCoordinate() throws IllegalStateException {
		assertCoordinatesAreValid();
		return this.doTransformToSphericCoordinate();
	}

	@Override
	public boolean isEqual(Coordinate other) throws IllegalStateException {
		assertCoordinatesAreValid();
		if	(this == other) return true;
		
		CartesianCoordinate cc = other.asCartesianCoordinates();
		if (this.x == cc.x && this.y == cc.y && this.z == cc.z) return true;
		if (Math.abs(this.x - cc.x) < EPSILON && Math.abs(this.y - cc.y) < EPSILON && Math.abs(this.z - cc.z) < EPSILON) return true;
		return false;
	}
	
	/*
	 * setters
	 */
	
	public CartesianCoordinate setX(double value) {
		return newInstance(value, this.y, this.z);
	}
	
	public CartesianCoordinate setY(double value) {
		return newInstance(this.x, value, this.z);
	}
	
	public CartesianCoordinate setZ(double value) {
		return newInstance(this.x, this.y, value);
	}
	
	/*
	 * primitives
	 */
	private SphericCoordinate doTransformToSphericCoordinate() {
		double rad = Math.sqrt(x*x + y*y + z*z);
		double theta = Math.acos(z / rad);
		double phi = Math.atan2(y, x);
		
		return SphericCoordinate.newInstance(rad, theta, phi);
	}
	
	/*
	 *  assertions
	 */
	private void assertCoordinatesAreValid() throws IllegalStateException {
		if (!Double.isFinite(this.x) || !Double.isFinite(this.y) || !Double.isFinite(this.z)) 
			throw new IllegalStateException("class invariant not fullfilled! Some of the coordinates variables are not valid.");
	}
}

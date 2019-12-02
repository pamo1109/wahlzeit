package org.wahlzeit.work;

public class CartesianCoordinate extends AbstractCoordinate {

	double x;
	double y;
	double z;
	
	public CartesianCoordinate(double x, double y, double z) {
		super();
		this.x = x;
		this.y = y;
		this.z = z;
		assertCoordinatesAreValid();
	}

	@Override
	public CartesianCoordinate asCartesianCoordinates() {
		assertCoordinatesAreValid();
		return this;
	}

	@Override
	public SphericCoordinate asSphericCoordinate() {
		assertCoordinatesAreValid();
		return this.doTransformToSphericCoordinate();
	}

	@Override
	public boolean isEqual(Coordinate other) {
		assertCoordinatesAreValid();
		if	(this == other) return true;
		
		CartesianCoordinate cc = other.asCartesianCoordinates();
		if (this.x == cc.x && this.y == cc.y && this.z == cc.z) return true;
		if (Math.abs(this.x - cc.x) < EPSILON && Math.abs(this.y - cc.y) < EPSILON && Math.abs(this.z - cc.z) < EPSILON) return true;
		return false;
	}
	
	/*
	 * primitives
	 */
	private SphericCoordinate doTransformToSphericCoordinate() {
		double rad = Math.sqrt(x*x + y*y + z*z);
		double theta = Math.acos(z / rad);
		double phi = Math.atan2(y, x);
		
		return new SphericCoordinate(rad, theta, phi);
	}
	
	/*
	 *  assertions
	 */
	private void assertCoordinatesAreValid() throws IllegalStateException {
		if (!Double.isFinite(this.x) || !Double.isFinite(this.y) || !Double.isFinite(this.z)) 
			throw new IllegalStateException();
	}
}

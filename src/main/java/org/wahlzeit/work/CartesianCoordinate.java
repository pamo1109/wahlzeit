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
	}

	@Override
	public CartesianCoordinate asCartesianCoordinates() {
		return this;
	}

	@Override
	public SphericCoordinate asSphericCoordinate() {
		return this.doTransformToSphericCoordinate();
	}

	@Override
	public boolean isEqual(Coordinate other) {
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
}

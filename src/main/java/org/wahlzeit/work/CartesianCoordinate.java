package org.wahlzeit.work;

public class CartesianCoordinate implements Coordinate {

	double x;
	double y;
	double z;
	
	public CartesianCoordinate(double x, double y, double z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}

	@Override
	public CartesianCoordinate asCartesianCoordinates() {
		return this;
	}

	@Override
	public double getCartesianDistance(Coordinate other) {
		CartesianCoordinate cc = other.asCartesianCoordinates();
		return this.doComputeCartesianDistance(cc);
	}
	
	@Override
	public SphericCoordinate asSphericCoordinate() {
		return this.doTransformToSphericCoordinate();
	}

	@Override
	public double getCentralAngle(Coordinate other) {
		SphericCoordinate asSpheric = this.asSphericCoordinate();
		double result = asSpheric.getCentralAngle(other.asSphericCoordinate());
		
		return result;
	}

	@Override
	public boolean isEqual(Coordinate other) {
		if	(this == other) return true;
		if	(!(other instanceof CartesianCoordinate)) return false;
		
		CartesianCoordinate cc = other.asCartesianCoordinates();
		if (this.x == cc.x && this.y == cc.y && this.z == cc.z) return true;
		
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
	
	private double doComputeCartesianDistance(CartesianCoordinate other) {
		double deltaX = this.x - other.x;
		double deltaY = this.y - other.y;
		double deltaZ = this.z - other.z;
		double cartesianDistance = Math.sqrt(deltaX * deltaX + deltaY * deltaY + deltaZ * deltaZ);
		
		return cartesianDistance;
	}
}

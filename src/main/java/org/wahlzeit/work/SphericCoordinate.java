/**
 * 
 */
package org.wahlzeit.work;

/**
 * @author patrickmoritz
 *
 */
public class SphericCoordinate implements Coordinate {

	double phi;
	double theta;
	double radius;
	
	/**
	 * 
	 */
	public SphericCoordinate(double rad, double theta, double phi) {
		this.radius = rad;
		this.theta = theta;
		this.phi = phi;
	}

	@Override
	public CartesianCoordinate asCartesianCoordinates() {
		return this.doTransformToCartesianCoordinate();
	}

	@Override
	public double getCartesianDistance(Coordinate other) {
		CartesianCoordinate asCartesian = this.asCartesianCoordinates();
		CartesianCoordinate cc = other.asCartesianCoordinates();
		double cartesianDistance = asCartesian.getCartesianDistance(cc);
	
		return cartesianDistance;
	}

	@Override
	public SphericCoordinate asSphericCoordinate() {
		return this;
	}

	@Override
	public double getCentralAngle(Coordinate other) {
		SphericCoordinate sc = other.asSphericCoordinate();
		return this.doComputeCentralAngle(sc);
	}

	@Override
	public boolean isEqual(Coordinate other) {
		if	(this == other) return true;
		if	(!(other instanceof SphericCoordinate)) return false;
		
		SphericCoordinate sc = other.asSphericCoordinate();
		if (this.radius == sc.radius && this.phi == sc.phi && this.theta == sc.theta) return true;
		
		return false;
	}
	
	/*
	 * primitives
	 */
	private CartesianCoordinate doTransformToCartesianCoordinate() {
		double x = radius * Math.sin(theta) * Math.cos(phi);
		double y = radius * Math.sin(theta) * Math.sin(phi);
		double z = radius * Math.cos(theta);
		
		return new CartesianCoordinate(x, y, z);
	}
	
	private double doComputeCentralAngle(SphericCoordinate other) {
		
		double deltaPhi = Math.abs(this.phi - other.phi);
		return Math.acos(Math.sin(this.theta) * Math.sin(other.theta) 
				+ Math.cos(this.theta) * Math.cos(other.theta) * Math.cos(deltaPhi)
				);
	}

}

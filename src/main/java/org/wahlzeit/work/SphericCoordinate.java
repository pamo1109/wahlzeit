/**
 * 
 */
package org.wahlzeit.work;

/**
 * @author patrickmoritz
 *
 */
public class SphericCoordinate extends AbstractCoordinate {

	final double phi;
	final double theta;
	final double radius;
	
	/**
	 * 
	 */
	private SphericCoordinate(double rad, double theta, double phi) throws IllegalStateException {
		super();
		this.radius = rad;
		this.theta = theta;
		this.phi = phi;
		assertCoordinatesAreValid();
	}
	
	public static SphericCoordinate newInstance(double rad, double theta, double phi) {
		return new SphericCoordinate(rad, theta, phi);
	}

	@Override
	public CartesianCoordinate asCartesianCoordinates() throws IllegalStateException {
		assertCoordinatesAreValid();
		return this.doTransformToCartesianCoordinate();
	}

	@Override
	public SphericCoordinate asSphericCoordinate() throws IllegalStateException {
		assertCoordinatesAreValid();
		return this;
	}

	@Override
	public boolean isEqual(Coordinate other) throws IllegalStateException {
		assertCoordinatesAreValid();
		if	(this == other) return true;
		
		SphericCoordinate sc = other.asSphericCoordinate();
		if (Math.abs(this.radius - sc.radius) < EPSILON && Math.abs(this.phi - sc.phi) < EPSILON && Math.abs(this.theta - sc.theta) < EPSILON) return true;
		return false;
	}
	
	/*
	 * setters
	 */
	
	public SphericCoordinate setRad(double value) {
		return newInstance(value, this.theta, this.phi);
	}
	
	public SphericCoordinate setTheta(double value) {
		return newInstance(this.radius, value, this.phi);
	}
	
	public SphericCoordinate setPhi(double value) {
		return newInstance(this.radius, this.theta, value);
	}
	
	/*
	 * primitives
	 */
	private CartesianCoordinate doTransformToCartesianCoordinate() {
		double x = radius * Math.sin(theta) * Math.cos(phi);
		double y = radius * Math.sin(theta) * Math.sin(phi);
		double z = radius * Math.cos(theta);
		
		return CartesianCoordinate.newInstance(x, y, z);
	}
	
	/*
	 *  assertions
	 */
	private void assertCoordinatesAreValid() throws IllegalStateException {
		if (!Double.isFinite(this.radius) || !Double.isFinite(this.theta) || !Double.isFinite(this.phi) || this.radius < 0.0) 
			throw new IllegalStateException("class invariant not fullfilled! Some of the coordinates variables are not valid.");
	}
}

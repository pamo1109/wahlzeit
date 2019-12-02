/**
 * 
 */
package org.wahlzeit.work;

/**
 * @author patrickmoritz
 *
 */
public class SphericCoordinate extends AbstractCoordinate {

	double phi;
	double theta;
	double radius;
	
	/**
	 * 
	 */
	public SphericCoordinate(double rad, double theta, double phi) {
		super();
		this.radius = rad;
		this.theta = theta;
		this.phi = phi;
		assertCoordinatesAreValid();
	}

	@Override
	public CartesianCoordinate asCartesianCoordinates() {
		assertCoordinatesAreValid();
		return this.doTransformToCartesianCoordinate();
	}

	@Override
	public SphericCoordinate asSphericCoordinate() {
		assertCoordinatesAreValid();
		return this;
	}

	@Override
	public boolean isEqual(Coordinate other) {
		assertCoordinatesAreValid();
		if	(this == other) return true;
		
		SphericCoordinate sc = other.asSphericCoordinate();
		if (Math.abs(this.radius - sc.radius) < EPSILON && Math.abs(this.phi - sc.phi) < EPSILON && Math.abs(this.theta - sc.theta) < EPSILON) return true;
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
	
	/*
	 *  assertions
	 */
	private void assertCoordinatesAreValid() throws IllegalStateException {
		if (!Double.isFinite(this.radius) || !Double.isFinite(this.theta) || !Double.isFinite(this.phi) || this.radius < 0.0) 
			throw new IllegalStateException();
	}
}

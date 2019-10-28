/**
 * 
 */
package org.wahlzeit.model;

/**
 * @author patrickmoritz
 *
 */
public class Coordinate {
	
	private double x, y, z;
	
	public Coordinate() {
		 this.x = 0.0;
		 this.y = 0.0;
		 this.z = 0.0;
	}
	
	public Coordinate(double x, double y, double z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}
	
	double getDistance(Coordinate other) {
		double partial = 	Math.pow(this.x - other.x, 2)
							+ Math.pow(this.y - other.y, 2)
							+ Math.pow(this.z - other.z, 2);
		
		return Math.sqrt(partial);
	}
	
	boolean isEqual(Coordinate other) {
		if(other == this) return true;
		
		return 	this.x == other.x
				&& this.y == other.y
				&& this.z == other.z;
	}
}

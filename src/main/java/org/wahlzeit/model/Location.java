/**
 * 
 */
package org.wahlzeit.model;

/**
 * @author patrickmoritz
 *
 */
public class Location {
	
	public Coordinate coord;
	
	public Location() {
		this.coord = new Coordinate();
	}
	
	public Location(Coordinate coord) {
		this.coord = coord;
	}
}

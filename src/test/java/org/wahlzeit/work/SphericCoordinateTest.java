/**
 * 
 */
package org.wahlzeit.work;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * @author patrickmoritz
 *
 */
public class SphericCoordinateTest {

	@Test
	public void testEqualityCheck() {
		SphericCoordinate sc1 = new SphericCoordinate(1, 0.5, 0.5);
		SphericCoordinate sc2 = new SphericCoordinate(1, 0.5, 0.5);
		
		CartesianCoordinate cc = sc1.asCartesianCoordinates();
		
		assertTrue(sc1.isEqual(sc2));
		assertTrue(sc2.isEqual(cc));
		assertTrue(sc1.isEqual(cc));
	}
	
	@Test
	public void testCartesianDistance() {
		SphericCoordinate sc1 = new SphericCoordinate(1, 0.5, 0.5);
		SphericCoordinate sc2 = new SphericCoordinate(1, 0.5, 0.5);
		
		assertTrue(sc1.getCartesianDistance(sc2) == 0);
	}
	
	@Test
	public void testCentralAngle() {
		SphericCoordinate sc1 = new SphericCoordinate(1, 0.5, 0.5);
		SphericCoordinate sc2 = new SphericCoordinate(1, 0.5, 0.5);
		SphericCoordinate sc3 = new SphericCoordinate(1, 0.7, 0.5);
		
		assertTrue(sc1.getCentralAngle(sc2) == 0);
		assertTrue(sc1.getCentralAngle(sc3) != 0);
	}
	
	@Test(expected = IllegalStateException.class)
	public void testConstructorWithNaN() {
		SphericCoordinate coord = new SphericCoordinate(Double.NaN, 0, 0);
	}
	
	@Test(expected = IllegalStateException.class)
	public void testConstructorWithInfinite() {
		SphericCoordinate coord = new SphericCoordinate(Double.POSITIVE_INFINITY, 0, 0);
	}
	
	@Test(expected = IllegalStateException.class)
	public void testConstructorWithNegativeRadius() {
		SphericCoordinate coord = new SphericCoordinate(-1, 0, 0);
	}

}

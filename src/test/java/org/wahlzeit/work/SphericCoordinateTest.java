/**
 * 
 */
package org.wahlzeit.work;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * @author patrickmoritz
 *
 */
class SphericCoordinateTest {

	@Test
	void testEqualityCheck() {
		SphericCoordinate sc1 = new SphericCoordinate(1, 0.5, 0.5);
		SphericCoordinate sc2 = new SphericCoordinate(1, 0.5, 0.5);
		
		CartesianCoordinate cc = sc1.asCartesianCoordinates();
		
		assertTrue(sc1.isEqual(sc2));
		assertTrue(sc2.isEqual(cc));
		assertTrue(sc1.isEqual(cc));
	}
	
	@Test
	void testCartesianDistance() {
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

}

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
class CartesianCoordinateTest {

	@Test
	void testEqualityCheck() {
		CartesianCoordinate testObject1 = new CartesianCoordinate(1, 2, 3);
		CartesianCoordinate testObject2 = new CartesianCoordinate(1, 2, 3);
		
		SphericCoordinate asSpheric = testObject2.asSphericCoordinate();
		
		assertTrue(testObject1.isEqual(testObject2));
		assertTrue(testObject2.isEqual(asSpheric));
		assertTrue(testObject1.isEqual(asSpheric));
	}
	
	@Test
	public void testCartesianDistance() {
		CartesianCoordinate testObject1 = new CartesianCoordinate(0, 0, 0);
		CartesianCoordinate testObject2 = new CartesianCoordinate(0, 0, 0);
		CartesianCoordinate testObject3 = new CartesianCoordinate(0, 0, 1);
		
		assertTrue(testObject1.getCartesianDistance(testObject2) == 0.0);
		assertTrue(testObject1.getCartesianDistance(testObject3) == 1.0);
	}
	
	@Test
	public void testCentralAngle() {
		CartesianCoordinate testObject1 = new CartesianCoordinate(1, 2, 3);
		CartesianCoordinate testObject2 = new CartesianCoordinate(1, 2, 3);
		CartesianCoordinate testObject3 = new CartesianCoordinate(1, 0, 1);
		
		assertTrue(testObject1.getCentralAngle(testObject2) == 0);
		assertTrue(testObject1.getCentralAngle(testObject3) != 0);
	}

}

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
public class CartesianCoordinateTest {

	@Test
	public void testEqualityCheck() {
		CartesianCoordinate testObject1 = CartesianCoordinate.newInstance(1, 2, 3);
		CartesianCoordinate testObject2 = CartesianCoordinate.newInstance(1, 2, 3);
		
		SphericCoordinate asSpheric = testObject2.asSphericCoordinate();
		
		assertTrue(testObject1.isEqual(testObject2));
		assertTrue(testObject2.isEqual(asSpheric));
		assertTrue(testObject1.isEqual(asSpheric));
	}
	
	@Test
	public void testCartesianDistance() {
		CartesianCoordinate testObject1 = CartesianCoordinate.newInstance(0, 0, 0);
		CartesianCoordinate testObject2 = CartesianCoordinate.newInstance(0, 0, 0);
		CartesianCoordinate testObject3 = CartesianCoordinate.newInstance(0, 0, 1);
		
		assertTrue(testObject1.getCartesianDistance(testObject2) == 0.0);
		assertTrue(testObject1.getCartesianDistance(testObject3) == 1.0);
	}
	
	@Test
	public void testCentralAngle() {
		CartesianCoordinate testObject1 = CartesianCoordinate.newInstance(1, 2, 3);
		CartesianCoordinate testObject2 = CartesianCoordinate.newInstance(1, 2, 3);
		CartesianCoordinate testObject3 = CartesianCoordinate.newInstance(1, 0, 1);
		
		assertTrue(testObject1.getCentralAngle(testObject2) == 0);
		assertTrue(testObject1.getCentralAngle(testObject3) != 0);
	}
	
	@Test(expected = IllegalStateException.class)
	public void testConstructorWithNaN() {
		CartesianCoordinate coord = CartesianCoordinate.newInstance(Double.NaN, 0, 0);
	}
	
	@Test(expected = IllegalStateException.class)
	public void testConstructorWithInfinite() {
		CartesianCoordinate coord = CartesianCoordinate.newInstance(Double.POSITIVE_INFINITY, 0, 0);
	}

}

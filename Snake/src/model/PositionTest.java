package model;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.Before;
import org.junit.jupiter.api.Test;
/**
 * Tests the position on the screen 
 * @author jay, nithil, kaushal
 *
 */
class PositionTest {

	
	Position testPosition  = new Position(23,32);	
	
	
	
	/**
	 * Test method for {@link model.Position#testGetxPos()}.
	 */
	@Test
	void testGetxPos() {
		assertEquals(23, testPosition.getxPos());
	}
	/**
	 * Test method for {@link model.Position#testSetxPos()}.
	 */
	@Test
	void testSetxPos() {
		testPosition.setxPos(143);
		assertEquals(143, testPosition.getxPos());
	}
	/**
	 * Test method for {@link model.Position#testGetyPos()}.
	 */
	@Test
	void testGetyPos() {
		assertEquals(32, testPosition.getyPos());
	}
	/**
	 * Test method for {@link model.Position#testSetyPos()}.
	 */
	@Test
	void testSetyPos() {
		testPosition.setyPos(40);
		assertEquals(40, testPosition.getyPos());
	}

}

package model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
/**
 * Tests the food and its position in the game
 * @author jay, nithil, kaushal
 *
 */
class FoodTest {
	Position pos  = new Position(23,32);
	Food testFood = new Food(pos);
	/**
	 * Test method for {@link model.Food#testGetMaxX()}.
	 */
	@Test
	void testGetMaxX() {
		assertEquals(32, testFood.getMaxX());
	}
	/**
	 * Test method for {@link model.Food#testGetMaxY()}.
	 */
	@Test
	void testGetMaxY() {
		assertEquals(41, testFood.getMaxY());
	}
	/**
	 * Test method for {@link model.Food#testGetPos()}.
	 */
	@Test
	void testGetPos() {
		assertEquals(pos, testFood.getPos());
	}
	/**
	 * Test method for {@link model.Food#testSetPos()}.
	 */
	@Test
	void testSetPos() {
		Position pos = new Position(25,35);
		testFood.setPos(pos);
		assertEquals(pos, testFood.getPos());
	}

}

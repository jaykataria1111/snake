package model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class FoodTest {
	Position pos  = new Position(23,32);
	Food testFood = new Food(pos);
	
	@Test
	void testGetMaxX() {
		assertEquals(32, testFood.getMaxX());
	}

	@Test
	void testGetMaxY() {
		assertEquals(41, testFood.getMaxY());
	}

	@Test
	void testGetPos() {
		assertEquals(pos, testFood.getPos());
	}

	@Test
	void testSetPos() {
		Position pos = new Position(25,35);
		testFood.setPos(pos);
		assertEquals(pos, testFood.getPos());
	}

}

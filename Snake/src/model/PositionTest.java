package model;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.Before;
import org.junit.jupiter.api.Test;

class PositionTest {

	
	Position testPosition  = new Position(23,32);	
	
	
	
	
	@Test
	void testGetxPos() {
		assertEquals(23, testPosition.getxPos());
	}

	@Test
	void testSetxPos() {
		testPosition.setxPos(143);
		assertEquals(143, testPosition.getxPos());
	}

	@Test
	void testGetyPos() {
		assertEquals(32, testPosition.getyPos());
	}

	@Test
	void testSetyPos() {
		testPosition.setyPos(40);
		assertEquals(40, testPosition.getyPos());
	}

}

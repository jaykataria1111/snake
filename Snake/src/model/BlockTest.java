package model;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.*;

import org.junit.jupiter.api.Test;

class BlockTest {
	Position pos  = new Position(23,32);
	Block testBlock = new Block(pos);
	
	@Test
	void testgetPos(){
		assertEquals(pos, testBlock.pos);
	}
	@Test
	void testsetPos(){
		Position pos  = new Position(26, 36);
		testBlock.setPos(pos);
		assertEquals(pos, testBlock.pos);
	}
}

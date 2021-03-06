package model;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.*;

import org.junit.jupiter.api.Test;
/**
 * The following class tests a block on the screen.
 * @author Jay, Nithil, Kaushal.
 *
 */
class BlockTest {
	Position pos  = new Position(23,32);
	Block testBlock = new Block(pos);
	
	/**
	 * Test method for {@link model.Block#testgetPos()}.
	 */
	@Test
	void testgetPos(){
		assertEquals(pos, testBlock.getPos());
	}
	/**
	 * Test method for {@link model.Block#testsetPos()}.
	 */
	@Test
	void testsetPos(){
		Position pos  = new Position(26, 36);
		testBlock.setPos(pos);
		assertEquals(pos, testBlock.getPos());
	}
}

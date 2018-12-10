/**
 * 
 */
package model;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import message.KeyPressed;
/**
 * The following class tests a snake. 
 */
class SnakeTest {

	Snake snake = new Snake(new Position(100,100) , 5);
	/**
	 * @throws java.lang.Exception
	 */
	@AfterEach
	void tearDown() throws Exception {
	}

	

	/**
	 * Test method for {@link model.Snake#addBlockToSnake()}.
	 */
	@Test
	void testAddBlockToSnake() {
		snake.addBlockToSnake();
		assertEquals(snake.getSnakeBlock().size(), 6 );
	}

	/**
	 * Test method for {@link model.Snake#addBlock()}.
	 */
	@Test
	void testAddBlock() {
		snake.addBlock();
		assertEquals(snake.getSnakeBlock().size(), 6 );
	}

	/**
	 * Test method for {@link model.Snake#getxPositions()}.
	 */
	@Test
	void testGetxPositions() {
		
		ArrayList<Integer> positions = snake.getxPositions();
		
		ArrayList<Integer> arrayxPositions = new ArrayList<>();
		
		arrayxPositions.add(100);
		arrayxPositions.add(89);
		arrayxPositions.add(78);
		arrayxPositions.add(67);
		arrayxPositions.add(56);
		assertEquals(arrayxPositions, positions);
		
	}

	/**
	 * Test method for {@link model.Snake#getyPositions()}.
	 */
	@Test
	void testGetyPositions() {
		ArrayList<Integer> positions = snake.getyPositions();
		
		ArrayList<Integer> arrayyPositions = new ArrayList<>();
		
		arrayyPositions.add(100);
		arrayyPositions.add(100);
		arrayyPositions.add(100);
		arrayyPositions.add(100);
		arrayyPositions.add(100);
		assertEquals(arrayyPositions, positions);
	}

	/**
	 * Test method for {@link model.Snake#moveSnake(message.KeyPressed)}.
	 */
	@Test
	void testMoveSnake() {
		snake.moveSnake(KeyPressed.RIGHT);
		assertEquals(snake.getHeadPosition().getxPos(), 111 );
		
	}

	/**
	 * Test method for {@link model.Snake#getHeadPosition()}.
	 */
	@Test
	void testGetHeadPosition() {
		
		assertEquals(snake.getHeadPosition().getxPos(), 100);
		assertEquals(snake.getHeadPosition().getxPos(), 100);
	}




	/**
	 * Test method for {@link model.Snake#getPos()}.
	 */
	@Test
	void testGetPos() {
		assertEquals(snake.getPos(), new Position(100,100));
	}

	

}

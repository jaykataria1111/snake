package model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ModelTest {

	Model model = new Model();

	

	/**
	 *Tests set snake and get snake together.
	 */
	@Test
	void testSetSnake() {
		Snake snake = new Snake(new Position(100,100) , 6);
		model.setSnake(snake);
		assertEquals(snake,model.getSnake());	
	}
	

	/**
	 * Tests setfood and get food together 
	 */
	@Test
	void testSetFood() {
		Food food = new Food(new Position(200,200));
		model.setFood(food);
		assertEquals(model.getFood(),food);
	}

	
	/**
	 * tests if won.
	 */
	@Test
	void testIfWon() {
		assertEquals(model.ifWon(), false);
	}

	
	/**
	 *  tests getxFood Position.
	 */
	@Test
	void testGetFoodxPosition() {
		
		assertEquals(model.getFoodxPosition(), new Integer(100));
	}

	/**
	 * tests getFood y Position
	 */
	@Test
	void testGetFoodyPosition() {
		assertEquals(model.getFoodyPosition(), new Integer(100));
	}

	/**
	 * test food y position
	 */
	@Test
	void testAteFood() {
		assertEquals(false , model.ateFood());
	}

	/**
	 * tests if game over   
	 */
	@Test
	void testGameOver() {
		assertEquals(false , model.gameOver());
	}

}

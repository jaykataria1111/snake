/**
 * 
 */
package model;

import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.BlockingQueue;

import Controller.ValveResponse;
import message.Message;

/**
 * @author Jay, Nithil, Kaushal
 *The following class is a Model class
 */
/**
 * @author jay
 *
 */
public class Model {
	
	public static final int winningSize = 40;
	Snake snake;
	Food food;
	BlockingQueue<Message> queue;
	private Random random;
	

	public Model()
	{
		snake = new Snake(new Position(110,110),5);
		food = new Food(new Position(100,100));
		random = new Random();

	}
	
	/**
	 * @return the snake
	 */
	public Snake getSnake() {
		return snake;
	}

	/**
	 * @param snake is the new Snake.
	 */
	public void setSnake(Snake snake)
	{
		this.snake = snake;
	}


	/**
	 * @return the food
	 */
	public Food getFood() {
		return food;
	}

	/**
	 * @param food the food to set
	 */
	public void setFood(Food food) {
		this.food = food;
	}

	



	
	public boolean ifWon()
	{
		if(snake.getSnakeBlock().size()  ==  winningSize)
			return true;
		
		return false;
	}
	
	
	
	/**
	 * Checks if the snake ate the food and if the snake ate the food then makes a new food particle on the screen.
	 */
	public void processFood()
	{
		if(ateFood())
		{
			snake.addBlock();
			this.food = new Food(getRandomPosition());
		}
	}
	
	
	
	/**
	 * Gets the X cordinate of the food position that was generated.
	 * @return returns the x cordinate of the food position that was generated.
	 */
	public Integer getFoodxPosition()
	{
		return this.food.getPos().getxPos();
	}
	
	/**
	 * Gets the Y coordinate of the food position that was generated.
	 * @return returns the y coordinate of the food position that was generated.
	 */
	public Integer getFoodyPosition()
	{
		return this.food.getPos().getyPos();
	}
	
	
	
	
	/**
	 * Checks if the snake ate the food
	 * @return true if the snake ate the food. 
	 */
	public boolean ateFood()
	{
		if(snake.getHeadPosition().getxPos() <= food.getPos().getxPos() && snake.getHeadPosition().getyPos() <= food.getPos().getyPos()  && snake.getMaxX() >= food.getMaxX() && snake.getMaxY()>= food.getMaxY())
		return true;	
		
		
		
		int xDifference = snake.getHeadPosition().getxPos() - food.getPos().getxPos();
		int yDifference = snake.getHeadPosition().getyPos() - food.getPos().getyPos();
		
		int xMaxDifference = snake.getMaxX()- food.getMaxX();
		int yMaxDifference = snake.getMaxY()- food.getMaxY();
		
		xDifference = Math.abs(xDifference);
		yDifference = Math.abs(yDifference);
		xMaxDifference =  Math.abs(xMaxDifference);
		yMaxDifference = Math.abs(yMaxDifference);
		
		
		if(xDifference<9 && yDifference<9 && xMaxDifference<9 && yMaxDifference<9)
			return true;
		
		
		return false;
		
	}
	
	
	/**
	 * The following method checks whether the game is over.
	 * @return True if the game is over.
	 */
	public boolean gameOver()
	{
		ArrayList<Block> snakelist = snake.getSnakeBlock();
		
		ArrayList<Position> blockPositions  = new ArrayList<>();
		
		for(Block block: snakelist)
		{
			if(blockPositions.contains(block.getPos()))
				return true;
			
			blockPositions.add(block.getPos());
		}
		
		
		
		if(snake.getHeadPosition().getxPos()<0 || snake.getHeadPosition().getxPos()>286)
			return true;
		
		
		
		if(snake.getHeadPosition().getyPos()<0 || snake.getHeadPosition().getyPos()>286 )
			return true;
		
		
		
		return false;
		
	}
	
	
	
	
	
	
	
	
	

	/**
	 * The following method generates a random food particle on the screen.
	 * @return returns a random position of the next food particle generated on the screen.
	 */
	private Position getRandomPosition() {
		
		int x =random.nextInt(27)*11;
		int y =random.nextInt(27)*11;

		return new Position(x,y);
	}

	

}

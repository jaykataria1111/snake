/**
 * 
 */
package Model;

import java.util.Random;
import java.util.concurrent.BlockingQueue;

import Controller.ValveResponse;
import message.Message;

/**
 * @author Jay, Nithil, Kaushal
 *The following class is a Model class
 */
public class Model {
	
	Level level;
	Statistics stats;
	Snake snake;
	Food food;
	boolean playStarted;
	boolean playEnded;
	BlockingQueue<Message> queue;
	private Random random;
	

	public Model(BlockingQueue<Message> queue)
	{
		level = new Level(0);
		snake = new Snake(new Position(110,110),5,queue);
		stats = new Statistics(0);
		food = new Food(new Position(100,100));
		random = new Random();
		this.queue = queue;
	}
	
	/**
	 * @return the level
	 */
	public Level getLevel() {
		return level;
	}

	/**
	 * @param level the level to set
	 */
	public void setLevel(Level level) {
		this.level = level;
	}

	/**
	 * @return the stats
	 */
	public Statistics getStats() {
		return stats;
	}

	/**
	 * @param stats the stats to set
	 */
	public void setStats(Statistics stats) {
		this.stats = stats;
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

	/**
	 * @return the playStarted
	 */
	public boolean isPlayStarted() {
		return playStarted;
	}

	/**
	 * @param playStarted the playStarted to set
	 */
	public void setPlayStarted(boolean playStarted) {
		this.playStarted = playStarted;
	}

	/**
	 * @return the playEnded
	 */
	public boolean isPlayEnded() {
		return playEnded;
	}

	/**
	 * @param playEnded the playEnded to set
	 */
	public void setPlayEnded(boolean playEnded) {
		this.playEnded = playEnded;
	}

	/**
	 * 
	 */
	public Model() {
		// TODO Auto-generated constructor stub
	}
	
	
	
	/**
	 * Represents that the play started.
	 */
	public void playStarted()
	{
		
	}
	
	
	/**
	 * Represents the playended
	 */
	public void playEnded()
	{
	
	}
	
	
	/**
	 * Updates the static high scores if there are any.
	 */
	public void addHighScore(Statistics stat)
	{
		
	}
	

	
	
	public void processFood()
	{
		if(ateFood())
		{
			snake.addBlock();
			this.food = new Food(getRandomPosition());
		}
	}
	
	
	
	public Integer getFoodxPosition()
	{
		return this.food.getPos().getxPos();
	}
	
	
	public Integer getFoodyPosition()
	{
		return this.food.getPos().getyPos();
	}
	
	
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
	
	
	
	
	
	
	
	
	
	
	
	

	private Position getRandomPosition() {
		
		int x =random.nextInt(27)*11;
		int y =random.nextInt(27)*11;

		return new Position(x,y);
	}

	

}

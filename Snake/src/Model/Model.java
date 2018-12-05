/**
 * 
 */
package Model;

import Controller.ValveResponse;
import message.Message;

/**
 * @author Jay, Nithil, Kaushal
 *The following class is a Model class
 */
public class Model implements Valve{
	
	Level level;
	Statistics stats;
	Snake snake;
	Food food;
	boolean playStarted;
	boolean playEnded;

	

	
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

	@Override
	public ValveResponse execute(Message message) {
		// TODO Auto-generated method stub
		return ValveResponse.MISS;
	}

}

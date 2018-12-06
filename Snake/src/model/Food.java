package model;

/**
 * The following class represents food for a snake.
 * @author Jay, Nithil, Kaushal
 *
 */
public class Food extends Block  {

	
	
	public static final int FOOD_SIZE = 9;
	/**
	 * The following is where the foods position is on screen
	 * @param pos is the position on the screen.
	 */
	public Food(Position pos) {
		super(pos);
		
	}

	
	/**
	 * Represents how maximum can the food size go in x direction.
	 * @return returns the max food size
	 */
	public int getMaxX()
	{
		return super.getPos().getxPos() + FOOD_SIZE;
	}
	
	
	/**
	 * Represents how maximum can the food size go in x direction.
	 * @return returns the max food size
	 */
	public int getMaxY()
	{
		return super.getPos().getyPos() + FOOD_SIZE;
	}
	
	
	
	
}

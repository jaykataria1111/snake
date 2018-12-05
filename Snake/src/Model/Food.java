package Model;

/**
 * The following class represents food for a snake.
 * @author Jay, Nithil, Kaushal
 *
 */
public class Food extends Block  {

	/**
	 * The following is where the foods position is on screen
	 * @param pos is the position on the screen.
	 */
	public Food(Position pos) {
		super(pos);
		
	}

	
	public int getMaxX()
	{
		return super.getPos().getxPos() + 9;
	}
	
	public int getMaxY()
	{
		return super.getPos().getyPos() + 9;
	}
	
	
	
	
}

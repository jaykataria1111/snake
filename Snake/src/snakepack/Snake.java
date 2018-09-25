/**
 * 
 */
package snakepack;

import java.util.Stack;

/**
 * THe following class represents the snake on the screen.
 * @author Jay, Nithil, Kaushal
 *
 */
public class Snake {

	
	int snakeLength;
	Stack<Block> snakeblocks;
	
	/**
	 * 
	 */
	public Snake() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @return the snakeLength
	 */
	public int getSnakeLength() {
		return snakeLength;
	}

	/**
	 * @param snakeLength the snakeLength to set
	 */
	public void setSnakeLength(int snakeLength) {
		this.snakeLength = snakeLength;
	}

	/**
	 * @return the snakeblocks
	 */
	public Stack<Block> getSnakeblocks() {
		return snakeblocks;
	}

	/**
	 * @param snakeblocks the snakeblocks to set
	 */
	public void setSnakeblocks(Stack<Block> snakeblocks) {
		this.snakeblocks = snakeblocks;
	}
	
	/**
	 * Draws the Snake on the Screen.
	 */
	public void drawSnake()
	{
		
	}
	
	/**
	 * THe following method simulizes a snake eating food  i.e. increasing its length.
	 * @param b is the food to eat.
	 */
	public void eatFood(Block b)
	{
	}

}


/**
 * 
 */
package Model;

/**
 * The following class describes a block on the screen.
 * @author Jay, Nithil, Kaushal
 *
 */
public class Block {
	

	Position pos;

	/**
	 * @param pos is the position of the Block.
	 */
	public Block(Position pos) {

		this.pos = pos;
	}



	/**
	 * @return the pos i.e. position of the block
	 */
	public Position getPos() {
		return pos;
	}

	/**
	 * @param pos the position to set the block on.
	 */
	public void setPos(Position pos) {
		this.pos = pos;
	}
	
	/**
	 * Draws the Block on the screen.
	 */
	public void drawBlock()
	{
		
	}
	
	
	


}

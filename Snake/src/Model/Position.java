/**
 * 
 */
package Model;

/**
 * The following class represents a position on the Screen
 * @author Jay, Nithil, Kaushal
 *
 */
public class Position {

	
	private int xPos;
	private int yPos;
	/**
	 * @param xPos is the x position.
	 * @param yPos is the y position.
	 */
	public Position(int xPos, int yPos) {
		super();
		this.xPos = xPos;
		this.yPos = yPos;
	}
	/**
	 * @return the xPos
	 */
	public int getxPos() {
		return xPos;
	}
	/**
	 * @param xPos the xPos to set
	 */
	public void setxPos(int xPos) {
		this.xPos = xPos;
	}
	/**
	 * @return the yPos
	 */
	public int getyPos() {
		return yPos;
	}
	/**
	 * @param yPos the yPos to set
	 */
	public void setyPos(int yPos) {
		this.yPos = yPos;
	}
	
	

}

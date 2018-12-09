/**
 * 
 */
package message;

import java.util.ArrayList;

/**
 * THe following message represents a Position on the screen, the message is supposed to get snakes postion.
 * @author jay, nithil, kaushal
 *
 */
public class PositionMessage extends Message {

	
	ArrayList<Integer> xPositions ;
	ArrayList<Integer> yPositions ; 
	
	
	public PositionMessage(ArrayList<Integer> xPositions, ArrayList<Integer> yPositions) {
		super();
		this.xPositions = xPositions;
		this.yPositions = yPositions;
	}


	/**
	 * @return the xPositions
	 */
	public ArrayList<Integer> getxPositions() {
		return xPositions;
	}


	/**
	 * @param xPositions the xPositions to set
	 */
	public void setxPositions(ArrayList<Integer> xPositions) {
		this.xPositions = xPositions;
	}


	/**
	 * @return the yPositions
	 */
	public ArrayList<Integer> getyPositions() {
		return yPositions;
	}


	/**
	 * @param yPositions the yPositions to set
	 */
	public void setyPositions(ArrayList<Integer> yPositions) {
		this.yPositions = yPositions;
	}

	
	
	
	
	
}

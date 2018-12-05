/**
 * 
 */
package message;

import java.util.ArrayList;

/**
 * @author jay
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

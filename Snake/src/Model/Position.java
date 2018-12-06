/**
 * 
 */
package Model;

import Controller.ValveResponse;
import message.Message;

/**
 * The following class represents a position on the Screen
 * @author Jay, Nithil, Kaushal
 *
 */
public class Position implements Valve{

	
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
	public Position(Position pos) {
		// TODO Auto-generated constructor stub
		this.xPos = pos.getxPos();
		this.yPos = pos.getyPos();
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
	
	
	
	
	
	
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + xPos;
		result = prime * result + yPos;
		return result;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Position other = (Position) obj;
		if (xPos != other.xPos)
			return false;
		if (yPos != other.yPos)
			return false;
		return true;
	}
	
	
	@Override
	public ValveResponse execute(Message message) {
		// TODO Auto-generated method stub
		return ValveResponse.MISS;
	}
	
	

}

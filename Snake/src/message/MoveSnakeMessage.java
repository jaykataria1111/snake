/**
 * 
 */
package message;

import Model.*;
/**
 * @author jay
 *
 */
public class MoveSnakeMessage extends Message {

	
	KeyPressed key;
	/**
	 * Send the message of which key was pressed.
	 */
	public MoveSnakeMessage(KeyPressed key) {
		// TODO Auto-generated constructor stub
		this.key = key;
	}
	/**
	 * @return the key
	 */
	public KeyPressed getKey() {
		return key;
	}
	/**
	 * @param key the key to set
	 */
	public void setKey(KeyPressed key) {
		this.key = key;
	}
	
	
	
	

}

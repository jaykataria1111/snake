/**
 * 
 */
package snakepack;

/**
 * The following class represents a player in the program.
 * @author Jay, Nithil, Kaushal
 *
 */
public class Player {
	
	private String name;

	/**
	 * @param name
	 */
	public Player(String name) {
		super();
		this.name = name;
	}

	
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	
	/**
	 * THe up key is pressed by the player
	 */
	public void upKeyPressed() {}
	
	
	/**
	 * The down key is pressed by the player
	 */
	public void downKeyPressed() {}
	
	/**
	 * The left key is pressed by the player
	 */
	public void leftKeyPressed() {}
	
	/**
	 * The right key is pressed by the player.
	 */
	public void rightKeyPressed() {}
	
	
	

}

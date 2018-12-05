package Model;

/**
 * The following class represents a level in the game,
 * @author Jay, Nithil, Kaushal
 *
 */
public class Level {

	public static final int LEVEL1 = 1;
	public static final int LEVEL2 = 2;
	public static final int LEVEL3 = 3;
	public static final int LEVEL4 = 4;
	
	private int currentLevel;

	/**
	 * @param currentLevel
	 */
	public Level(int currentLevel) {
		super();
		this.currentLevel = currentLevel;
	}

	/**
	 * @return the currentLevel
	 */
	public int getCurrentLevel() {
		return currentLevel;
	}

	/**
	 * @param currentLevel the currentLevel to set
	 */
	public void setCurrentLevel(int currentLevel) {
		this.currentLevel = currentLevel;
	}
	
	

}

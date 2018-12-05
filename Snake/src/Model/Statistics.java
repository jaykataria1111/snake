/**
 * 
 */
package Model;

/**
 * @author Jay, Nithil, Kaushal
 * The following class keeps the statistics of game.
 *
 */
public class Statistics {

	private int currentScore;
	public static int[] HighScore = new int[5];
	
	

	/**
	 * Constructs a method using a scor.
	 * @param currentScore
	 */
	public Statistics(int currentScore) {
		super();
		this.currentScore = currentScore;
	}

	/**
	 * @return the currentScore
	 */
	public int getCurrentScore() {
		return currentScore;
	}

	/**
	 * @param currentScore the currentScore to set
	 */
	public void setCurrentScore(int currentScore) {
		this.currentScore = currentScore;
	}

	/**
	 * @return the highScore
	 */
	public static int[] getHighScore() {
		return HighScore;
	}

	/**
	 * @param highScore the highScore to set
	 */
	public static void setHighScore(int[] highScore) {
		HighScore = highScore;
	}

}

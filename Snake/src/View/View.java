/**
 * 
 */
package View;

import message.Message;

import java.util.concurrent.BlockingQueue;

import javax.swing.JButton;
import javax.swing.JFrame;

/**
 * @author Jay, Nithil, Kaushal
 *THe following class represents a view class.
 */
public class View {
	
	
	JFrame outerFrame;
	JButton playButton;
	JButton levelButton;
	JButton highScoreButton;

	/**
	 * 
	 */
	public View(BlockingQueue<Message> queue) {
		// TODO Auto-generated constructor stub
		outerFrame = new JFrame();
		outerFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		outerFrame.setTitle("Snake Game");
		outerFrame.setLocationRelativeTo(null);
		outerFrame.setDefaultLookAndFeelDecorated(true);
		
		
		
	}
	
	/**
	 * Switches the GUI to playMode
	 */
	public void playMode()
	{
		
	}
	
	/**
	 * Switches the GUI to highScoreMode()
	 */
	public void highScoreMode()
	{
		
	}
	
	
	/**
	 * Switches the GUI to levelMode
	 */
	public void levelMode()
	{
		
	}

}
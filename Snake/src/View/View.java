
package View;
import message.Message;
import model.Valve;

import java.io.IOException;
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
	PlayPanel playPanel;
	/**
	 * @throws IOException 
	 * The following method is the main view which takes a blocking queue and implements actions based upon it.
	 */
	public View(BlockingQueue<Message> queue) throws IOException {
		outerFrame = new JFrame();
		outerFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		outerFrame.setTitle("Snake Game");
		outerFrame.setLocationRelativeTo(null);
		outerFrame.setDefaultLookAndFeelDecorated(true);
		 playPanel = new PlayPanel(queue);
		 KeyBoardListener listener = new KeyBoardListener(queue);
		 playPanel.addKeyListener(listener);
		 outerFrame.addKeyListener(listener);
		outerFrame.add(playPanel);
		outerFrame.pack();
		outerFrame.setVisible(true);
	}
	/**
	 * @return the playPanel
	 */
	public PlayPanel getPlayPanel() {
		return playPanel;
	}
}

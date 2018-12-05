/**
 * 
 */
package View;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.LayoutManager;
import java.util.concurrent.BlockingQueue;

import javax.swing.JPanel;

/**
 * @author jay
 *
 */
public class PlayPanel extends JPanel {

	/**
	 * 
	 */
	public PlayPanel(BlockingQueue queue) {
		// TODO Auto-generated constructor stub
		
		this.setBackground(new java.awt.Color(153, 204, 153));
		this.setPreferredSize(new Dimension(300,300));	
		this.setVisible(true);
		
	}
	
	
	
	
	@Override
	public void paintComponent(Graphics g) {
        super.paintComponent(g);
     
  
        
    }

	/**
	 * @param layout
	 */
	public PlayPanel(LayoutManager layout) {
		super(layout);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param isDoubleBuffered
	 */
	public PlayPanel(boolean isDoubleBuffered) {
		super(isDoubleBuffered);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param layout
	 * @param isDoubleBuffered
	 */
	public PlayPanel(LayoutManager layout, boolean isDoubleBuffered) {
		super(layout, isDoubleBuffered);
		// TODO Auto-generated constructor stub
	}

}

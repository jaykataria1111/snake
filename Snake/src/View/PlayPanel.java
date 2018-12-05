/**
 * 
 */
package View;

import Model.Valve;
import message.DownButtonMessage;
import message.FoodCheckMessage;
import message.KeyPressed;
import message.LeftButtonMessage;
import message.Message;
import message.MoveSnakeMessage;
import message.PositionMessage;
import message.RightButtonMessage;
import message.UpButtonMessage;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.BlockingQueue;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.Timer;

import Controller.ValveResponse;

/**
 * @author jay
 *
 */
public class PlayPanel extends JPanel  implements ActionListener{

	
	
	Integer foodImagexPosition;
	Integer foodImageyPosition;
	
	ArrayList<Integer> xPositions;
	ArrayList<Integer> yPositions;
	BlockingQueue queue; 
	Timer timer;
	KeyPressed key;
	Image blockImage;
	Image foodImage;
	/**
	 * @throws IOException 
	 * 
	 */
	public PlayPanel(BlockingQueue<Message> queue) throws IOException {
		// TODO Auto-generated constructor stub
		
		
		
		blockImage = ImageIO.read(new File("//Users//jay//CS 151//Project//snake//Snake//blackBlock.png"));
		blockImage = blockImage.getScaledInstance(10,10, Image.SCALE_DEFAULT);
		
		foodImage = ImageIO.read(new File("//Users//jay//CS 151//Project//snake//Snake//Food.png"));
		foodImage = foodImage.getScaledInstance(9,9, Image.SCALE_DEFAULT);
		
		
		
		
		this.setBackground(new java.awt.Color(153, 204, 153));
		this.setPreferredSize(new Dimension(300,300));	
		this.setVisible(true);
		timer = new Timer(150,this);
		timer.start();
		this.queue = queue;
		key = KeyPressed.RIGHT;
		
		xPositions = new ArrayList<Integer>();
		yPositions = new ArrayList<Integer>();
	
	
		
	}
	
	
	/**
	 * @return the foodImagexPosition
	 */
	public Integer getFoodImagexPosition() {
		return foodImagexPosition;
	}


	/**
	 * @param foodImagexPosition the foodImagexPosition to set
	 */
	public void setFoodImagexPosition(Integer foodImagexPosition) {
		this.foodImagexPosition = foodImagexPosition;
	}


	/**
	 * @return the foodImageyPosition
	 */
	public Integer getFoodImageyPosition() {
		return foodImageyPosition;
	}


	/**
	 * @param foodImageyPosition the foodImageyPosition to set
	 */
	public void setFoodImageyPosition(Integer foodImageyPosition) {
		this.foodImageyPosition = foodImageyPosition;
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		
		
		
		
		
		FoodCheckMessage fcg = new FoodCheckMessage();
		
		try {
			queue.put(fcg);
		} catch (InterruptedException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		
		
		MoveSnakeMessage msg = new MoveSnakeMessage(key);
	    try {
			queue.put(msg);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
	    
	    repaint();
	}
	
	
	
	
	
	
	@Override
	public void paintComponent(Graphics g) {
        super.paintComponent(g);
     
  
        g.drawImage(foodImage, this.foodImagexPosition, this.foodImageyPosition, this);
        
        for(int i =0; i< xPositions.size() ; i++)
        {
        	g.drawImage(blockImage, xPositions.get(i), yPositions.get(i), this);
        }
        
        
        
        
        
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




	


	public void updatePositions(ArrayList<Integer> getxPositions, ArrayList<Integer> getyPositions) {
		// TODO Auto-generated method stub
		
		this.xPositions = getxPositions;
		this.yPositions = getyPositions;
	}


	public void setLeftKey() {
		// TODO Auto-generated method stub
		
		if(key != KeyPressed.RIGHT)
			key = KeyPressed.LEFT;
		
    	//System.out.println("Pressed");
			
	}
	
	
	public void setRightKey() {
		
		if(key != KeyPressed.LEFT)
			key = KeyPressed.RIGHT;
		
	}
	
	
	public void setDownKey() {
		
		if(key != KeyPressed.UP)
			key = KeyPressed.DOWN;
		
	}

	

	public void setUpKey() {
		
		if(key != KeyPressed.DOWN)
			key = KeyPressed.UP;
		
	}

	

}

/**
 * 
 */
package View;

import message.CheckGameOverMessage;
import message.CheckIfWonMessage;
import message.DownButtonMessage;
import message.FoodCheckMessage;
import message.KeyPressed;
import message.LeftButtonMessage;
import message.Message;
import message.MoveSnakeMessage;
import message.RightButtonMessage;
import message.UpButtonMessage;
import model.Valve;

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

	
	int counter;
	Integer foodImagexPosition;
	Integer foodImageyPosition;
	
	ArrayList<Integer> xPositions;
	ArrayList<Integer> yPositions;
	BlockingQueue queue; 
	Timer timer;
	KeyPressed key;
	Image blockImage;
	Image foodImage;
	Image threeImage;
	Image twoImage;
	Image oneImage;
	Image gameOverImage;
	boolean gameOver;
	Image youWinImage;
	boolean youWin;
	
	
	/**
	 * @throws IOException 
	 * Default constructor which takes the blocking queue.
	 */
	public PlayPanel(BlockingQueue<Message> queue) throws IOException {
		// TODO Auto-generated constructor stub
		
		counter = 0;
		gameOver = false;
		youWin = false;
		
		blockImage = ImageIO.read(new File("././blackBlock.png"));
		blockImage = blockImage.getScaledInstance(10,10, Image.SCALE_DEFAULT);
		
		foodImage = ImageIO.read(new File("././Food.png"));
		foodImage = foodImage.getScaledInstance(9,9, Image.SCALE_DEFAULT);
		
		threeImage =  ImageIO.read(new File("././3.jpg"));
		threeImage = threeImage.getScaledInstance(297,297, Image.SCALE_DEFAULT);	
		
		
		twoImage =  ImageIO.read(new File("././2.jpg"));
		twoImage = 	twoImage.getScaledInstance(297,297, Image.SCALE_DEFAULT);
		
		oneImage =  ImageIO.read(new File("././1.jpg"));
		oneImage = 	oneImage.getScaledInstance(297,297, Image.SCALE_DEFAULT);
		
		
		gameOverImage = ImageIO.read(new File("././Game_Over.jpg"));
		gameOverImage = gameOverImage.getScaledInstance(297,297, Image.SCALE_DEFAULT);
		
		youWinImage = ImageIO.read(new File("././youWin.jpeg"));
		youWinImage = youWinImage.getScaledInstance(297,297, Image.SCALE_DEFAULT);
		
		
		this.setBackground(new java.awt.Color(153, 204, 153));
		this.setPreferredSize(new Dimension(297,297));	
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
		
		
		if(counter < 6)
		{	
			counter++;
		}
		else if(counter >6 && counter < 13)
		{
			counter++;
		}
		else if( counter > 13 && counter < 20)
        {
			counter++;
        }
		else
		{
		
		CheckIfWonMessage ifWon = new CheckIfWonMessage();
		
		try {
			queue.put(ifWon);
		} catch (InterruptedException e4) {
			// TODO Auto-generated catch block
			e4.printStackTrace();
		}
			
			
			
		CheckGameOverMessage checkGameOver = new CheckGameOverMessage();

		
		try {
			queue.put(checkGameOver);
		} catch (InterruptedException e3) {
			// TODO Auto-generated catch block
			e3.printStackTrace();
		}
		
		
		
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
		
		
	    counter++;
	    repaint();
		}
		
		
		
	}
	
	
	
	
	
	
	/* (non-Javadoc)
	 * @see javax.swing.JComponent#paintComponent(java.awt.Graphics)
	 */
	@Override
	public void paintComponent(Graphics g) {
        super.paintComponent(g);
     
        if(!gameOver && ! youWin)
		{
        if(counter < 6)
        {
        	g.drawImage(threeImage, 0, 0, this);
        	
        }
        else if(counter >6 && counter < 13)
        {
        	g.drawImage(twoImage, 0, 0, this);
        }
        else if( counter > 13 && counter < 20)
        {
        	g.drawImage(oneImage, 0, 0, this);
        }
        
        else
        {
        g.drawImage(foodImage, this.foodImagexPosition, this.foodImageyPosition, this);
        
        for(int i =0; i< xPositions.size() ; i++)
        {
        	g.drawImage(blockImage, xPositions.get(i), yPositions.get(i), this);
        }
        
        
        }
		}
        else if(gameOver == true)
        {
        	g.drawImage(gameOverImage, 0, 0, this);
        }
        else 
        {
        	g.drawImage(youWinImage, 0, 0, this);
        }
        
    }

	
	
	
	
	/**
	 * @return the youWin
	 */
	public boolean isYouWin() {
		return youWin;
	}


	/**
	 * @param youWin the youWin to set
	 */
	public void setYouWin(boolean youWin) {
		this.youWin = youWin;
	}


	/**
	 * @return the gameOver
	 */
	public boolean isGameOver() {
		return gameOver;
	}


	/**
	 * @param gameOver the gameOver to set
	 */
	public void setGameOver(boolean gameOver) {
		this.gameOver = gameOver;
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




	


	/**
	 * Updates the postion of the snake based on the arraylis i.e.
	 * @param getxPositions
	 * @param getyPositions
	 */
	public void updatePositions(ArrayList<Integer> getxPositions, ArrayList<Integer> getyPositions) {
		// TODO Auto-generated method stub
		
		this.xPositions = getxPositions;
		this.yPositions = getyPositions;
	}


	/**
	 * Sets the left key so that the snake can go in the left direction.
	 */
	public void setLeftKey() {
		// TODO Auto-generated method stub
		
		if(key != KeyPressed.RIGHT  && counter > 20)
			key = KeyPressed.LEFT;
		
    	//System.out.println("Pressed");
			
	}
	
	/**
	 * Sets the right key so that the snake can go in the right direction.
	 */
	public void setRightKey() {
		
		if(key != KeyPressed.LEFT && counter > 20)
			key = KeyPressed.RIGHT;
		
	}
	
	/**
	 * Sets the down key so that the snake can go in the down direction.
	 */
	public void setDownKey() {
		
		if(key != KeyPressed.UP && counter > 20) 
			key = KeyPressed.DOWN;
		
	}

	
	/**
	 * Sets the up key so that the snake can go in the up direction.
	 */
	public void setUpKey() {
		
		if(key != KeyPressed.DOWN && counter > 20)
			key = KeyPressed.UP;
		
	}

	

}

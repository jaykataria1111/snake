/**
 * 
 */
package View;

import Model.Valve;
import message.DownButtonMessage;
import message.KeyPressed;
import message.LeftButtonMessage;
import message.Message;
import message.MoveSnakeMessage;
import message.RightButtonMessage;
import message.UpButtonMessage;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.BlockingQueue;

import javax.swing.JPanel;
import javax.swing.Timer;

import Controller.ValveResponse;

/**
 * @author jay
 *
 */
public class PlayPanel extends JPanel  implements Valve,ActionListener{

	BlockingQueue queue; 
	Timer timer;
	KeyPressed key;
	/**
	 * 
	 */
	public PlayPanel(BlockingQueue<Message> queue) {
		// TODO Auto-generated constructor stub
		
		this.setBackground(new java.awt.Color(153, 204, 153));
		this.setPreferredSize(new Dimension(300,300));	
		this.setVisible(true);
		timer = new Timer(150,this);
		timer.start();
		this.queue = queue;
		key = KeyPressed.RIGHT;
		
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		MoveSnakeMessage msg = new MoveSnakeMessage(key);
	    try {
			queue.put(msg);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
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




	@Override
	public ValveResponse execute(Message message) {
		// TODO Auto-generated method stub
		
		
		
		
		if(!(message instanceof LeftButtonMessage) || !(message instanceof RightButtonMessage) || !(message instanceof UpButtonMessage) || !(message instanceof DownButtonMessage) )
			return ValveResponse.MISS;
		
		
		
		 if (message instanceof LeftButtonMessage)  {
	            
	        	key = KeyPressed.LEFT;
	        	//System.out.println("Pressed");
	        
	        }

	        if(message instanceof RightButtonMessage) {
	           
	        	key = KeyPressed.RIGHT;
	        	//System.out.println("Pressed");
	        }

	       
		
		
		
		
		
		return ValveResponse.EXECUTED;
	}




	

}

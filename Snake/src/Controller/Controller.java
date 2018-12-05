/**
 * 
 */
package Controller;

import java.awt.List;
import java.util.LinkedList;
import java.util.concurrent.BlockingQueue;

import Model.Model;
import View.View;

import message.Message;




enum ValveResponse
{
 MISS,
 EXECUTED,
 FINISH
};



/**
 * @author Jay, Nithil, Kaushal
 * THe following class is the controller class which controls the flow of the program.
 *
 */
public class Controller {
	
	
	Model model;
	View view;
	private BlockingQueue<Message> messageQueue;
	
	

	

	/**
	 * 
	 */
	public Controller(View view,Model model,BlockingQueue<Message> queue) {
		// TODO Auto-generated constructor stub
		this.view = view;
		this.model = model;
		this.messageQueue = queue;
		
	}
	
	
		public void mainLoop() throws Exception{ 
			
			ValveResponse response = ValveResponse.EXECUTED; 
			Message message = null;
		
		while(response != ValveResponse.FINISH){
		 try{
			 
	
		message = (Message) messageQueue.take(); 
		}
		
		 catch(InterruptedException e){
		  e.printStackTrace();
		
		}
		 
		}
		
		}
	
	/**
	 * Updates each frame of the snake and food, basically the game.
	 */
	public void updateFrame()
	{}
	
	/**
	 * Starts the game.
	 */
	public void startGame()
	{
		
	}
	
	
	/**
	 * Gets the input of the Game.
	 */
	public void getInput()
	{
		
	}
	
	
	
	public static void main(String[] args)
	{
		
		view = View.init(queue);	
		model = new Model();
		Controller game = new Controller(view,model, queue); game.mainLoop();
		view.dispose();
		queue.clear();
		
	}
	
	
	
	
	

}

/**
 * 
 */
package Controller;

import java.util.concurrent.BlockingQueue;

import Model.Model;
import View.View;

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
	public Controller() {
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * Represents the mainloop of the game.
	 */
	public void mainloop()
	{
		
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

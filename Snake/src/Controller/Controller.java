/**
 * 
 */
package Controller;

import java.awt.List;
import java.util.LinkedList;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import View.View;
import message.CheckGameOverMessage;
import message.CheckIfWonMessage;
import message.DownButtonMessage;
import message.FoodCheckMessage;
import message.LeftButtonMessage;
import message.Message;
import message.MoveSnakeMessage;
import message.RightButtonMessage;
import message.UpButtonMessage;
import model.Model;
import model.Valve;
import Controller.*;

/**
 * @author Jay, Nithil, Kaushal
 * THe following class is the controller class which controls the flow of the program.
 *
 */

/**
 * @author jay
 *
 */
public class Controller {
	
	
	Model model;
	View view;
	private BlockingQueue<Message> messageQueue;
	
	private LinkedList<Valve> valves = new LinkedList<Valve>();
	

	

	
	/**
	 * The default constructor where the normal a
	 * @param view is the view class
	 * @param model is the model class 
	 * @param queue is the static data structure with messages
	 */
	public Controller(View view,Model model,BlockingQueue<Message> queue) {
		// TODO Auto-generated constructor stub
		this.view = view;
		this.model = model;
		this.messageQueue = queue;
		
		addValves(valves);
		
	}
	
	
	
	
		/**
		 * Adds all the available valves to the linked list of valves
		 * @param valves2 is the linked list in which one would wan to insert the valves.
		 */
		private void addValves(LinkedList<Valve> valves2) {
		// TODO Auto-generated method stub
		
			valves2.add(new LeftButtonValve());
			valves2.add(new RightButtonValve());
			valves2.add(new DownButtonValve());
			valves2.add(new UpButtonValve());
			valves2.add(new FoodCheckValve());
			valves2.add(new MoveSnakeValve());
			valves2.add(new CheckGameOverValve());
			valves2.add(new CheckIfWonValve());
			
			
			
	}


		/**
		 * Is the main loop of the game this is the point where the game decides whether everything is working, i.e. communication center of the game.
		 * @throws Exception
		 */
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
		
		
			for(Valve valve : valves)
			{
				
			
			response = valve.execute(message);
			
			if(response != ValveResponse.MISS)
			{
				//System.out.println("Breaking");
				break;
			}
			 
			}
		
		 
		
		 
		 //System.out.println(messageQueue.size());
		 
		}
		
		
		}
	
	
	
	
	

	
	
	
	/**
	 * The following class implements a leftButton valve i.e. when a left button is pressed the following valve acts accordingly.
	 * @author jay
	 *
	 */
	private class LeftButtonValve implements Valve{

		@Override
		public ValveResponse execute(Message message) {
			// TODO Auto-generated method stub
			
			if(!(message instanceof LeftButtonMessage))
			return ValveResponse.MISS;
			
			
			
			view.getPlayPanel().setLeftKey();
			
			
			return ValveResponse.EXECUTED;
		}
		
	}
	
	
	/**
	 * The following class implements a right Button valve i.e. when a right button is pressed the following valve acts accordingly.
	 * @author jay
	 *
	 */
	private class RightButtonValve implements Valve{

		@Override
		public ValveResponse execute(Message message) {
			// TODO Auto-generated method stub
			
			if(!(message instanceof RightButtonMessage))
			return ValveResponse.MISS;
			
			
			
			view.getPlayPanel().setRightKey();
			
			
			return ValveResponse.EXECUTED;
		}
		
	}
	
	
	/**
	 * The following class implements a Up Button valve i.e. when UP button is pressed the following valve acts accordingly.
	 * @author jay
	 *
	 */
	private class UpButtonValve implements Valve{

		@Override
		public ValveResponse execute(Message message) {
			// TODO Auto-generated method stub
			
			if(!(message instanceof UpButtonMessage))
			return ValveResponse.MISS;
			
			
			
			view.getPlayPanel().setUpKey();
			
			
			return ValveResponse.EXECUTED;
		}
		
	}
	
	
	/**
	 * The following class implements a Down Button valve i.e. when Down button is pressed the following valve acts accordingly.
	 * @author jay
	 *
	 */
	private class DownButtonValve implements Valve{

		@Override
		public ValveResponse execute(Message message) {
			// TODO Auto-generated method stub
			
			if(!(message instanceof DownButtonMessage))
			return ValveResponse.MISS;
			
			
			
			view.getPlayPanel().setDownKey();
			
			
			return ValveResponse.EXECUTED;
		}
		
	}
	
	
	
	
	/**
	 * Moves a snake when a the message is called.
	 * @author jay
	 *
	 */
	private class MoveSnakeValve implements Valve{

		@Override
		public ValveResponse execute(Message message) {
			// TODO Auto-generated method stub
			if(!(message instanceof MoveSnakeMessage))
			return ValveResponse.MISS;
			
			MoveSnakeMessage msg = (MoveSnakeMessage) message;
			
			model.getSnake().moveSnake(msg.getKey());
			
			view.getPlayPanel().updatePositions(model.getSnake().getxPositions(),model.getSnake().getyPositions());
			
			//view.getPlayPanel().repaint();
			return ValveResponse.EXECUTED;
		}
		
		
	}
	
	
	/**
	 * Checks if the snake has eaten the food when the valve is called.
	 * @author jay
	 *
	 */
	
	private class FoodCheckValve implements Valve{

		@Override
		public ValveResponse execute(Message message) {
			// TODO Auto-generated method stub
			if(!(message instanceof FoodCheckMessage))
				return ValveResponse.MISS;
			
			model.processFood();
			view.getPlayPanel().setFoodImagexPosition(model.getFoodxPosition());
			view.getPlayPanel().setFoodImageyPosition(model.getFoodyPosition());
			
			return ValveResponse.EXECUTED;
		}
		
	}
	
	
	
	/**
	 * Checks if the Game is over.
	 * @author jay
	 *
	 */
	private class CheckGameOverValve implements Valve{

		@Override
		public ValveResponse execute(Message message) {
			// TODO Auto-generated method stub
			if(!(message instanceof CheckGameOverMessage))
				return ValveResponse.MISS;
			
			if(model.gameOver())
			{
				view.getPlayPanel().setGameOver(true);
			return ValveResponse.FINISH;
			}
			
			
			return ValveResponse.EXECUTED;
		}
		
		
	}
	
	
	/**
	 * Checks if the player won the game.
	 * @author jay
	 *
	 */
	private class CheckIfWonValve implements Valve{

		@Override
		public ValveResponse execute(Message message) {
			
			if(!(message instanceof CheckIfWonMessage))
				return ValveResponse.MISS;
			
			
			if(model.ifWon())
			{
				view.getPlayPanel().setYouWin(true);
				return ValveResponse.FINISH;
			}
			
			return ValveResponse.EXECUTED;
		}
		
		
	}
	
	
	

	
	
	

}

/**
 * 
 */
package Controller;

import java.awt.List;
import java.util.LinkedList;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import Model.Model;
import View.View;
import message.DownButtonMessage;
import message.FoodCheckMessage;
import message.LeftButtonMessage;
import message.Message;
import message.MoveSnakeMessage;
import message.RightButtonMessage;
import message.UpButtonMessage;
import Controller.*;

import Model.Valve;

/**
 * @author Jay, Nithil, Kaushal
 * THe following class is the controller class which controls the flow of the program.
 *
 */
public class Controller {
	
	
	Model model;
	View view;
	private BlockingQueue<Message> messageQueue;
	
	private LinkedList<Valve> valves = new LinkedList<Valve>();
	

	

	/**
	 * 
	 */
	public Controller(View view,Model model,BlockingQueue<Message> queue) {
		// TODO Auto-generated constructor stub
		this.view = view;
		this.model = model;
		this.messageQueue = queue;
		
		addValves(valves);
		
	}
	
	
		private void addValves(LinkedList<Valve> valves2) {
		// TODO Auto-generated method stub
		
			valves2.add(new LeftButtonValve());
			valves2.add(new RightButtonValve());
			valves2.add(new DownButtonValve());
			valves2.add(new UpButtonValve());
			valves2.add(new FoodCheckValve());
			valves2.add(new MoveSnakeValve());
			
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
		
		

			for(Valve valve : valves)
			{
				
			
			response = valve.execute(message);
			
			if(response != ValveResponse.MISS)
			{
				//System.out.println("Breaking");
				break;
			}
			 
			}

		for(Valve valve : valves)
		{
			response = valve.execute(message);
		if(response != ValveResponse.MISS) 
			break;
		 
		}
		
		 

		
		 
		
		 
		 //System.out.println(messageQueue.size());
		 
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
	
	
	
	public static void main(String[] args) throws Exception
	{
		
		BlockingQueue<Message> queue = new LinkedBlockingQueue<Message>();
		View gameView = new View(queue);
		Model mod = new Model(queue);
		Controller mainGame = new Controller(gameView,mod, queue); 
		mainGame.mainLoop();
		
		
		
	}
	
	
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
	
	private class MoveSnakeValve implements Valve{

		@Override
		public ValveResponse execute(Message message) {
			// TODO Auto-generated method stub
			if(!(message instanceof MoveSnakeMessage))
			return ValveResponse.MISS;
			
			MoveSnakeMessage msg = (MoveSnakeMessage) message;
			
			try {
				model.getSnake().moveSnake(msg.getKey());
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			view.getPlayPanel().updatePositions(model.getSnake().getxPositions(),model.getSnake().getyPositions());
			
			//view.getPlayPanel().repaint();
			return ValveResponse.EXECUTED;
		}
		
		
	}
	
	
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
	
	
	
	
	

	
	
	

}

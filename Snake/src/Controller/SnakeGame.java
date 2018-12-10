/**
 * 
 */
package Controller;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import View.View;
import message.Message;
import model.Model;
/**
 * @author jay, nithil, kaushal
 * Represents the main game.
 */
public class SnakeGame {
	public static void main(String[] args) throws Exception
	{	
		BlockingQueue<Message> queue = new LinkedBlockingQueue<Message>();
		View gameView = new View(queue);
		Model mod = new Model();
		Controller mainGame = new Controller(gameView,mod, queue); 
		mainGame.mainLoop();	
	}

}

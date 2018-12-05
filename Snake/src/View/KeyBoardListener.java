/**
 * 
 */
package View;

import message.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.concurrent.BlockingQueue;

/**
 * @author jay
 *
 */
public class KeyBoardListener implements KeyListener {

	
	BlockingQueue<Message> queue;
	/**
	 * 
	 */
	public KeyBoardListener(BlockingQueue<Message> queue) {
		// TODO Auto-generated constructor stub
		this.queue = queue;
		
	}

	/* (non-Javadoc)
	 * @see java.awt.event.KeyListener#keyTyped(java.awt.event.KeyEvent)
	 */
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see java.awt.event.KeyListener#keyPressed(java.awt.event.KeyEvent)
	 */
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
		int keya = e.getKeyCode();

        if (keya == KeyEvent.VK_LEFT )  {
            
        	try {
				queue.put(new LeftButtonMessage());
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
        
        }

        if(keya == KeyEvent.VK_RIGHT ) {

        	try {
				queue.put(new RightButtonMessage());
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
        	
        }

        if (keya == KeyEvent.VK_UP  )  {
        	try {
				queue.put(new UpButtonMessage());
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
        	
        }

        if (keya == KeyEvent.VK_DOWN ) {
        	try {
				queue.put(new DownButtonMessage());
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
        	
        }

	}

	/* (non-Javadoc)
	 * @see java.awt.event.KeyListener#keyReleased(java.awt.event.KeyEvent)
	 */
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

}

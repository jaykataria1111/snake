/**
 * 
 */
package Model;

import java.util.ArrayList;
import java.util.Stack;

import Controller.ValveResponse;
import message.DownButtonMessage;
import message.KeyPressed;
import message.LeftButtonMessage;
import message.Message;
import message.MoveSnakeMessage;
import message.RightButtonMessage;
import message.UpButtonMessage;








/**
 * THe following class represents the snake on the screen.
 * @author Jay, Nithil, Kaushal
 *
 */
public class Snake implements Valve{


	int snakeLength;
	ArrayList<Block> snakeBlock;
	Position pos;
	public static final int BLOCK_SPACE = 1;
	
    
	/**
	 * @throws IOException 
	 * 
	 */
	public Snake(Position pos,int snakeLength) {

		this.pos = pos;
		this.snakeLength = snakeLength;
		this.snakeBlock = new ArrayList<Block>();
		for(int i=0;i<snakeLength;i++)
		{
			addBlockToSnake();
		}
	}


	public void addBlockToSnake() 
	{
		if(snakeBlock.isEmpty())
		{
			snakeBlock.add(new Block(this.pos));
		}
		else
		{
			Position p = new Position(snakeBlock.get(snakeBlock.size()-1).getPos().getxPos(),snakeBlock.get(snakeBlock.size()-1).getPos().getyPos());
			int xpos  = p.getxPos() - Block.BLOCKSIZE - BLOCK_SPACE ;
			p.setxPos(xpos);
			snakeBlock.add(new Block(p));

		}
	}


	public void addBlock() 
	{
		
		
		int changeInX = snakeBlock.get(snakeBlock.size()-2).getPos().getxPos() - snakeBlock.get(snakeBlock.size()-1).getPos().getxPos();
		int changeInY = snakeBlock.get(snakeBlock.size()-2).getPos().getyPos() - snakeBlock.get(snakeBlock.size()-1).getPos().getyPos();

		if(changeInX > 0)
		{
			Position p = new Position(snakeBlock.get(snakeBlock.size()-1).getPos().getxPos(),snakeBlock.get(snakeBlock.size()-1).getPos().getyPos());
			int ypos  = p.getyPos() - Block.BLOCKSIZE - BLOCK_SPACE ;
			p.setxPos(ypos);
			snakeBlock.add(new Block(p));


		}
		else if(changeInX < 0)
		{
			Position p = new Position(snakeBlock.get(snakeBlock.size()-1).getPos().getxPos(),snakeBlock.get(snakeBlock.size()-1).getPos().getyPos());
			int ypos  = p.getyPos() + Block.BLOCKSIZE + BLOCK_SPACE ;
			p.setxPos(ypos);
			snakeBlock.add(new Block(p));

		}
		else if(changeInY > 0 )
		{
			Position p = new Position(snakeBlock.get(snakeBlock.size()-1).getPos().getxPos(),snakeBlock.get(snakeBlock.size()-1).getPos().getyPos());
			int xpos  = p.getxPos() - Block.BLOCKSIZE - BLOCK_SPACE ;
			p.setxPos(xpos);
			snakeBlock.add(new Block(p));

		}
		else
		{
			Position p = new Position(snakeBlock.get(snakeBlock.size()-1).getPos().getxPos(),snakeBlock.get(snakeBlock.size()-1).getPos().getyPos());
			int xpos  = p.getxPos()  + Block.BLOCKSIZE + BLOCK_SPACE;
			p.setxPos(xpos);
			snakeBlock.add(new Block(p));
		}


	}














	public void moveSnake(KeyPressed key)
	{

		Position current;
		Position previous = new Position(snakeBlock.get(0).getPos());

		for(int i=1;i<snakeBlock.size();i++)
		{

			current = new Position(snakeBlock.get(i).getPos());

			snakeBlock.get(i).setPos(previous);

			previous = new Position(current);

		}


		if(key == KeyPressed.LEFT )
		{
			Position p = new Position(snakeBlock.get(0).getPos());
			p.setxPos(p.getxPos() - Block.BLOCKSIZE - BLOCK_SPACE);
			if(p.getxPos()<0)
			{
				p.setxPos(297-p.getxPos());
			}

			snakeBlock.get(0).setPos(p);

		}

		if(key == KeyPressed.RIGHT)
		{
			Position p = new Position(snakeBlock.get(0).getPos());
			p.setxPos(p.getxPos()+ Block.BLOCKSIZE + BLOCK_SPACE);
			if(p.getxPos()>297)
			{
				p.setxPos(p.getxPos()-308);
			}
			
			snakeBlock.get(0).setPos(p);

		}

		if(key == KeyPressed.UP )
		{
			Position p = new Position(snakeBlock.get(0).getPos());
			p.setyPos(p.getyPos() - Block.BLOCKSIZE - BLOCK_SPACE);
			if(p.getyPos()<0)
			{
				p.setyPos(297-p.getyPos());
			}
			snakeBlock.get(0).setPos(p);
		}

		if(key == KeyPressed.DOWN )
		{
			Position p = new Position(snakeBlock.get(0).getPos() );
			p.setyPos(p.getyPos()+ Block.BLOCKSIZE + BLOCK_SPACE);
			if(p.getyPos()>297)
			{
				p.setyPos(p.getyPos()-308);
			}
			snakeBlock.get(0).setPos(p);
		}




	}

	
	public Position getHeadPosition()
	{
		return snakeBlock.get(0).getPos();
	}
	
	
	public int getMaxX()
	{
		return  snakeBlock.get(0).getPos().getxPos()+ Block.BLOCKSIZE;
	}
	
	public int getMaxY()
	{
		return snakeBlock.get(0).getPos().getyPos()+ Block.BLOCKSIZE;
	}




	/**
	 * @return the snakeLength
	 */
	public int getSnakeLength() {
		return snakeLength;
	}


	/**
	 * @param snakeLength the snakeLength to set
	 */
	public void setSnakeLength(int snakeLength) {
		this.snakeLength = snakeLength;
	}


	/**
	 * @return the snakeBlock
	 */
	public ArrayList<Block> getSnakeBlock() {
		return snakeBlock;
	}


	/**
	 * @param snakeBlock the snakeBlock to set
	 */
	public void setSnakeBlock(ArrayList<Block> snakeBlock) {
		this.snakeBlock = snakeBlock;
	}


	/**
	 * @return the pos
	 */
	public Position getPos() {
		return pos;
	}


	/**
	 * @param pos the pos to set
	 */
	public void setPos(Position pos) {
		this.pos = pos;
	}


	@Override
	public ValveResponse execute(Message message) {
		// TODO Auto-generated method stub
		
		if(!(message instanceof MoveSnakeMessage))
		return ValveResponse.MISS;
		
		
		MoveSnakeMessage msg = (MoveSnakeMessage) message;
		
		this.moveSnake(msg.getKey());
		
		
		return ValveResponse.EXECUTED;

	}





}


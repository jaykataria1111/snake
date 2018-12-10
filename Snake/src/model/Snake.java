/**
 * 
 */
package model;

import java.util.ArrayList;
import java.util.Stack;
import java.util.concurrent.BlockingQueue;

import Controller.ValveResponse;
import message.DownButtonMessage;
import message.KeyPressed;
import message.LeftButtonMessage;
import message.Message;
import message.MoveSnakeMessage;
import message.RightButtonMessage;
import message.UpButtonMessage;


import message.*;





/**
 * The following class represents the snake on the screen.
 * @author Jay, Nithil, Kaushal
 *
 */
public class Snake {

	
	int snakeLength;
	ArrayList<Block> snakeBlock;
	Position pos;
	public static final int BLOCK_SPACE = 1;
	
    
	/**
	 * @throws IOException 
	 * Default counstructor for snake.
	 * @param pos is the snakes starting position
	 * @param snakeLength is the length of the snake.
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


	/**
	 * Adds a new block to the snake.
	 */
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


	/**
	 * helps the main add block method.
	 */
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




	
	/**
	 * Gets all the xPositions in the Snake Class
	 * @return returns all the x Positions.
	 */
	public ArrayList<Integer> getxPositions()
	{
		ArrayList<Integer> positions = new ArrayList<Integer>();
		
		for(Block clk : snakeBlock)
		{
			positions.add(clk.getPos().getxPos());
		}
		
		return positions;
	}


	/**
	 * Gets all the yPositions in the Snake Class
	 * @return returns all the y Positions.
	 */
	public ArrayList<Integer> getyPositions()
	{
		ArrayList<Integer> positions = new ArrayList<Integer>();
		
		for(Block clk : snakeBlock)
		{
			positions.add(clk.getPos().getyPos());
		}
		
		return positions;
	}



	/**
	 * moves the snake according to the enum by 1 step.
	 */
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
			

			snakeBlock.get(0).setPos(p);

		}

		if(key == KeyPressed.RIGHT)
		{
			Position p = new Position(snakeBlock.get(0).getPos());
			p.setxPos(p.getxPos()+ Block.BLOCKSIZE + BLOCK_SPACE);
			
			
			snakeBlock.get(0).setPos(p);

		}

		if(key == KeyPressed.UP )
		{
			Position p = new Position(snakeBlock.get(0).getPos());
			p.setyPos(p.getyPos() - Block.BLOCKSIZE - BLOCK_SPACE);
			
			snakeBlock.get(0).setPos(p);
		}

		if(key == KeyPressed.DOWN )
		{
			Position p = new Position(snakeBlock.get(0).getPos() );
			p.setyPos(p.getyPos()+ Block.BLOCKSIZE + BLOCK_SPACE);
			
			snakeBlock.get(0).setPos(p);
		}


	}

	
	/**
	 * Gets the Position of the head of the snake.
	 * @return the position of the head of the snake.
	 */
	public Position getHeadPosition()
	{
		return snakeBlock.get(0).getPos();
	}
	
	/**
	 * Gets how much maximum a block can go!
	 * @return the maximum amount that the block can go.
	 */
	public int getMaxX()
	{
		return  snakeBlock.get(0).getPos().getxPos()+ Block.BLOCKSIZE;
	}
	
	public int getMaxY()
	{
		return snakeBlock.get(0).getPos().getyPos()+ Block.BLOCKSIZE;
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


	

	





}


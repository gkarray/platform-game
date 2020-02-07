package platform.game;

import platform.util.Box;
import platform.util.Vector;
import platform.util.Input;
import platform.util.Sprite;
import platform.util.Output;

/**
 * Simple solid actor that does nothing.
 */
public class Block extends Actor 
{
   // TO BE COMPLETED
	private Box box ;
	private Sprite sprite ;
	
	public Block(Vector ext1, Vector ext2, Sprite s)
	{
		sprite = s ;
		box = new Box(ext1,ext2) ;
	}
	
	public Block(Box box2, Sprite sprite2) 
	{
		sprite = sprite2 ;
		box = box2 ;
	}
	
	public Block(Box box1)
	{
		box = box1;
	}

	public void draw (Input input, Output output)
	{
		if(sprite == null)
			super.draw(input, output);
		else
			output.drawSprite(sprite, getBox());
	}
	
	public int getPriority()
	{
		return 0;
	}
	
	public boolean isSolid() 
	{
		return true ;
	}
	
	public Box getBox()
	{
		return box ;
	}
}

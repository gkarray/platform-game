package platform.game;

import platform.util.Box;
import platform.util.Input;
import platform.util.Output;
import platform.util.Sprite;

public class Background extends Actor 
{
	private Sprite sprite ;
	private Box box ;
	private double angle ;
	
	public Background(Box b, Sprite s)
	{
		sprite = s;
		box = b ;
		angle = 0 ;
	}
	
	public Background(Box b, Sprite s, double a)
	{
		this(b,s) ;
		angle = a ;
	}
	
	public void draw(Input input, Output output)
	{
		super.draw(input, output);
		output.drawSprite(sprite, getBox(), angle);
	}
	
	public Box getBox()
	{
		return box ;
	}
	
	@Override
	public int getPriority() 
	{
		// TODO Auto-generated method stub
		return -1;
	}

}

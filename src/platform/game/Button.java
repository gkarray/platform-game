package platform.game;

import platform.util.Box;
import platform.util.Input;
import platform.util.Output;
import platform.util.Vector;

public class Button extends Actor implements Signal
{
	private Vector position ;
	private boolean isPressed ;
	private boolean dynamic ;
	
	public Button(Vector pos)
	{
		isPressed = false ;
		position = pos ;
		dynamic = true ;
	}
	
	public Button(Vector pos, boolean d)
	{
		isPressed = false ;
		position = pos ;
		dynamic = d ;
	}
	
	
	@Override
	public int getPriority() 
	{
		// TODO Auto-generated method stub
		return 1000;
	}
	
	public void interact(Actor other)
	{
		super.interact(other);
		if (other instanceof Player && other.getBox().isColliding(getBox())) 
		{
			isPressed = true ;
		}
	}
	
	public void postUpdate(Input input)
	{
		super.postUpdate(input);
		if(dynamic)
		isPressed = false ;
	}
	
	public void draw(Input input, Output output)
	{
		super.draw(input, output);
		if(dynamic)
		{
		if(isActive())
			output.drawSprite(getSprite("button.pressed"), getBox());
		else
			output.drawSprite(getSprite("button"), getBox());
		}
		else
		{
			if(isActive())
				output.drawSprite(getSprite("button.pressed.nondynamic"), getBox());
			else
				output.drawSprite(getSprite("button.nondynamic"), getBox());
		}
	}
	
	public Box getBox()
	{
		return new Box(position, 0.5,0.5) ;
	}
	
	public boolean isActive()
	{
		return isPressed; 
	}

}

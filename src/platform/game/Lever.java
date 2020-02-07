package platform.game;

import platform.util.Box;
import platform.util.Input;
import platform.util.Output;
import platform.util.Vector;

public class Lever extends Actor implements Signal
{
	private Vector position ;
	private boolean value ;
	private double timer ;
	private double period;
	
	public Lever(Vector pos, double per)
	{
		value = false ;
		position = pos;
		timer = 0 ;
		period = per ;
	}
	
	public Box getBox()
	{
		return new Box(position, 0.6,0.6) ;
	}
	
	public boolean isActive()
	{
		return value ;
	}
	
	public void draw(Input input, Output output)
	{
		super.draw(input, output);
		if(value)
			output.drawSprite(getSprite("lever.right"), getBox());
		else
			output.drawSprite(getSprite("lever.left"), getBox());
	}
	
	public void update(Input input)
	{
		super.update(input);
		if(timer > 0)
			timer = timer - input.getDeltaTime() ;
		else
			value = false ;
	}
	
	public void interact(Actor other)
	{
		if (other.isSolid ()) 
		{
			Vector delta = other.getBox ().getCollision(getBox ()) ;
			if (delta != null)
			{
				position = position.add(delta) ;
			}
		}
	}
	
	public boolean hurt(Actor instigator , Damage type , double amount , Vector location) 
	{
		switch(type)
		{
		case ACTIVATION :
			value = !value ;
			if(value)
				timer = period ;
			else
				timer = 0 ;
			return true;
		default :
			return super.hurt(instigator, type, amount, location) ;
		}
	}
	
	@Override
	public int getPriority() 
	{
		// TODO Auto-generated method stub
		return 800;
	}

}

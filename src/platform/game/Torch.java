package platform.game;

import platform.util.Box;
import platform.util.Input;
import platform.util.Output;
import platform.util.Vector;

public class Torch extends Actor implements Signal
{
	private Box box ;
	private boolean lit ;
	private double variation ;
	
	public Torch(Vector position, boolean l)
	{
		box = new Box(position, 1, 1) ;
		lit = l ;
		variation = 0 ;
	}
	
	public void update(Input input)
	{
		super.update(input);
		variation -= input.getDeltaTime () ;
		if (variation < 0.0)
		variation = 0.6 ;
	}
	
	public void draw(Input input, Output output)
	{
		super.draw(input, output);
		if(lit)
		{
			String name = "torch.lit.1" ;
			if (variation < 0.3)
				name = "torch.lit.2" ;
			output.drawSprite(getSprite(name), box);
		}
		else
			output.drawSprite(getSprite("torch"), box);
	}
	
	public boolean hurt(Actor instigator , Damage type , double amount , Vector location)
	{
		switch(type)
		{
		case AIR :
			lit = false ;
			return true ;
		case FIRE :
			lit = true ;
			return true ;
		default :
			return super.hurt(instigator, type, amount, location) ;
		}
	}
	
	@Override
	public boolean isActive ()
	{
		return lit ;
	}
	
	public Box getBox()
	{
		return box ;
	}
	
	
	@Override
	public int getPriority() 
	{
		// TODO Auto-generated method stub
		return 34;
	}
}

package platform.game;

import platform.util.Box;
import platform.util.Input;
import platform.util.Output;
import platform.util.Vector;

public class Spike extends Actor 
{
	private Vector position ;
	private double cooldown ;
	
	public Spike(Vector pos)
	{
		position = pos ;
		cooldown = 0.5 ;
	}
	
	public void draw(Input input, Output output)
	{
		super.draw(input, output);
		output.drawSprite(getSprite("spikes"), getBox());
	}
	
	public Box getBox()
	{
		return new Box(position, 1, 0.5) ;
	}
	
	public void update(Input input)
	{
		super.update(input);
		if(cooldown > 0)
			cooldown = cooldown - input.getDeltaTime() ;
	}
	
	public void interact(Actor other)
	{
		super.interact(other);
		if(getBox().isColliding(other.getBox()) && cooldown <= 0)
		{
			if(other.hurt(this, Damage.PHYSICAL, 2, getPosition()))
				cooldown = 0.5 ;
		}
		if (other.isSolid ()) 
		{
			Vector delta = other.getBox ().getCollision(getBox ()) ;
			if (delta != null)
			{
				position = position.add(delta) ;
			}
		}
	}
	
	public boolean isSolid()
	{
		return true ;
	}
	
	@Override
	public int getPriority() 
	{
		// TODO Auto-generated method stub
		return 700;
	}

}

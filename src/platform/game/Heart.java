package platform.game;

import platform.util.Box;
import platform.util.Input;
import platform.util.Output;
import platform.util.Vector;

public class Heart extends Actor 
{
	private double cooldown ;
	private Vector position ;
	
	public Heart(Vector pos)
	{
		position = pos ;
		cooldown = 0 ;
	}
	
	public Box getBox()
	{
		return new Box(position, 0.5, 0.5) ;
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
		if(cooldown <= 0 && getBox ().isColliding(other.getBox ()) && other instanceof Player)
		{
			other.hurt(this, Damage.HEAL, 10, getPosition()) ;
			cooldown = 10 ;
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
	
	public void draw(Input input, Output output)
	{
		super.draw(input, output);
		if(cooldown <= 0)
			output.drawSprite(getSprite("heart.full"), getBox());
	}
	
	
	@Override
	public int getPriority() 
	{
		// TODO Auto-generated method stub
		return 999;
	}

}

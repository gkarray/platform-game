package platform.game;

import platform.util.Box;
import platform.util.Input;
import platform.util.Output;
import platform.util.Vector;

public class Star extends Actor 
{
	private Vector position ;
	
	public Star(Vector pos)
	{
		position = pos ;
	}
	
	public Box getBox()
	{
		return new Box(position,0.7,0.7);
	}
	
	public void draw(Input input, Output output)
	{
		super.draw(input, output);
		output.drawSprite(getSprite("star"), getBox());
	}
	
	public void interact(Actor other)
	{
		super.interact(other);
		if (other.isSolid ()) 
		{
			Vector delta = other.getBox ().getCollision(getBox ()) ;
			if (delta != null)
			{
				position = position.add(delta) ;
			}
		}
		if(other instanceof Player && other.getBox().isColliding(getBox()))
		{
			other.hurt(this, Damage.STAR, 0.0, position) ;
			getWorld().unregister(this);
		}
	}
	
	@Override
	public int getPriority() 
	{
		// TODO Auto-generated method stub
		return 999;
	}

}

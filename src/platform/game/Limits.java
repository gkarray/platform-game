package platform.game;

import platform.util.Box;
import platform.util.Vector;

public class Limits extends Actor 
{
	private Box box ;
	
	public Limits(Box b)
	{
		box = b ;
	}
	
	public Box getBox()
	{
		return box ;
	}
	
	public void interact(Actor other)
	{
		super.interact(other);
		if(!other.getBox().isColliding(getBox()))
		{
			other.hurt(this , Damage.VOID , Double.POSITIVE_INFINITY ,	Vector.ZERO) ;
		}
	}
	
	@Override
	public int getPriority() 
	{
		// TODO Auto-generated method stub
		return 1000;
	}

}

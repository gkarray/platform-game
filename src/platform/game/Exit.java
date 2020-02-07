package platform.game;

import platform.game.level.Level;
import platform.util.Box;
import platform.util.Input;
import platform.util.Output;
import platform.util.Vector;

public class Exit extends Actor 
{
	private Vector position ;
	private Level next ;
	private Signal signal ;
	private Signal signalDoor ;
	private Level otherNext ;
	private boolean dynamic ;
	
	public Exit(Vector pos, Level nex, Signal s)
	{
		position = pos ;
		next = nex ;
		signal = s ;
		dynamic = false ;
	}
	
	public Exit(Vector pos, Level nex, Level otherNex, Signal s, Signal signalDoo)
	{
		position = pos ;
		next = nex ;
		signal = s ;
		otherNext = otherNex ;
		signalDoor = signalDoo ;
		dynamic = true;
	}
	
	public void update(Input input)
	{
		super.update(input);
		if(dynamic)
		{
			if(signalDoor.isActive())
				next = otherNext ;
		}
	}
	
	public void draw(Input input, Output output)
	{
		super.draw(input, output);
		if(signal.isActive())
			output.drawSprite(getSprite("door.open"), getBox());
		else
			output.drawSprite(getSprite("door.closed"), getBox());
	}
	
	public Box getBox()
	{
		return new Box(position, 1, 1) ;
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
		if(other instanceof Player && signal.isActive() && other.getBox().isColliding(getBox()))
		{
			getWorld().nextLevel();
			getWorld().setNextLevel(next);
		}
	}
	
	
	
	@Override
	public int getPriority() 
	{
		// TODO Auto-generated method stub
		return 500;
	}

}

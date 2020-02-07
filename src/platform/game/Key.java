package platform.game;

import platform.util.Box;
import platform.util.Input;
import platform.util.Output;
import platform.util.Vector;

public class Key extends Actor implements Signal
{
	private Vector position ;
	private boolean taken ;
	private Colors couleur ;
	
	public Key(Vector pos, Colors coul)
	{
		taken = false ;
		position = pos ;
		couleur = coul ;
	}
	
	public boolean isActive()
	{
		return taken ;
	}
	
	public void update(Input input)
	{
		super.update(input);
		if(taken)
		{
			getWorld().unregister(this);
		}
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
			taken = true ;
		}
	}
	
	public void draw(Input input, Output output)
	{
		super.draw(input, output);
		switch(couleur)
		{
		case RED :
			output.drawSprite(getSprite("key.red"), getBox());
			break;
		case BLUE :
			output.drawSprite(getSprite("key.blue"), getBox());
			break;
		case GREEN :
			output.drawSprite(getSprite("key.green"), getBox());
			break;
		case YELLOW :
			output.drawSprite(getSprite("key.yellow"), getBox());
			break;
		}
	}
	
	public Box getBox()
	{
		return new Box(position, 0.7, 0.6) ;
	}
	
	@Override
	public int getPriority() 
	{
		// TODO Auto-generated method stub
		return 100;
	}

}

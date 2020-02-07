package platform.game;

import platform.util.Box;
import platform.util.Input;
import platform.util.Output;
import platform.util.Sprite;
import platform.util.Vector;

public class Sign extends Actor 
{
	private Vector position ;
	private Sprite sprite ;
	private boolean isActive ;
	
	public Sign(Vector pos, Sprite s)
	{
		position = pos ;
		sprite = s ;
		isActive = false ;
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
			isActive = true ;
	}
	
	public void postUpdate(Input input)
	{
		super.postUpdate(input);
		isActive = false ;
	}
	
	public Box getBox()
	{
		return new Box(position, 1,1) ;
	}
	
	public void draw(Input input, Output output)
	{
		super.draw(input, output);
		output.drawSprite(getSprite("sign"), getBox());
		if(isActive)
		{
			output.drawSprite(sprite, new Box(position.add(new Vector(0,4)), 12,4));
		}
	}
	
	@Override
	public int getPriority() 
	{
		// TODO Auto-generated method stub
		return 9000;
	}

}

package platform.game;

import platform.util.Box;
import platform.util.Input;
import platform.util.Output;
import platform.util.Vector;

public class Arrow extends Actor 
{
	private int direction ;
	private Vector position ;
	private Actor support ;
	private Vector velocity ;
	private Vector difference ;
	private double timer ;
	
	public Arrow(Vector pos, int dir)
	{
		position = pos ;
		direction = dir ;
		if(direction == 0)
		{
			velocity = new Vector(2,0);
		}
		if(direction == 1)
		{
			velocity = new Vector(0,2);
		}
		if(direction == 2)
		{
			velocity = new Vector(-2,0);
		}
		if(direction == 3)
		{
			velocity = new Vector(0,-2);
		}
		timer = 0 ;
	}
	
	public void update(Input input)
	{
		super.update(input);
		
		if(support != null)
		{
			position = support.getPosition().add(difference) ;
			timer = timer + input.getDeltaTime() ;
		}
		else
		{
			position = position.add(velocity.mul(input.getDeltaTime()));
		}
		if(timer >= 4)
		{
			getWorld().unregister(this);
		}
	}
	
	public void draw(Input input, Output output)
	{
		super.draw(input, output);
		if(direction == 0)
		{
			output.drawSprite(getSprite("arrow"), getBox(), 0);
		}
		if(direction == 1)
		{
			output.drawSprite(getSprite("arrow"), getBox(), Math.PI/2);
		}
		if(direction == 2)
		{
			output.drawSprite(getSprite("arrow"), getBox(), Math.PI);
		}
		if(direction == 3)
		{
			output.drawSprite(getSprite("arrow"), getBox(), 3*Math.PI/2);
		}
		
	}
	
	public void interact(Actor other)
	{
		super.interact(other);
		if(other.getBox().isColliding(getBox()) && (other.isSolid() || other instanceof Player) && support == null)
		{
			other.hurt(this, Damage.PHYSICAL, 1, position) ;
			velocity = Vector.ZERO ;
			support = other ;
			difference = position.add(support.getPosition().mul(-1)) ;
		}
	}
	
	public Box getBox()
	{
		return new Box(position, 0.8, 0.3) ;
	}
	
	@Override
	public int getPriority() 
	{
		// TODO Auto-generated method stub
		return 43;
	}

}

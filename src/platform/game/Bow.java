package platform.game;

import platform.util.Box;
import platform.util.Input;
import platform.util.Output;
import platform.util.Vector;

public class Bow extends Actor 
{
	private int direction ;
	private double cooldown ;
	private Vector position ;
	private double time ;
	
	public Bow(int dir, double cd, Vector pos)
	{
		direction = dir ;
		cooldown = cd ;
		position = pos ;
		time = cd ;
	}
	
	public Box getBox()
	{
		return new Box(position, 0.4, 1) ;
	}
	
	public void update(Input input)
	{
		super.update(input);
		if(time < cooldown)
			time = time + input.getDeltaTime() ;
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
	if(time >= cooldown)	
	{
		if(direction == 0)
		{
			if(other.getBox().isColliding(new Box(getBox().getMin(),getBox().getMax().add(new Vector(100,0)))) && (other instanceof Player))
			{
				Arrow arrow = new Arrow(position, direction) ;
				arrow.register(getWorld());
				getWorld().register(arrow);
				time = 0 ; 
			}
		}
		if(direction == 1)
		{
			if(other.getBox().isColliding(new Box(getBox().getMin(),getBox().getMax().add(new Vector(0,100)))) && other instanceof Player)
			{
				Arrow arrow = new Arrow(position, direction) ;
				arrow.register(getWorld());
				getWorld().register(arrow);
				time = 0 ;
			}
		}
		if(direction == 2)
		{
			if(other.getBox().isColliding(new Box(getBox().getMin().add(new Vector(-100,0)),getBox().getMax())) && other instanceof Player)
			{
				Arrow arrow = new Arrow(position, direction) ;
				arrow.register(getWorld());
				getWorld().register(arrow);
				time = 0 ;
			}
		}
		if(direction == 3)
		{
			if(other.getBox().isColliding(new Box(getBox().getMin().add(new Vector(0,-100)),getBox().getMax())) && other instanceof Player)
			{
				Arrow arrow = new Arrow(position, direction) ;
				arrow.register(getWorld());
				getWorld().register(arrow);
				time = 0 ;
			}
		}
	}
	}
	
	public void draw(Input input, Output output)
	{
		super.draw(input, output);
		if(direction == 0)
		{
			output.drawSprite(getSprite("bow"), getBox(), 0);
		}
		if(direction == 1)
		{
			output.drawSprite(getSprite("bow"), getBox(), Math.PI/2);
		}
		if(direction == 2)
		{
			output.drawSprite(getSprite("bow"), getBox(), Math.PI);
		}
		if(direction == 3)
		{
			output.drawSprite(getSprite("bow"), getBox(), 3*Math.PI/2);
		}
	}
	
	@Override
	public int getPriority() 
	{
		// TODO Auto-generated method stub
		return 1000;
	}

}

package platform.game;

import platform.util.Box;
import platform.util.Input;
import platform.util.Output;
import platform.util.Vector;

public class Bomb extends Actor 
{
	private double bounciness ;
	private Vector position ;
	private Vector velocity ;
	private double timer ;
	private double timer2 ;
	private boolean colliding ;
	
	public Bomb(Vector pos, Vector vel)
	{
		position = pos ;
		velocity = vel ;
		bounciness = 0.5 ;
		timer = 4 ;
		timer2 = 0;
	}
	
	public void interact(Actor other)
	{
		super.interact(other);
		if (other.isSolid()) 
		{
			Vector delta = other.getBox().getCollision(position) ;
			if (delta != null) 
			{
				position = position.add(delta) ;
				colliding= true ;
				velocity = velocity.mirrored(delta).mul(bounciness) ;
				if(bounciness > 0)
					bounciness = bounciness - 0.05 ;
			}
		}
	}
	
	public void preUpdate(Input input)
	{
		super.preUpdate(input);
		colliding = false ;
	}
	
	public void draw(Input input, Output output)
	{
		super.draw(input, output);
		if(timer2 < timer/2)
			output.drawSprite(getSprite("bomb"), getBox());
		else
			output.drawSprite(getSprite("bomb.white"), getBox());
	}
	
	public void update(Input input)
	{
		super.update(input);
		timer = timer - input.getDeltaTime() ;
		timer2 = timer2 + input.getDeltaTime() ;
		if(timer2 >= timer)
			timer2 = 0 ;
		if (colliding) 
		{
			double scale = Math.pow (0.001 , input.getDeltaTime ()) ;
			velocity = velocity.mul(scale) ;
		}
		velocity = velocity.add(this.getWorld().getGravity().mul(input.getDeltaTime())) ;
		position = position.add(velocity.mul(input.getDeltaTime())) ;
		if(timer <= 0)
		{
			getWorld().hurt(new Box(position,2.5,2.5), this, Damage.AIR, 5, position);
			getWorld().hurt(new Box(position,2.5,2.5), this, Damage.FIRE, 50, position);
			getWorld().register(new Particle(getSprite("smoke.gray.1"), position, 2, 5));
			getWorld().register(new Particle(getSprite("smoke.yellow.2"), position, 2.5, 5));
			getWorld().register(new Particle(getSprite("smoke.gray.3"), position, 3, 5));
			getWorld().unregister(this);
		}
	}
	
	public Box getBox()
	{
		return new Box(position, 0.5, 0.5) ;
	}
	
	@Override
	public int getPriority()
	{
		// TODO Auto-generated method stub
		return 2000;
	}

}

package platform.game;

import platform.util.* ;

public class Fireball extends Actor 
{
	private Vector position ;
	private Vector velocity ;
	public static double SIZE = 0.4 ;
	private Actor owner ;
	private double bounciness ;
	
	public Fireball(Vector pos, Vector vel, Actor ow)
	{
		if(pos == null || vel == null)
			throw new NullPointerException() ;
		position = pos ;
		velocity = vel;
		owner = ow ;
		bounciness = 1 ;
	}
	
	@Override
	public int getPriority() 
	{
		// TODO Auto-generated method stub
		return 666;
	}
	
	@Override
	public Box getBox() 
	{
		return new Box(position , SIZE, SIZE) ;
	}
	
	@Override
	public void interact(Actor other) 
	{
		super.interact(other) ;
		if (other != owner && other.getBox ().isColliding(getBox ())) 
		{
			if (other.hurt(this , Damage.FIRE , 1.0, getPosition ()))
			{
				getWorld().unregister(this);
			}
		}
		if (other.isSolid()) 
		{
			Vector delta = other.getBox().getCollision(position) ;
			if (delta != null) 
			{
				position = position.add(delta) ;
				velocity = velocity.mirrored(delta).mul(bounciness) ;
				if(bounciness > 0)
					bounciness = bounciness - 0.05 ;
				else
					getWorld().unregister(this);
			}
		}
	}
	
	@Override
	public void update(Input input)
	{
		super.update(input) ;
		double delta = input.getDeltaTime() ;
		velocity = velocity.add(this.getWorld().getGravity().mul(delta)) ;
		position = position.add(velocity.mul(delta)) ;
	}
	
	public void draw(Input input, Output output)
	{
		super.draw(input, output);
		output.drawSprite(getWorld().getLoader().getSprite("fireball") , getBox(), 25*input.getTime()) ;
	}
	

}

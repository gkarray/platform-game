package platform.game;

import platform.util.Box;
import platform.util.Input;
import platform.util.Output;
import platform.util.Vector;

public class Jumper extends Actor 
{
	private Vector position ;
	private double cooldown ;
	
	public Jumper(Vector pos)
	{
		position = pos ;
	}
	
	@Override
	public int getPriority() {
		// TODO Auto-generated method stub
		return 44;
	}
	
	public Box getBox() 
	{
		Box box = new Box(new Vector(position.getX()-0.5, position.getY()), new Vector(position.getX()+0.5, position.getY()+1)) ;
		return box;
	}
	
	public void draw(Input input , Output output) 
	{
		super.draw(input, output);
		if(cooldown > 0)
			output.drawSprite(getSprite("jumper.extended"), getBox());
		else
			output.drawSprite(getSprite("jumper.normal"), getBox());
	}
	
	@Override
	public void update(Input input) 
	{
		super.update(input) ;
		cooldown -= input.getDeltaTime () ;
	}
	@Override
	public void interact(Actor other) 
	{
		super.interact(other) ;
		if (cooldown <= 0 && getBox ().isColliding(other.getBox ())) 
		{
			Vector below = new Vector(position.getX(), position.getY () - 1.0) ;
			if (other.hurt(this , Damage.AIR , 10.0, below))
				cooldown = 0.5 ;
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
}

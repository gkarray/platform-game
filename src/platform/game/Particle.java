package platform.game;

import platform.util.Box;
import platform.util.Input;
import platform.util.Output;
import platform.util.Sprite;
import platform.util.Vector;

public class Particle extends Actor 
{
	private Sprite sprite ;
	private double angle ;
	private Vector position ;
	private double size ;
	private double duration ;
	private double time ;
	
	public Particle(Sprite s, Vector pos, double si, double dur)
	{
		time = 0;
		angle = 0 ;
		duration = dur ;
		position = pos ;
		sprite = s ;
		size = si ;
	}
	
	@Override
	public void update(Input input) 
	{
		super.update(input) ;
		time += input.getDeltaTime() ;
		angle += input.getDeltaTime() ;
		if (time >= duration)
			getWorld().unregister(this) ;
	}
	
	public void draw(Input input, Output output)
	{
		super.draw(input, output);
		output.drawSprite(sprite, getBox(), angle, 1 - time/duration);
	}
	
	
	public Box getBox()
	{
		return new Box(position, size, size) ;
	}
	
	
	@Override
	public int getPriority() 
	{
		// TODO Auto-generated method stub
		return 1337;
	}


}

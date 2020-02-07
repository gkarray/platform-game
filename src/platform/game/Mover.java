package platform.game;

import platform.util.Box;
import platform.util.Input;
import platform.util.Output;
import platform.util.Sprite;
import platform.util.Vector;

public class Mover extends Block implements Signal
{
	private Vector on ;
	private Vector off ;
	private Signal signal ;
	private double current ;
	
	public Mover(Box b, Sprite s, Signal sig, Vector o)
	{
		super(b, s) ;
		on = o ;
		off = b.getCenter() ;
		signal = sig ;
		current = 0;
	}
	
	public boolean isActive()
	{
		return signal.isActive() ;
	}
	
	@Override
	public void update(Input input) 
	{
		super.update(input) ;
		if (signal.isActive ()) 
		{
			current += input.getDeltaTime () ;
			if (current > 1.0)
				current = 1.0 ;
		} 
		else 
		{
			current -= input.getDeltaTime () ;
			if (current < 0.0)
				current = 0.0 ;
		}
	}
	
	public Box getBox()
	{
		Box bo = super.getBox();
		return new Box(off.mul(1-current).add(on.mul(current)), bo.getWidth(), bo.getHeight()) ;
	}
}

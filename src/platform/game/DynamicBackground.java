package platform.game;

import platform.util.Box;
import platform.util.Input;
import platform.util.Sprite;
import platform.util.Vector;

public class DynamicBackground extends Background 
{
	private Actor actor ;
	
	public DynamicBackground(Box b, Sprite s, Actor a)
	{
		super(new Box(a.getPosition(), b.getWidth(), b.getHeight()), s) ;
		actor = a ;
	}
	
	public Box getBox()
	{
		return new Box(actor.getPosition(), super.getBox().getWidth(), super.getBox().getHeight()) ;
	}
	
}

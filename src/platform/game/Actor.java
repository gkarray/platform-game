package platform.game;

import platform.util.Box;
import platform.util.Input;
import platform.util.Vector;
import platform.util.Output;
import platform.util.Sprite;

/**
 * Base class of all simulated actors, attached to a world.
 */
public abstract class Actor implements Comparable<Actor> {
  // TO BE COMPLETED
	private World world;
	
	
	// pour évoluer au cours du temps :
	public void update(Input input) {}
	// pour être dessiné
	public void draw(Input input , Output output) {}
	
	public void preUpdate(Input input) {}
	
	public void postUpdate(Input input) {}

	public abstract int getPriority() ;
	
	public int compareTo(Actor other)
	{
		if(this.getPriority() > other.getPriority())
			return -1 ;
		else
		{
			if(this.getPriority() == other.getPriority())
				return 0 ;
			else
				return 1 ;
		}
	}
	
	public void interact(Actor other) {}
	
	public boolean isSolid() 
	{
		return false ;
	}
	
	public void register(World world) 
	{
		this.world = world ;
	}
	
	public void unregister() 
	{
		world = null ;
	}
	
	protected World getWorld()
	{
		return world ;
	}
	
	public Box getBox() 
	{
		return null ;
	}
		
	public Vector getPosition() 
	{
		Box box = getBox() ;
		
		if (box == null)
			return null ;
		
		return box.getCenter() ;
	}
	
	public boolean hurt(Actor instigator , Damage type , double amount , Vector location) 
	{
		return false ;
	}
	
	protected Sprite getSprite(String name)
	{
		return getWorld().getLoader().getSprite(name) ;
	}
}
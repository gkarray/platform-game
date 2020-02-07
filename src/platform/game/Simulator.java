package platform.game;


import platform.game.level.Level;

import platform.util.Sprite ;
import java.util.ArrayList;
import java.util.List;
import platform.util.Box;
import platform.util.SortedCollection;

import platform.util.Input;
import platform.util.Loader;
import platform.util.Output;
import platform.util.Vector;
import platform.util.View;

/**
 * Basic implementation of world, managing a complete collection of actors.
 */
public class Simulator implements World {

    private Loader loader;
    private Vector expectedCenter ;
    private double expectedRadius ;
    private SortedCollection<Actor> actors = new SortedCollection<Actor>();
    private List<Actor> registered ;
    private List<Actor> unregistered ;
    private Level next;
    private Level actualLevel;
    private boolean transition;

  
    /**
     * Create a new simulator.
     * @param loader associated loader, not null
     * @param args level arguments, not null
     */
	public Simulator(Loader loader, String[] args) {
		if (loader == null) {
			throw new NullPointerException() ;
			}
			this.loader = loader ;
			expectedCenter = Vector.ZERO ;
			expectedRadius = 10.0 ;
			registered = new ArrayList<Actor>() ;
			unregistered = new ArrayList<Actor>() ;
			transition = false ;
			next = Level.createDefaultLevel();
			register(next) ;
			actualLevel = next ;
	}
	
    /**
     * Simulate a single step of the simulation.
     * @param input input object to use, not null
     * @param output output object to use, not null
     */
	public void update(Input input, Output output) {
        
      // TO BE COMPLETED
		View view = new View(input , output) ;
		view.setTarget(expectedCenter , expectedRadius) ;
		// Apply preUpdate
		for (Actor a : actors)
		a.preUpdate(view) ; 
		// Apply interactions
		for (Actor actor : actors)
			for (Actor other : actors)
				if (actor.getPriority() > other.getPriority())
					actor.interact(other) ;
		// Apply update
		for (Actor a : actors)
		a.update(view) ;
		// Draw everything
		for (Actor a : actors.descending())
		a.draw(view, view) ;
		// Apply postUpdate
		for (Actor a : actors)
		a.postUpdate(view) ;
		// Add registered actors
		for (int i = 0 ; i < registered.size() ; ++i)
		{
			Actor actor = registered.get(i) ;
			if ( !actors.contains(actor)) 
			{
				actor.register(this);
				actors.add(actor) ;
			}
		}
		registered.clear() ;
		// Remove unregistered actors
		for (int i = 0 ; i < unregistered.size() ; ++i) 
		{
			Actor actor = unregistered.get(i) ;
			actors.remove(actor) ;
		}
		unregistered.clear() ;
		// Going to next level
		if (transition) 
		{
			if (next == null) 
			{
				next = Level.createDefaultLevel () ;
			}
			Level level = next ;
			transition = false ;
			next = null ;
			// Clearing actors and registering only the new level
			actors.clear () ;
			registered.clear () ;
			unregistered.clear () ;
			register(level) ;
			actualLevel = level ;
		}
	}

    @Override
    public Loader getLoader() {
        return loader;
    }

    @Override
    public void setView(Vector center , double radius) {
    	if (center == null)
    		throw new NullPointerException() ;
    	if (radius <= 0.0)
    		throw new IllegalArgumentException("radius must be positive") ;
    	expectedCenter = center ;
    	expectedRadius = radius ;
    }
    
    @Override
    public void register(Actor actor) {
    registered.add(actor) ;
    }
    @Override
    public void unregister(Actor actor) {
    unregistered.add(actor) ;
    }
    
    public void setNextLevel(Level level)
    {
    	next = level ;
    }
    
    public void nextLevel()
    {
    	transition = true ;
    }
    
    @Override
    public int hurt(Box area , Actor instigator , Damage type , double amount , Vector location) 
    {
    	int victims = 0 ;
    	for (Actor actor : actors)
    		if (area.isColliding(actor.getBox ()))
    			if (actor.hurt(instigator , type , amount , location))
    				++ victims ;
    	return victims ;
    }
    
    public Level getActualLevel()
    {
    	return actualLevel ;
    }
    
}

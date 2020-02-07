package platform.game;

import platform.util.Box;
import platform.util.Input;
import platform.util.Output;
import platform.util.Vector;

public class Door extends Block implements Signal
{
	private Signal signal ;
	private Colors couleur ;
	
	public Door(Vector vect, Colors coul, Signal sig)
	{
		super(new Box(vect,1,1)) ;
		signal = sig ;
		couleur = coul ;
	}
	
	public void draw(Input input, Output output)
	{
		super.draw(input, output);
		if(!signal.isActive())
		{
			switch(couleur)
			{
			case RED :
				output.drawSprite(getSprite("lock.red"), getBox());
				break;
			case BLUE :
				output.drawSprite(getSprite("lock.blue"), getBox());
				break;
			case GREEN :
				output.drawSprite(getSprite("lock.green"), getBox());
				break;
			case YELLOW :
				output.drawSprite(getSprite("lock.yellow"), getBox());
				break;
			}
		}
	}
	
	public boolean isSolid()
	{
		return !signal.isActive() ;
	}
	
	public boolean isActive()
	{
		return !signal.isActive() ;
	}
}

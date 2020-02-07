package platform.game;

import platform.game.Actor;
import platform.game.Player;
import platform.util.Box;
import platform.util.Input;
import platform.util.Output;
import platform.util.Vector;

public class Overlay extends Actor 
{
	private Player player ;
	
	public Overlay(Player play)
	{
		player = play ;
	}
	
	public void draw(Input input, Output output)
	{
		super.draw(input, output);
		double health = 5.0 * player.getHealth () / player.getHealthMax () ;
		for (int i = 1 ; i <= 5 ; ++i) 
		{
			String name ;
			if (health >= i)
				name = "heart.full" ;
			else
				if (health >= i - 0.5)
					name = "heart.half" ;
				else
					name = "heart.empty" ;
			output.drawSprite(getSprite(name), new Box(player.getBox().getCenter().add(new Vector(-0.4 + 0.2*(i-1),0.4)), 0.2, 0.2));
		}
	}
	
	public Box getBox()
	{
		return new Box(player.getBox().getCenter().add(new Vector(0,0.4)), 1, 0.2) ;
	}
	
	@Override
	public int getPriority() 
	{
		// TODO Auto-generated method stub
		return 9000;
	}

}

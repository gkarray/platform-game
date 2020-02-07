package platform.game;

import platform.util.Box;
import platform.util.Input;
import platform.util.Output;
import platform.util.Sprite;

public class Led extends Block 
{
	private Signal signal ;
	
	public Led(Box b, Signal sig)
	{
		super(b);
		signal = sig ;
	}
	
	public void draw(Input input, Output output)
	{
		String name = "box.3.disabled" ;
		if (signal.isActive())
			name = "box.3.enabled" ;
		Sprite sprite = getWorld().getLoader().getSprite(name) ;
		output.drawSprite(sprite , getBox()) ;
	}
	
	
	
	
}

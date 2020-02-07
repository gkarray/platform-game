package platform.game;

import java.awt.event.KeyEvent;

import platform.util.Input;

public class Switch extends Actor implements Signal
{
	private boolean v = true ;
	
	public void update(Input input)
	{
		super.update(input);
		if (input.getKeyboardButton(KeyEvent.VK_S).isPressed ())
			v = !v ;
	}
	
	public boolean isActive()
	{
		return v ;
	}
	
	@Override
	public int getPriority() 
	{
		// TODO Auto-generated method stub
		return 5000;
	}

}

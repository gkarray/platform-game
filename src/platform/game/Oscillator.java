package platform.game;

import platform.util.Input;
import platform.util.Output;

public class Oscillator extends Actor implements Signal
{
	private double variation ;
	private double cooldown ;
	
	public Oscillator(double v)
	{
		variation = 2*v ;
		cooldown = 2*v ;
	}
	
	public void update(Input input)
	{
		super.update(input);
		cooldown -= input.getDeltaTime() ;
		if(cooldown < 0)
			cooldown = variation ;
	}
	
	public boolean isActive()
	{
		if(cooldown > variation / 2)
			return true ;
		else
			return false ;
	}

	@Override
	public int getPriority() {
		// TODO Auto-generated method stub
		return 5000;
	}
}

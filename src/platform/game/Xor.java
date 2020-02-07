package platform.game;

public class Xor implements Signal
{
	private Signal left ;
	private Signal right ;
	
	public Xor(Signal signal1, Signal signal2)
	{
		if(signal1 == null || signal2 == null)
			throw new NullPointerException();
		left = signal1 ;
		right = signal2 ;
	}
	
	public boolean isActive()
	{
		return (left.isActive() && !right.isActive()) || (!left.isActive() && right.isActive()) ;
	}
	
}

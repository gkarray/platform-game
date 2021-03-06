package platform.game;

public class And implements Signal
{
	private final Signal left ;
	private final Signal right ;
	
	public And(Signal sig1, Signal sig2)
	{
		if(sig1 == null || sig2 == null)
			throw new NullPointerException();
		left = sig1 ;
		right = sig2 ;
	}
	
	@Override
	public boolean isActive () 
	{
		return left.isActive () && right.isActive () ;
	}
}

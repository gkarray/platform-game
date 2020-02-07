package platform.game;

public class Not implements Signal
{
	private final Signal signal ;
	
	public Not(Signal sig)
	{
		if (sig == null)
			throw new NullPointerException () ;
		signal = sig ;
	}
	
	@Override
	public boolean isActive () 
	{
		return !signal.isActive () ;
	}
}

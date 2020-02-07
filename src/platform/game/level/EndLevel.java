package platform.game.level;

import platform.game.Background;
import platform.game.World;
import platform.util.Box;
import platform.util.Vector;

public class EndLevel extends Level
{
	public void register(World world)
	{
		super.register(world);
		
		world.register(new Background(new Box(Vector.ZERO, 20, 12), world.getLoader().getSprite("background.end")));
		world.setView(Vector.ZERO, 8);
	}
}

package platform.game.level;

import platform.game.Background;
import platform.game.Block;
import platform.game.Limits;
import platform.game.Overlay;
import platform.game.Player;
import platform.game.Sign;
import platform.game.Star;
import platform.game.World;
import platform.util.Box;
import platform.util.Vector;

public class SecretLevel extends Level 
{
	public void register(World world)
	{
		super.register(world);
		
		world.register(new Block(new Box(new Vector(-1,-1), new Vector(1,0)), world.getLoader().getSprite("grass.middle")));
		world.register(new Block(new Box(new Vector(-3,-1), new Vector(-1,0)), world.getLoader().getSprite("grass.left")));
		world.register(new Block(new Box(new Vector(1,-1), new Vector(3,0)), world.getLoader().getSprite("grass.right")));
		
		Player player1 = new Player(new Vector(-2,0), new Vector(0,0)) ;
        world.register(player1) ;
		Overlay over1 = new Overlay(player1) ;
		world.register(over1);
		
		world.register(new Sign(Vector.ZERO, world.getLoader().getSprite("level.secret")));
		
		world.register(new Background(new Box(new Vector(0,0), 100, 100), world.getLoader().getSprite("smiley")));
		world.register(new Limits(new Box(new Vector(0,0), 100, 100)));
		
		world.register(new Star(new Vector(2,0)));
		
		
	}
	
}

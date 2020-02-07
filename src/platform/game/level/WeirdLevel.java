package platform.game.level;

import platform.game.Block;
import platform.game.Button;
import platform.game.DynamicBackground;
import platform.game.Exit;
import platform.game.Not;
import platform.game.Or;
import platform.game.Overlay;
import platform.game.Player;
import platform.game.Sign;
import platform.game.World;
import platform.util.Box;
import platform.util.Vector;

public class WeirdLevel extends Level
{
	public void register(World world)
	{
		super.register(world);
		
		Player player1 = new Player(new Vector(-4,0), new Vector(0,0)) ;
        world.register(player1) ;
		Overlay over1 = new Overlay(player1) ;
		world.register(over1);
		
		world.register(new Sign(new Vector(-3,0), world.getLoader().getSprite("level.weird")));
		
		world.register(new Block(new Box(new Vector(-5,-1), new Vector(1,0)), world.getLoader().getSprite("stone.3")));
		world.register(new Block(new Box(new Vector(-5,4), new Vector(1,5)), world.getLoader().getSprite("stone.3")));
		world.register(new Block(new Box(new Vector(-6,-1), new Vector(-5,5)), world.getLoader().getSprite("stone.7")));
		world.register(new Block(new Box(new Vector(1,-1), new Vector(2,5)), world.getLoader().getSprite("stone.7")));
		
		Button button = new Button(new Vector(-2,0.25)) ;
		world.register(button);
		
		world.register(new DynamicBackground(new Box(new Vector(-4,0),40,20), world.getLoader().getSprite("background.hell"), player1));
		
		world.register(new Exit(new Vector(0,0), new EndLevel(), new SecretLevel(),new Or(button, new Not(button)), button));
	}
	
}

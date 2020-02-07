package platform.game.level;

import platform.game.World;

import platform.game.Xor;
import platform.game.Actor;
import platform.game.And;
import platform.game.Background;
import platform.game.Block;
import platform.game.Bow;
import platform.game.Button;
import platform.game.Colors;
import platform.game.Door;
import platform.game.DynamicBackground;
import platform.game.Exit;
import platform.game.Heart;
import platform.game.Jumper;
import platform.game.Key;
import platform.game.Led;
import platform.game.Lever;
import platform.game.Limits;
import platform.game.Mover;
import platform.game.Not;
import platform.game.Oscillator;
import platform.game.Overlay;
import platform.game.Particle;
import platform.game.Player;
import platform.game.Sign;
import platform.game.Spike;
import platform.game.Switch;
import platform.game.Torch;
import platform.util.Box;
import platform.util.Vector;

public class Level2 extends Level 
{
	public void register(World world)
	{
		super.register(world);
		
		for(int i = -13 ; i < 13 ; i++)
		{
			if(i != -2 && i != 2)
			world.register(new Block(new Box(new Vector(i,-4), new Vector(i+1,-3)), world.getLoader().getSprite("grass.middle")));
		}
		world.register(new Block(new Box(new Vector(-14,-4), new Vector(-13,-3)), world.getLoader().getSprite("grass.left")));
		world.register(new Block(new Box(new Vector(13,-4), new Vector(14,-3)), world.getLoader().getSprite("grass.right")));
		
		for(int i = -13 ; i < 11 ; i ++)
			world.register(new Block(new Box(new Vector(i,-1), new Vector(i+1,0)), world.getLoader().getSprite("grass.middle")));
		world.register(new Block(new Box(new Vector(-14,-1), new Vector(-13,0)), world.getLoader().getSprite("grass.left")));
		world.register(new Block(new Box(new Vector(11,-1), new Vector(12,0)), world.getLoader().getSprite("grass.right")));
		
		world.register(new Block(new Box(new Vector(-15,-3), new Vector(-14,-1)), world.getLoader().getSprite("stone.broken.7")));
		world.register(new Block(new Box(new Vector(14,-3), new Vector(15,2)), world.getLoader().getSprite("stone.broken.7")));
		world.register(new Block(new Box(new Vector(14,2), new Vector(15,3)), world.getLoader().getSprite("stone.broken.1")));
		world.register(new Block(new Box(new Vector(14,3), new Vector(15,8)), world.getLoader().getSprite("stone.broken.7")));
		
		for(int i = -4 ; i < 13 ; i ++)
			world.register(new Block(new Box(new Vector(i,2), new Vector(i+1,3)), world.getLoader().getSprite("grass.middle")));
		world.register(new Block(new Box(new Vector(-5,2), new Vector(-4,3)), world.getLoader().getSprite("grass.left")));
		world.register(new Block(new Box(new Vector(13,2), new Vector(14,3)), world.getLoader().getSprite("grass.right")));
		
		world.register(new Block(new Box(new Vector(-7,0), new Vector(-6,5)), world.getLoader().getSprite("stone.broken.7")));
		
		for(int i = -13 ; i < 11 ; i ++)
			world.register(new Block(new Box(new Vector(i,5), new Vector(i+1,6)), world.getLoader().getSprite("grass.middle")));
		world.register(new Block(new Box(new Vector(-14,5), new Vector(-13,6)), world.getLoader().getSprite("grass.left")));
		world.register(new Block(new Box(new Vector(11,5), new Vector(12,6)), world.getLoader().getSprite("grass.right")));
		
		world.register(new Block(new Box(new Vector(-15,6), new Vector(-14,8)), world.getLoader().getSprite("stone.broken.7")));
		
		for(int i = -12 ; i < 13 ; i++)
		{
			if(i != 2)
			world.register(new Block(new Box(new Vector(i,8), new Vector(i+1,9)), world.getLoader().getSprite("grass.middle")));
		}
		world.register(new Block(new Box(new Vector(-14,8), new Vector(-13,9)), world.getLoader().getSprite("grass.left")));
		world.register(new Block(new Box(new Vector(13,8), new Vector(14,9)), world.getLoader().getSprite("grass.right")));
		
		Button button1 = new Button(new Vector(-12.5,-2.75));
		world.register(button1);
		
		world.register(new Mover(new Box(new Vector(-13,6), new Vector(-12,9)), world.getLoader().getSprite("stone.broken.7"), button1, new Vector(-12.5,9.5)));
		
		Torch torch1 = new Torch(new Vector(-11.5,7.5), false) ;
		world.register(torch1);
		Torch torch2 = new Torch(new Vector(-9.5,7.5), false) ;
		world.register(torch2);
		world.register(new Torch(new Vector(-10.5,6.5), false));
		world.register(new Door(new Vector(-11.5,-1.5), Colors.RED, torch1));
		world.register(new Door(new Vector(-9.5,-1.5), Colors.RED, torch2));
		world.register(new Door(new Vector(-10.5,-2.5), Colors.RED, new And(torch1, new Not(torch1))));
		
		Torch torch3 = new Torch(new Vector(-8.5,-2.5), false) ;
		world.register(torch3);
		Torch torch4 = new Torch(new Vector(-6.5,-2.5), false) ;
		world.register(torch4);
		world.register(new Torch(new Vector(-7.5,-1.5), false));
		world.register(new Door(new Vector(-8.5,6.5), Colors.YELLOW, torch3));
		world.register(new Door(new Vector(-6.5,6.5), Colors.YELLOW, torch4));
		world.register(new Door(new Vector(-7.5,7.5), Colors.YELLOW, new And(torch3, new Not(torch3))));
		
		world.register(new Bow(0,1,new Vector(-6.5,7)));
		
		world.register(new Block(new Box(new Vector(-4,6), new Vector(-1,7)), world.getLoader().getSprite("stone.broken.3")));
		
		Lever lever1 = new Lever(new Vector(-1.5, 7), 3);
		world.register(lever1);
		
		world.register(new Spike(new Vector(-4.5,-3)));
		world.register(new Spike(new Vector(-3.5,-3)));
		world.register(new Mover(new Box(new Vector(-2,-4), new Vector(-1,-1)),world.getLoader().getSprite("stone.broken.7"), lever1, new Vector(-1.5,-4.5)));
		
		Key key1 = new Key(new Vector(-0.5, -3), Colors.GREEN) ;
		world.register(key1);
		
		world.register(new Door(new Vector(-0.5,7.5), Colors.GREEN, key1));
		
		Torch torch5 = new Torch(new Vector(1.5, -2.5), false);
		world.register(torch5);
		Torch torch6 = new Torch(new Vector(1.5, 6.5), false) ;
		world.register(torch6);
		
		world.register(new Mover(new Box(new Vector(2,6), new Vector(3,9)),world.getLoader().getSprite("stone.broken.7"), new And(torch5, new Not(torch6)), new Vector(2.5,9.5) ));
		world.register(new Mover(new Box(new Vector(2,-4), new Vector(3,-1)),world.getLoader().getSprite("stone.broken.7"), new And(torch6, new Not(torch5)), new Vector(2.5,-4.5) ));
		
		world.register(new Spike(new Vector(4.5,-3)));
		world.register(new Spike(new Vector(5.5,-3)));
		world.register(new Spike(new Vector(7.5,-3)));
		world.register(new Spike(new Vector(8.5,-3)));
		world.register(new Spike(new Vector(4.5,6)));
		world.register(new Spike(new Vector(5.5,6)));
		world.register(new Spike(new Vector(7.5,6)));
		world.register(new Spike(new Vector(8.5,6)));
		
		Button button2 = new Button(new Vector(10.5,-2.75));
		world.register(button2);
		
		world.register(new Mover(new Box(new Vector(11,6), new Vector(14,7)), world.getLoader().getSprite("stone.broken.3"), button2, new Vector(10.5, 6.5)));
		world.register(new Jumper(new Vector(13.5, -3)));
		world.register(new Bow(1,1, new Vector(12.5,3)));
		world.register(new Heart(new Vector(10.5,3)));
		world.register(new Bow(3,2, new Vector(5.5, 5)));
		Button button3 = new Button(new Vector(5.5, 3.25)) ;
		world.register(button3);
		world.register(new Mover(new Box(new Vector(11,0), new Vector(14, 1)),world.getLoader().getSprite("stone.broken.3"), button3, new Vector(10.5,0.5)));
		Button button4 = new Button(new Vector(-4.5,3.25)) ;
		world.register(button4);
		Button button5 = new Button(new Vector(4.5, 0.25)) ;
		world.register(button5);
		Button button6 = new Button(new Vector(2.5,0.25), false);
		world.register(button6);
		Button button7 = new Button(new Vector(-2.5,0.25),false) ;
		world.register(button7);
		
		world.register(new Door(new Vector(5.5,0.5), Colors.BLUE, button4));
		world.register(new Door(new Vector(-5.5,2.5), Colors.BLUE, button5));
		world.register(new Block(new Box(new Vector(5,1), new Vector(6,2)), world.getLoader().getSprite("stone.broken.1")));
		
		world.register(new Sign(new Vector(-13.5,-3), world.getLoader().getSprite("level.2")));
		
		Switch switch1 = new Switch() ;
		world.register(switch1);
		Player player1 = new Player(new Vector(-13.5,-3), new Vector(0,0), switch1, true) ;
        world.register(player1) ;
		Overlay over1 = new Overlay(player1) ;
		world.register(over1);
		Player player2 = new Player(new Vector(-13.5,6), new Vector(0,0), new Not(switch1), false) ;
        world.register(player2) ;
		Overlay over2 = new Overlay(player2) ;
		world.register(over2);
		
		world.register(new Background(new Box(Vector.ZERO, 25,20), world.getLoader().getSprite("background.hearts.2")));
		world.register(new Exit(Vector.ZERO, new WeirdLevel(), new And(button6,button7)));
	}
}

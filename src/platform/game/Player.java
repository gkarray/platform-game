package platform.game;

import java.awt.event.KeyEvent;

import platform.game.level.EndLevel;
import platform.game.level.Level;
import platform.game.Overlay;
import platform.util.Box;
import platform.util.Input;
import platform.util.Output;
import platform.util.Vector;
import platform.util.View;

public class Player extends Actor 
{
	private Vector position ;
	private Vector velocity ;
	private static double SIZE = 0.5 ;
	private boolean colliding ;
	private double health ;
	private final double HEALTH_MAX ;
	private Signal signal ;
	private boolean number ;
	private boolean star ;
	
	public Player(Vector pos, Vector vel, Signal sig, boolean v)
	{
		position = pos ;
		velocity = vel ;
		health = 10 ;
		HEALTH_MAX = 10 ;
		colliding = false ;
		signal = sig ;
		number = v ;
		star = false ;
	}
	
	public Player(Vector pos, Vector vel)
	{
		position = pos ;
		velocity = vel ;
		health = 10 ;
		HEALTH_MAX = 10 ;
		colliding = false ;
		number = true ;
		star = false ;
	}
	
	public void preUpdate(Input input)
	{
		super.preUpdate(input);
		if(!star)
		colliding = false ;
	}
	
	public void update(Input input)
	{
		super.update(input) ;
		double delta = input.getDeltaTime() ;
		double maxSpeed = 4.0 ;
		if (colliding && !star) 
		{
			double scale = Math.pow (0.001 , input.getDeltaTime ()) ;
			velocity = velocity.mul(scale) ;
		}
		if(signal == null || signal.isActive())
		{
		if (input.getKeyboardButton(KeyEvent.VK_RIGHT).isDown ()) 
		{
			if (velocity.getX() < maxSpeed) 
			{
				double increase = 60.0 * input.getDeltaTime () ;
				double speed = velocity.getX() + increase ;
				if (speed > maxSpeed)
					speed = maxSpeed ;
				velocity = new Vector(speed , velocity.getY()) ;
			}
		}
		if (input.getKeyboardButton(KeyEvent.VK_LEFT).isDown ()) 
		{
			if (velocity.getX() > -maxSpeed) 
			{
				double increase = 60.0 * input.getDeltaTime () ;
				double speed = velocity.getX() - increase ;
				if (speed > maxSpeed)
					speed = maxSpeed ;
				velocity = new Vector(speed , velocity.getY()) ;
			}
		}
		if (input.getKeyboardButton(KeyEvent.VK_UP).isPressed() && colliding)
			velocity = new Vector(velocity.getX(), 7.0) ;
		if (input.getKeyboardButton(KeyEvent.VK_SPACE).isPressed ())
		{
			Vector v = velocity.add(velocity.resized (2.0)) ;
			Fireball fireball = new Fireball(position, v, this) ;
			fireball.register(getWorld());
			getWorld().register(fireball);
		}
		if (input.getKeyboardButton(KeyEvent.VK_B).isPressed ())
			getWorld().hurt(getBox(), this , Damage.AIR , 1,getPosition ()) ;
		if (input.getKeyboardButton(KeyEvent.VK_E).isPressed ())
			getWorld().hurt(getBox(), this , Damage.ACTIVATION , 1.0,getPosition ()) ;
		if(input.getKeyboardButton(KeyEvent.VK_P).isPressed ())
		{
			Vector v = velocity.add(velocity.resized (2.0)) ;
			Bomb bomb = new Bomb(position, v) ;
			bomb.register(getWorld());
			getWorld().register(bomb);
		}
	}
		if(health <= 0 || input.getKeyboardButton(KeyEvent.VK_R).isPressed ())
			death();
		velocity = velocity.add(this.getWorld().getGravity().mul(delta)) ;
		position = position.add(velocity.mul(delta)) ;
	}
	
	public void postUpdate(Input input)
	{
		super.postUpdate(input);
		int n = 8 ;
		if(star)
			n = 20 ;
		if(signal == null || signal.isActive())
		getWorld().setView(position, n);
	}
	
	public Box getBox() 
	{
		return new Box(position , SIZE, SIZE) ;
	}
	

	@Override
	public int getPriority() 
	{
		return 42;
	}
	
	public void draw(Input input , Output output) 
	{
		if(number)
			output.drawSprite(getSprite("blocker.happy.1"), getBox());
		else
			output.drawSprite(getSprite("blocker.happy.2"), getBox());
	}
	
	public Vector getVelocity()
	{
		return velocity ;
	}
	
	@Override
	public void interact(Actor other) 
	{
		super.interact(other) ;
		if (other.isSolid ()) 
		{
			Vector delta = other.getBox ().getCollision(getBox ()) ;
			if (delta != null)
			{
				position = position.add(delta) ;
				colliding = true ;
				if (delta.getX() != 0.0)
					velocity = new Vector (0.0, velocity.getY()) ;
				if (delta.getY() != 0.0)
					velocity = new Vector(velocity.getX(), 0.0) ;
			}
		}
	}
	
	@Override
	public boolean hurt(Actor instigator , Damage type , double amount , Vector location) 
	{
		switch (type) 
		{
		case AIR :
			if(instigator != this)
				velocity = getPosition ().sub(location).resized(amount) ;
			return true ;
		case VOID :
			health = 0 ;
			return true ;
		case HEAL :
			if(health <= HEALTH_MAX - amount)
				health = health + amount ;
			else
				health = HEALTH_MAX ;
			return true;
		case PHYSICAL :
			health = health - amount ;
			return true ;
		case FIRE :
			health = health - amount ;
			return true ;
		case STAR :
			star = true ;
			return true ;
		default :
			return super.hurt(instigator , type , amount , location) ;
		}
	}
	
	public double getHealth()
	{
		return health ;
	}
	
	public double getHealthMax()
	{
		return HEALTH_MAX ;
	}
	
	public void death()
	{
		getWorld().setNextLevel(getWorld().getActualLevel());
		if(star)
			getWorld().setNextLevel(new EndLevel());
		getWorld().nextLevel();
	}

}

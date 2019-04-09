package rpg.framework.main.entities.creatures;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import rpg.framework.gfx.Animation;
import rpg.framework.gfx.Assets;
import rpg.framework.main.Handler;

public class Player extends Creature {
	
	// ANIMATIONS
	private Animation playerDown, playerUp, playerLeft, playerRight;
	
	public Player(Handler handler, float x, float y) {
		super(handler, x, y, Creature.DEFAULT_CREATURE_WIDTH, Creature.DEFAULT_CREATURE_HEIGHT);
		
		bounds.x = 0;
		bounds.y = 0;
		bounds.width = 60;
		bounds.height = 90;
		
		// ANIMATIONS
		playerDown = new Animation(150, Assets.player_down);
		playerUp = new Animation(150, Assets.player_up);
		playerLeft = new Animation(150, Assets.player_left);
		playerRight = new Animation(150, Assets.player_right);
	}
	
	public void update() {
		
		// animation update
		playerDown.update();
		playerUp.update();
		playerLeft.update();
		playerRight.update();

		// movement update
		xMove = 0;
		yMove = 0;
		
		if(handler.getKeyManager().up
				&& (int)(y + bounds.y - handler.getGameCamera().getyOffset()) > 0)
			yMove = -speed;

		if(handler.getKeyManager().down
				&& (int)(y + bounds.y - handler.getGameCamera().getyOffset() + height)
				< handler.getHeight())
			yMove = speed;

		
		if(handler.getKeyManager().left
				&& (int)(x + bounds.x - handler.getGameCamera().getxOffset()) > 0)
			xMove = -speed;
	
		if(handler.getKeyManager().right
				&& (int)(x + bounds.x - handler.getGameCamera().getxOffset() + width)
				< handler.getWidth())
			xMove = speed;
		
		move();
		handler.getGameCamera().centerOnEntity(this);
	}

	public void render(Graphics g) {
		g.drawImage(getCurrentAnimationFrame(), (int)(x - handler.getGameCamera().getxOffset()),
				(int)(y - handler.getGameCamera().getyOffset()), width, height, null);
		
		g.drawRect((int)(x + bounds.x - handler.getGameCamera().getxOffset()),
				(int)(y + bounds.y - handler.getGameCamera().getyOffset()),
				bounds.width, bounds.height);
	}
	
	private BufferedImage getCurrentAnimationFrame() {
		if (yMove > 0) {
			return playerDown.getCurrentFrame();	
		} else if (yMove < 0) {
			return playerUp.getCurrentFrame();
		} else if (xMove < 0) {
			return playerLeft.getCurrentFrame();
		} else if (xMove > 0) {
			return playerRight.getCurrentFrame();
		} else
		return Assets.player;
	}
	
}

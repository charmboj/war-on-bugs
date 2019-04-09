package rpg.framework.main.entities.creatures;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import rpg.framework.gfx.Animation;
import rpg.framework.gfx.Assets;
import rpg.framework.main.Handler;

public class Zeus extends Creature {

	private Animation zeuswalk;
	
	public Zeus(Handler handler, float x, float y) {
		super(handler, x, y, Creature.DEFAULT_CREATURE_WIDTH, Creature.DEFAULT_CREATURE_HEIGHT);
		
		// ANIMATIONS
		zeuswalk = new Animation(150, Assets.zeus);
	}

	public void update() {
		zeuswalk.update();
	}
	
	public void render(Graphics g) {
		g.drawImage(getCurrentAnimationFrame(), (int)(x - handler.getGameCamera().getxOffset()),
				(int)(y - handler.getGameCamera().getyOffset()), width, height, null);
	}
	
	private BufferedImage getCurrentAnimationFrame() {
		return zeuswalk.getCurrentFrame();
	}
}

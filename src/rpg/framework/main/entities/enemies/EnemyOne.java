package rpg.framework.main.entities.enemies;

import java.awt.Graphics;
import java.awt.Rectangle;

import rpg.framework.main.Handler;
import rpg.framework.main.entities.creatures.Creature;

public class EnemyOne extends Creature {
	
	private boolean dead = false;
	private Rectangle bounds;

	public EnemyOne(Handler handler, float x, float y) {
		super(handler, x, y, Creature.DEFAULT_CREATURE_WIDTH, Creature.DEFAULT_CREATURE_HEIGHT);
		bounds = new Rectangle((int)(x + bounds.x - handler.getGameCamera().getxOffset()),
				(int)(y + bounds.y - handler.getGameCamera().getyOffset()), width, height);
	}

	public void update() {

	}
	
	public void render(Graphics g) {
		g.fillRect( (int)(x - handler.getGameCamera().getxOffset()),
				(int)(y - handler.getGameCamera().getyOffset()), width, height);
	}

}
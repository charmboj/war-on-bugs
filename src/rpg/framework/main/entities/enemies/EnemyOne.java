package rpg.framework.main.entities.enemies;

import java.awt.Graphics;
import java.awt.Rectangle;

import rpg.framework.main.Handler;
import rpg.framework.main.entities.creatures.Creature;
import rpg.framework.main.states.BattleState;
import rpg.framework.main.states.GameState;
import rpg.framework.main.states.State;

public class EnemyOne extends Creature {
	
	private boolean dead = false;

	public EnemyOne(Handler handler, float x, float y) {
		super(handler, x, y, Creature.DEFAULT_CREATURE_WIDTH, Creature.DEFAULT_CREATURE_HEIGHT);
	}

	public void update() {
		collision = new Rectangle((int)(x - handler.getGameCamera().getxOffset()),
				(int)(y - handler.getGameCamera().getyOffset()), width, height);
		
		if(this.collision.intersects(GameState.player.getCollision())) {
			State.setState(new BattleState(handler));
		}
	}
	
	public void render(Graphics g) {
		g.fillRect((int)(x - handler.getGameCamera().getxOffset()),
				(int)(y - handler.getGameCamera().getyOffset()), width, height);
	}

}
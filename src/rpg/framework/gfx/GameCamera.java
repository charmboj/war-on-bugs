/* GAME CAMERA
 * This class sets where the screen will focus on during gameplay. */

package rpg.framework.gfx;

import rpg.framework.main.Game;
import rpg.framework.main.entities.Entity;

public class GameCamera {

	private Game game;
	private float xOffset, yOffset;
	
	public GameCamera(Game game, float xOffset, float yOffset) {
		this.game = game;
		this.xOffset = xOffset;
		this.yOffset = yOffset;
	}

	public void move(float xAmount, float yAmount) {
		xOffset += xAmount;
		yOffset += yAmount;
	}
	
	// Centers camera on player
	public void centerOnEntity(Entity e) {
		if (e.getX() >= 280 && e.getX() <= 10 * 140) {
			xOffset = e.getX() - game.getWidth() / 2 + e.getWidth() / 2;
		} else if (e.getX() < 280) {
			xOffset = 0;
		} else {
			xOffset = 141 * 8;
		}
		if (e.getY() >= 180 && e.getY() <= 6 * 90) {
			yOffset = e.getY() - game.getHeight() / 2 + e.getHeight() / 2;
		} else if (e.getY() < 180) {
			yOffset = 0;
		} else {
			yOffset = 71 * 5;
		}
	
	}
	
	public float getxOffset() {
		return xOffset;
	}

	public void setxOffset(float xOffset) {
		this.xOffset = xOffset;
	}

	public float getyOffset() {
		return yOffset;
	}

	public void setyOffset(float yOffset) {
		this.yOffset = yOffset;
	}
	
}

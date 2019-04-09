package rpg.framework.main.entities;

import java.awt.Graphics;
import java.awt.Rectangle;

import rpg.framework.main.Game;
import rpg.framework.main.Handler;

public abstract class Entity {
	
	protected Handler handler;
	protected float x, y;
	protected int width, height;
	protected Rectangle bounds, collision;

	public Entity(Handler handler, float x, float y, int width, int height) {
		this.handler = handler;
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		
		bounds = new Rectangle(0, 0, width, height);
	}
		
	public Rectangle getCollision() {
		return collision;
	}

	public void setCollision(Rectangle collision) {
		this.collision = collision;
	}
	
	public float getX() {
		return x;
	}

	public void setX(float x) {
		this.x = x;
	}

	public float getY() {
		return y;
	}

	public void setY(float y) {
		this.y = y;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public abstract void update();
	
	public abstract void render(Graphics g);
}

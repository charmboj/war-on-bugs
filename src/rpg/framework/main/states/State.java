package rpg.framework.main.states;

import java.awt.Graphics;

import rpg.framework.main.Game;
import rpg.framework.main.Handler;

public abstract class State {

	private static State currentState = null;
	
	public static void setState(State state) {
		currentState = state;
	}
	
	public static State getState() {
		return currentState;
	}
	
	//class exclusive
	
	protected Handler handler;
	
	public State(Handler handler) {
		this.handler = handler;
	}
	
	public abstract void update();
	
	public abstract void render(Graphics g);
	
}

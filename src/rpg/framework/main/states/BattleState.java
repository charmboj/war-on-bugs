package rpg.framework.main.states;

import java.awt.Graphics;

import rpg.framework.main.Handler;

public class BattleState extends State {

	public BattleState(Handler handler) {
		super(handler);
	}

	@Override
	public void update() {
		
	}

	@Override
	public void render(Graphics g) {
		g.fillRect(0, 0, handler.getHeight(), handler.getWidth());
	}

}

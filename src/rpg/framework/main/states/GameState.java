package rpg.framework.main.states;

import java.awt.Graphics;

import rpg.framework.main.Game;
import rpg.framework.main.Handler;
import rpg.framework.main.entities.creatures.Player;
import rpg.framework.main.entities.creatures.Zeus;
import rpg.framework.main.worlds.World;

public class GameState extends State {

	private Player player;
	private Zeus zeus;
	private World world;
	
	public GameState(Handler handler) {
		super(handler);
		world = new World(handler, "resources/worlds/level1.txt");
		handler.setWorld(world);
		player = new Player(handler, 200, 200);
		zeus = new Zeus(handler, 200, 300);
	}
	
	public void update() {
		world.update();
		player.update();
		zeus.update();
	}
	
	public void render(Graphics g) {
		world.render(g);
		player.render(g);
		zeus.render(g);
		
	}
	
}

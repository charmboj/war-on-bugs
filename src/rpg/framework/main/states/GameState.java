package rpg.framework.main.states;

import java.awt.Graphics;

import rpg.framework.main.Handler;
import rpg.framework.main.entities.Spawn;
import rpg.framework.main.entities.creatures.Player;
import rpg.framework.main.entities.creatures.Zeus;
import rpg.framework.main.entities.enemies.EnemyOne;
import rpg.framework.main.tiles.Tile;
import rpg.framework.main.worlds.World;

public class GameState extends State {

	private Player player;
	private Zeus zeus;
	private World world;
	private EnemyOne enemyone;
	private Spawn spawn;
	
	public GameState(Handler handler) {
		super(handler);
		world = new World(handler, "resources/worlds/level1.txt");
		handler.setWorld(world);
		player = new Player(handler, world.getSpawnX() * Tile.TILEWIDTH,
				world.getSpawnY() * Tile.TILEHEIGHT);
		spawn = new Spawn(handler, 1);
	}
	
	public void update() {
		world.update();
		player.update();
		spawn.update();
	}
	
	public void render(Graphics g) {
		world.render(g);
		player.render(g);
		spawn.render(g);
		
	}
	
}

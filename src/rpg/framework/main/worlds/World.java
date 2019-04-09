package rpg.framework.main.worlds;

import java.awt.Graphics;

import rpg.framework.main.Game;
import rpg.framework.main.Handler;
import rpg.framework.main.tiles.Tile;
import rpg.framework.main.utils.Utils;

public class World {

	private Handler handler;
	private Game game;
	private int width, height; // dimensions of the level/world
	private int spawnX, spawnY; // spawn area of sprite
	private int[][] tiles; // position of tiles
	
	public World(Handler handler, String path) {
		this.handler = handler;
		loadWorld(path);
	}
	
	public void update() {
		
	}
	
	public void render(Graphics g) {
		
		int xStart = (int)Math.max(0, handler.getGameCamera().getxOffset() / Tile.TILEWIDTH),
			yStart = (int)Math.max(0, handler.getGameCamera().getyOffset() / Tile.TILEHEIGHT);
		int xEnd = (int)Math.min(width, (handler.getGameCamera().getxOffset() + handler.getWidth())
				/ Tile.TILEWIDTH + 1),
			yEnd = (int)Math.min(height, (handler.getGameCamera().getyOffset() + handler.getHeight())
						/ Tile.TILEHEIGHT + 1);
		
		for (int y = yStart; y < yEnd; y++) {
			for (int x = xStart; x < xEnd; x++) {
				getTile(x, y).render(g, (int)(x * Tile.TILEWIDTH - handler.getGameCamera().getxOffset()),
						(int)(y * Tile.TILEHEIGHT - handler.getGameCamera().getyOffset()));
			}
		}
	}
	
	public Tile getTile(int x, int y) {
		Tile t = Tile.tiles[tiles[x][y]];
		if (t == null)
			return Tile.levelone; // level one default tile if element from tile array is null
		return t;
	}
	
	private void loadWorld(String path) {
		String file = Utils.loadFileAsString(path);
		String[] tokens = file.split("\\s+"); // splits numbers into different elements
		
		// setting first four numbers in level as width, height, and spawn area
		width = Utils.parseInt(tokens[0]);
		height = Utils.parseInt(tokens[1]);
		spawnX = Utils.parseInt(tokens[2]);
		spawnY = Utils.parseInt(tokens[3]);
		
		// set each number after first four into tile IDs
		tiles = new int[width][height];
		for (int y = 0; y < height; y++) {
			for (int x = 0; x < width; x++) {
				tiles[x][y] = Utils.parseInt(tokens[(x + y * width) +4]);
			}
		}
	}
	
}

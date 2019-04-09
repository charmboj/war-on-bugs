package rpg.framework.main.tiles;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class Tile {

	// DECLARING ARRAY OF TILES (including their identifier numbers)
	
	public static Tile[] tiles = new Tile[20];
	public static Tile levelone = new LevelOneTile(0);
	public static Tile leveltwo = new LevelTwoTile(1);
	public static Tile levelthree = new LevelThreeTile(2);
	public static Tile levelfour = new LevelFourTile(3);
	public static Tile levelfive = new LevelFiveTile(4);
	public static Tile bossone = new LevelOneBossTile(5);
	
	
	// CLASS
	
	public static final int TILEWIDTH = 193, TILEHEIGHT = 140;
	
	protected BufferedImage texture;
	protected final int id; // tile identifier
	
	public Tile(BufferedImage texture, int id) {
		this.texture = texture;
		this.id = id;
		
		tiles[id] = this;
	}
	
	public void update() {
		
	}
	
	public void render(Graphics g, int x, int y) {
		g.drawImage(texture, x, y, TILEWIDTH, TILEHEIGHT, null);
	}
	
	public boolean isSolid() { // determines if a tile is walkable (not solid) or not (solid)
		return false; // by default, walkable
	}
	
	public int getId() {
		return id;
	}
	
}

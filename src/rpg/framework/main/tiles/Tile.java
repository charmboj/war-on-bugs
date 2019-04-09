package rpg.framework.main.tiles;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import rpg.framework.main.tiles.boss.*;
import rpg.framework.main.tiles.portals.*;

public class Tile {

	// DECLARING TILES (including their identifier numbers)
	
	public static Tile[] tiles = new Tile[20];
	
	// normal tiles
	public static Tile levelone = new LevelOneTile(0);
	public static Tile leveltwo = new LevelTwoTile(1);
	public static Tile levelthree = new LevelThreeTile(2);
	public static Tile levelfour = new LevelFourTile(3);
	public static Tile levelfive = new LevelFiveTile(4);
	
	// boss tiles
	public static Tile bossone = new LevelOneBossTile(5);
	public static Tile bosstwo = new LevelTwoBossTile(6);
	public static Tile bossthree = new LevelTwoBossTile(7);
	public static Tile bossfour = new LevelTwoBossTile(8);
	public static Tile bossfive = new LevelTwoBossTile(9);
	
	
	// spawn tiles
	public static Tile portalone = new PortalOne(10);
	public static Tile portaltwo = new PortalOne(11);
	public static Tile portalthree = new PortalOne(12);
	public static Tile portalfour = new PortalOne(13);
	public static Tile portalfive = new PortalOne(14);
	
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

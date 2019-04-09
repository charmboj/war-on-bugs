package rpg.framework.main.entities;

import java.awt.Graphics;

import rpg.framework.main.Handler;
import rpg.framework.main.entities.enemies.EnemyOne;
import rpg.framework.main.tiles.Tile;
import rpg.framework.main.entities.creatures.Zeus;


public class Spawn {

	private EnemyOne[] enemyone;
	private Zeus zeus;
	private int mapid;
	
	public Spawn(Handler handler, int mapid) {
		this.mapid = mapid;
		
		zeus = new Zeus(handler, 200, 300); // to be modified
		enemyone = new EnemyOne[5];
		enemyone[0] = new EnemyOne(handler, 5 * Tile.TILEWIDTH, 5 * Tile.TILEHEIGHT);
		enemyone[1] = new EnemyOne(handler, 4 * Tile.TILEWIDTH, 4 * Tile.TILEHEIGHT);
		enemyone[2] = new EnemyOne(handler, 3 * Tile.TILEWIDTH, 3 * Tile.TILEHEIGHT);
		enemyone[3] = new EnemyOne(handler, 2 * Tile.TILEWIDTH, 2 * Tile.TILEHEIGHT);
		enemyone[4] = new EnemyOne(handler, 1 * Tile.TILEWIDTH, 1 * Tile.TILEHEIGHT);
		
	}
	
	public void update() {
		switch(mapid) {
		case 1: 
			zeus.update();
			for (int i = 0; i < enemyone.length; i++)
				enemyone[i].update();
		}
	}
	
	public void render(Graphics g) {
		switch(mapid) {
		case 1: 
			zeus.render(g);
			for (int i = 0; i < enemyone.length; i++)
				enemyone[i].render(g);
		}
	}
	
}

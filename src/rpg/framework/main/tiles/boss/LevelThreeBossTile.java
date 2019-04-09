package rpg.framework.main.tiles.boss;

import rpg.framework.gfx.Assets;
import rpg.framework.main.tiles.Tile;

public class LevelThreeBossTile extends Tile {

	public LevelThreeBossTile(int id) {
		super(Assets.bossthree, id);
	}
	
	public boolean isSolid() {
		return true;
	}
}

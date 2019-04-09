package rpg.framework.main.tiles.boss;

import rpg.framework.gfx.Assets;
import rpg.framework.main.tiles.Tile;

public class LevelOneBossTile extends Tile {

	public LevelOneBossTile(int id) {
		super(Assets.bossone, id);
	}
	
	public boolean isSolid() {
		return true;
	}
}

package rpg.framework.main.tiles.boss;

import rpg.framework.gfx.Assets;
import rpg.framework.main.tiles.Tile;

public class LevelFiveBossTile extends Tile {

	public LevelFiveBossTile(int id) {
		super(Assets.bossfive, id);
	}
	
	public boolean isSolid() {
		return true;
	}
}

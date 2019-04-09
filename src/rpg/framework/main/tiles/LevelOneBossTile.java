package rpg.framework.main.tiles;

import rpg.framework.gfx.Assets;

public class LevelOneBossTile extends Tile {

	public LevelOneBossTile(int id) {
		super(Assets.bossone, id);
	}
	
	public boolean isSolid() {
		return true;
	}
}

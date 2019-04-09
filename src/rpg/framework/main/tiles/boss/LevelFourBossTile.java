package rpg.framework.main.tiles.boss;

import rpg.framework.gfx.Assets;
import rpg.framework.main.tiles.Tile;

public class LevelFourBossTile extends Tile {

	public LevelFourBossTile(int id) {
		super(Assets.bossfour, id);
	}
	
	public boolean isSolid() {
		return true;
	}
}

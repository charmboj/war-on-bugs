package rpg.framework.gfx;

import java.awt.image.BufferedImage;

public class Assets {
	
	private static final int width = 21, height = 32; // fixed sizes for sprites
	private static final int cropwidth = 23, cropheight = 32; // fixed cropping dimensions
	
	// BUFFERED IMAGE DECLARATIONS (player)
	public static BufferedImage player;
	public static BufferedImage[] player_down, player_up, player_left, player_right;
	public static BufferedImage[] zeus, sasser, melissa, codered, iloveyou;
	
	// BUFFERED IMAGE DECLARATIONS (tiles)
	public static BufferedImage levelone, leveltwo, levelthree, levelfour, levelfive;
	public static BufferedImage bossone, bosstwo, bossthree, bossfour, bossfive;
	
	public static void init() { // loads sheets and images
		SpriteSheet sheet = new SpriteSheet(ImageLoad.loadImage("/textures/SpriteSheet.png"));
		
		// Map tiles
		levelone = ImageLoad.loadImage("/textures/bgzeus.jpg");
		leveltwo = ImageLoad.loadImage("/textures/bgsas.jpg");
		levelthree = ImageLoad.loadImage("/textures/bgmel.jpg");
		levelfour = ImageLoad.loadImage("/textures/bgred.jpg");
		levelfive = ImageLoad.loadImage("/textures/bgiloveyou.jpg");
		bossone = ImageLoad.loadImage("/textures/platformzeus.jpg");
		bosstwo = ImageLoad.loadImage("/textures/platformsas.jpg");
		bossthree = ImageLoad.loadImage("/textures/platformmel.jpg");
		bossfour = ImageLoad.loadImage("/textures/platformred.jpg");
		bossfive = ImageLoad.loadImage("/textures/platformiloveyou.jpg");
		
		// Defining animation arrays/frame containers
		player_down = new BufferedImage[4];
		player_up = new BufferedImage[4];
		player_left = new BufferedImage[4];
		player_right = new BufferedImage[4];
		//temporary bosses
		zeus = new BufferedImage[4];
		sasser = new BufferedImage[4];
		melissa = new BufferedImage[4];
		codered = new BufferedImage[4];
		iloveyou = new BufferedImage[4];
		
		// Player walking down
		player_down[0] = sheet.crop(0, cropheight * 2, width, height);
		player_down[1] = sheet.crop(cropwidth, cropheight * 2, width, height);
		player_down[2] = sheet.crop(cropwidth * 2, cropheight * 2, width, height);
		player_down[3] = player_down[1];

		// Player walking up
		player_up[0] = sheet.crop(0, 0, width, height);
		player_up[1] = sheet.crop(cropwidth, 0, width, height);
		player_up[2] = sheet.crop(cropwidth * 2, 0, width, height);
		player_up[3] = player_up[1];

		// Player walking left
		player_left[0] = sheet.crop(0, cropheight * 3, width, height);
		player_left[1] = sheet.crop(cropwidth, cropheight * 3, width, height);
		player_left[2] = sheet.crop(cropwidth * 2, cropheight * 3, width, height);
		player_left[3] = player_left[1];

		// Player walking right
		player_right[0] = sheet.crop(0, cropheight, width, height);
		player_right[1] = sheet.crop(cropwidth, cropheight, width, height);
		player_right[2] = sheet.crop(cropwidth * 2, cropheight, width, height);
		player_right[3] = player_right[1];
		
		// Default player standing position
		player = sheet.crop(cropwidth, cropheight * 2, width, height);
		
		// BOSS VIRUSES - Zeus
		zeus[0] = sheet.crop(cropwidth * 3, 0, width, height);
		zeus[1] = sheet.crop(cropwidth * 4, 0, width, height);
		zeus[2] = sheet.crop(cropwidth * 5, 0, width, height);
		zeus[3] = zeus[1];
		
		// Sasser
		sasser[0] = sheet.crop(cropwidth * 3, cropheight, width, height);
		sasser[1] = sheet.crop(cropwidth * 4, cropheight, width, height);
		sasser[2] = sheet.crop(cropwidth * 5, cropheight, width, height);
		sasser[3] = sasser[1];
		
		
		
	}
}

/* IMAGE LOADER
 * This class allows loading of images onto the screen. */

package rpg.framework.gfx;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ImageLoad {
	public static BufferedImage loadImage(String path) {
		try {
			return ImageIO.read(ImageLoad.class.getResource(path));
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(1);
		}
		return null;
	}
}

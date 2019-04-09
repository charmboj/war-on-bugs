package rpg.framework.gfx;

import java.awt.image.BufferedImage;

public class Animation {

	private int speed, index;
	private long lasttime, timer;
	private BufferedImage[] frames;
	
	public Animation(int speed, BufferedImage[] frames) {
		this.speed = speed;
		this.frames = frames;
		index = 0;
		timer = 0;
		lasttime = System.currentTimeMillis();
	}
	
	public void update() {
		timer += System.currentTimeMillis() - lasttime;
		lasttime = System.currentTimeMillis();
		
		if (timer > speed) {
			index++;
			timer = 0;
			if (index >= frames.length)
				index = 0; // this loops the animation
		}
	}
	
	public BufferedImage getCurrentFrame() {
		return frames[index];
	}
	
}

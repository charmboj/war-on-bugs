package rpg.framework.display;

import java.awt.*;
import javax.swing.*;

public class Display {

	
	private JFrame frame;
	private Canvas canvas;
	
	private String title;
	private int width, height;
	
	public Display(String title, int width, int height) {
		this.title = title;
		this.width = width;
		this.height = height;
		
		createDisplay();
	}
	
	
	private void createDisplay() { // includes settings of the frame
		frame = new JFrame(title);
		frame.setSize(width, height);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false); // frame cannot be resized
		frame.setLocationRelativeTo(null); // sets frame to be centered by default
		frame.setVisible(true);
		
		canvas = new Canvas();
		canvas.setPreferredSize(new Dimension(width, height));
		canvas.setMaximumSize(new Dimension(width, height));
		canvas.setMinimumSize(new Dimension(width, height));
		canvas.setFocusable(false);
		
		frame.add(canvas);
		frame.pack();
	}
	
	public Canvas getCanvas() { // created so that Game may have access to the canvas
		return canvas;
	}
	
	public JFrame getFrame() {
		return frame;
	}
	
}

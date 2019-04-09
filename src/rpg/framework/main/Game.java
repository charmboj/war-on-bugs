package rpg.framework.main;

import java.awt.*;

import java.awt.image.BufferStrategy; // makes computer draw on screen

import rpg.framework.display.*;
import rpg.framework.gfx.Assets;
import rpg.framework.gfx.GameCamera;
import rpg.framework.main.input.KeyManager;
import rpg.framework.main.states.*;

public class Game implements Runnable {

	private Display display;
	public String title;
	private int width, height;
	
	private Thread thread;
	private Boolean running = false; // at first, not running yet
	
	// for resources/graphics
	private BufferStrategy bs;
	private Graphics g;
	
	private KeyManager keymanager;
	private GameCamera gamecamera;
	private Handler handler;
	
	//Declaring states
	private State gameState, mainmenuState, battleState, creditsState, settingsState;
	
	// taking the width and height from display
	public Game(String title, int width, int height) {
		this.title = title;
		this.width = width;
		this.height = height;
		keymanager = new KeyManager();
	}
	
	private void init() { // initializes graphics/display
		display = new Display(title, width, height);
		display.getFrame().addKeyListener(keymanager);
		Assets.init();
		
		handler = new Handler(this);
		gamecamera = new GameCamera(handler, 0, 0);
		
		//initializing game states
		gameState = new GameState(handler);
		mainmenuState = new MainMenuState(handler);
		State.setState(gameState);
	}

	// update and render the frames
	private void update() {
		keymanager.update();
		
		if (State.getState() != null)
			State.getState().update();
	}
	
	private void render() {
		bs = display.getCanvas().getBufferStrategy();
		if(bs == null) {
			display.getCanvas().createBufferStrategy(3); // creates buffers
			return;
		}
		g = bs.getDrawGraphics();
		
		// Clear screen
		g.clearRect(0, 0, width, height);
		
		// Draw stuff here

		if (State.getState() != null)
			State.getState().render(g);
		
			
		// end drawing
		bs.show(); 
		g.dispose();
	}
	
	public void run() {
		
		init();
		
		int fps = 60; // frames per second
		double TimePerUpdate = 1000000000 / fps;
		double delta = 0;
		long now;
		long lastTime = System.nanoTime();
		
		while(running) {
			now = System.nanoTime();
			delta += (now - lastTime) / TimePerUpdate;
			lastTime = now;
			
			if (delta >= 1) {
				update();
				render();
				delta--;
			}
		}
		
		stop(); // terminate the game
		
	}
	
	public KeyManager getKeyManager() {
		return keymanager;
	}
	
	public GameCamera getGameCamera() {
		return gamecamera;
	}
	
	public int getWidth() {
		return width;
	}
	
	public int getHeight() {
		return height;
	}
	
	public synchronized void start() {
		if (running)
			return; // will not load code below because it's already running
		running = true;
		thread = new Thread(this); // starts a new thread
		thread.start();
	}
	
	public synchronized void stop() {
		if(!running)
			return; // will not load code below because it's already stopped
		running = false;
		try { 		// closes the thread
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
}

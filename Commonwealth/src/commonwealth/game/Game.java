package commonwealth.game;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferStrategy;
import java.io.File;

import commonwealth.issues.IssueMenu;
import commonwealth.scenes.Origin;
import commonwealth.scenes.UnityEnding;
import commonwealth.ser.Serialization;

public class Game extends Canvas implements Runnable{

	private Thread thread;
	private boolean running = false;
	public static int width, height;
	
	public Map map;
	public IssueMenu issuemenu;
	public InfoBook book;
	MenuState menu;
	NationName naming;
	NationNameBack nameBack;
	Opening opening;
	Origin origin;
	
	UnityEnding unityEnding;
	
	public static final String root = "/Commonwealth";
	public static final String fileName = "/file.sav";

	Serialization ser = new Serialization();
	
	public enum STATE{
		
		game,
		menu,
		naming,
		opening, 
		origin, 
		ending
		
	}
	
	public enum ENDING{
		
		unity
		
	}
	
	public static STATE gameState = STATE.menu;
	public static ENDING ending = ENDING.unity;
	
	public void init(){
		
		width  = getWidth();
		height = getHeight();
		
		map = new Map(this);
		issuemenu = new IssueMenu(this, map);
		book = new InfoBook(map);
		naming = new NationName(this);
		menu = new MenuState(this, map);
		nameBack = new NationNameBack(this);
		opening = new Opening(this);
		origin = new Origin(this);
		
		unityEnding = new UnityEnding(this);
		
		this.addMouseListener(map);
		this.addMouseListener(issuemenu);
		this.addMouseListener(book);
		this.addMouseListener(menu);
		this.addKeyListener(naming);
		this.addMouseListener(nameBack);
	}
	
	public synchronized void start(){
		
		if(running)
			return;
		
		running = true;
		thread = new Thread(this);
		thread.start();
		
		
	}
	
	public synchronized void stop(){
		if(!running) return;
		
		running = false;
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void run() {
		
		init();
		this.requestFocus();
		long lastTime = System.nanoTime();
		double amountOfTicks = 60.0;
		double ns = 1000000000 / amountOfTicks;
		double delta = 0;
		long timer = System.currentTimeMillis();
		int updates = 0;
		int frames = 0;
		while(running){
			long now = System.nanoTime();
			delta += (now - lastTime) / ns;
			lastTime = now;
			while(delta >= 1){
				tick();
				updates++;
				delta--;
			}
			render();
			frames++;
			
			if(System.currentTimeMillis() - timer > 1000){
				timer += 1000;
				System.out.println("FPS: " + frames + " Ticks: " + updates);
				frames = 0;
				updates = 0;
			}
		}
		
	}
	
	public void tick(){
		if(gameState == STATE.game){
			map.tick();
			issuemenu.tick();
			book.tick();
		}if(gameState == STATE.menu){
			menu.tick();
		}if(gameState == STATE.naming){
			naming.tick();
		}if(gameState == STATE.opening){
			opening.tick();
		}if(gameState == STATE.origin){
			origin.tick();
		}
		if(gameState == STATE.ending){
			if(ending == ENDING.unity){
				unityEnding.tick();
			}
		}
	}
	
	public void render(){
		
		BufferStrategy bs = this.getBufferStrategy();
		if(bs == null){
			this.createBufferStrategy(3);
			return;
			
		}
		
		Graphics g = bs.getDrawGraphics();
		
		Graphics2D g2d = (Graphics2D) g;
		
		//Draw here
		if(gameState == STATE.game){
			map.render(g);
			issuemenu.render(g);
			book.render(g);
		}
		if(gameState == STATE.menu){
			menu.render(g);
		}
		if(gameState == STATE.naming){
			naming.render(g);
		}
		if(gameState == STATE.opening){
			opening.render(g);
		}
		if(gameState == STATE.origin){
			origin.render(g);
		}
		if(gameState == STATE.ending){
			if(ending == ENDING.unity){
				unityEnding.render(g);
			}
		}
		
		g.dispose();
		bs.show();
	}
	
	public static void main(String args[]){
		
		new Window(800, 600,"Commonwealth" , new Game());
	}
	
	public static String createDataFolder(){
		
		String home = System.getProperty("user.home");
		String OS = System.getProperty("os.name").toLowerCase();
		
		if(OS.contains("win")){
			home = System.getenv("appdata");
		}else if(OS.contains("mac")){
			home += "~/Library/Application Support";
		}else if(OS.contains("nix") || OS.contains("nux") || OS.contains("aix")){
			home += "~/.";
		}
		
		File dir = new File(home);
		dir = new File(dir, root);
		
		if(!dir.exists()){
			
			dir.mkdir();
			System.out.println("Creating folder...");
		}
		
		return dir.getAbsolutePath();
	}
	
	public static int clamp(int var, int min, int max){
		if(var >= max){
			return max;
		}else if(var <= min){
			return min;
		}else{
			return var;
		}
	}

}

package commonwealth.game;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.List;

import commonwealth.game.Game.STATE;

public class Opening {

	int red = 0;
	int pause = 10;
	int step = 0;
	Game game;
	BufferedImageLoader loader = new BufferedImageLoader();
	BufferedImage logo = null;

	public Opening(Game game){
		this.game = game;
			
		try{
			logo = loader.loadImage("/tex/Low Orbit Games.png");
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
	
	
	public void tick(){
		
		if(red < 255 && step == 0){
			red++;
		}
		if(red == 255){
			step = 1;
		}
		
		if(step == 1 && red != 0){
			red--;
		}
		
		if(red == 0 && step == 1){
			pause--;
		}
		if(pause == 0){

			game.gameState = STATE.menu;
			
		}
		
	}
	
	public void render(Graphics g){
		g.setColor(Color.black);
		g.fillRect(0, 0, game.width, game.height);
		g.setColor(new Color(red, red, red));
		g.fillRect(200, 100, 400, 400);
		g.setFont(new Font("Arial", 0, 30));
		g.drawString("LOW ORBIT GAMES", 250, 550);
		g.drawImage(logo, 200, 100, 400, 400, null);
	}
	
}

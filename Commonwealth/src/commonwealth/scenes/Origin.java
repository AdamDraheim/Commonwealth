package commonwealth.scenes;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import commonwealth.game.BufferedImageLoader;
import commonwealth.game.Game;
import commonwealth.game.Game.STATE;
import commonwealth.game.Map;


public class Origin {

	BufferedImageLoader loader = new BufferedImageLoader();
	BufferedImage origin = null;

	int timer = 0;
	
	public Origin(Game game){
		
		try{
			origin = loader.loadImage("/tex/Promotional.png");
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
	
	public void tick(){
				
		timer++;
		
	}
	
	public void render(Graphics g){
		
		g.drawImage(origin, 0, 0, Game.width, Game.height, null);
		
		
		if(timer < 255){
			g.setColor(new Color(0, 0, 0, 255 - timer));
			g.fillRect(0, 0, Game.width, Game.height);
		}
		
		g.setFont(new Font("Courier New", 0, 20));
		
		if(timer >= 250){
			if(timer < 350){
				g.setColor(new Color(255, 255, 255, (timer - 250) * (5/2)));
			}else{
				g.setColor(Color.white);
			}
			g.drawString("In the year 2217, " + Map.nationName + " lost contact with Earth", 10, 20);

		}
		
		if(timer >= 400){
			if(timer < 500){
				g.setColor(new Color(255, 255, 255, (timer - 400) * (5 / 2)));
			}else{
				g.setColor(Color.white);
			}
			g.drawString("Each district in the colony established values and cultures", 10, 50);
		}
		if(timer >= 550){
			if(timer < 650){
				g.setColor(new Color(255, 255, 255, (timer - 550) * (5 / 2)));
			}else{
				g.setColor(Color.white);
			}
			g.drawString("And together, they created an independent nation.", 10, 80);
			
		}
		
		if(timer >= 700){
			if(timer < 800){
				g.setColor(new Color(255, 255, 255, (timer - 700) * (5 / 2)));
			}else{
				g.setColor(Color.white);
			}
			g.drawString("Now, in the year 2230, you have been elected leader", 10, 140);
		}
		
		if(timer >= 850){
			if(timer < 950){
				g.setColor(new Color(255, 255, 255, (timer - 850) * (5 / 2)));
			}else{
				g.setColor(Color.white);
			}
			g.drawString("to lead " + Map.nationName + " to a flourishing future...", 10, 170);
			
		}
		
		if(timer >= 1000){
			if(timer < 1100){
				g.setColor(new Color(255, 255, 255, (timer - 1000) * (5 / 2)));
			}else{
				g.setColor(Color.white);
			}
			g.drawString("...or what could be the end of the colony.", 10, 200);
		}
		
		if(timer > 1200){
			g.setColor(new Color(0, 0, 0, timer - 1200));
			g.fillRect(0, 0, Game.width, Game.height);
		}
		
		if(timer > 1450){
			Game.gameState = STATE.game;
		}
		
	}
	
}

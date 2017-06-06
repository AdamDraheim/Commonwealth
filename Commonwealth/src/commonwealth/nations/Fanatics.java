package commonwealth.nations;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.Serializable;

import commonwealth.game.BufferedImageLoader;
import commonwealth.game.Game;
import commonwealth.game.Map;

public class Fanatics extends Nations{
	
	public Fanatics(int happiness, int resources, int defense, int religion, int tech, ID affiliation, Game game) {
		super(happiness, resources, defense, religion, tech, affiliation);	

	}

	public void tick() {
		happiness = Game.clamp(happiness, 0, 100);
		resources = Game.clamp(resources, 0, 100);
		defense = Game.clamp(defense, 0, 100);
		religion = Game.clamp(religion, 0, 100);
		tech = Game.clamp(tech, 0, 100);
	}

	public void render(Graphics g) {
		
		g.drawImage(Map.bottomnation, 0, 0, Game.width, Game.height, null);
		g.setColor(Color.black);
		g.setFont(new Font("Arial", 2, 30));
		g.drawString("Sons of Primum", 240, 425);
		
		g.setFont(new Font("Arial", 0, 20));

		g.drawImage(Map.icons, 240, 430, 100, 100, null);

		if(happiness < 20){
			g.setColor(Color.red);
		}else{
			g.setColor(Color.black);
		}
		g.drawString(happiness + "%", 270, 445); 
		if(resources < 40){
			g.setColor(Color.red);
		}else{
			g.setColor(Color.black);
		}
		g.drawString(resources + "%", 342, 445);
		if(defense < 30){
			g.setColor(Color.red);
		}else{
			g.setColor(Color.black);
		}
		g.drawString(defense + "%", 270, 475); 
		if(religion < 80){
			g.setColor(Color.red);
		}else{
			g.setColor(Color.black);
		}
		g.drawString(religion + "%", 342, 475);
		if(tech < 60){
			g.setColor(Color.red);
		}else{
			g.setColor(Color.black);
		}
		g.drawString(tech + "%     ", 270, 505);
	}

}

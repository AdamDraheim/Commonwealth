package commonwealth.secede;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import commonwealth.game.BufferedImageLoader;
import commonwealth.game.Map;
import commonwealth.issues.Issues;
import commonwealth.nations.ID;
import commonwealth.nations.Nations;

public class SonsSecede extends Issues{

	Map map;
	
	BufferedImageLoader loader = new BufferedImageLoader();
	
	BufferedImage character = null;
	
	public SonsSecede(Map map){
		this.map = map;
		
		try{
			character = loader.loadImage("/tex/Fanatic.png");
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
	
	public void tick() {
		
		
		
	}

	public void render(Graphics g) {
		
		g.setColor(Color.black);
		g.fillRect(88, 88, 132, 132);
		g.drawImage(character, 90, 90, 128, 128, null);
		g.setFont(new Font("Arial", Font.BOLD, 40));
		g.drawString("The Holy Land", 250, 100);
		g.setFont(new Font("Arial", 0, 20));
		g.drawString("Under your government, our religion and our ways of life have been", 75, 250);
		g.drawString("neglected. We want freedom of religion, not to be forced from it.", 75, 275);
		g.drawString("Now, we Sons of Primus follow Elder Danton's advice and leave for", 75, 300);
		g.drawString("a new Holy Land. Enjoy your colony of heretics and blasphemers.", 75, 325);
		
	}

	public void effects() {
		
		for(int i = 0; i < map.nationList.size(); i++){
			Nations tempNation = map.nationList.get(i);
			
			if(tempNation.getAffiliation() == ID.fanatic){
				map.nationList.remove(tempNation);
			}
			
		}
		
	}

	public void negEffects() {

	}	
	
	
}

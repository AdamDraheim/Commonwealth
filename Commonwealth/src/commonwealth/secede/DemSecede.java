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

public class DemSecede extends Issues{

	Map map;
	
	BufferedImageLoader loader = new BufferedImageLoader();
	
	BufferedImage character = null;
	
	public DemSecede(Map map){
		this.map = map;
		
		try{
			character = loader.loadImage("/tex/President.png");
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
		g.drawString("Fall of the Republic", 250, 100);
		g.setFont(new Font("Arial", 0, 20));
		g.drawString("Protestors line the streets. I am not sure how, but somehow you", 75, 250);
		g.drawString("made every demographic in our state despise your rule. Thus, on this", 75, 275);
		g.drawString("day, we hereby declare independence from your tyrannical rule. We the " , 75, 300);
		g.drawString("people of Aegr Republic are no longer a state, but an independent nation.", 75, 325);
		
	}

	public void effects() {
		
		for(int i = 0; i < map.nationList.size(); i++){
			Nations tempNation = map.nationList.get(i);
			
			if(tempNation.getAffiliation() == ID.democrat){
				map.nationList.remove(tempNation);
			}
			
		}
		
	}

	public void negEffects() {

	}	
	
	
}

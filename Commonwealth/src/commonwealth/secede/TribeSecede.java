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

public class TribeSecede extends Issues{

	Map map;
	
	BufferedImageLoader loader = new BufferedImageLoader();
	
	BufferedImage character = null;
	
	public TribeSecede(Map map){
		this.map = map;
		
		try{
			character = loader.loadImage("/tex/Tribal.png");
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
		g.drawString("Traditions Change", 250, 100);
		g.setFont(new Font("Arial", 0, 20));
		g.drawString("We have found village after village desolate, abandoned. Disappear?", 75, 250);
		g.drawString("Raiders? Maybe. We did not know, but now we understand. Your rule", 75, 275);
		g.drawString("has tarnished the old traditions. They left to preserve their lives." , 75, 300);
		g.drawString("Now, we leave too. Tales of today shall be bleak, like your nation.", 75, 325);
		
	}

	public void effects() {
		
		for(int i = 0; i < map.nationList.size(); i++){
			Nations tempNation = map.nationList.get(i);
			
			if(tempNation.getAffiliation() == ID.tribal){
				map.nationList.remove(tempNation);
			}
			
		}
		
	}

	public void negEffects() {

	}	
	
	
}

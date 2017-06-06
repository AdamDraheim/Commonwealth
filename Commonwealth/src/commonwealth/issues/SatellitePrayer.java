package commonwealth.issues;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import commonwealth.game.BufferedImageLoader;
import commonwealth.game.Map;
import commonwealth.nations.ID;
import commonwealth.nations.Nations;

public class SatellitePrayer extends Issues{

	Map map;
	
	BufferedImageLoader loader = new BufferedImageLoader();
		
	BufferedImage character = null;
	
	public SatellitePrayer(Map map){
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
		g.drawString("The God's Gift", 250, 100);
		g.setFont(new Font("Arial", 0, 20));
		g.drawString("During last night's prayer to the Gods to provide us with a better life,", 75, 250);
		g.drawString("they came through and crashed a satellite in our city. But, this is a test", 75, 275);
		g.drawString("the Aegr Republic is failing. Clearly we're not meant to use the technology", 75, 300);
		g.drawString("but instead to revere it. A symbol that we are still being watched over.", 75, 325);
		g.drawString("Do not let the Aegr Republic take our artifacts.", 75, 350);
		
	}

	public void effects() {
		
		
		for(int i = 0; i < map.nationList.size(); i++){
			Nations tempNation = map.nationList.get(i);
			
			if(tempNation.getAffiliation() == ID.fanatic){
				tempNation.setHappiness(tempNation.getHappiness() + 12);
				tempNation.setReligion(tempNation.getReligion() + 12);

			}
			if(tempNation.getAffiliation() == ID.tribal){
				tempNation.setReligion(tempNation.getReligion() + 4);
			}
			if(tempNation.getAffiliation() == ID.order){
				tempNation.setReligion(tempNation.getReligion() + 3);
			}
			if(tempNation.getAffiliation() == ID.democrat){
				tempNation.setHappiness(tempNation.getHappiness() - 8);
				tempNation.setReligion(tempNation.getReligion() + 6);

			}
			if(tempNation.getAffiliation() == ID.trader){
				
				tempNation.setReligion(tempNation.getReligion() + 4);
				
			}
		}
		
	}
	
	public void negEffects() {
		for(int i = 0; i < map.nationList.size(); i++){
			Nations tempNation = map.nationList.get(i);
			
			if(tempNation.getAffiliation() == ID.fanatic){
				tempNation.setHappiness(tempNation.getHappiness() - 6);
				tempNation.setReligion(tempNation.getReligion() - 4);

			}
			if(tempNation.getAffiliation() == ID.tribal){
				tempNation.setReligion(tempNation.getReligion() - 6);
				tempNation.setHappiness(tempNation.getHappiness() + 4);

			}
			if(tempNation.getAffiliation() == ID.order){
				tempNation.setHappiness(tempNation.getHappiness() + 4);

			}
			if(tempNation.getAffiliation() == ID.democrat){
				tempNation.setHappiness(tempNation.getHappiness() - 4);
				tempNation.setReligion(tempNation.getReligion() - 4);

			}
			if(tempNation.getAffiliation() == ID.trader){
				
				tempNation.setHappiness(tempNation.getHappiness() - 4);
				
			}
		}
		
	}	

	
	
}

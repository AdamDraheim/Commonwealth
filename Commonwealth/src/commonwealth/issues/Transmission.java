package commonwealth.issues;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import commonwealth.game.BufferedImageLoader;
import commonwealth.game.Map;
import commonwealth.nations.ID;
import commonwealth.nations.Nations;

public class Transmission extends Issues{

	Map map;
	
	BufferedImageLoader loader = new BufferedImageLoader();
	
	BufferedImage character = null;
	
	public Transmission(Map map){
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
		g.drawString("Someone out there?", 250, 100);
		g.setFont(new Font("Arial", 0, 20));
		g.drawString("While many value our independence, it will be in our best interest to", 75, 250);
		g.drawString("regain contact with our home planet. Undoubtedly, we are surviving now but", 75, 275);
		g.drawString("imagine how much better we would be doing in cooperation with home. Let's ", 75, 300);
		g.drawString("set up a 24 hour national radio and hope we reach someone.", 75, 325);
		
	}

	public void effects() {
		
		for(int i = 0; i < map.nationList.size(); i++){
			Nations tempNation = map.nationList.get(i);
			
			if(tempNation.getAffiliation() == ID.fanatic){
				tempNation.setHappiness(tempNation.getHappiness() - 4);
				tempNation.setTech(tempNation.getTech() + 6);

			}
			if(tempNation.getAffiliation() == ID.tribal){
				tempNation.setHappiness(tempNation.getHappiness() - 8);
				tempNation.setTech(tempNation.getTech() + 6);

			}
			if(tempNation.getAffiliation() == ID.order){
				tempNation.setHappiness(tempNation.getHappiness() - 4);
				tempNation.setTech(tempNation.getTech() + 5);

			}
			if(tempNation.getAffiliation() == ID.democrat){
				
				tempNation.setHappiness(tempNation.getHappiness() + 8);
				tempNation.setTech(tempNation.getTech() + 10);

			}
			if(tempNation.getAffiliation() == ID.trader){
				
				tempNation.setHappiness(tempNation.getHappiness() + 4);
				tempNation.setTech(tempNation.getTech() + 6);
				
			}
		}
		
	}

	public void negEffects() {
		for(int i = 0; i < map.nationList.size(); i++){
			Nations tempNation = map.nationList.get(i);
			
			if(tempNation.getAffiliation() == ID.fanatic){
				tempNation.setHappiness(tempNation.getHappiness() + 4);
				tempNation.setReligion(tempNation.getReligion() + 6);
				tempNation.setTech(tempNation.getTech() - 5);

			}
			if(tempNation.getAffiliation() == ID.tribal){
				tempNation.setHappiness(tempNation.getHappiness() + 6);

			}
			if(tempNation.getAffiliation() == ID.order){
				tempNation.setHappiness(tempNation.getHappiness() + 12);

			}
			if(tempNation.getAffiliation() == ID.democrat){
				
				tempNation.setHappiness(tempNation.getHappiness() - 4);
				tempNation.setTech(tempNation.getTech() - 4);

			}
			if(tempNation.getAffiliation() == ID.trader){
				
				tempNation.setHappiness(tempNation.getHappiness() - 8);
				
			}
		}
		
	}	
	
}

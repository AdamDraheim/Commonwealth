package commonwealth.issues;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import commonwealth.game.BufferedImageLoader;
import commonwealth.game.Map;
import commonwealth.nations.ID;
import commonwealth.nations.Nations;

public class Slavery extends Issues{

	Map map;
	
	BufferedImageLoader loader = new BufferedImageLoader();
	
	public static boolean slaveryActive = false;
	
	BufferedImage character = null;
	
	public Slavery(Map map){
		this.map = map;
		
		try{
			character = loader.loadImage("/tex/General.png");
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
		g.drawString("More Workers Required", 250, 100);
		g.setFont(new Font("Arial", 0, 20));
		g.drawString("Sir, there is a lot to be done to keep the nation alive, and I fear we do not", 75, 250);
		g.drawString("have the people to keep everything running. With all the nearby bandits, who", 75, 275);
		g.drawString("chose to attack us instead of join us, we may be able to use them to work", 75, 300);
		g.drawString("for us. Let's fight back. Capture some of them and put them to work.", 75, 325);
		
	}

	public void effects() {
		
		slaveryActive = true;
		for(int i = 0; i < map.nationList.size(); i++){
			Nations tempNation = map.nationList.get(i);
			
			if(tempNation.getAffiliation() == ID.fanatic){

				tempNation.setHappiness(tempNation.getHappiness() - 10);
				
			}
			if(tempNation.getAffiliation() == ID.tribal){
				tempNation.setResources(tempNation.getResources() -10);
				tempNation.setHappiness(tempNation.getHappiness() - 20);
				tempNation.setDefense(tempNation.getDefense() - 10);
				tempNation.setReligion(tempNation.getReligion() - 10);

			}
			if(tempNation.getAffiliation() == ID.order){
				tempNation.setResources(tempNation.getResources() + 20);
				tempNation.setHappiness(tempNation.getHappiness() + 10);
				tempNation.setDefense(tempNation.getDefense() + 5);

			}
			if(tempNation.getAffiliation() == ID.democrat){
				tempNation.setResources(tempNation.getResources() + 5);
				tempNation.setHappiness(tempNation.getHappiness() - 10);

			}
			if(tempNation.getAffiliation() == ID.trader){
				
				tempNation.setHappiness(tempNation.getHappiness() + 8);
				tempNation.setResources(tempNation.getResources() + 8);
				
			}
		}
		
	}

	public void negEffects() {
		for(int i = 0; i < map.nationList.size(); i++){
			Nations tempNation = map.nationList.get(i);
			
			if(tempNation.getAffiliation() == ID.fanatic){
				tempNation.setHappiness(tempNation.getHappiness() + 6);

			}
			if(tempNation.getAffiliation() == ID.tribal){
				tempNation.setDefense(tempNation.getDefense() + 4);
				tempNation.setReligion(tempNation.getReligion() + 4);
				tempNation.setHappiness(tempNation.getHappiness() - 6);

			}
			if(tempNation.getAffiliation() == ID.order){
				tempNation.setResources(tempNation.getResources() - 15);
				tempNation.setHappiness(tempNation.getHappiness() - 8);

			}
			if(tempNation.getAffiliation() == ID.democrat){
				tempNation.setHappiness(tempNation.getHappiness() + 4);
				tempNation.setDefense(tempNation.getDefense() - 6);

			}
			if(tempNation.getAffiliation() == ID.trader){
				
				tempNation.setHappiness(tempNation.getHappiness() - 3);
				
			}
		}
		
	}	
	
}

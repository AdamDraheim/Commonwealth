package commonwealth.issues;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import commonwealth.game.BufferedImageLoader;
import commonwealth.game.Map;
import commonwealth.nations.ID;
import commonwealth.nations.Nations;

public class Refugees extends Issues{

	Map map;
	
	BufferedImageLoader loader = new BufferedImageLoader();
		
	BufferedImage character = null;
	
	public Refugees(Map map){
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
		g.drawString("Those who flee...", 250, 100);
		g.setFont(new Font("Arial", 0, 20));
		g.drawString("Today, refugees appeared on our shores. They escaped from a colony", 75, 250);
		g.drawString("now burnt to the ground by bandits, and ask for food and water. I think", 75, 275);
		g.drawString("we must provide them with something, and then perhaps they will join us.", 75, 300);
		g.drawString("It may be a weight to our resources, but it is necessary to help them ", 75, 325);
		g.drawString("when we are so fortunate.", 75, 350);
		
	}

	public void effects() {
				
		for(int i = 0; i < map.nationList.size(); i++){
			Nations tempNation = map.nationList.get(i);
			
			if(tempNation.getAffiliation() == ID.fanatic){
				tempNation.setHappiness(tempNation.getHappiness() + 10);
				tempNation.setResources(tempNation.getResources() - 10);
				tempNation.setReligion(tempNation.getReligion() + 10);

			}
			if(tempNation.getAffiliation() == ID.tribal){
				tempNation.setResources(tempNation.getResources() - 4);
				tempNation.setHappiness(tempNation.getHappiness() - 6);

			}
			if(tempNation.getAffiliation() == ID.order){
				tempNation.setDefense(tempNation.getDefense() - 12);
				tempNation.setHappiness(tempNation.getHappiness() - 16);
				tempNation.setResources(tempNation.getResources() - 10);

			}
			if(tempNation.getAffiliation() == ID.democrat){
				tempNation.setHappiness(tempNation.getHappiness() + 8);
				tempNation.setResources(tempNation.getResources() - 10);

			}
			if(tempNation.getAffiliation() == ID.trader){
				
				tempNation.setHappiness(tempNation.getHappiness() - 24);
				tempNation.setResources(tempNation.getResources() - 8);

				
			}
		}
		
	}

	public void negEffects() {
		for(int i = 0; i < map.nationList.size(); i++){
			Nations tempNation = map.nationList.get(i);
			
			if(tempNation.getAffiliation() == ID.fanatic){
				tempNation.setHappiness(tempNation.getHappiness() - 6);
				tempNation.setReligion(tempNation.getReligion() - 6);

			}
			if(tempNation.getAffiliation() == ID.tribal){
				tempNation.setDefense(tempNation.getDefense() + 10);
				tempNation.setHappiness(tempNation.getHappiness() + 6);

			}
			if(tempNation.getAffiliation() == ID.order){
				tempNation.setDefense(tempNation.getDefense() - 6);
				tempNation.setHappiness(tempNation.getHappiness() - 4);

			}
			if(tempNation.getAffiliation() == ID.democrat){
				tempNation.setHappiness(tempNation.getHappiness() + 8);
				tempNation.setDefense(tempNation.getDefense() - 6);

			}
			if(tempNation.getAffiliation() == ID.trader){
				
				tempNation.setHappiness(tempNation.getHappiness() - 8);
				
			}
		}
		
	}	
	
}

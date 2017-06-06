package commonwealth.issues;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import commonwealth.game.BufferedImageLoader;
import commonwealth.game.Map;
import commonwealth.nations.ID;
import commonwealth.nations.Nations;

public class Currency extends Issues{

	Map map;
	
	BufferedImageLoader loader = new BufferedImageLoader();
	
	BufferedImage character = null;
	
	public Currency(Map map){
		this.map = map;
		
		try{
			character = loader.loadImage("/tex/Trader.png");
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
		g.drawString("National Currency", 250, 100);
		g.setFont(new Font("Arial", 0, 20));
		g.drawString("I've travelled all across the region, and yet everywhere I go, there is a", 75, 250);
		g.drawString("different form of currency. How about we make a national currency system?", 75, 275);
		g.drawString("It would be easier on our traders, and then we cant mint your face on coins. ", 75, 300);
		g.drawString("As far as I see, it is a win-win.", 75, 325);
		
	}

	public void effects() {
		
		for(int i = 0; i < map.nationList.size(); i++){
			Nations tempNation = map.nationList.get(i);
			
			if(tempNation.getAffiliation() == ID.fanatic){
				tempNation.setResources(tempNation.getResources() - 5);
				tempNation.setHappiness(tempNation.getHappiness() - 6);

			}
			if(tempNation.getAffiliation() == ID.tribal){
				tempNation.setResources(tempNation.getResources() + 3);
				tempNation.setHappiness(tempNation.getHappiness() - 12);

			}
			if(tempNation.getAffiliation() == ID.order){
				tempNation.setResources(tempNation.getResources() + 4);
				tempNation.setHappiness(tempNation.getHappiness() + 8);

			}
			if(tempNation.getAffiliation() == ID.democrat){
				tempNation.setResources(tempNation.getResources() + 5);
				tempNation.setHappiness(tempNation.getHappiness() + 8);

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
				tempNation.setHappiness(tempNation.getHappiness() + 3);

			}
			if(tempNation.getAffiliation() == ID.tribal){
				tempNation.setResources(tempNation.getResources() + 10);
				tempNation.setHappiness(tempNation.getHappiness() + 2);

			}
			if(tempNation.getAffiliation() == ID.order){
				tempNation.setResources(tempNation.getResources() - 6);
				tempNation.setHappiness(tempNation.getHappiness() - 4);

			}
			if(tempNation.getAffiliation() == ID.democrat){


			}
			if(tempNation.getAffiliation() == ID.trader){
				
				tempNation.setHappiness(tempNation.getHappiness() - 6);
				
			}
		}
		
	}		

	
	
}

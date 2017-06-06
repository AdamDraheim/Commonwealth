package commonwealth.issues;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import commonwealth.game.BufferedImageLoader;
import commonwealth.game.Map;
import commonwealth.nations.ID;
import commonwealth.nations.Nations;

public class TradeRoutes extends Issues{

	Map map;
	
	BufferedImageLoader loader = new BufferedImageLoader();
	
	BufferedImage character = null;
	
	public TradeRoutes(Map map){
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
		g.drawString("New Trade Routes", 250, 100);
		g.setFont(new Font("Arial", 0, 20));
		g.drawString("A profitable venture can be had if we were to begin trading with the", 75, 250);
		g.drawString("various settlements around us. Bellator especially would be a nice location", 75, 275);
		g.drawString("to establish a network with. Imagine, we remove our surplus goods and we ", 75, 300);
		g.drawString("get luxuries we don't have. Like Garagoes. Would love some garagoes", 75, 325);
		g.drawString("right now.", 75, 350);

		
	}

	public void effects() {
		
		for(int i = 0; i < map.nationList.size(); i++){
			Nations tempNation = map.nationList.get(i);
			
			if(tempNation.getAffiliation() == ID.fanatic){
				tempNation.setResources(tempNation.getResources() + 3);

			}
			if(tempNation.getAffiliation() == ID.tribal){
				tempNation.setResources(tempNation.getResources() + 3);
				tempNation.setHappiness(tempNation.getHappiness() + 4);

			}
			if(tempNation.getAffiliation() == ID.order){
				tempNation.setResources(tempNation.getResources() + 1);
				tempNation.setHappiness(tempNation.getHappiness() - 8);

			}
			if(tempNation.getAffiliation() == ID.democrat){
				tempNation.setResources(tempNation.getResources() + 5);
				tempNation.setHappiness(tempNation.getHappiness() + 4);

			}
			if(tempNation.getAffiliation() == ID.trader){
				
				tempNation.setHappiness(tempNation.getHappiness() + 8);
				tempNation.setResources(tempNation.getResources() + 13);
				
			}
		}
		
	}

	public void negEffects() {
		for(int i = 0; i < map.nationList.size(); i++){
			Nations tempNation = map.nationList.get(i);
			
			if(tempNation.getAffiliation() == ID.fanatic){

			}
			if(tempNation.getAffiliation() == ID.tribal){
				tempNation.setDefense(tempNation.getDefense() + 4);
				tempNation.setHappiness(tempNation.getHappiness() + 4);

			}
			if(tempNation.getAffiliation() == ID.order){
				tempNation.setHappiness(tempNation.getHappiness() - 6);
				tempNation.setResources(tempNation.getResources() + 10);

			}
			if(tempNation.getAffiliation() == ID.democrat){
				tempNation.setHappiness(tempNation.getHappiness() - 4);
				tempNation.setResources(tempNation.getResources() + 4);

			}
			if(tempNation.getAffiliation() == ID.trader){
				
				tempNation.setHappiness(tempNation.getHappiness() - 13);
				tempNation.setResources(tempNation.getResources() - 10);
				
			}
		}
		
	}	
	
}

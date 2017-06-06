package commonwealth.issues;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import commonwealth.game.BufferedImageLoader;
import commonwealth.game.Map;
import commonwealth.nations.ID;
import commonwealth.nations.Nations;

public class CompulsoryService extends Issues{

	Map map;
	
	BufferedImageLoader loader = new BufferedImageLoader();
	
	public static boolean service = false;
	
	BufferedImage character = null;
	
	public CompulsoryService(Map map){
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
		g.drawString("Compulsory Service", 250, 100);
		g.setFont(new Font("Arial", 0, 20));
		g.drawString("Sir, over the course of our time in this nation, we have lost many good", 75, 250);
		g.drawString("men to bandits or the environment. As such, our troops count is nearing", 75, 275);
		g.drawString("depletion. We won't be able to defend ourselves unless we get more", 75, 300);
		g.drawString("troops. Make military service compulsory for men between 18 and 24, and I", 75, 325);
		g.drawString("promise that our nation will be safe.", 75, 350);
		
	}

	public void effects() {
		
		service = true;
		
		for(int i = 0; i < map.nationList.size(); i++){
			Nations tempNation = map.nationList.get(i);
			
			if(tempNation.getAffiliation() == ID.fanatic){
				tempNation.setHappiness(tempNation.getHappiness() - 6);

			}
			if(tempNation.getAffiliation() == ID.tribal){
				tempNation.setDefense(tempNation.getDefense() + 10);
				tempNation.setHappiness(tempNation.getHappiness() - 6);

			}
			if(tempNation.getAffiliation() == ID.order){
				tempNation.setDefense(tempNation.getDefense() + 15);
				tempNation.setHappiness(tempNation.getHappiness() + 12);

			}
			if(tempNation.getAffiliation() == ID.democrat){
				tempNation.setHappiness(tempNation.getHappiness() - 4);
				tempNation.setDefense(tempNation.getDefense() + 6);

			}
			if(tempNation.getAffiliation() == ID.trader){
				
				tempNation.setHappiness(tempNation.getHappiness() + 8);
				
			}
		}
		
	}

	public void negEffects() {
		for(int i = 0; i < map.nationList.size(); i++){
			Nations tempNation = map.nationList.get(i);
			
			if(tempNation.getAffiliation() == ID.fanatic){

			}
			if(tempNation.getAffiliation() == ID.tribal){

				tempNation.setHappiness(tempNation.getHappiness() + 4);

			}
			if(tempNation.getAffiliation() == ID.order){
				tempNation.setDefense(tempNation.getDefense() - 10);
				tempNation.setHappiness(tempNation.getHappiness() - 5);

			}
			if(tempNation.getAffiliation() == ID.democrat){
				tempNation.setHappiness(tempNation.getHappiness() + 2);
				tempNation.setDefense(tempNation.getDefense()- 4);

			}
			if(tempNation.getAffiliation() == ID.trader){
				
				tempNation.setHappiness(tempNation.getHappiness() - 8);
				tempNation.setDefense(tempNation.getDefense() - 10);
				
			}
		}
	
	}

}

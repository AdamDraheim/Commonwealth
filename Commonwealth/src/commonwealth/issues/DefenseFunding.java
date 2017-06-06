package commonwealth.issues;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import commonwealth.game.BufferedImageLoader;
import commonwealth.game.Map;
import commonwealth.nations.ID;
import commonwealth.nations.Nations;

public class DefenseFunding extends Issues{

	Map map;
	
	BufferedImageLoader loader = new BufferedImageLoader();
	
	BufferedImage character = null;
	
	public DefenseFunding(Map map){
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
		g.drawString("A Better Defense", 250, 100);
		g.setFont(new Font("Arial", 0, 20));
		g.drawString("Sir, upon inspection of our state's borders, we arose to the conclusion", 75, 250);
		g.drawString("that more troops will be necessary to protect the homeland. If you would", 75, 275);
		g.drawString("grant us some discretionary funds, we will be able to improve our state's", 75, 300);
		g.drawString("military influence in the more troubled regions.", 75, 325);

		
	}

	public void effects() {
		
		for(int i = 0; i < map.nationList.size(); i++){
			Nations tempNation = map.nationList.get(i);
			
			if(tempNation.getAffiliation() == ID.fanatic){
				
			}
			if(tempNation.getAffiliation() == ID.tribal){

			}
			if(tempNation.getAffiliation() == ID.order){

				tempNation.setHappiness(tempNation.getHappiness() + 16);
				tempNation.setDefense(tempNation.getDefense() + 10);
			}
			if(tempNation.getAffiliation() == ID.democrat){
				tempNation.setHappiness(tempNation.getHappiness() - 16);
				tempNation.setDefense(tempNation.getDefense() + 10);
			}
		}
		
	}

	public void negEffects() {
		for(int i = 0; i < map.nationList.size(); i++){
			Nations tempNation = map.nationList.get(i);
			
			if(tempNation.getAffiliation() == ID.fanatic){
				tempNation.setDefense(tempNation.getDefense() - 4);
				tempNation.setHappiness(tempNation.getHappiness() + 4);

			}
			if(tempNation.getAffiliation() == ID.tribal){
				tempNation.setDefense(tempNation.getDefense() - 2);
				tempNation.setHappiness(tempNation.getHappiness() - 6);

			}
			if(tempNation.getAffiliation() == ID.order){
				tempNation.setDefense(tempNation.getDefense() - 10);
				tempNation.setHappiness(tempNation.getHappiness() - 10);

			}
			if(tempNation.getAffiliation() == ID.democrat){
				tempNation.setHappiness(tempNation.getHappiness() + 6);
				tempNation.setDefense(tempNation.getDefense() - 4);

			}
			if(tempNation.getAffiliation() == ID.trader){
				
				tempNation.setHappiness(tempNation.getHappiness() - 4);
				
			}
		}
		
	}	
	
}

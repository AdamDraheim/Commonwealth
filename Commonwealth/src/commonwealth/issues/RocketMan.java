package commonwealth.issues;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import commonwealth.game.BufferedImageLoader;
import commonwealth.game.Map;
import commonwealth.nations.ID;
import commonwealth.nations.Nations;

public class RocketMan extends Issues{

	Map map;
	
	BufferedImageLoader loader = new BufferedImageLoader();
		
	BufferedImage character = null;
	
	public RocketMan(Map map){
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
		g.drawString("Rocket Man", 250, 100);
		g.setFont(new Font("Arial", 0, 20));
		g.drawString("We need to end the compulsory military service. Fathers, brothers, and sons", 75, 250);
		g.drawString("are leaving their families and if they are not dying, are abandoning their", 75, 275);
		g.drawString("newly born children. Depression is at an all time high because of the", 75, 300);
		g.drawString("separation. The soldiers are burning out their fuse out there alone, with no", 75, 325);
		g.drawString("one to comfort them. Please, end the service requirement.", 75, 350);
		
	}

	public void effects() {
		
		CompulsoryService.service = false;
		
		for(int i = 0; i < map.nationList.size(); i++){
			Nations tempNation = map.nationList.get(i);
			
			if(tempNation.getAffiliation() == ID.fanatic){
				tempNation.setHappiness(tempNation.getHappiness() + 4);

			}
			if(tempNation.getAffiliation() == ID.tribal){
				tempNation.setDefense(tempNation.getDefense() - 4);
				tempNation.setHappiness(tempNation.getHappiness() + 8);

			}
			if(tempNation.getAffiliation() == ID.order){
				tempNation.setDefense(tempNation.getDefense() - 10);
				tempNation.setHappiness(tempNation.getHappiness() - 10);

			}
			if(tempNation.getAffiliation() == ID.democrat){
				tempNation.setHappiness(tempNation.getHappiness() + 8);
				tempNation.setDefense(tempNation.getDefense() - 6);

			}
			if(tempNation.getAffiliation() == ID.trader){
				
				tempNation.setHappiness(tempNation.getHappiness() - 4);
				
			}
		}
		
	}

	public void negEffects() {
		for(int i = 0; i < map.nationList.size(); i++){
			Nations tempNation = map.nationList.get(i);
			
			if(tempNation.getAffiliation() == ID.fanatic){
				tempNation.setHappiness(tempNation.getHappiness() - 6);
				tempNation.setReligion(tempNation.getReligion() + 6);

			}
			if(tempNation.getAffiliation() == ID.tribal){
				tempNation.setDefense(tempNation.getDefense() - 4);
				tempNation.setHappiness(tempNation.getHappiness() + 6);
				tempNation.setReligion(tempNation.getReligion() + 4);

			}
			if(tempNation.getAffiliation() == ID.order){
				tempNation.setDefense(tempNation.getDefense() - 10);
				tempNation.setHappiness(tempNation.getHappiness() - 6);

			}
			if(tempNation.getAffiliation() == ID.democrat){
				tempNation.setHappiness(tempNation.getHappiness() + 4);
				tempNation.setDefense(tempNation.getDefense() - 4);

			}
			if(tempNation.getAffiliation() == ID.trader){
				
				tempNation.setHappiness(tempNation.getHappiness() + 2);
				
			}
		}
		
	}	
	
	
}

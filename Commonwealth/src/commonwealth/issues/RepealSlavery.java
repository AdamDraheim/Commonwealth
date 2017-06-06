package commonwealth.issues;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import commonwealth.game.BufferedImageLoader;
import commonwealth.game.Map;
import commonwealth.nations.ID;
import commonwealth.nations.Nations;

public class RepealSlavery extends Issues{

	Map map;
	
	BufferedImageLoader loader = new BufferedImageLoader();
		
	BufferedImage character = null;
	
	public RepealSlavery(Map map){
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
		g.drawString("End Slavery", 250, 100);
		g.setFont(new Font("Arial", 0, 20));
		g.drawString("Have mercy upon us. The Remnant came and took us from our homes.", 75, 250);
		g.drawString("This legal? How? Please, end the slavery of my people", 75, 275);
		g.drawString("We are not the bandits. Let our people come home, no", 75, 300);
		g.drawString("one deserves to live as a slave.", 75, 325);
		
	}

	public void effects() {
		
		Slavery.slaveryActive = false;
		for(int i = 0; i < map.nationList.size(); i++){
			Nations tempNation = map.nationList.get(i);
			
			if(tempNation.getAffiliation() == ID.fanatic){

				tempNation.setHappiness(tempNation.getHappiness() + 5);
				tempNation.setReligion(tempNation.getReligion() + 10);
				
			}
			if(tempNation.getAffiliation() == ID.order){
				tempNation.setResources(tempNation.getResources() -10);
				tempNation.setHappiness(tempNation.getHappiness() - 20);
				tempNation.setDefense(tempNation.getDefense() - 10);
				tempNation.setResources(tempNation.getResources() - 10);
				

			}
			if(tempNation.getAffiliation() == ID.tribal){
				tempNation.setResources(tempNation.getResources() + 10);
				tempNation.setHappiness(tempNation.getHappiness() + 15);
				tempNation.setDefense(tempNation.getDefense() + 5);

			}
			if(tempNation.getAffiliation() == ID.democrat){
				tempNation.setResources(tempNation.getResources() - 10);
				tempNation.setHappiness(tempNation.getHappiness() + 5);

			}
			if(tempNation.getAffiliation() == ID.trader){
				
				tempNation.setHappiness(tempNation.getHappiness() - 4);
				tempNation.setResources(tempNation.getResources() - 4);
				
			}
		}
		
	}

	public void negEffects() {
		for(int i = 0; i < map.nationList.size(); i++){
			Nations tempNation = map.nationList.get(i);
			
			if(tempNation.getAffiliation() == ID.fanatic){
				tempNation.setHappiness(tempNation.getHappiness() - 6);
				tempNation.setReligion(tempNation.getReligion() - 10);

			}
			if(tempNation.getAffiliation() == ID.tribal){
				tempNation.setDefense(tempNation.getDefense() + 10);
				tempNation.setHappiness(tempNation.getHappiness() - 6);

			}
			if(tempNation.getAffiliation() == ID.order){
				tempNation.setDefense(tempNation.getDefense() + 7);
				tempNation.setHappiness(tempNation.getHappiness() + 6);

			}
			if(tempNation.getAffiliation() == ID.democrat){
				tempNation.setHappiness(tempNation.getHappiness() - 4);
				tempNation.setDefense(tempNation.getDefense() + 6);

			}
			if(tempNation.getAffiliation() == ID.trader){
				
				tempNation.setHappiness(tempNation.getHappiness() + 3);
				tempNation.setResources(tempNation.getResources() + 4);
				
			}
		}
		
	}	
	
	
}

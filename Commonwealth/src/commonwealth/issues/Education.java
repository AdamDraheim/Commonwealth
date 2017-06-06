package commonwealth.issues;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import commonwealth.game.BufferedImageLoader;
import commonwealth.game.Map;
import commonwealth.nations.ID;
import commonwealth.nations.Nations;

public class Education extends Issues{

	Map map;
	
	BufferedImageLoader loader = new BufferedImageLoader();
	
	BufferedImage character = null;
	
	public Education(Map map){
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
		g.drawString("A Textbook Concept", 250, 100);
		g.setFont(new Font("Arial", 0, 20));
		g.drawString("Ah the ignorant masses stumble through our world with no idea of our history", 75, 250);
		g.drawString("like the life of Elder Danton, or events preceding lost contact. Let us teach", 75, 275);
		g.drawString("the people. Make education mandatory for the kids. We will give them the", 75, 300);
		g.drawString("necessary studies to succeed, and follow the word of Danton.", 75, 325);
		
	}

	public void effects() {
		
		for(int i = 0; i < map.nationList.size(); i++){
			Nations tempNation = map.nationList.get(i);
			
			if(tempNation.getAffiliation() == ID.fanatic){
				tempNation.setReligion(tempNation.getReligion() + 10);
				tempNation.setHappiness(tempNation.getHappiness() + 8);
				tempNation.setTech(tempNation.getTech() + 8);

			}
			if(tempNation.getAffiliation() == ID.tribal){
				tempNation.setReligion(tempNation.getReligion() + 6);
				tempNation.setHappiness(tempNation.getHappiness() - 4);
				tempNation.setTech(tempNation.getTech() + 8);


			}
			if(tempNation.getAffiliation() == ID.order){
				tempNation.setReligion(tempNation.getReligion() + 6);
				tempNation.setHappiness(tempNation.getHappiness() - 4);
				tempNation.setTech(tempNation.getTech() + 8);


			}
			if(tempNation.getAffiliation() == ID.democrat){
				tempNation.setResources(tempNation.getResources() + 8);
				tempNation.setHappiness(tempNation.getHappiness() + 6);
				tempNation.setTech(tempNation.getTech() + 8);


			}
			if(tempNation.getAffiliation() == ID.trader){
				
				tempNation.setReligion(tempNation.getReligion() + 6);
				tempNation.setHappiness(tempNation.getHappiness() - 2);
				tempNation.setTech(tempNation.getTech() + 8);

				
			}
		}
		
	}

	public void negEffects() {
		for(int i = 0; i < map.nationList.size(); i++){
			Nations tempNation = map.nationList.get(i);
			
			if(tempNation.getAffiliation() == ID.fanatic){
				tempNation.setReligion(tempNation.getReligion() - 6);
				tempNation.setHappiness(tempNation.getHappiness() - 6);
				tempNation.setTech(tempNation.getTech() -6);

			}
			if(tempNation.getAffiliation() == ID.tribal){
				tempNation.setReligion(tempNation.getReligion() - 4);
				tempNation.setHappiness(tempNation.getHappiness() - 6);
				tempNation.setTech(tempNation.getTech() -6);


			}
			if(tempNation.getAffiliation() == ID.order){
				tempNation.setResources(tempNation.getResources() - 6);
				tempNation.setHappiness(tempNation.getHappiness() - 4);
				tempNation.setTech(tempNation.getTech() -6);


			}
			if(tempNation.getAffiliation() == ID.democrat){

				tempNation.setTech(tempNation.getTech() -6);


			}
			if(tempNation.getAffiliation() == ID.trader){
				
				tempNation.setReligion(tempNation.getReligion() - 4);
				tempNation.setHappiness(tempNation.getHappiness() -5);
				tempNation.setTech(tempNation.getTech() -6);

			}
		}
		
	}		

	
	
}

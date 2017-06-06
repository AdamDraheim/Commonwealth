package commonwealth.issues;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import commonwealth.game.BufferedImageLoader;
import commonwealth.game.Map;
import commonwealth.nations.ID;
import commonwealth.nations.Nations;

public class TechPreservation extends Issues{

	Map map;
	
	BufferedImageLoader loader = new BufferedImageLoader();
	
	BufferedImage fanatic = null;
	
	public TechPreservation(Map map){
		this.map = map;
		
		try{
			fanatic = loader.loadImage("/tex/Fanatic.png");
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
	
	public void tick() {
		
		
		
	}

	public void render(Graphics g) {
		
		g.setColor(Color.black);
		g.fillRect(88, 88, 132, 132);
		g.drawImage(fanatic, 90, 90, 128, 128, null);
		g.setFont(new Font("Arial", Font.BOLD, 40));
		g.drawString("PROTECT THE TECH", 250, 100);
		g.setFont(new Font("Arial", 0, 20));
		g.drawString("Our holy sites are ravaged by those blasphemous Ashen. This is not what", 75, 250);
		g.drawString("Elder Danton would have wanted. He told us salvation will come if we keep", 75, 275);
		g.drawString("the tech alive. Ban the blasphemers from the site. We must preserve ", 75, 300);
		g.drawString("what we have left.", 75, 325);

		
	}

	public void effects() {
		
		for(int i = 0; i < map.nationList.size(); i++){
			Nations tempNation = map.nationList.get(i);
			
			if(tempNation.getAffiliation() == ID.fanatic){
				tempNation.setReligion(tempNation.getReligion() + 10);
				tempNation.setHappiness(tempNation.getHappiness() + 10);
				tempNation.setTech(tempNation.getTech() + 10);
			}
			if(tempNation.getAffiliation() == ID.tribal){
				tempNation.setReligion(tempNation.getReligion() + 6);
				tempNation.setHappiness(tempNation.getHappiness() - 14);
				tempNation.setTech(tempNation.getTech() + 4);

			}
			if(tempNation.getAffiliation() == ID.order){
				tempNation.setReligion(tempNation.getReligion() + 6);
				tempNation.setHappiness(tempNation.getHappiness() - 4);
				tempNation.setTech(tempNation.getTech() + 8);

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
				tempNation.setReligion(tempNation.getReligion() - 4);
				tempNation.setHappiness(tempNation.getHappiness() + 6);

			}
			if(tempNation.getAffiliation() == ID.order){
				tempNation.setDefense(tempNation.getDefense() + 15);
				tempNation.setHappiness(tempNation.getHappiness() + 12);
				tempNation.setReligion(tempNation.getReligion() - 4);

			}
			if(tempNation.getAffiliation() == ID.democrat){
				tempNation.setHappiness(tempNation.getHappiness() - 4);
				tempNation.setReligion(tempNation.getReligion() - 4);

			}
			if(tempNation.getAffiliation() == ID.trader){
				
				tempNation.setHappiness(tempNation.getHappiness() + 4);
				
			}
		}
		
	}	
	
}

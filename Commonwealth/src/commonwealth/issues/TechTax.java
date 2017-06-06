package commonwealth.issues;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import commonwealth.game.BufferedImageLoader;
import commonwealth.game.Map;
import commonwealth.nations.ID;
import commonwealth.nations.Nations;

public class TechTax extends Issues{

	Map map;
	
	BufferedImageLoader loader = new BufferedImageLoader();
	
	BufferedImage tribal = null;
	
	public TechTax(Map map){
		this.map = map;
		
		try{
			tribal = loader.loadImage("/tex/Tribal.png");
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
	
	public void tick() {
		
		
		
	}

	public void render(Graphics g) {
		
		g.setColor(Color.black);
		g.fillRect(88, 88, 132, 132);
		g.drawImage(tribal, 90, 90, 128, 128, null);
		g.setFont(new Font("Arial", Font.BOLD, 40));
		g.drawString("TAX THE TECH", 250, 100);
		g.setFont(new Font("Arial", 0, 20));
		g.drawString("Technology is freely traded. But, do we want technology to be traded?", 75, 250);
		g.drawString("We do not know what these do. Perhaps good. perhaps bad. Tax it", 75, 275);
		g.drawString("as to limit the potential danger. It is better to be safe than sorry.", 75, 300);


		
	}

	public void effects() {
		for(int i = 0; i < map.nationList.size(); i++){
			Nations tempNation = map.nationList.get(i);
			if(tempNation.getAffiliation() == ID.tribal){
				tempNation.setReligion(tempNation.getReligion() - 12);
				tempNation.setHappiness(tempNation.getHappiness() + 10);
	
			}
			if(tempNation.getAffiliation() == ID.fanatic){
				tempNation.setReligion(tempNation.getReligion() - 6);
				tempNation.setHappiness(tempNation.getHappiness() - 12);
	
			}
			if(tempNation.getAffiliation() == ID.order){
				tempNation.setReligion(tempNation.getReligion() - 6);
				tempNation.setHappiness(tempNation.getHappiness() + 6);
	
			}
		}

	}
	
	public void negEffects() {
		for(int i = 0; i < map.nationList.size(); i++){
			Nations tempNation = map.nationList.get(i);
			
			if(tempNation.getAffiliation() == ID.fanatic){
				tempNation.setHappiness(tempNation.getHappiness() + 6);
				tempNation.setReligion(tempNation.getReligion() + 5);

			}
			if(tempNation.getAffiliation() == ID.tribal){
				tempNation.setReligion(tempNation.getReligion() + 8);
				tempNation.setHappiness(tempNation.getHappiness() - 6);

			}
			if(tempNation.getAffiliation() == ID.order){
				tempNation.setHappiness(tempNation.getHappiness() - 4);
				tempNation.setReligion(tempNation.getReligion() + 6);

			}
			if(tempNation.getAffiliation() == ID.democrat){
				tempNation.setHappiness(tempNation.getHappiness() - 4);

			}
			if(tempNation.getAffiliation() == ID.trader){
								
			}
		}
		
	}	
	
}

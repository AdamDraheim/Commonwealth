package commonwealth.issues;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import commonwealth.game.BufferedImageLoader;
import commonwealth.game.Map;
import commonwealth.nations.ID;
import commonwealth.nations.Nations;

public class Nationhood extends Issues{

	Map map;
	
	BufferedImageLoader loader = new BufferedImageLoader();
	
	BufferedImage character = null;
	
	public Nationhood(Map map){
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
		g.drawString("A new country", 250, 100);
		g.setFont(new Font("Arial", 0, 20));
		g.drawString("", 75, 250);
		g.drawString("Good day sir, with the alliances sorted out, we decided to elect you", 75, 275);
		g.drawString("as leader. We trust the fate of our new nation in your hands. You", 75, 300);
		g.drawString("can say no, but we won't accept that. You MUST lead us.", 75, 325);
		
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
				tempNation.setHappiness(tempNation.getHappiness() + 4);

			}
			if(tempNation.getAffiliation() == ID.tribal){
				tempNation.setHappiness(tempNation.getHappiness() + 6);

			}
			if(tempNation.getAffiliation() == ID.order){
				tempNation.setHappiness(tempNation.getHappiness() - 6);

			}
			if(tempNation.getAffiliation() == ID.democrat){
				tempNation.setHappiness(tempNation.getHappiness() - 12);

			}
			if(tempNation.getAffiliation() == ID.trader){
				
				tempNation.setHappiness(tempNation.getHappiness() + 8);
				
			}
		}
		
	}	
	
}

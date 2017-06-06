package commonwealth.constitution;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import commonwealth.game.BufferedImageLoader;
import commonwealth.game.Map;
import commonwealth.issues.Issues;
import commonwealth.nations.ID;
import commonwealth.nations.Nations;

public class Constitution extends Issues{

	Map map;
	
	BufferedImageLoader loader = new BufferedImageLoader();
	
	BufferedImage character = null;
	
	public Constitution(Map map){
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
		g.drawString("The Rule of Law", 250, 100);
		g.setFont(new Font("Arial", 0, 20));
		g.drawString("Our esteemed leader, it has been a year since this alliance first began.", 75, 250);
		g.drawString("Seeing as we seem here to stay for a bit, let us draft a constitution to", 75, 275);
		g.drawString("outline the rights and powers of the government. If you agree, I and a few ", 75, 300);
		g.drawString("other leaders will present some ideas next month for the constitution.", 75, 325);

		
	}

	public void effects() {
		
		map.constitution = true;
		
	}

	public void negEffects() {
		for(int i = 0; i < map.nationList.size(); i++){
			Nations tempNation = map.nationList.get(i);
			
			if(tempNation.getAffiliation() == ID.fanatic){
				tempNation.setHappiness(tempNation.getHappiness() - 6);
				tempNation.setReligion(tempNation.getReligion() - 6);

			}
			if(tempNation.getAffiliation() == ID.tribal){
				tempNation.setHappiness(tempNation.getHappiness() - 6);

			}
			
			if(tempNation.getAffiliation() == ID.order){
				
				tempNation.setHappiness(tempNation.getHappiness() + 6);

			}
			if(tempNation.getAffiliation() == ID.democrat){
				tempNation.setHappiness(tempNation.getHappiness() + 10);

			}
			if(tempNation.getAffiliation() == ID.trader){
				
				tempNation.setHappiness(tempNation.getHappiness() + 8);
				
			}
		}
		
	}	
	
	
}

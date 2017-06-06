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

public class judgeClause extends Issues{

	Map map;
	
	BufferedImageLoader loader = new BufferedImageLoader();
	
	BufferedImage character = null;
	
	public judgeClause(Map map){
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
		g.drawString("The Judiciary Clause", 250, 100);
		g.setFont(new Font("Arial", 0, 20));
		g.drawString("Good morning, good leader. Glad you decided to adopt a constitution.", 75, 250);
		g.drawString("As you know, we will need someone to interpret the constitution. I propose", 75, 275);
		g.drawString("we make a court of five people, chosen by yourself, who will serve for", 75, 300);
		g.drawString("life and can overturn any legislation you try to pass that they believe to be", 75, 325);
		g.drawString("unconstitutional. Do you want to adopt the Judiciary Clause?", 75, 350);

		
	}

	public void effects() {
		
		map.judicialClause = true;
		
		for(int i = 0; i < map.nationList.size(); i++){
			Nations tempNation = map.nationList.get(i);
			
			if(tempNation.getAffiliation() == ID.fanatic){
				
			}
			if(tempNation.getAffiliation() == ID.tribal){

				tempNation.setHappiness(tempNation.getHappiness() - 10);
				
			}
			if(tempNation.getAffiliation() == ID.order){

			}
			if(tempNation.getAffiliation() == ID.democrat){
				
				tempNation.setHappiness(tempNation.getHappiness() + 10);
			}
		}	
	}
	
	public void negEffects() {
	
	}
}

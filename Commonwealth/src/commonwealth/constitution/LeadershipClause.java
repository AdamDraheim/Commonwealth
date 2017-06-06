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

public class LeadershipClause extends Issues{

	Map map;
	
	BufferedImageLoader loader = new BufferedImageLoader();
	
	BufferedImage character = null;
	
	public LeadershipClause(Map map){
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
		g.drawString("The Leadership Clause", 250, 100);
		g.setFont(new Font("Arial", 0, 20));
		g.drawString("Sir, unfortunate as it may, some day you may be unfit to serve. In this", 75, 250);
		g.drawString("situation, we would need a temporary leader to lead until a new one can be", 75, 275);
		g.drawString("elected. Also, if in time of crisis you prove unable to protect the people,", 75, 300);
		g.drawString("a leader skilled in such emergencies would be called upon to lead in your", 75, 325);
		g.drawString("stead. This clause determines whether someone could replace you if unfit", 75, 350);
		g.drawString("to serve properly. May we add it to the constitution?", 75, 375);

		
	}

	public void effects() {
		
		map.leadershipClause = true;
		
		for(int i = 0; i < map.nationList.size(); i++){
			Nations tempNation = map.nationList.get(i);
			
			if(tempNation.getAffiliation() == ID.fanatic){
				
			}
			if(tempNation.getAffiliation() == ID.tribal){

			}
			if(tempNation.getAffiliation() == ID.order){

				tempNation.setHappiness(tempNation.getHappiness() + 10);
			}
			if(tempNation.getAffiliation() == ID.democrat){
				
				tempNation.setHappiness(tempNation.getHappiness() - 10);
			}
		}
		
	}

	public void negEffects() {
		for(int i = 0; i < map.nationList.size(); i++){
			Nations tempNation = map.nationList.get(i);
			
			if(tempNation.getAffiliation() == ID.fanatic){

			}
			if(tempNation.getAffiliation() == ID.tribal){
				tempNation.setHappiness(tempNation.getHappiness() - 6);

			}
			if(tempNation.getAffiliation() == ID.order){
				tempNation.setHappiness(tempNation.getHappiness() - 6);
				tempNation.setDefense(tempNation.getDefense() - 5);

			}
			if(tempNation.getAffiliation() == ID.democrat){
				tempNation.setHappiness(tempNation.getHappiness() + 4);

			}
			if(tempNation.getAffiliation() == ID.trader){
				
				tempNation.setHappiness(tempNation.getHappiness() + 8);
				
			}
		}
		
	}	
	
}

package commonwealth.secede;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import commonwealth.game.BufferedImageLoader;
import commonwealth.game.Map;
import commonwealth.issues.Issues;
import commonwealth.nations.ID;
import commonwealth.nations.Nations;

public class OrderSecede extends Issues{

	Map map;
	
	BufferedImageLoader loader = new BufferedImageLoader();
	
	BufferedImage character = null;
	
	public OrderSecede(Map map){
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
		g.drawString("Collapsed Bastion", 250, 100);
		g.setFont(new Font("Arial", 0, 20));
		g.drawString("Bandits. Rogue Soldiers. Rampant crime. All this has come because", 75, 250);
		g.drawString("of your lax rule. We tried to keep peace, yet you are inclined to", 75, 275);
		g.drawString("make our efforts be in vain. No more! Let your land fallow in unrest." , 75, 300);
		g.drawString("It is clearly what you want.", 75, 325);
		
	}

	public void effects() {
		
		for(int i = 0; i < map.nationList.size(); i++){
			Nations tempNation = map.nationList.get(i);
			
			if(tempNation.getAffiliation() == ID.order){
				map.nationList.remove(tempNation);
			}
			
		}
		
	}

	public void negEffects() {

	}	
	
	
}

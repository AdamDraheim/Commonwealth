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

public class TradeSecede extends Issues{

	Map map;
	
	BufferedImageLoader loader = new BufferedImageLoader();
	
	BufferedImage character = null;
	
	public TradeSecede(Map map){
		this.map = map;
		
		try{
			character = loader.loadImage("/tex/Trader.png");
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
		g.drawString("Last Caravan", 250, 100);
		g.setFont(new Font("Arial", 0, 20));
		g.drawString("You have led our economy to ruin. Our traders either lie dead or", 75, 250);
		g.drawString("have long since left us. It was unfortunate this did not prove", 75, 275);
		g.drawString("lucrative. My caravans and I leave tomorrow morning. Perhaps,", 75, 300);
		g.drawString("some day, we'll trade with you, like when the planet blows up.", 75, 325);
		
	}

	public void effects() {
		
		for(int i = 0; i < map.nationList.size(); i++){
			Nations tempNation = map.nationList.get(i);
			
			if(tempNation.getAffiliation() == ID.trader){
				map.nationList.remove(tempNation);
			}
			
		}
		
	}

	public void negEffects() {

	}	
	
	
}

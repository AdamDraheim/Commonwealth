package commonwealth.issues;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;

import commonwealth.game.BufferedImageLoader;
import commonwealth.game.Game;
import commonwealth.game.Game.STATE;
import commonwealth.game.Map;

public class IssueMenu extends MouseAdapter{

	public static boolean issueActive = false;
	Map map;
	BufferedImageLoader loader = new BufferedImageLoader();
	BufferedImage issuepage = null;
	
	public IssueMenu(Game game, Map map){
		this.map = map;
		try{
			
			issuepage = loader.loadImage("/tex/Issuepaper.png");
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public void mousePressed(MouseEvent e){
		
		int mx = e.getX();
		int my = e.getY();
		
		if(Game.gameState == STATE.game){
			if(issueActive){
				if(mouseOver(mx, my, 100, 400, 200, 75)){
					
					map.issueList.get(map.currentIssue).effects();
					issueActive = false;
					map.issueList.remove(map.currentIssue);
	
		
					
				}else if(mouseOver(mx, my, 305, 400, 200, 75)){
					map.issueList.get(map.currentIssue).negEffects();
					issueActive = false;
					map.issueList.remove(map.currentIssue);
	
		
				}else if(mouseOver(mx, my, 510, 400, 200, 75)){
					issueActive = false;
				}
			}
		}
		
	}
	
	public void tick(){
		
	}
	
	public void render(Graphics g){
		if(issueActive){

			g.drawImage(issuepage, 0, 0, 800, 600, null);
			try{
				map.issueList.get(map.currentIssue).render(g);
			}catch(Exception e){
				e.printStackTrace();
			}
			g.setColor(Color.black);
			g.setFont(new Font("Arial", 0, 30));
			
			g.drawRect(100, 400, 200, 75);
			g.drawRect(305, 400, 200, 75);
			g.drawRect(510, 400, 200, 75);
			
			g.drawString("Yes", 175, 450);
			g.drawString("No", 380, 450);
			g.drawString("Later", 585, 450);


			
			
		}
		
	}
	

	private boolean mouseOver(int mx, int my, int x, int y, int width, int height){
		if(mx > x && mx < x + width){
			if(my > y && my < y + height){
				return true;
			}else return false;
		}else return false;
	}
	
	
}

package commonwealth.game;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import commonwealth.game.Game.STATE;

public class NationNameBack extends MouseAdapter{

	public NationNameBack(Game game){
		
	}
	
	public void mousePressed(MouseEvent e){
		
		int mx = e.getX();
		int my = e.getY();
		
		if(Game.gameState == STATE.naming){
			if(mouseOver(mx, my, 50, 50, 64, 64)){
				Game.gameState = STATE.menu;
			}
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

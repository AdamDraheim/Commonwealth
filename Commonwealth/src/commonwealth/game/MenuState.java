package commonwealth.game;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

import commonwealth.game.Game.STATE;
import commonwealth.ser.Serialization;
import commonwealth.ser.fileInfo;

public class MenuState extends MouseAdapter{

	BufferedImageLoader loader = new BufferedImageLoader();
	
	BufferedImage paper = null;
	Map map;
	
	Serialization ser = new Serialization();
	
	public MenuState(Game game, Map map){
		
		this.map = map;
		
		try{
			paper = loader.loadImage("/tex/Paper.png");
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
	
	public void mousePressed(MouseEvent e){
		
		int mx = e.getX();
		int my = e.getY();
		
		if(Game.gameState == STATE.menu){
			if(mouseOver(mx, my, 200, 200, 400, 100)){
				Game.gameState = STATE.naming;
			}
			if(mouseOver(mx, my, 200, 350, 400, 100)){
				
				if(ser.checkFileExists()){
				
					fileInfo loadFile = ser.load();
					
					try{
						
						for(int i = 0; i < loadFile.getNations().size(); i++){
						
							Map.nationList.add(loadFile.getNations().get(i));
							
						}
						
						Map.year = loadFile.getYear();
						Map.month = loadFile.getMonth();
						Map.nationName = loadFile.getName();
						Map.judicialClause = loadFile.isJudge();
						Map.leadershipClause = loadFile.isLeader();
						Map.constitution = loadFile.isConstitution();
						
						
					}catch(Exception w){
						w.printStackTrace();
					}
					
					Game.gameState = STATE.game;
					
					map.monthlyEffect();
					map.getIssues();
				}
			}
		}
		
	}
	
	public void tick(){
		
	}
	
	public void render(Graphics g){
		g.setColor(Color.black);
		g.fillRect(0,0, Game.width, Game.height);

		g.drawImage(paper, 0, 0, Game.width, Game.height, null);
		
		g.drawRect(200, 200, 400, 100);
		g.setFont(new Font("Courier New", Font.BOLD, 95));
		g.drawString("Commonwealth", 65, 120);
		g.setFont(new Font("Courier New", 0, 80));
		g.drawString("Play", 300, 270);
		if(ser.checkFileExists()){
			g.drawRect(200, 350, 400, 100);
			g.drawString("Load", 300, 420);
		
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

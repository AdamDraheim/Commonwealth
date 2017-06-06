package commonwealth.game;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;

import commonwealth.game.Game.STATE;
import commonwealth.nations.Democracy;
import commonwealth.nations.Fanatics;
import commonwealth.nations.ID;
import commonwealth.nations.NewOrder;
import commonwealth.nations.Traders;
import commonwealth.nations.Tribals;

public class NationName extends KeyAdapter{

	public String nation = "THE LOST COLONY";
	
	BufferedImageLoader loader = new BufferedImageLoader();
	
	BufferedImage paper = null, border = null, back = null;
	Game game;
	//16 max
	public NationName(Game game){
		
		this.game = game;
		
		try{
			paper = loader.loadImage("/tex/Paper.png");
			border = loader.loadImage("/tex/Border.png");
			back = loader.loadImage("/tex/Left.png");
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
	public void keyPressed(KeyEvent e){
		
		int key = e.getKeyCode();
		
		if(Game.gameState == STATE.naming){
			
			if(key != KeyEvent.VK_ENTER && key != KeyEvent.VK_BACK_SPACE && (KeyEvent.getKeyText(key).length() == 1 ||key == KeyEvent.VK_SPACE)){
				if(nation.length() < 16){
					if(key != KeyEvent.VK_SPACE){
						nation += KeyEvent.getKeyText(key).toUpperCase();
					}else if(key == KeyEvent.VK_SPACE){
						nation += " ";
					}
				}
			}
			if(key == KeyEvent.VK_ENTER){
				if(nation.length() > 0){
					Map.nationName = nation;
					Game.gameState = STATE.origin;
					
					Map.nationList.add(new NewOrder(50, (int)(Math.random() * 10) + 57, (int)(Math.random() * 10) + 77, (int)(Math.random() * 10) + 25, (int)(Math.random() * 10) + 35, ID.order, game));
					Map.nationList.add(new Tribals(50, (int)(Math.random() * 10) + 57, (int)(Math.random() * 10) + 57, (int)(Math.random() * 10) + 35, (int)(Math.random() * 10) + 35, ID.tribal, game));
					Map.nationList.add(new Fanatics(50, (int)(Math.random() * 10) + 35, (int)(Math.random() * 10) + 25, (int)(Math.random() * 10) + 77, (int)(Math.random() * 10) + 57, ID.fanatic, game));
					Map.nationList.add(new Democracy(50, (int)(Math.random() * 10) + 35, (int)(Math.random() * 10) + 45, (int)(Math.random() * 10) + 47, (int)(Math.random() * 10) + 47, ID.democrat, game));
					Map.nationList.add(new Traders(50, (int)(Math.random() * 10) + 67, (int)(Math.random() * 10) + 45, (int)(Math.random() * 10) + 35, (int)(Math.random() * 10) + 57, ID.trader, game));
					
				}
			}if(key == KeyEvent.VK_BACK_SPACE){
				if(nation.length() > 0){
					nation = nation.substring(0, nation.length() - 1);
				}
			}
			
		}
		
	}
	
	public void tick(){
		
	}
	
	public void render(Graphics g){
		g.setColor(Color.black);
		g.drawImage(paper, 0, 0, Game.width, Game.height, null);
		g.setColor(new Color(50, 30, 20));
		g.drawImage(border, 95, 185, 600, 100, null);
		g.setFont(new Font("Courier New", 0, 40));
		g.drawString(nation, 220, 245);
		g.setFont(new Font("Courier New", 0, 25));
		g.drawString("*Press <Enter> to confirm name", 200, 450);
		g.drawString("*Name must contain something", 200, 480);
		
		g.drawImage(back, 50, 50, 64, 64, null);
	}
	
}

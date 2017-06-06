package commonwealth.game;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

import commonwealth.game.Game.STATE;

public class InfoBook extends MouseAdapter{

	public static boolean bookOpen = false;
	int page = 1;
	
	public BufferedImageLoader loader = new BufferedImageLoader();
	BufferedImage book = null, x = null, right = null, left = null;
	
	public InfoBook(Map map){
		
		try{
			book = loader.loadImage("/tex/OpenBook.png");
			x = loader.loadImage("/tex/X.png");
			right = loader.loadImage("/tex/Right.png");
			left = loader.loadImage("/tex/Left.png");

		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
	
	public void mousePressed(MouseEvent e){
		
		int mx = e.getX();
		int my = e.getY();
		if(Game.gameState == STATE.game){
			if(bookOpen){
				if(mouseOver(mx, my, 640, 40, 64, 64)){
					bookOpen = false;
				}
				if(mouseOver(mx, my, 640, 500, 64,64)){
					if(page != 4){
						page++;
					}
				}
				if(mouseOver(mx, my, 90, 500, 64,64)){
					if(page != 1){
						page--;
					}
				}
			}
		}
		
	}
	
	public void tick(){
		
	}
	
	public void render(Graphics g){
		
		if(bookOpen){
			g.drawImage(book, 0, 0,Game.width, Game.height, null);
			g.drawImage(x, 640, 40, 64, 64, null);
			if(page != 4){
				g.drawImage(right, 640, 500, 64,64, null);
			}
			if(page != 1){
				g.drawImage(left, 90, 500, 64,64, null);
			}
			
			if(page == 1){
				g.setFont(new Font("Arial", Font.BOLD, 30));
				g.setColor(Color.BLACK);
				g.drawString(Map.nationName, 100, 130);
				g.drawString("How to Play", 440, 130);
				
				g.setFont(new Font("Arial", 0, 15));
				g.drawString("A forgotten colony, now lost", 100, 160);
				g.drawString("from the homeworld in mysterious", 100, 180);
				g.drawString("circumstances, elected a new leader", 100, 200);
				g.drawString("To manage the now independent", 100, 220);
				g.drawString("nation. Yet, the new nation, known as", 100, 240);
				g.drawString(Map.nationName + " has five colonial", 100, 260);
				g.drawString("states vying for power in the new world.", 100, 280);
				g.drawString("Will the nation stand the test of time", 100, 300);
				g.drawString("and regain contact with their old home?", 100, 320);
				
				g.drawString("As leader of " + Map.nationName + ", your", 440, 160);
				g.drawString("job is to manage the general politics of", 440, 180);
				g.drawString("each state to either keep the union", 440, 200);
				g.drawString("together or let one state rise to rule", 440, 220);
				g.drawString("the nation. Each month, you will receive", 440, 240);
				g.drawString("a few issues, which you can accept", 440, 260);
				g.drawString("or deny. This will have an impact on each", 440, 280);
				g.drawString("states' happiness, defense, technology,", 440, 300);
				g.drawString("resources, or religion. Then, at the end", 440, 320);
				g.drawString("of each month, each state's happiness", 440, 340);
				g.drawString("will be adjusted in regards to their beliefs", 440, 360);
				g.drawString("relative to their status. Keep them happy", 440, 380);
				g.drawString("or destroy them, so long as you rule until", 440, 400);
				g.drawString("2250. Good luck Mr. President.", 440, 420);
			}
			
			if(page == 2){
				g.setFont(new Font("Arial", Font.BOLD, 30));
				g.setColor(Color.BLACK);
				g.drawString("The Ashen Tide", 100, 130);
				g.drawString("Aegr Republic", 440, 130);
				
				g.setFont(new Font("Arial", 0, 15));
				g.drawString("Upon lost contact, several groups in", 100, 160);
				g.drawString(" the Northern region seperated and ", 100, 180);
				g.drawString("formed tribes becoming a hunter-gatherer ", 100, 200);
				g.drawString("society. Soon, contact was made with the", 100, 220);
				g.drawString("Ba'hn Traders, and added scavenging for", 100, 240);
				g.drawString(" old tech to their society The Ashen ", 100, 260);
				g.drawString("Tide prefer traditional society and", 100, 280);
				g.drawString("harbor distrust for organized religion,", 100, 300);
				g.drawString(" due to their long enduring tribal ", 100, 320);
				g.drawString("ancestral tales of long forgotten stories", 100, 340);
				g.drawString(" of space travel.", 100, 360);
				
				g.drawString("The Aegr Republic is the closest", 440, 160);
				g.drawString(" government to the mother nation ", 440, 180);
				g.drawString("on Earth. They first drew up the ", 440, 200);
				g.drawString("'Origin Contract' based on the rights", 440, 220);
				g.drawString(" of all humans and some old paper they", 440, 240);
				g.drawString("found called 'The Constitution'. While", 440, 260);
				g.drawString("yearning for a new Republic, the Aegr ", 440, 280);
				g.drawString("Republic longs to make the planet ", 440, 300);
				g.drawString("habitable for all with thehelp of", 440, 320);
				g.drawString(" the new national government.", 440, 340);
			}
		
			if(page == 3){
				g.setFont(new Font("Arial", Font.BOLD, 30));
				g.setColor(Color.BLACK);
				g.drawString("Ba'hn Traders", 100, 130);
				g.drawString("Sons of Primum", 440, 130);
				
				g.setFont(new Font("Arial", 0, 15));
				g.drawString("When the Ba'hn first looked out", 100, 160);
				g.drawString("upon the trade paradise that would", 100, 180);
				g.drawString("become their state, they instantly", 100, 200);
				g.drawString("began thinking of the best locations", 100, 220);
				g.drawString("for trading hubs, hotels, and galactic", 100, 240);
				g.drawString("marts. However, a month after lost", 100, 260);
				g.drawString("contact with home, they realized that ", 100, 280);
				g.drawString("they weren't receiving any interplanet", 100, 300);
				g.drawString("trade-dealing any time soon. Instead,", 100, 320);
				g.drawString("while trying to find trading partners", 100, 340);
				g.drawString("managed to create the modern alliance", 100, 360);
				g.drawString("the region is in today.", 100, 380);
				
				g.drawString("Inspired by the events occuring shortly", 440, 160);
				g.drawString("before lost contact, the Sons of Primum", 440, 180);
				g.drawString("began worshipping the old technology", 440, 200);
				g.drawString("and found their prophet in an old robot", 440, 220);
				g.drawString("named Danton. They have a hierarchal", 440, 240);
				g.drawString("religious society based on the idea that ", 440, 260);
				g.drawString("the old technology would bring salvation", 440, 280);
				g.drawString("Their locally-focused efforts helped many", 440, 300);
				g.drawString("colonists with their charitable actions,", 440, 320);
				g.drawString("though many worry they will accidentally", 440, 340);
				g.drawString("restart the more dangerous components", 440, 360);
				g.drawString("of the old technology.", 440, 380);

			}

			if(page == 4){
				g.setFont(new Font("Arial", Font.BOLD, 30));
				g.setColor(Color.BLACK);
				g.drawString("Remnant", 100, 130);
				
				g.setFont(new Font("Arial", 0, 15));

				g.drawString("To be fair, the military troops stationed", 100, 160);
				g.drawString("on the Origin, and later " + Map.nationName, 100, 180);
				g.drawString("intended to work alongside the civilians", 100, 200);
				g.drawString("yet, after much 'civie' incompetence,", 100, 220);
				g.drawString("the military leaders decided that it was ", 100, 240);
				g.drawString("too risky to leave everyone's lives in the", 100, 260);
				g.drawString("hands of the weak. As such, the military", 100, 280);
				g.drawString("soon established a new order in the middle", 100, 300);
				g.drawString("of the region with their nationalistic", 100, 320);
				g.drawString("speeches and promises of safety through.", 100, 340);
				g.drawString("unity.", 100, 360);
				

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

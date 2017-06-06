package commonwealth.scenes;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import commonwealth.game.BufferedImageLoader;
import commonwealth.game.Game;
import commonwealth.game.Map;
import commonwealth.game.Game.STATE;

public class UnityEnding {

	BufferedImageLoader loader = new BufferedImageLoader();
	BufferedImage warImage = null, victoryImage = null, overThrowImage = null, PeaceImage = null, nearPerfect = null;
	
	public static boolean war = false;
	public static int warEffort = 0;
	int timer = 0;
	
	public UnityEnding(Game game){
		
		try{
			warImage = loader.loadImage("/endings/Battle.png");
			victoryImage = loader.loadImage("/endings/Victory.png");
			overThrowImage = loader.loadImage("/endings/Overthrown.png");
			PeaceImage = loader.loadImage("/endings/Peace.png");
			nearPerfect = loader.loadImage("/endings/AlmostPerfect.png");
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
	
	public void tick(){
		timer++;
	}
	
	public void render(Graphics g){
		
		if(war){
			if(Map.leadershipClause == false || Map.secede[4] == true){
				if(warEffort < 200){
					g.drawImage(warImage, 0, 0, Game.width, Game.height, null);
					
					
					if(timer < 255){
						g.setColor(new Color(0, 0, 0, 255 - timer));
						g.fillRect(0, 0, Game.width, Game.height);
					}
					
					g.setFont(new Font("Courier New", Font.BOLD, 20));
					
					if(timer >= 250){
						if(timer < 350){
							g.setColor(new Color(255, 255, 255, (timer - 250) * (5/2)));
						}else{
							g.setColor(Color.white);
						}
						g.drawString("By 2250, war became a norm for the people of " + Map.nationName, 10, 20);
		
					}
					
					if(timer >= 400){
						if(timer < 500){
							g.setColor(new Color(255, 255, 255, (timer - 400) * (5 / 2)));
						}else{
							g.setColor(Color.white);
						}
						g.drawString("Territory never seemed to shift and progress was never made.", 10, 50);
					}
					if(timer >= 550){
						if(timer < 650){
							g.setColor(new Color(255, 255, 255, (timer - 550) * (5 / 2)));
						}else{
							g.setColor(Color.white);
						}
						g.drawString("The hope of a united nation faded into distant memory.", 10, 80);
						
					}
					
					if(timer >= 700){
						if(timer < 800){
							g.setColor(new Color(255, 255, 255, (timer - 700) * (5 / 2)));
						}else{
							g.setColor(Color.white);
						}
						g.drawString("The rebels eventually won independence ten years later,", 10, 140);
					}
					
					if(timer >= 850){
						if(timer < 950){
							g.setColor(new Color(255, 255, 255, (timer - 850) * (5 / 2)));
						}else{
							g.setColor(Color.white);
						}
						g.drawString("and would tell great tales of their fight for freedom.", 10, 170);
						
					}
					
					if(timer >= 1000){
						if(timer < 1100){
							g.setColor(new Color(255, 255, 255, (timer - 1000) * (5 / 2)));
						}else{
							g.setColor(Color.white);
						}
						g.drawString("from the tyranny under your rule", 10, 200);
					}
					
					if(timer > 1200){
						g.setColor(new Color(0, 0, 0, timer - 1200));
						g.fillRect(0, 0, Game.width, Game.height);
					}
					
				}else if(warEffort >= 200){
					g.drawImage(victoryImage, 0, 0, Game.width, Game.height, null);
					
					
					if(timer < 255){
						g.setColor(new Color(0, 0, 0, 255 - timer));
						g.fillRect(0, 0, Game.width, Game.height);
					}
					
					g.setFont(new Font("Courier New", Font.BOLD, 20));
					
					if(timer >= 250){
						if(timer < 350){
							g.setColor(new Color(255, 255, 255, (timer - 250) * (5/2)));
						}else{
							g.setColor(Color.white);
						}
						g.drawString("The rebel's mutiny did not last long, thanks to your troops.", 10, 20);
		
					}
					
					if(timer >= 400){
						if(timer < 500){
							g.setColor(new Color(255, 255, 255, (timer - 400) * (5 / 2)));
						}else{
							g.setColor(Color.white);
						}
						g.drawString("They bravely laid down their lives in those trenches", 10, 50);
					}
					if(timer >= 550){
						if(timer < 650){
							g.setColor(new Color(255, 255, 255, (timer - 550) * (5 / 2)));
						}else{
							g.setColor(Color.white);
						}
						g.drawString("to ensure the ideas of freedom and unity stayed alive.", 10, 80);
						
					}
					
					if(timer >= 700){
						if(timer < 800){
							g.setColor(new Color(255, 255, 255, (timer - 700) * (5 / 2)));
						}else{
							g.setColor(Color.white);
						}
						g.drawString("When the rebels finally surrendered, you were merciful", 10, 140);
					}
					
					if(timer >= 850){
						if(timer < 950){
							g.setColor(new Color(255, 255, 255, (timer - 850) * (5 / 2)));
						}else{
							g.setColor(Color.white);
						}
						g.drawString("You helped them rebuild, and soon rebellion was a memory.", 10, 170);
						
					}
					
					if(timer >= 1000){
						if(timer < 1100){
							g.setColor(new Color(255, 255, 255, (timer - 1000) * (5 / 2)));
						}else{
							g.setColor(Color.white);
						}
						g.drawString("Unity was restored in " + Map.nationName + ".", 10, 200);
					}
					
					if(timer > 1200){
						g.setColor(new Color(0, 0, 0, timer - 1200));
						g.fillRect(0, 0, Game.width, Game.height);
					}
				}
			}else if(Map.leadershipClause && Map.secede[4] == false){
				g.drawImage(overThrowImage, 0, 0, Game.width, Game.height, null);
					
					
				if(timer < 255){
					g.setColor(new Color(0, 0, 0, 255 - timer));
					g.fillRect(0, 0, Game.width, Game.height);
				}
					
				g.setFont(new Font("Courier New", Font.BOLD, 20));
					
				if(timer >= 250){
					if(timer < 350){
						g.setColor(new Color(255, 255, 255, (timer - 250) * (5/2)));
					}else{
						g.setColor(Color.white);
					}
					g.drawString("When war broke out, your reign did not last long much longer.", 10, 20);
		
				}
					
				if(timer >= 400){
					if(timer < 500){
						g.setColor(new Color(255, 255, 255, (timer - 400) * (5 / 2)));
					}else{
						g.setColor(Color.white);
					}
					g.drawString("Invoking the leadership clause, General Witheim usurped power.", 10, 50);
				}
				if(timer >= 550){
					if(timer < 650){
						g.setColor(new Color(255, 255, 255, (timer - 550) * (5 / 2)));
					}else{
						g.setColor(Color.white);
					}
					g.drawString("Total war began, and soon the war was over.", 10, 80);
						
				}
					
				if(timer >= 700){
					if(timer < 800){
						g.setColor(new Color(255, 255, 255, (timer - 700) * (5 / 2)));
					}else{
						g.setColor(Color.white);
					}
					g.drawString("Out of the ashes of the rebellion were subservant souls.", 10, 140);
				}
					
				if(timer >= 850){
					if(timer < 950){
						g.setColor(new Color(255, 255, 255, (timer - 850) * (5 / 2)));
					}else{
						g.setColor(Color.white);
					}
					g.drawString("Their hope for freedom crushed by the Remnant", 10, 170);
					
				}
					
				if(timer >= 1000){
					if(timer < 1100){
						g.setColor(new Color(255, 255, 255, (timer - 1000) * (5 / 2)));
					}else{
						g.setColor(Color.white);
					}
					g.drawString("A new era of fear had begun in " + Map.nationName + ".", 10, 200);
				}
					
				if(timer > 1200){
					g.setColor(new Color(0, 0, 0, timer - 1200));
					g.fillRect(0, 0, Game.width, Game.height);
				}
			}
		}else if(!war){
			if(Map.nationList.size() >= 4){
				g.drawImage(PeaceImage, 0, 0, Game.width, Game.height, null);
				
				
				if(timer < 255){
					g.setColor(new Color(0, 0, 0, 255 - timer));
					g.fillRect(0, 0, Game.width, Game.height);
				}
					
				g.setFont(new Font("Courier New", Font.BOLD, 20));
					
				if(timer >= 250){
					if(timer < 350){
						g.setColor(new Color(255, 255, 255, (timer - 250) * (5/2)));
					}else{
						g.setColor(Color.white);
					}
					g.drawString("Despite the hardships of the previous years,", 10, 20);
		
				}
					
				if(timer >= 400){
					if(timer < 500){
						g.setColor(new Color(255, 255, 255, (timer - 400) * (5 / 2)));
					}else{
						g.setColor(Color.white);
					}
					g.drawString(Map.nationName + " survived and entered a golden age of peace", 10, 50);
				}
				if(timer >= 550){
					if(timer < 650){
						g.setColor(new Color(255, 255, 255, (timer - 550) * (5 / 2)));
					}else{
						g.setColor(Color.white);
					}
					g.drawString("All were happy, and all were free.", 10, 80);
						
				}
					
				if(timer >= 700){
					if(timer < 800){
						g.setColor(new Color(255, 255, 255, (timer - 700) * (5 / 2)));
					}else{
						g.setColor(Color.white);
					}
					g.drawString("You were remembered as the greatest leader of the colony.", 10, 140);
				}
					
				if(timer >= 850){
					if(timer < 950){
						g.setColor(new Color(255, 255, 255, (timer - 850) * (5 / 2)));
					}else{
						g.setColor(Color.white);
					}
					g.drawString("Historians marvelled at your ability to hold the colony together.", 10, 170);
					
				}
					
				if(timer >= 1000){
					if(timer < 1100){
						g.setColor(new Color(255, 255, 255, (timer - 1000) * (5 / 2)));
					}else{
						g.setColor(Color.white);
					}
					g.drawString("That statue of you suffices as a small repayment for your service.", 10, 200);
				}
					
				if(timer > 1200){
					g.setColor(new Color(0, 0, 0, timer - 1200));
					g.fillRect(0, 0, Game.width, Game.height);
				}
			}else if(Map.nationList.size() < 4){
				
				g.drawImage(nearPerfect, 0, 0, Game.width, Game.height, null);
				
				
				if(timer < 255){
					g.setColor(new Color(0, 0, 0, 255 - timer));
					g.fillRect(0, 0, Game.width, Game.height);
				}
					
				g.setFont(new Font("Courier New", Font.BOLD, 20));
					
				if(timer >= 250){
					if(timer < 350){
						g.setColor(new Color(255, 255, 255, (timer - 250) * (5/2)));
					}else{
						g.setColor(Color.white);
					}
					g.drawString("Historians cannot agree on your quality of leadership.", 10, 20);
		
				}
					
				if(timer >= 400){
					if(timer < 500){
						g.setColor(new Color(255, 255, 255, (timer - 400) * (5 / 2)));
					}else{
						g.setColor(Color.white);
					}
					g.drawString("While peace was maintained and no major conflicts arose,", 10, 50);
				}
				if(timer >= 550){
					if(timer < 650){
						g.setColor(new Color(255, 255, 255, (timer - 550) * (5 / 2)));
					}else{
						g.setColor(Color.white);
					}
					g.drawString("the nation did not say unified. Some districts seceded.", 10, 80);
						
				}
					
				if(timer >= 700){
					if(timer < 800){
						g.setColor(new Color(255, 255, 255, (timer - 700) * (5 / 2)));
					}else{
						g.setColor(Color.white);
					}
					g.drawString("What matters now is that " + Map.nationName + " will endure.", 10, 140);
				}
					
				if(timer >= 850){
					if(timer < 950){
						g.setColor(new Color(255, 255, 255, (timer - 850) * (5 / 2)));
					}else{
						g.setColor(Color.white);
					}
					g.drawString("You were so close to keeping everything together", 10, 170);
					
				}
					
				if(timer >= 1000){
					if(timer < 1100){
						g.setColor(new Color(255, 255, 255, (timer - 1000) * (5 / 2)));
					}else{
						g.setColor(Color.white);
					}
					g.drawString("but in the end, that goal was just out of reach...", 10, 200);
				}
					
				if(timer > 1200){
					g.setColor(new Color(0, 0, 0, timer - 1200));
					g.fillRect(0, 0, Game.width, Game.height);
				}
				
			}
		}
		
	}
	
}

package commonwealth.game;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.util.LinkedList;

import commonwealth.constitution.Constitution;
import commonwealth.constitution.LeadershipClause;
import commonwealth.constitution.judgeClause;
import commonwealth.game.Game.STATE;
import commonwealth.issues.CompulsoryService;
import commonwealth.issues.Currency;
import commonwealth.issues.DefenseFunding;
import commonwealth.issues.Education;
import commonwealth.issues.IssueMenu;
import commonwealth.issues.Issues;
import commonwealth.issues.Nationhood;
import commonwealth.issues.Refugees;
import commonwealth.issues.RepealSlavery;
import commonwealth.issues.RocketMan;
import commonwealth.issues.SatellitePrayer;
import commonwealth.issues.Slavery;
import commonwealth.issues.TechPreservation;
import commonwealth.issues.TechTax;
import commonwealth.issues.TradeRoutes;
import commonwealth.issues.Transmission;
import commonwealth.nations.Democracy;
import commonwealth.nations.Fanatics;
import commonwealth.nations.ID;
import commonwealth.nations.Nations;
import commonwealth.nations.NewOrder;
import commonwealth.nations.Traders;
import commonwealth.nations.Tribals;
import commonwealth.secede.DemSecede;
import commonwealth.secede.OrderSecede;
import commonwealth.secede.SonsSecede;
import commonwealth.secede.TradeSecede;
import commonwealth.secede.TribeSecede;
import commonwealth.ser.Serialization;
import commonwealth.ser.fileInfo;

public class Map extends MouseAdapter{

	BufferedImageLoader loader = new BufferedImageLoader();
	BufferedImage map = null;
	BufferedImage newspaper = null, infobook = null;
	BufferedImage newsSel = null;
	
	public static BufferedImage topNation = null, centernation = null, bottomnation = null, leftnation = null, rightnation = null;
	public static BufferedImage icons = null;
	
	public static String nationName;
	public int currentIssue;
	public static int year = 1;
	public static int month = 1;
	Serialization ser = new Serialization();
	
	public static boolean[] secede = new boolean[5];
	public static boolean constitution;
	public static boolean leadershipClause, judicialClause;

	
	public static boolean[] issueSelect = new boolean[5];
	
	public LinkedList<Issues> issueList = new LinkedList<Issues>();
	public static LinkedList<Nations> nationList = new LinkedList<Nations>();

	public Map(Game game){
		
		try{
			
			map = loader.loadImage("/tex/Map.png");
			newspaper = loader.loadImage("/tex/Newspaper.png");
			infobook = loader.loadImage("/tex/InfoBook.png");
			icons = loader.loadImage("/tex/Icons.png");
			
			topNation = loader.loadImage("/tex/TopNation.png");
			centernation = loader.loadImage("/tex/CenterNation.png");
			bottomnation = loader.loadImage("/tex/BottomNation.png");
			leftnation = loader.loadImage("/tex/LeftNation.png");
			rightnation = loader.loadImage("/tex/RightNation.png");
			
			if(month == 1 && year == 1){
				issueList.add(new Nationhood(this));
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
	
	public void mousePressed(MouseEvent e){
		
		int mx = e.getX();
		int my = e.getY();
		if(Game.gameState == STATE.game){
			if(IssueMenu.issueActive == false && InfoBook.bookOpen == false){
				for(int i = 0; i < issueList.size(); i++){
					if(mouseOver(mx, my, 670, (100 * i) + 50, 128, 128)){
						
						currentIssue = i;
	
						IssueMenu.issueActive = true;
					}
					
				}
				if(mouseOver(mx, my, 20, 480, 100, 100)){
					
					InfoBook.bookOpen = true;
					
				}
				
				if(mouseOver(mx, my, 670, 10, 120, 40)){
					month += 1;
					if(month > 12){
						month = 1;
						year += 1;
					}
					
					try{
						fileInfo file = new fileInfo(nationName, nationList, year, month, constitution, judicialClause, leadershipClause);
						ser.save(file);
					}catch(Exception w){
						w.printStackTrace();
					}
					
					getIssues();
					monthlyEffect();
				}
			}
		}
		
	}
	
	public void tick(){
		
		for(int i = 0; i < nationList.size(); i++){
			Nations tempNation = nationList.get(i);
			tempNation.tick();
		}
	}
	
	public void render(Graphics g){
		
		g.drawImage(map, 0, 0, Game.width, Game.height, null);
		for(int i = 0; i < nationList.size(); i++){
			Nations tempNation = nationList.get(i);
			tempNation.render(g);
		}
		for(int i = 0; i < issueList.size(); i++){
			if(issueSelect[i] == false){
				g.drawImage(newspaper, 670, (100 * i) + 50, 128, 128, null);
			}else if(issueSelect[i] == true){
				g.drawImage(newsSel, 670, (100 * i) + 50, 128, 128, null);
			}
		}
		
		g.setColor(Color.black);
		g.drawRect(670, 10, 120, 40);
		g.setFont(new Font("Arial", Font.BOLD, 20));
		g.drawString("End Month", 680, 35);
		
		g.setFont(new Font("Courier New", Font.BOLD, 30));
		g.drawString(nationName + "- Year " + (year + 2230) + ", Month " + month, 10, 40);
		
		g.drawImage(infobook, 20, 480, 100, 100, null);
		
	}
	
	public void monthlyEffect(){
		
		for(int i = 0; i < nationList.size(); i++){
			Nations tempNation = nationList.get(i);
			
			if(tempNation.getAffiliation() == ID.democrat){
				if(tempNation.getDefense() < 40){
					tempNation.setHappiness(tempNation.getHappiness() - 5);
				}else{
					tempNation.setHappiness(tempNation.getHappiness() + 3);
				}
				if(tempNation.getResources() < 60){
					tempNation.setHappiness(tempNation.getHappiness() - 5);
				}else{
					tempNation.setHappiness(tempNation.getHappiness() + 3);
				}
				if(tempNation.getReligion() < 50){
					tempNation.setHappiness(tempNation.getHappiness() - 5);
				}else{
					tempNation.setHappiness(tempNation.getHappiness() + 3);
				}
				if(tempNation.getTech() < 50){
					tempNation.setHappiness(tempNation.getHappiness() - 5);
				}else{
					tempNation.setHappiness(tempNation.getHappiness() + 3);
				}
			}
			
			if(tempNation.getAffiliation() == ID.fanatic){
				if(tempNation.getDefense() < 30){
					tempNation.setHappiness(tempNation.getHappiness() - 5);
				}else{
					tempNation.setHappiness(tempNation.getHappiness() + 3);
				}
				if(tempNation.getResources() < 40){
					tempNation.setHappiness(tempNation.getHappiness() - 5);
				}else{
					tempNation.setHappiness(tempNation.getHappiness() + 3);
				}
				if(tempNation.getReligion() < 80){
					tempNation.setHappiness(tempNation.getHappiness() - 5);
				}else{
					tempNation.setHappiness(tempNation.getHappiness() + 3);
				}
				if(tempNation.getTech() < 60){
					tempNation.setHappiness(tempNation.getHappiness() - 5);
				}else{
					tempNation.setHappiness(tempNation.getHappiness() + 3);
				}
			}
			if(tempNation.getAffiliation() == ID.trader){
				if(tempNation.getDefense() < 50){
					tempNation.setHappiness(tempNation.getHappiness() - 5);
				}else{
					tempNation.setHappiness(tempNation.getHappiness() + 3);
				}
				if(tempNation.getResources() < 70){
					tempNation.setHappiness(tempNation.getHappiness() - 5);
				}else{
					tempNation.setHappiness(tempNation.getHappiness() + 3);
				}
				if(tempNation.getReligion() < 40){
					tempNation.setHappiness(tempNation.getHappiness() - 5);
				}else{
					tempNation.setHappiness(tempNation.getHappiness() + 3);
				}
				if(tempNation.getTech() < 60){
					tempNation.setHappiness(tempNation.getHappiness() - 5);
				}else{
					tempNation.setHappiness(tempNation.getHappiness() + 3);
				}
			}
			
			if(tempNation.getAffiliation() == ID.order){
				if(tempNation.getDefense() < 80){
					tempNation.setHappiness(tempNation.getHappiness() - 5);
				}else{
					tempNation.setHappiness(tempNation.getHappiness() + 3);
				}
				if(tempNation.getResources() < 60){
					tempNation.setHappiness(tempNation.getHappiness() - 5);
				}else{
					tempNation.setHappiness(tempNation.getHappiness() + 3);
				}
				if(tempNation.getReligion() < 30){
					tempNation.setHappiness(tempNation.getHappiness() - 5);
				}else{
					tempNation.setHappiness(tempNation.getHappiness() + 3);
				}
				if(tempNation.getTech() < 40){
					tempNation.setHappiness(tempNation.getHappiness() - 5);
				}else{
					tempNation.setHappiness(tempNation.getHappiness() + 3);
				}
			}
			if(tempNation.getAffiliation() == ID.tribal){
				if(tempNation.getDefense() < 60){
					tempNation.setHappiness(tempNation.getHappiness() - 5);
				}else{
					tempNation.setHappiness(tempNation.getHappiness() + 3);
				}
				if(tempNation.getResources() < 60){
					tempNation.setHappiness(tempNation.getHappiness() - 5);
				}else{
					tempNation.setHappiness(tempNation.getHappiness() + 3);
				}
				if(tempNation.getReligion() < 40){
					tempNation.setHappiness(tempNation.getHappiness() - 5);
				}else{
					tempNation.setHappiness(tempNation.getHappiness() + 3);
				}
				if(tempNation.getTech() < 40){
					tempNation.setHappiness(tempNation.getHappiness() - 5);
				}else{
					tempNation.setHappiness(tempNation.getHappiness() + 3);
				}
			}
		}
		
	}
	
	public void getIssues(){
		issueList.clear();
		
		//Ordinary Issue
		int randomIssue = (int)(Math.random() * 10);
		if(randomIssue == 0){
			issueList.add(new TechTax(this));
		}else if(randomIssue == 1){
			issueList.add(new TechPreservation(this));
		}else if(randomIssue == 2){
			issueList.add(new DefenseFunding(this));
		}else if(randomIssue == 3){
			issueList.add(new TradeRoutes(this));
		}else if(randomIssue == 4){
			issueList.add(new Currency(this));
		}else if(randomIssue == 5){
			issueList.add(new Transmission(this));
		}else if(randomIssue == 6){
			if(!Slavery.slaveryActive){
				issueList.add(new Slavery(this));
			}else if(Slavery.slaveryActive){
				issueList.add(new RepealSlavery(this));
			}
		}else if(randomIssue == 7){
			if(!CompulsoryService.service){
				issueList.add(new CompulsoryService(this));
			}else if(CompulsoryService.service){
				issueList.add(new RocketMan(this));
			}
		}else if(randomIssue == 8){
			issueList.add(new SatellitePrayer(this));
		}else if(randomIssue == 9){
			issueList.add(new Refugees(this));
		}else if(randomIssue == 10){
			issueList.add(new Education(this));
		}
		
		//Constitution Issue
		
		if(month == 1 && year == 2){
			issueList.add(new Constitution(this));
		}
		if(month == 2 && year == 2 && constitution == true){
			issueList.add(new LeadershipClause(this));
			issueList.add(new judgeClause(this));
		}
		
		//secession
		
		for(int i = 0; i < nationList.size(); i++){
			Nations tempNation = nationList.get(i);
			if(tempNation.getAffiliation() == ID.fanatic){
				if(tempNation.getHappiness() == 0){
					issueList.add(new SonsSecede(this));
					nationList.remove(tempNation);
					secede[0] = true;
				}
			}if(tempNation.getAffiliation() == ID.trader){
				if(tempNation.getHappiness() == 0){
					issueList.add(new TradeSecede(this));
					nationList.remove(tempNation);
					secede[1] = true;

				}
			}if(tempNation.getAffiliation() == ID.democrat){
				if(tempNation.getHappiness() == 0){
					issueList.add(new DemSecede(this));
					nationList.remove(tempNation);
					secede[2] = true;

				}
			}if(tempNation.getAffiliation() == ID.tribal){
				if(tempNation.getHappiness() == 0){
					issueList.add(new TribeSecede(this));
					nationList.remove(tempNation);
					secede[3] = true;

				}
			}
			if(tempNation.getAffiliation() == ID.order){
				if(tempNation.getHappiness() == 0){
					issueList.add(new OrderSecede(this));
					nationList.remove(tempNation);
					secede[4] = true;

				}
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

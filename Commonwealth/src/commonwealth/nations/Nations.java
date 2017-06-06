package commonwealth.nations;

import java.awt.Graphics;
import java.io.Serializable;

public abstract class Nations implements Serializable{

	protected int happiness, defense, resources, religion, tech;
	protected ID affiliation;
	
	public Nations(int happiness, int resources, int defense, int religion, int tech, ID affiliation){
		
		this.happiness = happiness;
		this.defense = defense;
		this.resources = resources;
		this.religion = religion;
		this.tech = tech;
		this.affiliation = affiliation;
		
	}

	public abstract void tick();
	public abstract void render(Graphics g);

	public int getHappiness() {
		return happiness;
	}

	public void setHappiness(int happiness) {
		this.happiness = happiness;
	}

	public int getDefense() {
		return defense;
	}

	public void setDefense(int defense) {
		this.defense = defense;
	}



	public int getResources() {
		return resources;
	}

	public void setResources(int resources) {
		this.resources = resources;
	}

	public int getReligion() {
		return religion;
	}

	public void setReligion(int religion) {
		this.religion = religion;
	}

	public int getTech() {
		return tech;
	}

	public void setTech(int tech) {
		this.tech = tech;
	}

	public ID getAffiliation() {
		return affiliation;
	}

	public void setAffiliation(ID affiliation) {
		this.affiliation = affiliation;
	}
	
	
	
}

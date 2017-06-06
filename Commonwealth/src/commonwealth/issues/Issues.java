package commonwealth.issues;

import java.awt.Graphics;
import java.io.Serializable;

public abstract class Issues implements Serializable{
	
	public Issues(){
		
		
		
	}
	
	public abstract void tick();
	public abstract void render(Graphics g);
	public abstract void effects();
	public abstract void negEffects();
	
}

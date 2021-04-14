import processing.core.PApplet;
import processing.event.MouseEvent;

public class Principal extends PApplet {

	public static void main(String[] args) {
		PApplet.main("Principal");
	}

	@Override
	public void settings() {
		size(500, 1500);
	}

	

	@Override
	public void setup() {
		
	}

	@Override
	public void draw() {
		background(250); 
		rectMode(CENTER);
		ellipse(50,50,250,750); 
	}
	
	public void mousePressed() {
      
	}
}

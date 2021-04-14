import Controllers.Controller;
import processing.core.PApplet;

public class Principal extends PApplet {

	Controller controller;
	
	public static void main(String[] args) {
		PApplet.main("Principal");
	}

	@Override
	public void settings() {
		size(500, 1500);
	}

	

	@Override
	public void setup() {
		this.controller = new Controller("Alicia.txt", this);
		this.controller.initialize();
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

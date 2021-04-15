package Model;

import processing.core.PApplet;
import processing.core.PImage;

public class Avatar {
	PImage image;
	int posX; 
	int posY; 
	int heigh;
	int width; 
	int speed;
	AnimateStrategy animateStrategy; 
	PApplet app; 
	
	public Avatar(int _posX, int _posY, int _heigh, int _width, int _speed, PApplet _app) {
		this.posX = _posX; 
		this.posY = _posY; 
		this.heigh = _heigh;
		this.width = _width; 
		this.speed = _speed; 
		this.app = _app;
		
	}
	public void setStrategy(AnimateStrategy strategy) {
		this.animateStrategy = strategy; 	
	}
	public void animate() {
		this.animateStrategy.animate(this); 
	}
	public void setImage(String imagePath) {
		this.image = this.app.loadImage(imagePath);
	}
	
    
}

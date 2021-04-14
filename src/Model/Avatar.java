package Model;

import processing.core.PImage;

public class Avatar {
	PImage image;
	int posX; 
	int posY;
	int posZ; 
	int heigh;
	int width; 
	int speed;
	AnimateStrategy animateStrategy; 
	
	public Avatar(int _posX, int _posY, int _posZ, int _heigh, int _width, int _speed) {
		this.posX = _posX; 
		this.posY = _posY; 
		this.posZ = _posZ; 
		this.heigh = _heigh;
		this.width = _width; 
		this.speed = _speed; 
		
	}
	public void setStrategy(AnimateStrategy strategy) {
		this.animateStrategy = strategy; 
		
	}
	public void animate() {
		this.animateStrategy.animate(this); 
	}
	
    
}

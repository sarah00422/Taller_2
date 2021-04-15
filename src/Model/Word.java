package Model;

import processing.core.PApplet;

public class Word {
	String word;
	boolean animated; 
	Avatar avatar; 
	PApplet app;
	int posX;
	int posY;
	int length;
	
	public Word (String _word, boolean _animated, PApplet _app) {
		this.word = _word; 
		this.animated = _animated; 
		this.app = _app;
		this.length = this.word.length() * 7;
	}
	
	public void animate() {
		if (animated) {
			this.avatar.animate();
		}else return; 
	}
	
	public void setAvatar(Avatar _avatar) {
		this.avatar = _avatar;
	}
	
	public void draw(int pointerX, int pointerY) {
		if(animated) {
			this.app.fill(181, 182, 174);
			this.app.textSize(16);
			this.length = this.word.length() * 12;
		} else {
			this.app.fill(181, 182, 174);
			this.app.textSize(12);
		}
		this.app.text(this.word, pointerX , pointerY);
		posX = pointerX + length/2;
		posY = pointerY + 5;
	}
	
	public int getLength() {
		return this.length;
	}
	
	public boolean isClicked(int mouseX, int mouseY) {
		boolean inRangeX = mouseX > (posX - length/2) && mouseX < (posX + length/2);
		boolean inRangeY = mouseY > (posY - 5) && mouseY < (posY + 5);
		System.out.print(this.avatar);
		return inRangeX && inRangeY;
	}

}

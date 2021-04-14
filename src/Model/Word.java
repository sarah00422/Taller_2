package Model;

import processing.core.PApplet;

public class Word {
	String word;
	boolean animated; 
	Avatar avatar;  
	
	public Word (String _word, boolean _animated) {
		this.word = _word; 
		this.animated = _animated;  
	}
	
	public void animate() {
		if (animated) {
			this.avatar.animate();
		}else return; 
	}
	
	public void setAvatar(Avatar _avatar) {
		this.avatar = _avatar;
	}

}

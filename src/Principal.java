import java.util.ArrayList;

import Controllers.Controller;
import Model.Avatar;
import Model.Word;
import processing.core.PApplet;
import processing.core.PImage;

public class Principal extends PApplet {

	Controller controller;
	ArrayList<ArrayList<Word>> words;
	ArrayList<Avatar> avatars;
	
	public static void main(String[] args) {
		PApplet.main("Principal");
	}
	
	PImage background; 
      
	@Override
	public void settings() {
		size(1200, 1000);
	}

	@Override
	public void setup() {
		this.controller = new Controller("Alicia.txt", this);
		background= loadImage("BACKGROUND.png");
		this.controller.initialize();
		this.controller.setAnimations();
		this.words = this.controller.loadWords();
		this.avatars = this.controller.getAvatars();
	}

	@Override
	public void draw() {
		background(background); 
		rectMode(CENTER);
		renderWords();
		renderAvatars();		
	}
	
	public void mousePressed() {
      animateAvatars(mouseX, mouseY);
      animateWords(mouseX, mouseY);
	}
	
	private void renderWords() {
		int pointerY = 40;
		for(int i = 0; i < words.size(); i++) {
			int pointerX = 20;
			for (int j = 0; j < words.get(i).size(); j++) {
				Word word = words.get(i).get(j);
				word.draw(pointerX, pointerY);
				pointerX += word.getLength() + 8;
			}
			pointerY += 17;
		}
	}
	
	private void renderAvatars() {
		for(int i = 0; i < this.avatars.size(); i++) {
			this.avatars.get(i).draw();
		}
	}
	
	private void animateAvatars(int mouseX, int mouseY) {
		for(int i = 0; i < this.avatars.size(); i++) {
			if(this.avatars.get(i).isClicked(mouseX, mouseY)) {
				this.avatars.get(i).animate();
			}
		}
	}
	
	private void animateWords(int mouseX, int mouseY) {
		for (int i = 0; i < this.words.size(); i++) {
			for(int j = 0; j < this.words.get(i).size(); j ++) {
				Word word = this.words.get(i).get(j);
				if(word.isClicked(mouseX, mouseY)) {
					word.animate();
				}
			}
		}
	}
}

package Controllers;

import java.util.ArrayList;
import java.util.Random;

import Model.AnimatedWords;
import Model.Avatar;
import Model.Word;
import processing.core.PApplet;

public class Controller {
	String filePath;
	PApplet app;
	ArrayList<Avatar> avatars;
	Random random;
	ArrayList<ArrayList<Word>> textData; 
	
	public Controller(String _path, PApplet _app) {
		this.filePath = _path;
		this.app = _app;
		this.textData = new ArrayList<ArrayList<Word>>();
	}
	
	public void initialize() {
		//1. read the file
		this.random = new Random();
		this.avatars = new ArrayList<Avatar>();
		Avatar alicia = new Avatar(100, 200, 1, 50, 50, 20, this.app);
		alicia.setImage("ALICIA.png");
		this.avatars.add(alicia);
		
		String[] lines = app.loadStrings(this.filePath);
		for (int i = 0; i < lines.length; i++) {
			String[] plainWords = lines[i].split(" ");
			ArrayList<Word> objectWords = new ArrayList<Word>();
			for(int j = 0; j < plainWords.length; j++) {
				if(plainWords[j].equals(AnimatedWords.ACHICA.toString())) {
					Word word = new Word(AnimatedWords.ACHICA.toString(), true);
					word.setAvatar(this.avatars.get(0));
					objectWords.add(word);
				} else {
					objectWords.add(new Word(plainWords[j], false));
				}
			}
			this.textData.add(objectWords);
		}
	}
}



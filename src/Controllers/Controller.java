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
		//1. load the images to the different avatars
		this.random = new Random();
		this.avatars = new ArrayList<Avatar>();
		
		Avatar flor = new Avatar(417, 358, 265, 242, 20, this.app);
		flor.setImage("FLOR1.png");
		this.avatars.add(flor);
		
		Avatar alicia = new Avatar(599, 271, 262, 267, 20, this.app);
		alicia.setImage("ALICIA.png");
		this.avatars.add(alicia);
		
		Avatar sombrerero = new Avatar(407, 512, 232, 775, 20, this.app);
		sombrerero.setImage("SOMBRERERO.png");
		this.avatars.add(sombrerero);
		
		Avatar reina = new Avatar(779, 444, 284, 231,20, this.app);
		reina.setImage("REINA1.png");
		this.avatars.add(reina);
		
		Avatar conejo = new Avatar(230, 570, 212, 259, 20, this.app);
		conejo.setImage("CONEJO.png");
		this.avatars.add(conejo);
		
		
		
	}
	
	public void loadWords() {
		//2. load the words and save them into the data structure
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



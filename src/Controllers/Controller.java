package Controllers;

import java.util.ArrayList;
import java.util.Random;

import Model.AnimatedWords;
import Model.Avatar;
import Model.DanceStrategy;
import Model.GetSmallerStrategy;
import Model.JumpStrategy;
import Model.RunStrategy;
import Model.ScreamStrategy;
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
		
		Avatar flor = new Avatar(417, 400, 265, 242, 20, this.app);
		flor.setImage("FLOR 1.png");
		this.avatars.add(flor);
		
		Avatar alicia = new Avatar(599, 271, 262, 267, 20, this.app);
		alicia.setImage("ALICIA.png");
		this.avatars.add(alicia);
		
		Avatar sombrerero = new Avatar(407, 480, 232, 775, 20, this.app);
		sombrerero.setImage("SOMBRERERO.png");
		this.avatars.add(sombrerero);
		
		Avatar reina = new Avatar(779, 444, 284, 231,20, this.app);
		reina.setImage("REINA 1.png");
		this.avatars.add(reina);
		
		Avatar conejo = new Avatar(600, 500, 212, 259, 5, this.app);
		conejo.setImage("CONEJO.png");
		this.avatars.add(conejo);
		
	}
	
	public ArrayList<ArrayList<Word>> loadWords() {
		//2. load the words and save them into the data structure
		String[] lines = app.loadStrings(this.filePath);
		for (int i = 0; i < lines.length; i++) {
			String[] plainWords = lines[i].split(" ");
			ArrayList<Word> objectWords = new ArrayList<Word>();
			for(int j = 0; j < plainWords.length; j++) {
				this.createWords(plainWords, objectWords, j);
			}
			this.textData.add(objectWords);
		}
		return this.textData;
	}
	
	public void setAnimations() {
		Avatar flor = this.avatars.get(0);
		Avatar alicia = this.avatars.get(1);
		Avatar sombrerero = this.avatars.get(2);
		Avatar reina = this.avatars.get(3);
		Avatar conejo = this.avatars.get(4);
		flor.setStrategy(DanceStrategy.getInstance());
		alicia.setStrategy(GetSmallerStrategy.getInstance());
		sombrerero.setStrategy(JumpStrategy.getInstance());
		reina.setStrategy(ScreamStrategy.getInstance());
		conejo.setStrategy(RunStrategy.getInstance());
	}
	
	private void createWords(String[] plainWords, ArrayList<Word> objectWords, int j) {
		if(plainWords[j].contains(AnimatedWords.ACHICA.toString())) {
			Word word = new Word(AnimatedWords.ACHICA.toString(), true, this.app);
			word.setAvatar(this.avatars.get(1));
			objectWords.add(word);
		} else if(plainWords[j].contains(AnimatedWords.CONEJO.toString())) {
			Word word = new Word(AnimatedWords.CONEJO.toString(), true, this.app);
			word.setAvatar(this.avatars.get(4));
			objectWords.add(word);
		} else if(plainWords[j].contains(AnimatedWords.SOMBRERERO.toString())) {
			Word word = new Word(AnimatedWords.SOMBRERERO.toString(), true, this.app);
			word.setAvatar(this.avatars.get(2));
			objectWords.add(word);
		} else if(plainWords[j].contains(AnimatedWords.REINA.toString())) {
			Word word = new Word(AnimatedWords.REINA.toString(), true, this.app);
			word.setAvatar(this.avatars.get(3));
			objectWords.add(word);
		} else if(plainWords[j].contains(AnimatedWords.FLOR.toString())) {
			Word word = new Word(AnimatedWords.FLOR.toString(), true, this.app);
			word.setAvatar(this.avatars.get(0));
			objectWords.add(word);
		}else {
			objectWords.add(new Word(plainWords[j], false, this.app));
		}
	}
	
	public ArrayList<Avatar> getAvatars() {
		return this.avatars;
	}
}



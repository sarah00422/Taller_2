package Model;

public class ScreamStrategy implements AnimateStrategy {
public static ScreamStrategy ScreamStrategyI;
	
	private ScreamStrategy() {}
	
	@Override
	public void animate(Avatar avatar) {
		avatar.setImage("REINA 2.png");
	}
	
	public static ScreamStrategy getInstance() {
		if(ScreamStrategyI == null) {
			ScreamStrategyI = new ScreamStrategy();
		}
		return ScreamStrategyI;
	}
}

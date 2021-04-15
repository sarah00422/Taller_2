package Model;

public class DanceStrategy implements AnimateStrategy {

	public static DanceStrategy danceStrategyI;
	
	private DanceStrategy() {}
	
	@Override
	public void animate(Avatar avatar) {
		avatar.setImage("FLOR 2.png");
	}
	
	public static DanceStrategy getInstance() {
		if(danceStrategyI == null) {
			danceStrategyI = new DanceStrategy();
		}
		return danceStrategyI;
	}
}

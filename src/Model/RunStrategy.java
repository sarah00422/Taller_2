package Model;

public class RunStrategy implements AnimateStrategy {
public static RunStrategy runStrategyI;
	
	private RunStrategy() {}
	
	private int initialPosX = 0;
	
	@Override
	public void animate(Avatar avatar) {
		if(initialPosX == 0) {
			initialPosX = avatar.posX;
		}
		avatar.posX += avatar.speed;
		if(avatar.posX > (900 - avatar.width/2) ) {
			avatar.speed *= -1;
		}
		
	}
	
	public static RunStrategy getInstance() {
		if(runStrategyI == null) {
			runStrategyI = new RunStrategy();
		}
		return runStrategyI;
	}
}

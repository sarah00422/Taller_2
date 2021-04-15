package Model;

public class JumpStrategy implements AnimateStrategy {
public static JumpStrategy JumpStrategyI;
	
	private JumpStrategy() {}
	
	@Override
	public void animate(Avatar avatar) {
		avatar.posY = avatar.posY - 30;
	}
	
	public static JumpStrategy getInstance() {
		if(JumpStrategyI == null) {
			JumpStrategyI = new JumpStrategy();
		}
		return JumpStrategyI;
	}
}

package Model;

public class GetSmallerStrategy implements AnimateStrategy  {
	public static GetSmallerStrategy getSmallerI;
	
	private GetSmallerStrategy() {}
	
	@Override
	public void animate(Avatar avatar) {
		avatar.heigh = (int) Math.round(avatar.heigh * 0.6);
		avatar.width = (int) Math.round(avatar.width * 0.6);
	}
	
	public static GetSmallerStrategy getInstance() {
		if(getSmallerI == null) {
			getSmallerI = new GetSmallerStrategy();
		}
		return getSmallerI;
	}
}

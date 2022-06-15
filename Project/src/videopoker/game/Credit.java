package videopoker.game;

public class Credit {
	private int credit;
	
	public Credit(int initialValue) {
		this.credit = initialValue;
		
	}
	
	public int Add(int change) {
		return credit + change;
				
	}

}

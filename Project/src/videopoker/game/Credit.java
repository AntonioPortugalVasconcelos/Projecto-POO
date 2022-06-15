package videopoker.game;

public class Credit {
	private int credit;
	
	public Credit(int initialValue) {
		this.credit = initialValue;
		
	}
	
	public void Add(int change) {
		this.credit = credit + change;
				
	}
	
	public int GetValue() {
		return credit;
				
	}

}

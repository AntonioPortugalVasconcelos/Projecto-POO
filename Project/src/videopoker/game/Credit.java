package videopoker.game;

public class Credit {
	private int credit;
	
	public Credit(int initialValue) {
		this.credit = initialValue;
		
	}
	
	public boolean Add(int change) {
		this.credit = credit + change;
		if (this.credit < 0) {
			return true;
		}
		return false;
				
	}
	
	public int GetValue() {
		return credit;
				
	}

}

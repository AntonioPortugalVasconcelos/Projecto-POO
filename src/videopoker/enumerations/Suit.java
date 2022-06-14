package videopoker.enumerations;

public enum Suit {
	C('C'), D('D'), S('S'), H('H');
	
	private char suit;
	
	Suit(char suit){
		this.suit = suit;
	}
	public char GetSuit() {
		return this.suit;
	}
}

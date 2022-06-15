package videopoker.game;
 

public class Card {
	private Rank rank;
	private Suit suit;
	
	
	public Card(Rank rank, Suit suit) {
		super();
		this.rank = rank;
		this.suit = suit;
	}
	
	public int CardValue() {
		return this.rank.GetValue();
	}
	public char CardSuit() {
		return this.suit.GetSuit();
	}
}

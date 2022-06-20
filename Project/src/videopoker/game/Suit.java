package videopoker.game;

public class Suit {

	private char suit;
	/**
	 * Constructor of Suit class
	 * @param suit
	 */
	public Suit(char suit){
		this.suit = suit;
	}
	/**
	 * gets the suit of the card
	 * @return the suit of card
	 */
	public char GetSuit() {
		return this.suit;
	}
}

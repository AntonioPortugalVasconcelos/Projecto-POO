package videopoker.game;
/**
 * 
 * @author  Ant�nio Vasconcelos and Ant�nio Falacho
 *
 */
public class Suit {

	private char suit;
	/**
	 * Constructor of Suit class
	 * @param suit char that represents suit
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

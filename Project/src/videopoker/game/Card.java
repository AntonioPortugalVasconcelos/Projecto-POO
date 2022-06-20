package videopoker.game;
 
/**
 * 
 * @author António Vasconcelos and António Falacho
 *
 */
public class Card {
	private Rank rank;
	private Suit suit;
	
	/**
	 * Card constructor
	 * @param rank card rank
	 * @param suit card suit
	 */
	public Card(Rank rank, Suit suit) {
		super();
		this.rank = rank;
		this.suit = suit;
	}
	/**
	 * Returning the value of cards rank
	 * @return integer for card rank
	 */
	public int CardValue() {
		return this.rank.GetValue();
	}
	/**
	 * Returning the suit of cards Suit
	 * @return char for card suit
	 */
	public char CardSuit() {
		return this.suit.GetSuit();
	}
	/**
	 * Returning the Rank of cards rank
	 * @return char for card rank
	 */
	public char CardRank() {
		return this.rank.GetRank();
	}
}

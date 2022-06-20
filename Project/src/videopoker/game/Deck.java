package videopoker.game;

import java.util.ArrayList;
import java.util.Collections;
/**
 * 
 * @author António Vasconcelos and António Falacho
 *
 */
public class Deck {
	
	private ArrayList<Card> cards = new ArrayList<Card>();
	/**
	 * Constructor of deck class for simulation mode
	 * @param cardList ArrayList of cards
	 */
	public Deck(ArrayList<Card> cardList) {
		this.CreateDeck(cardList);
		
	}
	/**
	 * Constructor of deck class for debug mode
	 * @param deckList string of cards to be decoded
	 */
	public Deck(String deckList) {
		this.CreateDebugDeck(deckList);
		
	}
	/**
	 * Creation of deck
	 * @param cardList cardList ArrayList of cards
	 */
	private void CreateDeck(ArrayList<Card> cardList) {
		this.cards = cardList;
		
	}
	/**
	 * Creation of deck for debug mode
	 * @param deckList string of cards to be decoded
	 */
	private void CreateDebugDeck(String deckList) {
		String[] cardIndicators = deckList.split(" ");		
		for(String cardIndicator : cardIndicators) {
			String[] indicator = cardIndicator.split("");
            this.cards.add(new Card(new Rank(indicator[0].charAt(0)), new Suit(indicator[1].charAt(0))));
            
		}
		
	}
	/**
	 * Remotion of a card from the deck
	 * @return drawn card from deck
	 */
	public Card drawCard() {
		
		Card draw = cards.get(0);
		cards.remove(draw);
		
		return draw;
		
	}
	/**
	 * Shuffle the deck
	 */
	public void Shuffle() {
		Collections.shuffle(cards);
	}

}

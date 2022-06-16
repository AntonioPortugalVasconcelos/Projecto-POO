package videopoker.game;

import java.util.ArrayList;
import java.util.Collections;

public class Deck {
	
	private ArrayList<Card> cards = new ArrayList<Card>();
	
	public Deck(ArrayList<Card> cardList) {
		this.CreateDeck(cardList);
		
	}
	
	public Deck(String deckList) {
		this.CreateDebugDeck(deckList);
		
	}
	
	private void CreateDeck(ArrayList<Card> cardList) {
		this.cards = cardList;
		
	}
	
	private void CreateDebugDeck(String deckList) {
		String[] cardIndicators = deckList.split(" ");		
		for(String cardIndicator : cardIndicators) {
			String[] indicator = cardIndicator.split("");
            this.cards.add(new Card(new Rank(indicator[0].charAt(0)), new Suit(indicator[1].charAt(0))));
            
		}
		
	}
	
	public Card drawCard() {
		
		Card draw = cards.get(0);
		cards.remove(draw);
		
		return draw;
		
	}
	
	public void Shuffle() {
		Collections.shuffle(cards);
	}

}

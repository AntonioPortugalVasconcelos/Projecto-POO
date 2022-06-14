package videopoker.game;

import java.util.ArrayList;

public class Deck {
	
	private ArrayList<Card> cards = new ArrayList<Card>();
	
	public Deck() {
		this.CreateDeck();
		
	}
	
	public Deck(String deckList) {
		this.CreateDebugDeck(deckList);
		
	}
	
	private void CreateDeck() {
		
	}
	
	private void CreateDebugDeck(String deckList) {
		String[] cardIndicators = deckList.split(" ");
		
		for(String cardIndicator : cardIndicators) {
			String[] indicator = cardIndicator.split("");
            this.cards.add(new Card(new Rank(Integer.valueOf(indicator(0)), new Suit(indicator(1).charAt(0))));
			
		}
		
	}

}

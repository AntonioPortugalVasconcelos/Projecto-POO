package videopoker.game;

import java.util.ArrayList;

public class Deck {
	
	private ArrayList<Card> cards = new ArrayList<Card>();
	private int deckSize = 0;
	
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
            this.cards.add(new Card(new Rank(indicator[0].charAt(0)), new Suit(indicator[1].charAt(0))));
			this.deckSize++;
            
		}
		
	}
	
	public Card drawCard() {
		
		Card draw = cards.get(deckSize);
		this.deckSize--;
		cards.remove(draw);
		
		return draw;
		
	}
	
	public void Shuffle() {
		
	}

}

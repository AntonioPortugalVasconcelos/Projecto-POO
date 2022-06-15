package videopoker.game;

import java.util.*;

public class Hand {
	private ArrayList<Card> hand;

	public Hand(ArrayList<Card> hand) {
		super();
		this.hand = hand;
		this.SortHand();
	}
	public void SortHand() {
		Comparator<Card> handComparer = Comparator.comparing(Card::CardValue);
		Collections.sort(hand, handComparer);
	}
	
	
}

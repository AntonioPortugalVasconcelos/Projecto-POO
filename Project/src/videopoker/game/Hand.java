package videopoker.game;

import java.util.*;

public class Hand {
	private ArrayList<Card> hand;
	private ArrayList<Card> hand_original;

	public Hand(ArrayList<Card> hand) {
		super();
		this.hand = hand;
		this.hand_original = hand;
	}
	
	public void SortHand() {
		Comparator<Card> handComparer = Comparator.comparing(Card::CardValue);
		Collections.sort(hand, handComparer);
	}
	
	public char[] HoldHand(String hold) {
		String[] cardsHold = hold.split(" ");
		int i = -1;
		char holdCard[] = {'0','0','0','0','0'};
		char discardCard[] = {'1','2','3','4','5'};
		Card draw;
		for(String aux : cardsHold) {
			if(i == -1 ) {
				i++;
				continue;
			}
			holdCard[i] = aux.charAt(0);
			i++;
		}
		for (int j = 0; j <= i; j++) {
			for (int d = 0; d < 5; d++) {
				if(holdCard[j] == discardCard[d]) {
					discardCard[d] = '0';
				}					
			}
		}
		return discardCard;
		//for ( d = 0; d < 5; d++) {
			//if(discardCard[d] != '0') {
				//draw = Game.getNextCard();
				
			//}
		//}
	}
	
	public int handType() {
		this.SortHand();
		
		if(checkRoyalFlush(cards)){
	        return 10;
	    }
	    if(checkStraightFlush(cards)){
	        return 9;
	    }
	    if(check4Kind(cards, flagAndValue)[0]){
	        return 8;
	    }
	    if(checkFullHouse(cards, flagAndValue3)[0]){
	        return 7;
	    }
	    if(checkFlush(cards)){
	        return 6;
	    }
	    if(checkStraight(cards)){
	        return 5;
	    }
	    if(check3Kind(cards, flagAndValue)[0]){
	        return 4;
	    }
	    if(check2Pair(cards, flagAndValue3)[0]){
	        return 3;
	    }
	    if(checkHighPair(cards, flagAndValue)[0]){
	        return 2;
	    }
	    return 1;
	}
}


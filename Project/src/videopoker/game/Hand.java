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
	public void addHand(Card a) {
		this.hand.add(a);
	}
	public void setHand(int i, Card a) {
		this.hand.set(i, a);
	}
	public ArrayList<Card> getHand(){
		return this.hand;
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
		
		if(checkRoyalFlush()){
	        return 10;
	    }
	    if(checkStraightFlush()){
	        return 9;
	    }
	    if(check4Kind()){
	        return 8;
	    }
	    if(checkFullHouse()){
	        return 7;
	    }
	    if(checkFlush()){
	        return 6;
	    }
	    if(checkStraight()){
	        return 5;
	    }
	    if(check3Kind()){
	        return 4;
	    }
	    if(check2Pair()){
	        return 3;
	    }
	    if(checkHighPair()){
	        return 2;
	    }
	    return 1;
	}
	
	private 	
}


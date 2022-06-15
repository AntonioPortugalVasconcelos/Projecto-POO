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
	        return 12;
	    }
	    if(checkStraightFlush()){
	        return 11;
	    }
	    if(check4KindA()){
	        return 10;
	    }
	    if(check4Kind24()){
	        return 9;
	    }
	    if(check4Kind5K()){
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
	
	private boolean checkHighPair() {
		for(int i = 0; i < 4; i++){
			if(this.hand.get(i).CardRank() == 'J' || this.hand.get(i).CardRank() == 'Q'||
			this.hand.get(i).CardRank() == 'K' || this.hand.get(i).CardRank() == 'A' ) {
				if(this.hand.get(i).CardRank() == this.hand.get(i+1).CardRank()) {
					return true;
				}
			}
		}
		return false;
	}
	private boolean check2Pair() {
		boolean flag = false;
		for(int i = 0; i < 4; i++){
			if (!flag) {
				if(this.hand.get(i).CardRank() == this.hand.get(i+1).CardRank()) {
					flag = true;
				}
			}
			else if(flag) {
				if(this.hand.get(i).CardRank() == this.hand.get(i+1).CardRank()) {
					return true;
				}
			}
		}
		return false;
	}
	private boolean check3Kind() {
		for(int i = 0; i < 3; i++){
			if(this.hand.get(i).CardRank() == this.hand.get(i+1).CardRank() && this.hand.get(i).CardRank() == this.hand.get(i+2).CardRank()) {
				return true;
			}	
		}
		return false;
	}
	private boolean checkStraight() {
		int i = 0;
		if (this.hand.get(i).CardValue()+1 == this.hand.get(i+1).CardValue() &&
			this.hand.get(i+1).CardValue()+1 == this.hand.get(i+2).CardValue() &&
			this.hand.get(i+2).CardValue()+1 == this.hand.get(i+3).CardValue() &&
			this.hand.get(i+3).CardValue()+1 == this.hand.get(i+4).CardValue()) {
	
			return true;
		}
		if (this.hand.get(i).CardValue() == 0 &&
				this.hand.get(i+1).CardValue() == 1 &&
				this.hand.get(i+2).CardValue() == 2 &&
				this.hand.get(i+3).CardValue() == 3 &&
				this.hand.get(i+4).CardValue() == 12) {
		
				return true;
			}
		return false;
	}
	private boolean checkFlush() {
		int i = 0;	
		if(this.hand.get(i).CardSuit() == this.hand.get(i+1).CardSuit() &&
			this.hand.get(i).CardSuit() == this.hand.get(i+2).CardSuit() &&
			this.hand.get(i).CardSuit() == this.hand.get(i+3).CardSuit() &&
			this.hand.get(i).CardSuit() == this.hand.get(i+4).CardSuit()){
			
			return true;
		}
		return false;
	}
	private boolean checkFullHouse() {
		if(check3Kind()) {
			for(int i = 0; i < 4; i++){
				if (this.hand.get(i).CardValue() == this.hand.get(i+1).CardValue() && 
						this.hand.get(i).CardValue() != this.hand.get(3).CardValue()) {
					return true;
				}
			}
		}
			
		return false;
	}
	private boolean check4KindA() {
		int i = 1;
		if(this.hand.get(i).CardRank() == 'A') {
			return true;
		}
		return false;
	}
	private boolean check4Kind24() {
		int i = 0;
		if(this.hand.get(i+2).CardRank() == '2' || this.hand.get(i+2).CardRank() == '3' || this.hand.get(i+2).CardRank() == '4') {
			for(i = 0; i < 2; i++){
		        if(this.hand.get(i).CardRank() == this.hand.get(i+1).CardRank() &&
		        	this.hand.get(i).CardRank() == this.hand.get(i+2).CardRank() &&
		        	this.hand.get(i).CardRank() == this.hand.get(i+3).CardRank()){
		        	
		            return true;
		        }
		    }	
		}
		return false;
	}
	private boolean check4Kind5K() {		
		for(int i = 0; i < 2; i++){
	        if(this.hand.get(i).CardRank() == this.hand.get(i+1).CardRank() &&
	        	this.hand.get(i).CardRank() == this.hand.get(i+2).CardRank() &&
	        	this.hand.get(i).CardRank() == this.hand.get(i+3).CardRank()){
	        	
	            return true;
	        }
	    }	
		
		return false;
	}
	private boolean checkStraightFlush() {
		return checkStraight() && checkFlush();
	}
	private boolean checkRoyalFlush() {
		return checkStraightFlush() && this.hand.get(4).CardRank() == 'A';
	}
}


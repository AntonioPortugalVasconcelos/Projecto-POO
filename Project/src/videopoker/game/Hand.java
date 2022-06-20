package videopoker.game;

import java.util.*;

public class Hand {
	private ArrayList<Card> hand;
	private ArrayList<Card> hand_original;
	private int index;
	private int index2;

	/**
	 * Constructor for Hand class
	 * @param hand
	 */
	public Hand(ArrayList<Card> hand) {
		super();
		this.hand = hand;
		this.index = -1;
		this.index2 = -1;
	}
	/**
	 * Sorts Hand by Value
	 */
	public void SortHand() {
		Comparator<Card> handComparer = Comparator.comparing(Card::CardValue);
		Collections.sort(this.hand, handComparer);
	}
	/**
	 * Sorts hand by Suit and value inside of suit
	 */
	public void SortHandSuit() {
		Comparator<Card> handComparer = Comparator.comparing(Card::CardSuit).thenComparing(Card::CardValue);
		Collections.sort(this.hand, handComparer);
	}
	/**
	 * Receives the original hand, which is a not sorted hand
	 * @param hands(original hand)
	 */
	public void handOriginal(ArrayList<Card> hands) {
		this.hand_original = hands;
	}
	/**
	 * Returns the original hand, which is a not sorted hand
	 */
	public void returnHand() {
		this.hand = this.hand_original;
	}
	/**
	 * Add a Card "a" to the hand
	 * @param a(card added to the hand)
	 */
	public void addHand(Card a) {
		this.hand.add(a);
	}
	/**
	 * Receives a card and a position and puts the card in the right position of the hand 
	 * @param i(position of the hand)
	 * @param a(card added to the hand)
	 */
	public void setHand(int i, Card a) {
		this.hand.set(i, a);
	}
	/**
	 * Returns the attribute hand
	 * @return
	 */
	public ArrayList<Card> getHand(){
		return this.hand;
	}
	/**
	 * Returns the attribute hand_original in a string
	 * @return string of the hand
	 */
	public String get2Hand(){
		String strHand = null;
		for(int i = 0; i < 5; i++) {
			if(i == 0) {
				strHand = Character.toString(this.hand_original.get(i).CardRank()) + Character.toString(this.hand_original.get(i).CardSuit());
			}
			else {
				strHand = strHand + " " + Character.toString(this.hand_original.get(i).CardRank()) + Character.toString(this.hand_original.get(i).CardSuit());
			}
		}
		return strHand;
	}
	/**
	 * Returns the attribute hand in a string
	 * @return string of the hand
	 */
	public String toString() {
		String strHand = null;
		for(int i = 0; i < 5; i++) {
			if(i == 0) {
				strHand = Character.toString(this.hand.get(i).CardRank()) + Character.toString(this.hand.get(i).CardSuit());
			}
			else {
				strHand = strHand + " " + Character.toString(this.hand.get(i).CardRank()) + Character.toString(this.hand.get(i).CardSuit());
			}
		}
		return strHand;
	}
	/**
	 * Returns the cards of the hand to discard
	 * @param hold(string with the cards to hold)
	 * @return
	 */
	public char[] HoldHand(String hold) {
		String[] cardsHold = hold.split(" ");
		int i = -1;
		char holdCard[] = {'0','0','0','0','0'};
		char discardCard[] = {'1','2','3','4','5'};
		for(String aux : cardsHold) {
			if(i == -1 ) {
				i++;
				continue;
			}
			holdCard[i] = aux.charAt(0);
			i++;
		}
		for (int j = 0; j < i; j++) {
			for (int d = 0; d < 5; d++) {
				if(holdCard[j] == discardCard[d]) {
					discardCard[d] = '0';
				}					
			}
		}
		return discardCard;
	}
	/**
	 * Checks to see the result of the last hand
	 * @return the value of the result codified
	 */
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
	/**
	 * Checks for a pair in the hand
	 * @return
	 */
	public boolean checkPair() {
		for(int i = 0; i < 4; i++){
			if(this.hand.get(i).CardRank() == this.hand.get(i+1).CardRank()) {
				this.index = i;
				return true;
			}
		}
		return false;
	}
	/**
	 * Checks for a high pair in the hand
	 * @return
	 */
	private boolean checkHighPair() {
		for(int i = 0; i < 4; i++){
			if(this.hand.get(i).CardRank() == 'J' || this.hand.get(i).CardRank() == 'Q'||
			this.hand.get(i).CardRank() == 'K' || this.hand.get(i).CardRank() == 'A' ) {
				if(this.hand.get(i).CardRank() == this.hand.get(i+1).CardRank()) {
					this.index = i;
					return true;
				}
			}
		}
		return false;
	}
	/**
	 * Checks for two pairs in the hand
	 * @return
	 */
	private boolean check2Pair() {
		boolean flag = false;
		for(int i = 0; i < 4; i++){
			if (!flag) {
				if(this.hand.get(i).CardRank() == this.hand.get(i+1).CardRank()) {
					this.index2 = i;
					flag = true;
				}
			}
			else if(flag) {
				if(this.hand.get(i).CardRank() == this.hand.get(i+1).CardRank()) {
					this.index = i;
					return true;
				}
			}
		}
		return false;
	}
	/**
	 * Checks for a three of a kind in the hand
	 * @return
	 */
	private boolean check3Kind() {
		for(int i = 0; i < 3; i++){
			if(this.hand.get(i).CardRank() == this.hand.get(i+1).CardRank() && this.hand.get(i).CardRank() == this.hand.get(i+2).CardRank()) {
				this.index = i;
				return true;
			}	
		}
		return false;
	}
	/**
	 * Checks for a straight in the hand
	 * @return
	 */
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
	/**
	 * Checks for a 4 of a kind of Aces in the hand
	 * @return
	 */
	private boolean check4KindA() {
		int i = 1;
		if(this.hand.get(i).CardRank() == 'A') {
			
			this.index = i;
			return true;
		}
		return false;
	}
	/**
	 * Checks for a 4 of a kind between 2 and 4 in the hand
	 * @return
	 */
	private boolean check4Kind24() {
		int i = 0;
		if(this.hand.get(i+2).CardRank() == '2' || this.hand.get(i+2).CardRank() == '3' || this.hand.get(i+2).CardRank() == '4') {
			for(i = 0; i < 2; i++){
		        if(this.hand.get(i).CardRank() == this.hand.get(i+1).CardRank() &&
		        	this.hand.get(i).CardRank() == this.hand.get(i+2).CardRank() &&
		        	this.hand.get(i).CardRank() == this.hand.get(i+3).CardRank()){
		        	
		        	this.index = i;
		            return true;
		        }
		    }	
		}
		return false;
	}
	/**
	 * Checks for a 4 of a kind between 4 and king in the hand
	 * @return
	 */
	private boolean check4Kind5K() {		
		for(int i = 0; i < 2; i++){
	        if(this.hand.get(i).CardRank() == this.hand.get(i+1).CardRank() &&
	        	this.hand.get(i).CardRank() == this.hand.get(i+2).CardRank() &&
	        	this.hand.get(i).CardRank() == this.hand.get(i+3).CardRank()){
	        	
	        	this.index = i;
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
	
	//				   //
	// ADVICE FUNCTIONS//
	//				   //
	
	public boolean checkAlmostRoyalFlush() {
		
		this.SortHandSuit();
		for(int i = 0; i < 2; i++) {
			if(this.hand.get(i).CardSuit() == this.hand.get(i+1).CardSuit() &&
			this.hand.get(i).CardSuit()== this.hand.get(i+2).CardSuit() &&
			this.hand.get(i).CardSuit()== this.hand.get(i+3).CardSuit()) {
				if(this.hand.get(i).CardValue() > 7 &&
				this.hand.get(i+1).CardValue() > 7 &&
				this.hand.get(i+2).CardValue() > 7 &&
				this.hand.get(i+3).CardValue() > 7) {
					this.index = i;
					return true;
				}
			}
		}

		this.SortHand();
		return false;
		
	}
	
	public boolean checkAlmostFlush(){
		this.SortHandSuit();
		for(int i = 0; i < 2; i++) {
			if(this.hand.get(i).CardSuit() == this.hand.get(i+1).CardSuit() &&
			this.hand.get(i).CardSuit()== this.hand.get(i+2).CardSuit() &&
			this.hand.get(i).CardSuit()== this.hand.get(i+3).CardSuit()) {
				this.index = i;
				return true;
			}
		}
		this.SortHand();
		return false;
	}
	
	public boolean checkAlmostStraight(){
		for(int i = 0; i < 2; i++) {
			if (this.hand.get(i).CardValue()+1 == this.hand.get(i+1).CardValue() &&
					this.hand.get(i+1).CardValue()+1 == this.hand.get(i+2).CardValue() &&
					this.hand.get(i+2).CardValue()+1 == this.hand.get(i+3).CardValue()) {
					
				this.index = i;	
				return true;
			}
		}
		return false;
	}
	
	public boolean checkAlmostStraightFlush(){
		int i = 0;

		if(this.hand.get(i).CardValue()+1 == this.hand.get(i+1).CardValue() &&
		this.hand.get(i+1).CardValue()+1 == this.hand.get(i+2).CardValue() &&
		this.hand.get(i+2).CardValue()+1 == this.hand.get(i+3).CardValue()) {
			if(this.hand.get(i).CardSuit()== this.hand.get(i+1).CardSuit() &&
				this.hand.get(i).CardSuit()== this.hand.get(i+2).CardSuit() &&
				this.hand.get(i).CardSuit()== this.hand.get(i+3).CardSuit()) {
				this.index = 1;
				return true;
			}
		}
		if(this.hand.get(i).CardValue()+1 == this.hand.get(i+1).CardValue() &&
				this.hand.get(i+1).CardValue()+1 == this.hand.get(i+2).CardValue() &&
				this.hand.get(i+2).CardValue()+2 == this.hand.get(i+4).CardValue()) {
					if(this.hand.get(i).CardSuit()== this.hand.get(i+1).CardSuit() &&
						this.hand.get(i).CardSuit()== this.hand.get(i+2).CardSuit() &&
						this.hand.get(i).CardSuit()== this.hand.get(i+4).CardSuit()) {
						this.index = 2;
						return true;
					}
		}
		if(this.hand.get(i).CardValue()+1 == this.hand.get(i+1).CardValue() &&
				this.hand.get(i+1).CardValue()+2 == this.hand.get(i+3).CardValue() &&
				this.hand.get(i+3).CardValue()+1 == this.hand.get(i+4).CardValue()) {
					if(this.hand.get(i).CardSuit()== this.hand.get(i+1).CardSuit() &&
						this.hand.get(i).CardSuit()== this.hand.get(i+3).CardSuit() &&
						this.hand.get(i).CardSuit()== this.hand.get(i+4).CardSuit()) {
						this.index = 3;
						return true;
					}
		}
		if(this.hand.get(i).CardValue()+2 == this.hand.get(i+2).CardValue() &&
				this.hand.get(i+2).CardValue()+1 == this.hand.get(i+3).CardValue() &&
				this.hand.get(i+3).CardValue()+1 == this.hand.get(i+4).CardValue()) {
					if(this.hand.get(i).CardSuit()== this.hand.get(i+2).CardSuit() &&
						this.hand.get(i).CardSuit()== this.hand.get(i+3).CardSuit() &&
						this.hand.get(i).CardSuit()== this.hand.get(i+4).CardSuit()) {
						this.index = 4;
						return true;
					}
		}
		if(this.hand.get(i+1).CardValue()+1 == this.hand.get(i+2).CardValue() &&
				this.hand.get(i+2).CardValue()+1 == this.hand.get(i+3).CardValue() &&
				this.hand.get(i+3).CardValue()+1 == this.hand.get(i+4).CardValue()) {
					if(this.hand.get(i+1).CardSuit()== this.hand.get(i+2).CardSuit() &&
						this.hand.get(i+1).CardSuit()== this.hand.get(i+3).CardSuit() &&
						this.hand.get(i+1).CardSuit()== this.hand.get(i+4).CardSuit()) {
						this.index = 5;
						return true;
					}
		}
		return false;
	}
	
	public boolean check3RoyalFlush(){
		this.SortHandSuit();
		for(int i = 0; i < 3; i++) {
			if(this.hand.get(i).CardSuit() == this.hand.get(i+1).CardSuit() &&
			this.hand.get(i).CardSuit()== this.hand.get(i+2).CardSuit()) {
				if(this.hand.get(i).CardValue() > 7 &&
					this.hand.get(i+1).CardValue() > 7 &&
					this.hand.get(i+2).CardValue() > 7) {
						this.index = i;
						return true;
				}
			}
		}
		this.SortHand();
		return false;
	}
	
	public boolean check3Aces() {
		if(check3Kind()) {
			if(this.hand.get(this.index).CardRank() == 'A') {
				return true;
			}
		}
		return false;
	}
	
	public boolean checkAKQJ() {
		int i = 1;
		if(this.hand.get(i).CardRank() == 'J' && this.hand.get(i+1).CardRank() == 'Q' &&
			this.hand.get(i+2).CardRank() == 'K' && this.hand.get(i+3).CardRank() == 'A') {
			return true;
		}
		return false;	
	}
	
	public boolean checkStraight3FlushT1() {
		int f = 0;
		int i = 0;
		this.SortHandSuit();
		for(i = 0; i < 5; i++) {
			if(this.hand.get(i).CardValue() > 8) {
				f++;
			}
		}
		for(i = 0; i < 3; i++) {
			if(this.hand.get(i).CardSuit() == this.hand.get(2).CardSuit() &&
					this.hand.get(i+1).CardSuit() == this.hand.get(2).CardSuit() &&
					this.hand.get(i+2).CardSuit() == this.hand.get(2).CardSuit()) {
				if(f==0 || f == 1 || f == 2) {
					if (this.hand.get(i).CardValue()+1 == this.hand.get(i+1).CardValue() &&
							this.hand.get(i+1).CardValue()+1 == this.hand.get(i+2).CardValue()) {
						return true;
					}
							
				}
				if(f == 1 || f == 2) {
					if (this.hand.get(i).CardValue()+2 == this.hand.get(i+1).CardValue() &&
							this.hand.get(i+1).CardValue()+1 == this.hand.get(i+2).CardValue()) {
								
							return true;
					}
					if (this.hand.get(i).CardValue()+1 == this.hand.get(i+1).CardValue() &&
							this.hand.get(i+1).CardValue()+2 == this.hand.get(i+2).CardValue()) {
								
							return true;
					}
				}
				if(f == 2) {
					if (this.hand.get(i).CardValue()+ 2 == this.hand.get(i+1).CardValue() &&
							this.hand.get(i+1).CardValue()+2 == this.hand.get(i+2).CardValue()) {
								
							return true;
					}
				}
			}
		}	
		this.SortHand();
		return false;
	}
	
	public boolean check4InStrainght3High() {
		int i = 0;
		if(this.hand.get(2).CardValue() > 8 &&
				this.hand.get(3).CardValue() > 8 &&
				this.hand.get(4).CardValue() > 8) {
			if(this.hand.get(1).CardValue() > 8 &&
					this.hand.get(2).CardValue() > 8 &&
					this.hand.get(3).CardValue() > 8 &&
					this.hand.get(4).CardValue() > 8) {
				this.index = 1;
				return true;
			}
			for (i = 1; i < 2; i++) {
				if(this.hand.get(i).CardValue()+1 == this.hand.get(i+1).CardValue() &&
				this.hand.get(i+1).CardValue()+1 == this.hand.get(i+2).CardValue() &&
				this.hand.get(i+2).CardValue()+2 == this.hand.get(i+3).CardValue()) {
					this.index = i;
					return true;
				}
			}
			for (i = 1; i < 2; i++) {
				if(this.hand.get(i).CardValue()+1 == this.hand.get(i+1).CardValue() &&
				this.hand.get(i+1).CardValue()+2 == this.hand.get(i+2).CardValue() &&
				this.hand.get(i+2).CardValue()+1 == this.hand.get(i+3).CardValue()) {
					this.index = i;
					return true;
				}
			}
			for (i = 1; i < 2; i++) {
				if(this.hand.get(i).CardValue()+2 == this.hand.get(i+1).CardValue() &&
				this.hand.get(i+1).CardValue()+1 == this.hand.get(i+2).CardValue() &&
				this.hand.get(i+2).CardValue()+1 == this.hand.get(i+3).CardValue()) {
					this.index = i;
					return true;
				}
			}
		}
		return false;
	}
	
	public boolean check3Flush2High() {
		this.SortHandSuit();
		for (int i = 0; i < 3; i++) {
			if(this.hand.get(i).CardSuit() == this.hand.get(i+1).CardSuit() &&
				this.hand.get(i).CardSuit()== this.hand.get(i+2).CardSuit()) {
				if((this.hand.get(i).CardValue() > 8 && this.hand.get(i+1).CardValue() > 8) ||
					(this.hand.get(i).CardValue() > 8 && this.hand.get(i+2).CardValue() > 8) ||
					(this.hand.get(i+1).CardValue() > 8 && this.hand.get(i+2).CardValue() > 8)) {
					this.index = i;
					return true;
				}
			}
		}
		this.SortHand();
		return false;
	}
	
	public boolean check2SuitHigh() {
		this.SortHandSuit();
		for (int i = 0; i < 4; i++) {
			if(this.hand.get(i).CardSuit() == this.hand.get(i+1).CardSuit()) {
				if((this.hand.get(i).CardValue() > 8 && this.hand.get(i+1).CardValue() > 8)) {
					this.index = i;
					return true;
				}
			}
		}
		this.SortHand();
		return false;
	}
	
	public boolean check4InStrainght2High() {
		int i = 0;
		if(this.hand.get(2).CardValue() > 8 &&
			this.hand.get(3).CardValue() > 8) {

			for (i = 1; i < 2; i++) {
				if(this.hand.get(i).CardValue()+1 == this.hand.get(i+1).CardValue() &&
				this.hand.get(i+1).CardValue()+1 == this.hand.get(i+2).CardValue() &&
				this.hand.get(i+2).CardValue()+2 == this.hand.get(i+3).CardValue()) {
					this.index = i;
					return true;
				}
			}
			for (i = 1; i < 2; i++) {
				if(this.hand.get(i).CardValue()+1 == this.hand.get(i+1).CardValue() &&
				this.hand.get(i+1).CardValue()+2 == this.hand.get(i+2).CardValue() &&
				this.hand.get(i+2).CardValue()+1 == this.hand.get(i+3).CardValue()) {
					this.index = i;
					return true;
				}
			}
			for (i = 1; i < 2; i++) {
				if(this.hand.get(i).CardValue()+2 == this.hand.get(i+1).CardValue() &&
				this.hand.get(i+1).CardValue()+1 == this.hand.get(i+2).CardValue() &&
				this.hand.get(i+2).CardValue()+1 == this.hand.get(i+3).CardValue()) {
					this.index = i;
					return true;
				}
			}
		}
		return false;
	}
	
	public boolean checkStraight3FlushT2() {
		int f = 0;
		int i = 0;
		this.SortHandSuit();
		for(i = 0; i < 5; i++) {
			if(this.hand.get(i).CardValue() > 8) {
				f++;
			}
		}
		for(i = 0; i < 3; i++) {
			if(this.hand.get(i).CardSuit() == this.hand.get(2).CardSuit() &&
					this.hand.get(i+1).CardSuit() == this.hand.get(2).CardSuit() &&
					this.hand.get(i+2).CardSuit() == this.hand.get(2).CardSuit()) {
				if(f==0 || f == 1) {
					if (this.hand.get(i).CardValue()+1 == this.hand.get(i+1).CardValue() &&
							this.hand.get(i+1).CardValue()+1 == this.hand.get(i+2).CardValue()) {
						return true;
					}
							
				}
				if(f == 0 || f == 1) {
					if (this.hand.get(i).CardValue()+2 == this.hand.get(i+1).CardValue() &&
							this.hand.get(i+1).CardValue()+1 == this.hand.get(i+2).CardValue()) {
								
							return true;
					}
					if (this.hand.get(i).CardValue()+1 == this.hand.get(i+1).CardValue() &&
							this.hand.get(i+1).CardValue()+2 == this.hand.get(i+2).CardValue()) {
								
							return true;
					}
				}
				if(f == 1) {
					if (this.hand.get(i).CardValue()+ 2 == this.hand.get(i+1).CardValue() &&
							this.hand.get(i+1).CardValue()+2 == this.hand.get(i+2).CardValue()) {
								
							return true;
					}
				}
			}
		}	
		this.SortHand();
		return false;
	}
	
	public boolean check4InStrainght1High() {
		int i = 0;
		if(this.hand.get(2).CardValue() > 8) {

			for (i = 1; i < 2; i++) {
				if(this.hand.get(i).CardValue()+1 == this.hand.get(i+1).CardValue() &&
				this.hand.get(i+1).CardValue()+1 == this.hand.get(i+2).CardValue() &&
				this.hand.get(i+2).CardValue()+2 == this.hand.get(i+3).CardValue()) {
					this.index = i;
					return true;
				}
			}
			for (i = 1; i < 2; i++) {
				if(this.hand.get(i).CardValue()+1 == this.hand.get(i+1).CardValue() &&
				this.hand.get(i+1).CardValue()+2 == this.hand.get(i+2).CardValue() &&
				this.hand.get(i+2).CardValue()+1 == this.hand.get(i+3).CardValue()) {
					this.index = i;
					return true;
				}
			}
			for (i = 1; i < 2; i++) {
				if(this.hand.get(i).CardValue()+2 == this.hand.get(i+1).CardValue() &&
				this.hand.get(i+1).CardValue()+1 == this.hand.get(i+2).CardValue() &&
				this.hand.get(i+2).CardValue()+1 == this.hand.get(i+3).CardValue()) {
					this.index = i;
					return true;
				}
			}
		}
		return false;
	}
	
	public boolean checkQJSuit() {
		boolean flag = false;
		for(int i = 0; i < 5; i++) {
			if (this.hand.get(i).CardRank() == 'Q') {
				this.index = i;
				flag = true;
			}
		}
		if(flag) {
			for(int i = 0; i < 5; i++) {
				if (this.hand.get(i).CardRank() == 'J') {
					if (this.hand.get(this.index).CardSuit() == this.hand.get(i).CardSuit()) {
						this.index2 = i;
						return true;
					}
				}
			}
		}
		return false;
	}
	
	public boolean checkKQJ() {
		int i = 2;
		if(this.hand.get(i).CardRank() == 'J' && this.hand.get(i+1).CardRank() == 'Q' &&
			this.hand.get(i+2).CardRank() == 'K') {
			return true;
		}
		return false;	
	}
	
	public boolean checkJTSuit() {
		boolean flag = false;
		for(int i = 0; i < 5; i++) {
			if (this.hand.get(i).CardRank() == 'J') {
				this.index = i;
				flag = true;
			}
		}
		if(flag) {
			for(int i = 0; i < 5; i++) {
				if (this.hand.get(i).CardRank() == 'T') {
					if (this.hand.get(this.index).CardSuit() == this.hand.get(i).CardSuit()) {
						this.index2 = i;
						return true;
					}
				}
			}
		}
		return false;
	}
	
	public boolean checkQJ() {
		boolean flag = false;
		for(int i = 0; i < 5; i++) {
			if (this.hand.get(i).CardRank() == 'Q') {
				this.index = i;
				flag = true;
			}
		}
		if(flag) {
			for(int i = 0; i < 5; i++) {
				if (this.hand.get(i).CardRank() == 'J') {
					this.index2 = i;
					return true;
				}
			}
		}
		return false;
	}
	
	public boolean check3Flush1High() {
		this.SortHandSuit();
		for (int i = 0; i < 3; i++) {
			if(this.hand.get(i).CardSuit() == this.hand.get(i+1).CardSuit() &&
				this.hand.get(i).CardSuit()== this.hand.get(i+2).CardSuit()) {
				if(this.hand.get(i).CardValue() > 8 ||
					this.hand.get(i+1).CardValue() > 8 ||
					this.hand.get(i+2).CardValue() > 8) {
					this.index = i;
					return true;
				}
			}
		}
		this.SortHand();
		return false;
	}
	
	public boolean checkQTSuit() {
		boolean flag = false;
		for(int i = 0; i < 5; i++) {
			if (this.hand.get(i).CardRank() == 'Q') {
				this.index = i;
				flag = true;
			}
		}
		if(flag) {
			for(int i = 0; i < 5; i++) {
				if (this.hand.get(i).CardRank() == 'T') {
					if (this.hand.get(this.index).CardSuit() == this.hand.get(i).CardSuit()) {
						this.index2 = i;
						return true;
					}
				}
			}
		}
		return false;
	}	
	
	public boolean checkStraight3FlushT3() {
		int i = 0;
		this.SortHandSuit();
		for(i = 0; i < 3; i++) {
			if(this.hand.get(i).CardSuit() == this.hand.get(2).CardSuit() &&
				this.hand.get(i+1).CardSuit() == this.hand.get(2).CardSuit() &&
				this.hand.get(i+2).CardSuit() == this.hand.get(2).CardSuit()) {

				if (this.hand.get(i).CardValue()+1 == this.hand.get(i+1).CardValue() &&
						this.hand.get(i+1).CardValue()+1 == this.hand.get(i+2).CardValue()) {
					return true;
				}
				if (this.hand.get(i).CardValue()+2 == this.hand.get(i+1).CardValue() &&
						this.hand.get(i+1).CardValue()+1 == this.hand.get(i+2).CardValue()) {
							
						return true;
				}
				if (this.hand.get(i).CardValue()+1 == this.hand.get(i+1).CardValue() &&
						this.hand.get(i+1).CardValue()+2 == this.hand.get(i+2).CardValue()) {
							
						return true;
				}
				if (this.hand.get(i).CardValue()+ 2 == this.hand.get(i+1).CardValue() &&
						this.hand.get(i+1).CardValue()+2 == this.hand.get(i+2).CardValue()) {
							
						return true;
				}
			}
		}	
		this.SortHand();
		return false;
	}
	
	public boolean checkKjKq() {
		boolean flag = false;
		for(int i = 0; i < 5; i++) {
			if (this.hand.get(i).CardRank() == 'K') {
				this.index = i;
				flag = true;
			}
		}
		if(flag) {
			for(int i = 0; i < 5; i++) {
				if (this.hand.get(i).CardRank() == 'J' || this.hand.get(i).CardRank() == 'Q') {
					this.index2 = i;
					return true;
				}
			}
		}
		return false;
	}
	
	public boolean CheckAce() {
		int i = 4;
		if(this.hand.get(i).CardRank() == 'A') {
			this.index = i;
			return true;
		}
		return false;
	}
	
	public boolean checkTK() {
		boolean flag = false;
		for(int i = 0; i < 5; i++) {
			if (this.hand.get(i).CardRank() == 'T') {
				this.index = i;
				flag = true;
			}
		}
		if(flag) {
			for(int i = 0; i < 5; i++) {
				if (this.hand.get(i).CardRank() == 'K') {
					if (this.hand.get(this.index).CardSuit() == this.hand.get(i).CardSuit()) {
						this.index2 = i;
						return true;
					}
				}
			}
		}
		return false;
	}	

	public boolean checkJoQoK() {
		for(int i = 0; i < 5; i++) {
			if (this.hand.get(i).CardRank() == 'J' || this.hand.get(i).CardRank() == 'Q' ||
					this.hand.get(i).CardRank() == 'K') {
				this.index = i;
				return true;
			}
		}
		return false;
	}

	public boolean InsideStraightLow() {
		int i = 0;
		for (i = 0; i < 2; i++) {
			if(this.hand.get(i).CardValue()+1 == this.hand.get(i+1).CardValue() &&
			this.hand.get(i+1).CardValue()+1 == this.hand.get(i+2).CardValue() &&
			this.hand.get(i+2).CardValue()+2 == this.hand.get(i+3).CardValue()) {
				this.index = i;
				return true;
			}
		}
		for (i = 0; i < 2; i++) {
			if(this.hand.get(i).CardValue()+1 == this.hand.get(i+1).CardValue() &&
			this.hand.get(i+1).CardValue()+2 == this.hand.get(i+2).CardValue() &&
			this.hand.get(i+2).CardValue()+1 == this.hand.get(i+3).CardValue()) {
				this.index = i;
				return true;
			}
		}
		for (i = 0; i < 2; i++) {
			if(this.hand.get(i).CardValue()+2 == this.hand.get(i+1).CardValue() &&
			this.hand.get(i+1).CardValue()+1 == this.hand.get(i+2).CardValue() &&
			this.hand.get(i+2).CardValue()+1 == this.hand.get(i+3).CardValue()) {
				this.index = i;
				return true;
			}
		}
		return false;
	}
	
	public boolean check3Flush() {
		this.SortHandSuit();
		for (int i = 0; i < 3; i++) {
			if(this.hand.get(i).CardSuit() == this.hand.get(i+1).CardSuit() &&
				this.hand.get(i).CardSuit()== this.hand.get(i+2).CardSuit()) {
				this.index = i;
				return true;
			}
		}
		this.SortHand();
		return false;
	}
		
	
	
	
	
	
	
	public String searchSameKind() {
		String Aces = null;
		boolean flag = false;
		for(int i = 0; i < 5; i++) {
			if (this.hand_original.get(i).CardRank() == this.hand.get(this.index).CardRank()) {
				if(!flag) {
					Aces = String.valueOf(i+1);
					flag = true;
				}
				else if(flag) {
					Aces = Aces + " " + String.valueOf(i+1);
				}
			}
		}	
		return Aces;
	}
	
	public String search2Pair() {
		String Aces = null;
		boolean flag = false;
		for(int i = 0; i < 5; i++) {
			if (this.hand_original.get(i).CardRank() == this.hand.get(this.index).CardRank() || 
					this.hand_original.get(i).CardRank() == this.hand.get(this.index2).CardRank()) {
				if(!flag) {
					Aces = String.valueOf(i+1);
					flag = true;
				}
				else if(flag) {
					Aces = Aces + " " + String.valueOf(i+1);
				}
			}
		}
		return Aces;
	}
	
	public String searchSameSuit() {
		String Aces = null;
		boolean flag = false;
		for(int i = 0; i < 5; i++) {
			if (this.hand_original.get(i).CardSuit() == this.hand.get(this.index).CardSuit()) {
				if(!flag) {
					Aces = String.valueOf(i+1);
					flag = true;
				}
				else if(flag) {
					Aces = Aces + " " + String.valueOf(i+1);
				}
			}
		}	
		return Aces;
	}
	
	public String search4Straight() {
		String Aces = null;
		boolean flag = false;
		for(int i = 0; i < 5; i++) {
			if (this.hand_original.get(i).CardValue() == this.hand.get(this.index).CardValue() ||
					this.hand_original.get(i).CardValue() == this.hand.get(this.index).CardValue()+1 ||
					this.hand_original.get(i).CardValue() == this.hand.get(this.index).CardValue()+2 ||
					this.hand_original.get(i).CardValue() == this.hand.get(this.index).CardValue()+3) {
				if(!flag) {
					Aces = String.valueOf(i+1);
					flag = true;
				}
				else if(flag) {
					Aces = Aces + " " + String.valueOf(i+1);
				}
			}
		}	
		return Aces;
	}
	
	public String searchAKQJ() {
		String Aces = null;
		boolean flag = false;
		for(int i = 0; i < 5; i++) {
			if (this.hand_original.get(i).CardRank() == 'J' || this.hand_original.get(i).CardRank() == 'Q' ||
					this.hand_original.get(i).CardRank() == 'K' || this.hand_original.get(i).CardRank() == 'A') {
				if(!flag) {
					Aces = String.valueOf(i+1);
					flag = true;
				}
				else if(flag) {
					Aces = Aces + " " + String.valueOf(i+1);
				}
			}
		}
		return Aces;
	}
	
	public String search4StraightFlush() {
		String Aces = null;
		boolean flag = false;
		if(this.index == 1) {
			for(int i = 0; i < 5; i++) {
				if(this.hand_original.get(i).CardRank() == this.hand.get(0).CardRank() ||
				this.hand_original.get(i).CardRank() == this.hand.get(1).CardRank() ||
				this.hand_original.get(i).CardRank() == this.hand.get(2).CardRank() ||
				this.hand_original.get(i).CardRank() == this.hand.get(3).CardRank()) {
					
					if(!flag) {
						Aces = String.valueOf(i+1);
						flag = true;
					}
					else if(flag) {
						Aces = Aces + " " + String.valueOf(i+1);
					}
				}
			}
		}
		else if(this.index == 2) {
			for(int i = 0; i < 5; i++) {
				if(this.hand_original.get(i).CardRank() == this.hand.get(0).CardRank() ||
				this.hand_original.get(i).CardRank() == this.hand.get(1).CardRank() ||
				this.hand_original.get(i).CardRank() == this.hand.get(2).CardRank() ||
				this.hand_original.get(i).CardRank() == this.hand.get(4).CardRank()) {
					
					if(!flag) {
						Aces = String.valueOf(i+1);
						flag = true;
					}
					else if(flag) {
						Aces = Aces + " " + String.valueOf(i+1);
					}
				}
			}
		}
		else if(this.index == 3) {
			for(int i = 0; i < 5; i++) {
				if(this.hand_original.get(i).CardRank() == this.hand.get(0).CardRank() ||
				this.hand_original.get(i).CardRank() == this.hand.get(1).CardRank() ||
				this.hand_original.get(i).CardRank() == this.hand.get(3).CardRank() ||
				this.hand_original.get(i).CardRank() == this.hand.get(4).CardRank()) {
					
					if(!flag) {
						Aces = String.valueOf(i+1);
						flag = true;
					}
					else if(flag) {
						Aces = Aces + " " + String.valueOf(i+1);
					}
				}
			}
		}
		else if(this.index == 4) {
			for(int i = 0; i < 5; i++) {
				if(this.hand_original.get(i).CardRank() == this.hand.get(0).CardRank() ||
				this.hand_original.get(i).CardRank() == this.hand.get(2).CardRank() ||
				this.hand_original.get(i).CardRank() == this.hand.get(3).CardRank() ||
				this.hand_original.get(i).CardRank() == this.hand.get(4).CardRank()) {
					
					if(!flag) {
						Aces = String.valueOf(i+1);
						flag = true;
					}
					else if(flag) {
						Aces = Aces + " " + String.valueOf(i+1);
					}
				}
			}
		}
		else if(this.index == 5) {
			for(int i = 0; i < 5; i++) {
				if(this.hand_original.get(i).CardRank() == this.hand.get(1).CardRank() ||
				this.hand_original.get(i).CardRank() == this.hand.get(2).CardRank() ||
				this.hand_original.get(i).CardRank() == this.hand.get(3).CardRank() ||
				this.hand_original.get(i).CardRank() == this.hand.get(4).CardRank()) {
					
					if(!flag) {
						Aces = String.valueOf(i+1);
						flag = true;
					}
					else if(flag) {
						Aces = Aces + " " + String.valueOf(i+1);
					}
				}
			}
		}
		return Aces;
	}
	
	public String searchAlmostRoyalFlush() {
		String Aces = null;
		boolean flag = false;
		for(int i = 0; i < 5; i++) {
			if((this.hand_original.get(i).CardRank() == this.hand.get(this.index).CardRank() &&
				this.hand_original.get(i).CardSuit() == this.hand.get(this.index).CardSuit()) ||
			(this.hand_original.get(i).CardRank() == this.hand.get(this.index+1).CardRank() &&
					this.hand_original.get(i).CardSuit() == this.hand.get(this.index+1).CardSuit()) ||
			(this.hand_original.get(i).CardRank() == this.hand.get(this.index+2).CardRank() &&
					this.hand_original.get(i).CardSuit() == this.hand.get(this.index).CardSuit()) ||
			(this.hand_original.get(i).CardRank() == this.hand.get(this.index+3).CardRank() &&
			this.hand_original.get(i).CardSuit() == this.hand.get(this.index).CardSuit())) {
				
				if(!flag) {
					Aces = String.valueOf(i+1);
					flag = true;
				}
				else if(flag) {
					Aces = Aces + " " + String.valueOf(i+1);
				}
			}
		}
		return Aces;
	}
	
	public String search3RoyalFlush() {
		String Aces = null;
		boolean flag = false;
		for(int i = 0; i < 5; i++) {
			if(this.hand_original.get(i).CardRank() == this.hand.get(2).CardRank() ||
			this.hand_original.get(i).CardRank() == this.hand.get(3).CardRank() ||
			this.hand_original.get(i).CardRank() == this.hand.get(4).CardRank()) {
				
				if(!flag) {
					Aces = String.valueOf(i+1);
					flag = true;
				}
				else if(flag) {
					Aces = Aces + " " + String.valueOf(i+1);
				}
			}
		}
		return Aces;
	}
	
	public String search3Flush() {
		String Aces = null;
		boolean flag = false;
		for(int i = 0; i < 5; i++) {
			if(this.hand_original.get(i).CardSuit() == this.hand.get(this.index).CardSuit()) {
				
				if(!flag) {
					Aces = String.valueOf(i+1);
					flag = true;
				}
				else if(flag) {
					Aces = Aces + " " + String.valueOf(i+1);
				}
			}
		}
		return Aces;
	}

	public String searchAlmostStraight() {
		String Aces = null;
		boolean flag = false;
		for(int i = 0; i < 5; i++) {
			if((this.hand_original.get(i).CardRank() == this.hand.get(this.index).CardRank() &&
					this.hand_original.get(i).CardSuit() == this.hand.get(this.index).CardSuit())||
			(this.hand_original.get(i).CardRank() == this.hand.get(this.index + 1).CardRank() &&
					this.hand_original.get(i).CardSuit() == this.hand.get(this.index).CardSuit()) ||
			(this.hand_original.get(i).CardRank() == this.hand.get(this.index + 2).CardRank() &&
					this.hand_original.get(i).CardSuit() == this.hand.get(this.index + 2).CardSuit())||
			(this.hand_original.get(i).CardRank() == this.hand.get(this.index + 3).CardRank() &&
					this.hand_original.get(i).CardSuit() == this.hand.get(this.index + 3).CardSuit())) {
				
				if(!flag) {
					Aces = String.valueOf(i+1);
					flag = true;
				}
				else if(flag) {
					Aces = Aces + " " + String.valueOf(i+1);
				}
			}
		}
		return Aces;
	}
	
	public String searchStraight3Flush() {
		String Aces = null;
		boolean flag = false;
		for(int i = 0; i < 5; i++) {
			if(this.hand_original.get(i).CardSuit() == this.hand.get(2).CardSuit()) {
				
				if(!flag) {
					Aces = String.valueOf(i+1);
					flag = true;
				}
				else if(flag) {
					Aces = Aces + " " + String.valueOf(i+1);
				}
			}
		}
		return Aces;
	}

	public String search2HighSuit() {
		String Aces = null;
		boolean flag = false;
		for(int i = 0; i < 5; i++) {
			if(this.hand_original.get(i).CardRank() == this.hand.get(this.index).CardRank() ||
			this.hand_original.get(i).CardRank() == this.hand.get(this.index + 1).CardRank()) {
				
				if(!flag) {
					Aces = String.valueOf(i+1);
					flag = true;
				}
				else if(flag) {
					Aces = Aces + " " + String.valueOf(i+1);
				}
			}
		}
		return Aces;
	}


}


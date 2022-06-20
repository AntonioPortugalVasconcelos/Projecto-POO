package videopoker.mode;

import java.util.ArrayList;

import videopoker.game.Advice;
import videopoker.game.Card;
import videopoker.game.Deck;
import videopoker.game.Hand;
import videopoker.game.Rank;
import videopoker.game.Suit;
import videopoker.interfaces.GameMode;

public class SimulationMode implements GameMode {
	
	private String[] args;
	private Advice advice;
	private Hand hand;

	public int StartingCredit() {
		return Integer.valueOf(args[1]);
	}

	public int BetValue() {
		return Integer.valueOf(args[2]);
	}
	
	public int GetPlays() {
		return Integer.valueOf(args[3]);
	}
	
	public String[] NextCommand(String prevCommand) {
		this.advice = new Advice(hand);
		if(prevCommand == null) {
	    	String[] returnStrings = new String[]{"b", "b"};
	    	return returnStrings;
	    	
		} else if (prevCommand.charAt(0) == 'h'){
	    	String[] returnStrings = new String[]{"b", "b"};
	    	return returnStrings;
			
		}else if(prevCommand.equals("b")) {
	    	String[] returnStrings = new String[]{"d", "d"};
	    	return returnStrings;
			
		}else {
			System.out.printf("-cmd a\n");
	    	String[] returnStrings = new String[]{advice.getAdv(), "h"};
	    	return returnStrings;
			
			
		}
	}
	
	public SimulationMode(String[] arguments) {
		this.args = arguments;
		
	}
	
	public void SetHand(Hand hand) {
		this.hand = hand;
	}

    public Deck createDeck(Deck legacyDeck) {
    	char[] suits = {'H', 'D', 'S' , 'C'};
    	char [] values = {'2','3','4','5','6','7','8','9','T','J','Q','K','A'};
    	ArrayList<Card> cards = new ArrayList<Card>();
    	
        for (char cardSuit : suits) {
            for (char cardValue : values) {
                cards.add(new Card(new Rank(cardValue), new Suit(cardSuit)));
            }
        }
        
        Deck deck = new Deck(cards);
        deck.Shuffle();
        return deck;
    }

}

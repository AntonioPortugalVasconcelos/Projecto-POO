package videopoker.mode;

import java.util.ArrayList;

import videopoker.game.Advice;
import videopoker.game.Card;
import videopoker.game.Deck;
import videopoker.game.Hand;
import videopoker.game.Rank;
import videopoker.game.Suit;
import videopoker.interfaces.GameMode;
/**
 * 
 * @author  António Vasconcelos and António Falacho
 *
 */
public class SimulationMode implements GameMode {
	
	private String[] args;
	private Advice advice;
	private Hand hand;

	/**
     * Gets the initial credit from commands
     * @return integer for credit value
     */
	public int StartingCredit() {
		return Integer.valueOf(args[1]);
	}
	/**
	 * Call function to get size of the bet
	 * @return integer for bet value
	 */
	public int BetValue() {
		return Integer.valueOf(args[2]);
	}
	/**
	 * Call function to get the number of plays
	 * @return integer for number of plays
	 */
	public int GetPlays() {
		return Integer.valueOf(args[3]);
	}
    /**
     * From the previous command, this function determines what command it must do
     * @return string with command
     */
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
	/**
	 * Constructor of SimulationMode class
	 * @param arguments input arguments
	 */
	public SimulationMode(String[] arguments) {
		this.args = arguments;
		
	}
	/**
	 * Pulls out the first five cards from the deck to the hand of the player
	 */
	public void SetHand(Hand hand) {
		this.hand = hand;
	}
	/**
	 * Creates the deck
	 */
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

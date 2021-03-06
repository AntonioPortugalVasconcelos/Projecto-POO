package videopoker.mode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import videopoker.game.Card;
import videopoker.game.Deck;
import videopoker.game.Hand;
import videopoker.game.Rank;
import videopoker.game.Suit;
import videopoker.interfaces.GameMode;
/**
 * 
 * @author Ant?nio Vasconcelos and Ant?nio Falacho
 *
 */
public class PlayerMode implements GameMode{
	
	private String[] args;
	/**
	 * Call function to get size of the bet
	 * @return returns size of bet
	 */
	@Override
	public int StartingCredit() {
		return Integer.valueOf(args[1]);
	}
	/**
	 * Call function to get the number of plays
	 * @return returns number of plays
	 */
	public int GetPlays() {
		return Integer.valueOf(args[2]);
	}
	/**
	 * Gets next command from the terminal
	 */
	public String[] NextCommand(String commands) {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
	    try {
	    	String[] returnStrings = new String[]{reader.readLine(), null};
	    	return returnStrings;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	/**
	 * Constructor for a player mode
	 * @param arguments input arguments
	 */
	public PlayerMode(String[] arguments) {
		this.args = arguments;
		
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
    /**
	 * Legacy code
	 */
	public void SetHand(Hand hand) {
		
	}

}

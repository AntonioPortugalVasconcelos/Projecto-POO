package videopoker.mode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import videopoker.game.Card;
import videopoker.game.Deck;
import videopoker.game.Rank;
import videopoker.game.Suit;
import videopoker.interfaces.GameMode;

public class SimulationMode implements GameMode{
	
	private String[] args;

	@Override
	public int StartingCredit() {
		return Integer.valueOf(args[1]);
	}

	public int BetValue() {
		return Integer.valueOf(args[2]);
	}
	
	public int GetPlays() {
		return Integer.valueOf(args[3]);
	}
	
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
	
	public SimulationMode(String[] arguments) {
		this.args = arguments;
		
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

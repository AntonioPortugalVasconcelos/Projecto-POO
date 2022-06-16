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
		return 0;
	}

	@Override
	public String getCommands() {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
	    try {
			return reader.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
		
	}

	@Override
	public String GetDeck() {
		return null;
	}

	@Override
	public String[] NextCommand(String commands) {
		return null;
	}
	
	public SimulationMode(String[] arguments) {
		this.args = arguments;
		
	}

    public Deck createDeck() {
    	char[] suits = {'H', 'D', 'S' , 'C'};
    	char [] values = {'2','3','4','5','6','7','8','9','T','J','Q','K','A'};
    	ArrayList<Card> cards = new ArrayList<Card>();
    	
        for (char cardSuit : suits) {
            for (char cardValue : values) {
                cards.add(new Card(new Rank(cardValue), new Suit(cardSuit)));
            }
        }
        
        return new Deck(cards);
    }

}

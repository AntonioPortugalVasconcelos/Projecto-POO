package videopoker.game;

import java.util.ArrayList;

import interfaces.GameMode;
import videopoker.mode.DebugMode;
import videopoker.mode.SimulationMode;

public class Game {
	private Hand hand;
	private Deck deck;
	private GameMode mode;
	private Credit credit;
	private String commands;
	
	public Game(DebugMode mode) {
		this.mode = mode;
		
		
	}

	public Game(SimulationMode mode) {
		this.mode = mode;
		
		
	}
	
	private void initializeGame() {
		this.credit = new Credit(mode.StartingCredit());
		this.commands = mode.getCommands();
		this.deck = new Deck(mode.GetDeck());
		for (int i = 0; i < 5; i++) {
			this.hand.AddHand(deck.drawCard());
		}
		
	}
	
	
	
}

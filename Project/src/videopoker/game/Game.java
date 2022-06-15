package videopoker.game;

import java.util.ArrayList;

import interfaces.GameMode;
import videopoker.mode.DebugMode;
import videopoker.mode.SimulationMode;


public class Game {
	private Hand hand;
	private ArrayList<Card> deck = new ArrayList<Card>();
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
		this.deck = new Deck(mode.getDeck());
		
	}
	
	
	
}

package videopoker.game;

import interfaces.GameMode;
import videopoker.mode.DebugMode;
import videopoker.mode.SimulationMode;

public class Game {
	private Hand hand;
	private Deck deck;
	private GameMode mode;
	private Credit credit;
	private Credit initialCredit;
	private String commands;
	private String command;
	private int bet;
	
	public Game(DebugMode mode) {
		this.mode = mode;
		
		
	}

	public Game(SimulationMode mode) {
		this.mode = mode;
		
		
	}
	
	private void initializeGame() {
		this.credit = new Credit(mode.StartingCredit());
		this.initialCredit = this.credit;
		this.commands = mode.getCommands();
		this.deck = new Deck(mode.GetDeck());
		for (int i = 0; i < 5; i++) {
			this.hand.addHand(deck.drawCard());
		}
		
	}
	
	private void GetCommands() {
		String[] returnString = null;
		returnString = mode.NextCommand(commands);
		this.command = returnString[0];
		this.commands = returnString[1];
		
	}
	
	
	public void TurnStart() {
		this.GetCommands();
		
	}
	
	public void TurnEnd() {
		
	}
	
}

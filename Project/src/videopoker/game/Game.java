package videopoker.game;

import videopoker.interfaces.GameMode;
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
	
	public Game(GameMode mode) {
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
	
	private void DoCommand(String command) {
		switch (command.charAt(0)) {
			case 'b':
			case '$':
			case 'd':
			case 'h':
			case 'a':
			case 's':
		
		}
		
	}
	
	
	public void TurnStart() {
		this.GetCommands();
		this.DoCommand(command);
		
	}
	
	public void TurnEnd() {
		
	}
	
}

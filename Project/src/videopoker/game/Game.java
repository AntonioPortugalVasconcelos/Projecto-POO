package videopoker.game;

import java.util.ArrayList;

import videopoker.interfaces.GameMode;
import videopoker.mode.DebugMode;
import videopoker.mode.SimulationMode;

public class Game {
	private Hand hand;
	private Deck deck;
	private GameMode mode;
	private Credit credit;
	private Credit initialCredit;
	private Statistics stats;
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
		
	}
	
	private void GetCommands() {
		String[] returnString = null;
		returnString = mode.NextCommand(commands);
		this.command = returnString[0];
		this.commands = returnString[1];
		
	}
	
	private void DoCommandStart(String command) {
		System.out.printf("-cmd %s", command.charAt(0));
		switch (command.charAt(0)) {
			case 'b':
				if (command.length() != 1) {
					this.bet = Integer.valueOf(command.split(" ")[1]);
					this.credit.Add(-bet);
					
				}else {
					this.bet = 5;
					this.credit.Add(-bet);
					
				}
				System.out.printf("player is betting %s", this.bet);
				
			case '$':
				System.out.printf("player's credit is %d", this.credit.GetValue());
				
			case 'd':;
				for (int i = 0; i < 5; i++) {
					this.hand.addHand(deck.drawCard());
				}
				System.out.printf("player's hand %d", this.hand.toString());
				
			case 'h':
				System.out.printf("h: can't hold right now");
				
			case 'a':
				System.out.printf("advice");				
				
			case 's':
				System.out.printf("Hand						Nb");	
				System.out.printf("---------------------------");	
				System.out.printf("Jacks or Better			%d", this.stats.GetStat("1"));	
				System.out.printf("Two Pairs				%d", this.stats.GetStat("2"));	
				System.out.printf("Three of a Kind			%d", this.stats.GetStat("3"));	
				System.out.printf("Straight					%d", this.stats.GetStat("4"));
				System.out.printf("Flush					%d", this.stats.GetStat("5"));	
				System.out.printf("Full House				%d", this.stats.GetStat("6"));	
				System.out.printf("Four of a Kind 			%d", this.stats.GetStat("7"));	
				System.out.printf("Straight Flush 			%d", this.stats.GetStat("8"));	
				System.out.printf("Royal Flush				%d", this.stats.GetStat("9"));	
				System.out.printf("Other					%d", this.stats.GetStat("0"));	
				System.out.printf("---------------------------");	
				System.out.printf("Total					%d", this.stats.TotalPlays());	
				System.out.printf("---------------------------");
				System.out.printf("Credit				%d(%d)", this.credit.GetValue(), (this.initialCredit.GetValue()-this.credit.GetValue())/this.stats.TotalPlays()*100);
		
		}
		System.out.printf("/n");
		
	}
	
	private void DoCommandEnd(String command) {
		switch (command.charAt(0)) {
			case 'b':
				System.out.printf("b: can't bet right now");
				
				
			case '$':
				System.out.printf("player's credit is %d", this.credit.GetValue());
				
			case 'd':
				System.out.printf("d: can't deal right now");
				
				
			case 'h':
				char [] holding = this.hand.HoldHand(command);
				for (char cardPosition : holding) {
					if (cardPosition != 0) {
						this.hand.setHand(cardPosition, this.deck.drawCard());
						
					}
				}
				System.out.printf("player's hand %d", this.hand.toString());
				
			case 'a':
				System.out.printf("advice");
				
				
			case 's':
				System.out.printf("Hand						Nb");	
				System.out.printf("---------------------------");	
				System.out.printf("Jacks or Better			%d", this.stats.GetStat("1"));	
				System.out.printf("Two Pairs				%d", this.stats.GetStat("2"));	
				System.out.printf("Three of a Kind			%d", this.stats.GetStat("3"));	
				System.out.printf("Straight					%d", this.stats.GetStat("4"));
				System.out.printf("Flush					%d", this.stats.GetStat("5"));	
				System.out.printf("Full House				%d", this.stats.GetStat("6"));	
				System.out.printf("Four of a Kind 			%d", this.stats.GetStat("7"));	
				System.out.printf("Straight Flush 			%d", this.stats.GetStat("8"));	
				System.out.printf("Royal Flush				%d", this.stats.GetStat("9"));	
				System.out.printf("Other					%d", this.stats.GetStat("0"));	
				System.out.printf("---------------------------");	
				System.out.printf("Total					%d", this.stats.TotalPlays());	
				System.out.printf("---------------------------");
				System.out.printf("Credit				%d(%d)", this.credit.GetValue(), (this.initialCredit.GetValue()-this.credit.GetValue())/this.stats.TotalPlays()*100);
		
		}
		
	}
	
	
	public String TurnStart() {
		this.GetCommands();
		this.DoCommandStart(command);
		return command;
		
	}
	
	public String TurnEnd() {
		this.GetCommands();
		this.DoCommandEnd(command);
		return command;
		
	}
	
}

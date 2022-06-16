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
	private String commands = null;
	private String command;
	private int plays = 0;
	private int bet;
	private int state;
	
	public Game(GameMode mode) {
		this.mode = mode;
		
		
	}
	
	public void initializeGame() {
		this.credit = new Credit(mode.StartingCredit());
		this.initialCredit = this.credit;
		this.commands = mode.getCommands();
		this.deck = new Deck(mode.GetDeck());
		this.state = 0;
		
	}
	
	public int GetCommandLenght() {
		return this.commands.length();
		
	}
	
	public int Getnumberplays() {
		return this.plays;
		
	}
	
	public int Getstate() {
		return this.state;
		
	}
	
	private void GetCommands() {
		String[] returnString = null;
		returnString = mode.NextCommand(commands);
		this.command = returnString[0];
		this.commands = returnString[1];
		
	}
	
	private void DoCommandStart(String command) {
		System.out.printf("-cmd %s\n", command.charAt(0));
		switch (command.charAt(0)) {
			case 'b':
				if (command.length() != 1) {
					this.bet = Integer.valueOf(command.split(" ")[1]);
					this.credit.Add(-bet);
					
				}else {
					this.bet = 5;
					this.credit.Add(-bet);
					
				}
				System.out.printf("player is betting %s\n", this.bet);
				break;
				
			case '$':
				System.out.printf("player's credit is %d\n", this.credit.GetValue());
				break;
				
			case 'd':;
				ArrayList<Card> cards = new ArrayList<Card>();
				for (int i = 0; i < 5; i++) {
					cards.add(deck.drawCard());
				}
				this.hand = new Hand(cards);
				this.state = 1;
				System.out.printf("player's hand %d\n", this.hand.toString());
				break;
				
			case 'h':
				System.out.println("h: can't hold right now");
				break;
				
			case 'a':
				System.out.println("advice");
				break;				
				
			case 's':
				System.out.printf("Hand						Nb\n");	
				System.out.printf("---------------------------\n");	
				System.out.printf("Jacks or Better			%d\n", this.stats.GetStat("1"));	
				System.out.printf("Two Pairs				%d\n", this.stats.GetStat("2"));	
				System.out.printf("Three of a Kind			%d\n", this.stats.GetStat("3"));	
				System.out.printf("Straight					%d\n", this.stats.GetStat("4"));
				System.out.printf("Flush					%d\n", this.stats.GetStat("5"));	
				System.out.printf("Full House				%d\n", this.stats.GetStat("6"));	
				System.out.printf("Four of a Kind 			%d\n", this.stats.GetStat("7"));	
				System.out.printf("Straight Flush 			%d\n", this.stats.GetStat("8"));	
				System.out.printf("Royal Flush				%d\n", this.stats.GetStat("9"));	
				System.out.printf("Other					%d\n", this.stats.GetStat("0"));	
				System.out.printf("---------------------------\n");	
				System.out.printf("Total					%d\n", this.stats.TotalPlays());	
				System.out.printf("---------------------------\n");
				System.out.printf("Credit				%d(%d)\n", this.credit.GetValue(), (this.initialCredit.GetValue()-this.credit.GetValue())/this.stats.TotalPlays()*100);
				break;
		
		}
		System.out.printf("\n");
		
	}
	
	private void DoCommandEnd(String command) {
		switch (command.charAt(0)) {
			case 'b':
				System.out.println("b: can't bet right now");
				break;
				
			case '$':
				System.out.printf("player's credit is %d\n", this.credit.GetValue());
				break;
				
			case 'd':
				System.out.println("d: can't deal right now");
				break;
				
				
			case 'h':
				char [] holding = this.hand.HoldHand(command);
				for (char cardPosition : holding) {
					if (cardPosition != 0) {
						this.hand.setHand(cardPosition, this.deck.drawCard());
						
					}
				}
				System.out.printf("player's hand %d\n", this.hand.toString());
				this.state = 0;
				break;
				
			case 'a':
				System.out.printf("advice\n");
				break;
				
				
			case 's':
				System.out.printf("Hand						Nb\n");	
				System.out.printf("---------------------------\n");	
				System.out.printf("Jacks or Better			%d\n", this.stats.GetStat("1"));	
				System.out.printf("Two Pairs				%d\n", this.stats.GetStat("2"));	
				System.out.printf("Three of a Kind			%d\n", this.stats.GetStat("3"));	
				System.out.printf("Straight					%d\n", this.stats.GetStat("4"));
				System.out.printf("Flush					%d\n", this.stats.GetStat("5"));	
				System.out.printf("Full House				%d\n", this.stats.GetStat("6"));	
				System.out.printf("Four of a Kind 			%d\n", this.stats.GetStat("7"));	
				System.out.printf("Straight Flush 			%d\n", this.stats.GetStat("8"));	
				System.out.printf("Royal Flush				%d\n", this.stats.GetStat("9"));	
				System.out.printf("Other					%d\n", this.stats.GetStat("0"));	
				System.out.printf("---------------------------\n");	
				System.out.printf("Total					%d\n", this.stats.TotalPlays());	
				System.out.printf("---------------------------\n");
				System.out.printf("Credit				%d(%d)\n", this.credit.GetValue(), (this.initialCredit.GetValue()-this.credit.GetValue())/this.stats.TotalPlays()*100);
				break;
		
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

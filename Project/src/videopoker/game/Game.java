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
	
	public void initializeGameD() {
		this.credit = new Credit(mode.StartingCredit());
		this.initialCredit = new Credit(mode.StartingCredit());
		this.commands = ((DebugMode) mode).getCommands();
		this.deck = new Deck(((DebugMode) mode).GetDeck());
		this.stats = new Statistics();
		this.state = 0;
		
	}

	public void initializeGameS() {
		this.credit = new Credit(mode.StartingCredit());
		this.initialCredit = new Credit(mode.StartingCredit());
		this.deck = (((SimulationMode) mode).createDeck());
		this.stats = new Statistics();
		this.plays = (((SimulationMode) mode).GetPlays());
		this.bet = (((SimulationMode) mode).BetValue());
		this.state = 0;
		
	}
	
	public int GetCommandLenght() {
		if (this.commands == null) {
			return 0;
		}
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
		System.out.printf("-cmd %s\n", command);
		switch (command.charAt(0)) {
			case 'b':
				if (commands == null) {
					
				}
				else if (command.length() != 1) {
					this.bet = Integer.valueOf(command.split(" ")[1]);
					if (this.bet < 1 || this.bet > 5) {
						System.out.printf("b: illegal amount \n");
						break;
						
					}
					if (this.credit.Add(-bet)) {
						this.credit.Add(bet);
						System.out.printf("b: illegal amount \n");
						break;
					}
					
				}else {
					this.bet = 5;
					if (this.credit.Add(-bet)) {
						this.credit.Add(bet);
						System.out.printf("b: illegal amount %s\n", this.bet);
						break;
					}
					
				}
				System.out.printf("player is betting %s\n", this.bet);
				this.stats.AddBet(bet);
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
				System.out.printf("player's hand %s\n", this.hand.toString());
				break;
				
			case 'h':
				System.out.printf("h: can't hold right now\n");
				break;
				
			case 'a':
				System.out.printf("advice\n");
				break;				
				
			case 's':
				System.out.printf("Hand                     Nb\n");	
				System.out.printf("---------------------------\n");	
				System.out.printf("Jacks or Better          %d\n", this.stats.GetStat("1"));	
				System.out.printf("Two Pairs                %d\n", this.stats.GetStat("2"));	
				System.out.printf("Three of a Kind          %d\n", this.stats.GetStat("3"));	
				System.out.printf("Straight                 %d\n", this.stats.GetStat("4"));
				System.out.printf("Flush                    %d\n", this.stats.GetStat("5"));	
				System.out.printf("Full House               %d\n", this.stats.GetStat("6"));	
				System.out.printf("Four of a Kind           %d\n", this.stats.GetStat("7"));	
				System.out.printf("Straight Flush           %d\n", this.stats.GetStat("8"));	
				System.out.printf("Royal Flush              %d\n", this.stats.GetStat("9"));	
				System.out.printf("Other                    %d\n", this.stats.GetStat("0"));	
				System.out.printf("---------------------------\n");	
				System.out.printf("Total                    %d\n", this.stats.TotalPlays());	
				System.out.printf("---------------------------\n");
				System.out.printf("Credit             %d(%f%%)\n", this.credit.GetValue(), (float)(this.initialCredit.GetValue()-this.credit.GetValue())/this.stats.GetBets()*100);
				break;
		
		}
		System.out.printf("\n");
		
	}
	
	private void DoCommandEnd(String command) {
		System.out.printf("-cmd %s\n", command);
		switch (command.charAt(0)) {
			case 'b':
				System.out.printf("b: can't bet right now\n");
				break;
				
			case '$':
				System.out.printf("player's credit is %d\n\n", this.credit.GetValue());
				break;
				
			case 'd':
				System.out.printf("d: can't deal right now\n");
				break;
				
				
			case 'h':
				char [] holding = this.hand.HoldHand(command);
				for (char cardPosition : holding) {
					if (cardPosition != '0') {
						this.hand.setHand(Character.getNumericValue(cardPosition) - 1, this.deck.drawCard());
						
					}
				}
				System.out.printf("player's hand %s\n", this.hand.toString());
				this.credit.Add(HandCheck(this.hand, this.bet));
				System.out.printf("%d\n\n", this.credit.GetValue());
				this.state = 0;
				break;
				
			case 'a':
				System.out.printf("advice\n\n");
				break;
				
				
			case 's':
				System.out.printf("Hand                     Nb\n");	
				System.out.printf("---------------------------\n");	
				System.out.printf("Jacks or Better          %d\n", this.stats.GetStat("1"));	
				System.out.printf("Two Pairs                %d\n", this.stats.GetStat("2"));	
				System.out.printf("Three of a Kind          %d\n", this.stats.GetStat("3"));	
				System.out.printf("Straight                 %d\n", this.stats.GetStat("4"));
				System.out.printf("Flush                    %d\n", this.stats.GetStat("5"));	
				System.out.printf("Full House               %d\n", this.stats.GetStat("6"));	
				System.out.printf("Four of a Kind           %d\n", this.stats.GetStat("7"));	
				System.out.printf("Straight Flush           %d\n", this.stats.GetStat("8"));	
				System.out.printf("Royal Flush              %d\n", this.stats.GetStat("9"));	
				System.out.printf("Other                    %d\n", this.stats.GetStat("0"));	
				System.out.printf("---------------------------\n");	
				System.out.printf("Total                    %d\n", this.stats.TotalPlays());	
				System.out.printf("---------------------------\n");
				System.out.printf("Credit             %d(%f%%)\n", this.credit.GetValue(), (float)(this.initialCredit.GetValue()-this.credit.GetValue())/this.stats.GetBets()*100);
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
	
	private int HandCheck(Hand hand, int bet) {
		switch (hand.handType()){
			case 12:
				this.stats.AddStat(9);
				System.out.printf("player wins with a ROYAL FLUSH and his credit is ");
				if (bet != 5) {
					return 4000;
				}else {
					return 250*bet;
				}
			case 11:
				this.stats.AddStat(8);
				System.out.printf("player wins with a STRAIGHT FLUSH and his credit is ");
				return 50 * bet;
			case 10:
				this.stats.AddStat(7);
				System.out.printf("player wins with a FOUR ACES and his credit is ");
				return 160 * bet;
			case 9:
				this.stats.AddStat(7);
				System.out.printf("player wins with a FOUR 2-4 and his credit is ");
				return 80 * bet;
			case 8:
				this.stats.AddStat(7);
				System.out.printf("player wins with a FOUR 5-K and his credit is ");
				return 50 * bet;
			case 7:
				this.stats.AddStat(6);
				System.out.printf("player wins with a FULL HOUSE and his credit is ");
				return 10 * bet;
			case 6:
				this.stats.AddStat(5);
				System.out.printf("player wins with a FLUSH and his credit is ");
				return 7 * bet;
			case 5:
				this.stats.AddStat(4);
				System.out.printf("player wins with a STRAIGHT and his credit is ");
				return 5 * bet;
			case 4:
				this.stats.AddStat(3);
				System.out.printf("player wins with a THREE OF A KIND and his credit is ");
				return 3 * bet;
			case 3:
				this.stats.AddStat(2);
				System.out.printf("player wins with a TWO PAIR and his credit is ");
				return 1 * bet;
			case 2:
				this.stats.AddStat(1);
				System.out.printf("player wins with a JACKS OR BETTER and his credit is ");
				return 1 * bet;
			case 1:
				this.stats.AddStat(0);
				System.out.printf("player loses and his credit is  ");
				return 0;
		}
		return -1;
	}
	
}

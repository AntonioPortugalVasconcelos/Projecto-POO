package videopoker.game;

public class Statistics {
	private int JackorBetter = 0;
	private int TwoPair = 0;
	private int ThreeKind = 0;
	private int Straight = 0;
	private int Flush = 0;
	private int FullHouse = 0;
	private int FourKind = 0;
	private int StraightFlush = 0;
	private int RoyalFlush = 0;
	private int Other = 0;
	
	public void AddStat(String stat) {
		switch (stat) {
			case "1":
				this.JackorBetter++;
			case "2":
				this.TwoPair++;
			case "3":
				this.ThreeKind++;
			case "4":
				this.Straight++;
			case "5":
				this.Flush++;
			case "6":
				this.FullHouse++;
			case "7":
				this.FourKind++;
			case "8":
				this.StraightFlush++;
			case "9":
				this.RoyalFlush++;
			case "0":
				this.Other++;
		
		}
		
	}
	
	public int GetStat(String stat) {
		switch (stat) {
			case "1":
				return this.JackorBetter;
			case "2":
				return this.TwoPair;
			case "3":
				return this.ThreeKind;
			case "4":
				return this.Straight;
			case "5":
				return this.Flush;
			case "6":
				return this.FullHouse;
			case "7":
				return this.FourKind;
			case "8":
				return this.StraightFlush;
			case "9":
				return this.RoyalFlush;
			case "0":
				return this.Other;
		
		}
		return -1;
		
	}
	
	public int TotalPlays() {
		return this.JackorBetter + this.TwoPair + this.ThreeKind + this.Straight + this.Flush +
				this.FullHouse + this.FourKind + this.StraightFlush + this.RoyalFlush + this.Other;
	}

}

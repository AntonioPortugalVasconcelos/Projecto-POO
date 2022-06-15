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
				JackorBetter++;
			case "2":
				TwoPair++;
			case "3":
				ThreeKind++;
			case "4":
				Straight++;
			case "5":
				Flush++;
			case "6":
				FullHouse++;
			case "7":
				FourKind++;
			case "8":
				StraightFlush++;
			case "9":
				RoyalFlush++;
			case "0":
				Other++;
		
		}
		
	}
	
	public int GetStat(String stat) {
		switch (stat) {
			case "1":
				return JackorBetter;
			case "2":
				return TwoPair;
			case "3":
				return ThreeKind;
			case "4":
				return Straight;
			case "5":
				return Flush;
			case "6":
				return FullHouse;
			case "7":
				return FourKind;
			case "8":
				return StraightFlush;
			case "9":
				return RoyalFlush;
			case "0":
				return Other;
		
		}
		return -1;
		
	}

}

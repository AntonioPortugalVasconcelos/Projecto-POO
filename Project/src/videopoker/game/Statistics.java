package videopoker.game;
/**
 * 
 * @author  António Vasconcelos and António Falacho
 *
 */
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
	private int SumOfBets = 0;
	private int SumOfGains = 0;
	/**
	 * Receives the result of the last hand and adds it to the statistics
	 * @param stat(last result)
	 */
	public void AddStat(int stat) {
		switch (stat) {
			case 1:
				this.JackorBetter++;
				break;
			case 2:
				this.TwoPair++;
				break;
			case 3:
				this.ThreeKind++;
				break;
			case 4:
				this.Straight++;
				break;
			case 5:
				this.Flush++;
				break;
			case 6:
				this.FullHouse++;
				break;
			case 7:
				this.FourKind++;
				break;
			case 8:
				this.StraightFlush++;
				break;
			case 9:
				this.RoyalFlush++;
				break;
			case 0:
				this.Other++;
				break;
		
		}
		
	}
	/**
	 * Returns the statistics of each hand
	 * @param stat(Which hand will be returned)
	 * @return value for requested statistic
	 */
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
	/**
	 * Returns the total of plays made
	 * @return total number of plays
	 */
	public int TotalPlays() {
		return this.JackorBetter + this.TwoPair + this.ThreeKind + this.Straight + this.Flush +
				this.FullHouse + this.FourKind + this.StraightFlush + this.RoyalFlush + this.Other;
	}
	/**
	 * Adds another bet made
	 * @param bet value to add to total bets
	 */
	public void AddBet(int bet) {
		this.SumOfBets += bet;
	}
	/**
	 * gets the sum of all bets
	 * @return total sum of bets
	 */
	public int GetBets() {
		return SumOfBets;
	}
	/**
	 * Adds another gain made
	 * @param gain value to add to total gain
	 */
	public void AddGain(int gain) {
		this.SumOfGains += gain;
	}
	/**
	 * gets the sum of all gains
	 * @return total sum of gains
	 */
	public int GetGains() {
		return SumOfGains;
	}

}

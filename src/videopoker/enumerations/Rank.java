package videopoker.enumerations;

public enum Rank {
	ACE('A'), TWO('2'), THREE('3'),
	FOUR('4'), FIVE('5'), SIX('6'),
	SEVEN('7'), EIGHT('8'), NINE('9'),
	TEN('T'), JACK('J'), QUEEN('Q'), KING('K');
	
	 private char val;
	 
	 Rank(char val) {
	        this.val = val;
	    }
	 
	 public char GetValue() {
		 return this.val;
	 }
	 
}

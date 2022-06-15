package videopoker.game;

public class Rank {
	private char val;
	private char cardNumb[] = {'2','3','4','5','6','7','8','9','T','J','Q','K','A'};
	 
	 public Rank(char val) {
	        this.val = val;
	    }
	 
	 public int GetValue() {
		 for (int i = 0; i < 13; i++) {
			 if(val == cardNumb[i]){
				return i; 
			 }
		 }
		 System.out.println("Error: Wrong Card Number");
		 return -1;
	 }
	 public char GetRank() {
		 return this.val;
	 }
	 
}

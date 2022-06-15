package videopoker.game;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Advice {
	Hand hand;

	public Advice(Hand hand) {
		super();
		this.hand = hand;
	}
	
	public void getAdvice() {
		int i;		
		i = this.hand.handType();
		if(i == 12 || i == 11) {
			System.out.println("player should hold cards 1 2 3 4 5");
		}
		if(this.hand.checkAlmostRoyalFlush())
		
			
	}
}

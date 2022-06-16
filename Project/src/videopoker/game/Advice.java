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
			System.out.printf("player should hold cards 1 2 3 4 5\n");
			return;
		}
		if(i == 10 || i == 9 || i == 8) {
			String fourKind = this.hand.searchSameKind();
			System.out.printf("player should hold cards %s\n", fourKind);
			return;
		}
		
		if(this.hand.checkAlmostRoyalFlush()) {
			return;
		}
		if(this.hand.check3Aces()) {
			String Aces = this.hand.searchSameKind();
			System.out.printf("player should hold cards %s\n", Aces);
			return;
		}
		if(i == 7 || i == 6 || i == 5) {
			System.out.printf("player should hold cards 1 2 3 4 5\n");
			return;
		}
		if(i == 4) {
			String threeKind = this.hand.searchSameKind();
			System.out.printf("player should hold cards %s\n", threeKind);
			return;
		}
		
	}
}

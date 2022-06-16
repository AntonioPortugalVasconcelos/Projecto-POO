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
		if(this.hand.checkAlmostStraightFlush()) {
			return;
		}
		if(i == 3) {
			String twoPairs = this.hand.search2Pair();
			System.out.printf("player should hold cards %s\n", twoPairs);
			return;
		}
		if(i == 2) {
			String highPair = this.hand.searchSameKind();
			System.out.printf("player should hold cards %s\n", highPair);
			return;
		}
		if(this.hand.checkAlmostFlush()) {
			String flush = this.hand.searchSameSuit();
			System.out.printf("player should hold cards %s\n", flush);
			return;
		}
		if(this.hand.check3RoyalFlush()) {
			return;
		}
		if(this.hand.checkAlmostStraight()) {
			String straight = this.hand.search4Straight();
			System.out.printf("player should hold cards %s\n", straight);
			return;
		}
		if(this.hand.checkPair()) {
			String low = this.hand.searchSameKind();
			System.out.printf("player should hold cards %s\n", low);
			return;
		}
		if(this.hand.checkAKQJ()) {
			String low = this.hand.searchAKQJ();
			System.out.printf("player should hold cards %s\n", low);
			return;
		}
		if(this.hand.Straight3Flushout) {
			
		}
		if(this.hand.checkQJSuit()) {
			String Aces = this.hand.search2Pair();
			System.out.printf("player should hold cards %s\n", Aces);
			return;
		}
		if(this.hand.checkKQJ()) {
			String low = this.hand.searchAKQJ();
			System.out.printf("player should hold cards %s\n", low);
			return;
		if(this.hand.checkJTSuit()) {
			String Aces = this.hand.search2Pair();
			System.out.printf("player should hold cards %s\n", Aces);
			return;
		}
		if(this.hand.checkQJ()) {
			String Aces = this.hand.search2Pair();
			System.out.printf("player should hold cards %s\n", Aces);
			return;
		}
		if(this.hand.OneHigh3Flush) {
			
		}
		if(this.hand.checkQTSuit()) {
			String Aces = this.hand.search2Pair();
			System.out.printf("player should hold cards %s\n", Aces);
			return;
		}
		if(this.hand.Straight3FlushT3) {
			
		}
		if(this.hand.checkKjKq()) {
			String Aces = this.hand.search2Pair();
			System.out.printf("player should hold cards %s\n", Aces);
			return;
		}
		if(this.hand.CheckAce()) {
			String Ace = this.hand.searchSameKind();
			System.out.printf("player should hold cards %s\n", Ace);
			return;
		}
		if(this.hand.checkTK()) {
			String Aces = this.hand.search2Pair();
			System.out.printf("player should hold cards %s\n", Aces);
			return;
		}
		if(this.hand.checkJoQoK()) {
			String Aces = this.hand.searchSameKind();
			System.out.printf("player should hold cards %s\n", Aces);
			return;
		}
		if(this.hand.InsideStraightLow) {
			
		}
		if(this.hand.threeFlush) {
			
		}
		else {
			System.out.printf("player shouldn't hold cards\n");
			return;
		}
	}
}

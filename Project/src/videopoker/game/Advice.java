package videopoker.game;


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
			String Aces = this.hand.searchAlmostRoyalFlush();
			System.out.printf("player should hold cards %s\n", Aces);
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
			String Aces = this.hand.search4StraightFlush();
			System.out.printf("player should hold cards %s\n", Aces);
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
			String Aces = this.hand.searchSameSuit();
			System.out.printf("player should hold cards %s\n", Aces);
			return;
		}
		if(this.hand.checkAlmostStraight()) {
			String straight = this.hand.searchAlmostStraight();
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
		if(this.hand.checkStraight3FlushT1()) {
			String low = this.hand.searchStraight3Flush();
			System.out.printf("player should hold cards %s\n", low);
			return;
		}
		if(this.hand.check4InStrainght3High()) {
			String low = this.hand.searchAlmostStraight();
			System.out.printf("player should hold cards %s\n", low);
			return;
		}
		if(this.hand.checkQJSuit()) {
			String Aces = this.hand.search2Pair();
			System.out.printf("player should hold cards %s\n", Aces);
			return;
		}
		if(this.hand.check3Flush2High()) {
			String Aces = this.hand.searchSameSuit();
			System.out.printf("player should hold cards %s\n", Aces);
			return;
		}
		if(this.hand.check2SuitHigh()) {
			String Aces = this.hand.search2HighSuit();
			System.out.printf("player should hold cards %s\n", Aces);
			return;
		}
		if(this.hand.check4InStrainght2High()) {
			String low = this.hand.searchAlmostStraight();
			System.out.printf("player should hold cards %s\n", low);
			return;
		}
		if(this.hand.checkStraight3FlushT2()) {
			String low = this.hand.searchStraight3Flush();
			System.out.printf("player should hold cards %s\n", low);
			return;
		}
		if(this.hand.check4InStrainght1High()) {
			String low = this.hand.searchAlmostStraight();
			System.out.printf("player should hold cards %s\n", low);
			return;
		}
		if(this.hand.checkKQJ()) {
			String low = this.hand.searchAKQJ();
			System.out.printf("player should hold cards %s\n", low);
			return;
		}
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
		if(this.hand.check3Flush1High()) {
			String Aces = this.hand.search3Flush();
			System.out.printf("player should hold cards %s\n", Aces);
			return;
		}
		if(this.hand.checkQTSuit()) {
			String Aces = this.hand.search2Pair();
			System.out.printf("player should hold cards %s\n", Aces);
			return;
		}
		if(this.hand.checkStraight3FlushT3()) {
			String low = this.hand.searchStraight3Flush();
			System.out.printf("player should hold cards %s\n", low);
			return;
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
		if(this.hand.InsideStraightLow()) {
			String Aces = this.hand.searchAlmostStraight();
			System.out.printf("player should hold cards %s\n", Aces);
			return;
		}
		if(this.hand.check3Flush()) {
			String Aces = this.hand.searchSameSuit();
			System.out.printf("player should hold cards %s\n", Aces);
			return;
		}
		else {
			System.out.printf("player shouldn't hold cards\n");
			return;
		}
	}
}

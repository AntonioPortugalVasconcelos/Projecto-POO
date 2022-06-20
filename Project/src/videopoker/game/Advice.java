package videopoker.game;

import java.util.ArrayList;

public class Advice {
	private Hand hand;
	

	public Advice(Hand hand) {
		super();
		this.hand = hand;	
	}
	
	public String getAdv() {
		String Hold = "h";
		String Numbers;
		Numbers = getAdvice();
		this.hand.returnHand();
		System.out.printf("\n");
		if (Numbers == null) {
			return Hold;
		}
		Hold = Hold + " " + Numbers;
		return Hold;
	}
	
	public String getAdvice() {
		int i;	
		String DeckList;
		ArrayList<Card> cards = new ArrayList<Card>();
		DeckList = this.hand.toString();
		String[] cardIndicators = DeckList.split(" ");		
		for(String cardIndicator : cardIndicators) {
			String[] indicator = cardIndicator.split("");
            cards.add(new Card(new Rank(indicator[0].charAt(0)), new Suit(indicator[1].charAt(0))));
		}
		i = this.hand.handType();
		this.hand.handOriginal(cards);
		if(i == 12 || i == 11) {
			System.out.printf("player should hold cards 1 2 3 4 5\n");
			return "1 2 3 4 5";
		}
		if(i == 10 || i == 9 || i == 8) {
			String fourKind = this.hand.searchSameKind();
			System.out.printf("player should hold cards %s\n", fourKind);
			return fourKind;
		}
		
		if(this.hand.checkAlmostRoyalFlush()) {
			String Aces = this.hand.searchAlmostRoyalFlush();
			System.out.printf("player should hold cards %s\n", Aces);
			return Aces;
		}
		if(this.hand.check3Aces()) {	
			String Aces = this.hand.searchSameKind();
			System.out.printf("player should hold cards %s\n", Aces);
			return Aces;
		}
		if(i == 7 || i == 6 || i == 5) {
			System.out.printf("player should hold cards 1 2 3 4 5\n");
			return "1 2 3 4 5";
		}
		if(i == 4) {
			String threeKind = this.hand.searchSameKind();
			System.out.printf("player should hold cards %s\n", threeKind);
			return threeKind;
		}
		if(this.hand.checkAlmostStraightFlush()) {
			String Aces = this.hand.search4StraightFlush();
			System.out.printf("player should hold cards %s\n", Aces);
			return Aces;
		}

		if(i == 3) {
			String twoPairs = this.hand.search2Pair();
			System.out.printf("player should hold cards %s\n", twoPairs);
			return twoPairs;
		}
		if(i == 2) {
			String highPair = this.hand.searchSameKind();
			System.out.printf("player should hold cards %s\n", highPair);
			return highPair;
		}
		if(this.hand.checkAlmostFlush()) {
			String flush = this.hand.searchSameSuit();
			System.out.printf("player should hold cards %s\n", flush);
			return flush;
		}
		if(this.hand.check3RoyalFlush()) {
			String Aces = this.hand.searchSameSuit();
			System.out.printf("player should hold cards %s\n", Aces);
			return Aces;
		}
		if(this.hand.checkAlmostStraight()) {
			String straight = this.hand.searchAlmostStraight();
			System.out.printf("player should hold cards %s\n", straight);
			return straight;
		}
		if(this.hand.checkPair()) {
			String low = this.hand.searchSameKind();
			System.out.printf("player should hold cards %s\n", low);
			return low;
		}
		if(this.hand.checkAKQJ()) {
			String low = this.hand.searchAKQJ();
			System.out.printf("player should hold cards %s\n", low);
			return low;
		}
		if(this.hand.checkStraight3FlushT1()) {
			String low = this.hand.searchStraight3Flush();
			System.out.printf("player should hold cards %s\n", low);
			return low;
		}
		if(this.hand.check4InStrainght3High()) {
			String low = this.hand.searchAlmostStraight();
			System.out.printf("player should hold cards %s\n", low);
			return low;
		}
		if(this.hand.checkQJSuit()) {
			String Aces = this.hand.search2Pair();
			System.out.printf("player should hold cards %s\n", Aces);
			return Aces;
		}
		if(this.hand.check3Flush2High()) {
			String Aces = this.hand.searchSameSuit();
			System.out.printf("player should hold cards %s\n", Aces);
			return Aces;
		}
		if(this.hand.check2SuitHigh()) {
			String Aces = this.hand.search2HighSuit();
			System.out.printf("player should hold cards %s\n", Aces);
			return Aces;
		}
		if(this.hand.check4InStrainght2High()) {
			String low = this.hand.searchAlmostStraight();
			System.out.printf("player should hold cards %s\n", low);
			return low;
		}
		if(this.hand.checkStraight3FlushT2()) {
			String low = this.hand.searchStraight3Flush();
			System.out.printf("player should hold cards %s\n", low);
			return low;
		}
		if(this.hand.check4InStrainght1High()) {
			String low = this.hand.searchAlmostStraight();
			System.out.printf("player should hold cards %s\n", low);
			return low;
		}
		if(this.hand.checkKQJ()) {
			String low = this.hand.searchAKQJ();
			System.out.printf("player should hold cards %s\n", low);
			return low;
		}
		if(this.hand.checkJTSuit()) {
			String Aces = this.hand.search2Pair();
			System.out.printf("player should hold cards %s\n", Aces);
			return Aces;
		}
		if(this.hand.checkQJ()) {
			String Aces = this.hand.search2Pair();
			System.out.printf("player should hold cards %s\n", Aces);
			return Aces;
		}
		if(this.hand.check3Flush1High()) {
			String Aces = this.hand.search3Flush();
			System.out.printf("player should hold cards %s\n", Aces);
			return Aces;
		}
		if(this.hand.checkQTSuit()) {
			String Aces = this.hand.search2Pair();
			System.out.printf("player should hold cards %s\n", Aces);
			return Aces;
		}
		if(this.hand.checkStraight3FlushT3()) {
			String low = this.hand.searchStraight3Flush();
			System.out.printf("player should hold cards %s\n", low);
			return low;
		}
		if(this.hand.checkKjKq()) {
			String Aces = this.hand.search2Pair();
			System.out.printf("player should hold cards %s\n", Aces);
			return Aces;
		}
		if(this.hand.CheckAce()) {
			String Ace = this.hand.searchSameKind();
			System.out.printf("player should hold cards %s\n", Ace);
			return Ace;
		}
		if(this.hand.checkTK()) {
			String Aces = this.hand.search2Pair();
			System.out.printf("player should hold cards %s\n", Aces);
			return Aces;
		}
		if(this.hand.checkJoQoK()) {
			String Aces = this.hand.searchSameKind();
			System.out.printf("player should hold cards %s\n", Aces);
			return Aces;
		}
		if(this.hand.InsideStraightLow()) {
			String Aces = this.hand.searchAlmostStraight();
			System.out.printf("player should hold cards %s\n", Aces);
			return Aces;
		}
		if(this.hand.check3Flush()) {
			String Aces = this.hand.searchSameSuit();
			System.out.printf("player should hold cards %s\n", Aces);
			return Aces;
		}
		else {
			System.out.printf("player shouldn't hold cards\n");
			return null;
		}
	}
}

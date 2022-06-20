package videopoker.interfaces;

import videopoker.game.Deck;
import videopoker.game.Hand;

public interface GameMode {

	public int StartingCredit();

	public String[] NextCommand(String commands);

	public Deck createDeck(Deck deck);

	public void SetHand(Hand hand);


}

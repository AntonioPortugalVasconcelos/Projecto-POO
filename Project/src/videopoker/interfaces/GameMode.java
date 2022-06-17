package videopoker.interfaces;

import videopoker.game.Deck;

public interface GameMode {

	public int StartingCredit();

	public String[] NextCommand(String commands);

	public Deck createDeck(Deck deck);


}

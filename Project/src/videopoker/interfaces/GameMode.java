package videopoker.interfaces;

import videopoker.game.Deck;
import videopoker.game.Hand;
/**
 * 
 * @author  António Vasconcelos and António Falacho
 *
 */
public interface GameMode {
	/**
	 * Call function for Starting Credit 
	 */
	public int StartingCredit();
	/**
	 * Call function for Next Command 
	 */
	public String[] NextCommand(String commands);
	/**
	 * Call function for Create Deck 
	 */
	public Deck createDeck(Deck deck);
	/**
	 * Call function for Set Hand 
	 */
	public void SetHand(Hand hand);


}

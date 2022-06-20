package videopoker.game;
/**
 * 
 * @author António Vasconcelos and António Falacho
 *
 */
public class Credit {
	private int credit;
	/**
	 * Constructor of Credit class
	 * @param initialValue(the initial credit)
	 */
	public Credit(int initialValue) {
		this.credit = initialValue;
		
	}
	/**
	 * Receiving or losing credit depending on the result of the game
	 * @param change(the credit won or lost)
	 */
	public void Add(int change) {
		this.credit = credit + change;
		return;
				
	}
	/**
	 * Returns value of credit
	 * @return integer of total credit
	 */
	public int GetValue() {
		return credit;
				
	}

}

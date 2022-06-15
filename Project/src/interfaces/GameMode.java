package interfaces;

public interface GameMode {

	public int StartingCredit();

	public String getCommands();
	
	public String GetDeck();

	public String[] NextCommand(String commands);

}

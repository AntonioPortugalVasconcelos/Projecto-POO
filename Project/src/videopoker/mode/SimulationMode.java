package videopoker.mode;

import videopoker.interfaces.GameMode;

public class SimulationMode implements GameMode{
	
	private String[] args;

	@Override
	public int StartingCredit() {
		return 0;
	}

	@Override
	public String getCommands() {
		return null;
	}

	@Override
	public String GetDeck() {
		return null;
	}

	@Override
	public String[] NextCommand(String commands) {
		return null;
	}
	
	public SimulationMode(String[] arguments) {
		this.args = arguments;
		
	}

}

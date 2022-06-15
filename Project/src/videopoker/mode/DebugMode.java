package videopoker.mode;

import interfaces.GameMode;

public class DebugMode implements GameMode {
    private String[] args;
    
    public DebugMode(String[] arguments) {
    	this.args = arguments;
    	
    	
    }
    
    public int StartingCredit() {
    	return Integer.valueOf(args[1]);
    	
    }
    
    public String GetCommands() {
    	return Files.readString(Path.of("..\\\\..\\\\..\\\\..\\\\TESTS\\" + args[2]))
    			
    }
    
}

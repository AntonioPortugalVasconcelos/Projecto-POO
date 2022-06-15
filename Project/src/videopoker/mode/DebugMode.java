package videopoker.mode;

import java.nio.file.Files;
import java.nio.file.Path;

import interfaces.GameMode;

public abstract class DebugMode implements GameMode {
    private String[] args;
    
    public DebugMode(String[] arguments) {
    	this.args = arguments;
    	
    	
    }
    
    public int StartingCredit() {
    	return Integer.valueOf(args[1]);
    	
    }
    
    public String GetCommands() {
    	return Files.readString(Path.of("..\\\\..\\\\..\\\\..\\\\TESTS\\" + args[2]));
    			
    }
    
    public String GetDeck() {
    	return Files.readString(Path.of("..\\\\..\\\\..\\\\..\\\\TESTS\\" + args[3]));
    			
    }
    
}

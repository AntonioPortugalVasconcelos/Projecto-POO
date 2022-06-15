package videopoker.mode;

import java.nio.file.Files;
import java.nio.file.Path;

import videopoker.interfaces.GameMode;

public abstract class DebugMode implements GameMode {
    private String[] args;
    
    public DebugMode(String[] arguments) {
    	this.args = arguments;
    	
    	
    }
    
    public int StartingCredit() {
    	return Integer.valueOf(args[1]);
    	
    }
    
    public String GetCommands() {
    	return Files.readString(Path.of("..\\..\\..\\..\\TESTS\\" + args[2]));
    			
    }
    
    public String[] NextCommand(String commands) {
    	String[] splitCommands = commands.split(" ");
    	String command = null;
    	String commandString = null;
    	Boolean commandDone = false;
		if (splitCommands[0] == "h" || splitCommands[0] == "b") {
			command = splitCommands[0];
	    	for (String letter : splitCommands) {
	    		if (isNumeric(letter) && !commandDone) {
	    			command = command + " " + letter;
	    			
	    		}else {
	    			commandDone = true;
	    			commandString = commandString + " " + letter;
	    		}
	    		
	    	}
	    	String[] returnStrings = new String[]{command, commandString};
	    	return returnStrings;
		}
    	return null;
    }
    
    public String GetDeck() throws IOException {
    	return Files.readString(Path.of("..\\..\\..\\..\\TESTS\\" + args[3]));
    			
    }
    
    private static boolean isNumeric(String str) { 
	  try {  
	    Double.parseDouble(str);  
	    return true;
	  } catch(NumberFormatException e){  
	    return false;  
	  }  
	}
}

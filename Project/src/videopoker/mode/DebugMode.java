package videopoker.mode;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;

import videopoker.interfaces.GameMode;

public class DebugMode implements GameMode {
    private String[] args;
    
    public DebugMode(String[] arguments) {
    	this.args = arguments;
    	
    	
    }
    
    @Override
    public int StartingCredit() {
    	return Integer.valueOf(args[1]);
    	
    }
    
    @Override
    public String getCommands() {
    	try {
			return Files.readString(Path.of("..\\TESTS\\" + this.args[2] + ".txt"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
    			
    }
    
    @Override
    public String[] NextCommand(String commands) {
    	String[] splitCommands = commands.split(" ");
    	String command = null;
    	String commandString = null;
    	Boolean commandDone = false;
		command = splitCommands[0];
		String[] shortCommand = Arrays.copyOfRange(splitCommands, 1, splitCommands.length);
		if (command.equals("h") || command.equals("b")) {
	    	for (String letter : shortCommand) {
	    		if (isNumeric(letter) && !commandDone) {
	    			command = command + " " + letter;
	    			
	    		}else if (!commandDone){
	    			commandDone = true;
	    			commandString = letter;
	    		}else {
	    			commandString = commandString + " " + letter;
	    			
	    		}
	    		
	    	}
	    	String[] returnStrings = new String[]{command, commandString};
	    	return returnStrings;
	    	
		}else{
			for (String letter : shortCommand) {
				if (!commandDone){
	    			commandDone = true;
	    			commandString = letter;
				}else {
					commandString = commandString + " " + letter;
					
				}	
				
	    	}
	    	String[] returnStrings = new String[]{command, commandString};
	    	return returnStrings;
			
		}
		
    }
    
    @Override
    public String GetDeck() {
    	try {
			return Files.readString(Path.of("..\\TESTS\\" + this.args[3] + ".txt"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
    			
    }
    
    private boolean isNumeric(String str) { 
	  try {  
	    Double.parseDouble(str);  
	    return true;
	  } catch(NumberFormatException e){  
	    return false;  
	  }  
	}

}

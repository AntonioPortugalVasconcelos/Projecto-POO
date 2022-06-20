package videopoker.mode;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;

import videopoker.game.Deck;
import videopoker.game.Hand;
import videopoker.interfaces.GameMode;
/**
 * 
 * @author António Vasconcelos and António Falacho
 *
 */
public class DebugMode implements GameMode {
    private String[] args;
    
    /**
     * constructor for debug mode
     * @param arguments input arguments
     */
    public DebugMode(String[] arguments) {
    	this.args = arguments;
    	
    	
    }
    /**
     * Gets the initial credit from commands
     * @return integer value of initial credit
     */
    @Override
    public int StartingCredit() {
    	return Integer.valueOf(args[1]);
    	
    }
    /**
     * reads the cmd files (gets the commands of the game)
     * @return string of all commands for this mode
     */
    public String getCommands() {
    	try {
			return Files.readString(Path.of("..\\TESTS\\" + this.args[2] + ".txt"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
    			
    }
    /**
     * Gets the next command of the game
     */
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
    /**
     * Gets the cards for the deck from the card files
     * @return string of deck from file
     */
    public String GetDeck() {
    	try {
			return Files.readString(Path.of("..\\TESTS\\" + this.args[3] + ".txt"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
    			
    }
    /**
     * Verifies if a string is or isn´t a number
     * @param str
     * @return
     */
    private boolean isNumeric(String str) { 
	  try {  
	    Double.parseDouble(str);  
	    return true;
	  } catch(NumberFormatException e){  
	    return false;  
	  }  
	}
    /**
     * Creates the deck from the cards the function getDeck pulled from txt files
     */
    @Override
	public Deck createDeck(Deck deck) {
		return deck;
		
    }
	/**
	 * Legacy code
	 */
	public void SetHand(Hand hand) {
		
	}

}

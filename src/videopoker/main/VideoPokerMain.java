package videopoker.main;

import com.Casino.BlackJack.classes.GameLogic.Game;
import com.Casino.BlackJack.classes.GameModes.DebugMode;
import com.Casino.BlackJack.classes.GameModes.InteractiveMode;
import com.Casino.BlackJack.classes.GameModes.SimulationMode;
import com.Casino.BlackJack.main.String;

public class VideoPokerMain {

	public static void main(String[] args) {

		Game game = null;
		
		if (args.length == 0) {
            System.out.println("Error: No gamemode specified");
            return;
        }
		
		switch (args[0]) {
        case "-d":
            game = new Game(new DebugMode(args));
            break;
        case "-s":
            game = new Game(new SimulationMode(args));
            break;
        default:
            System.out.println("");
            System.exit(0);
    
		}
	}
}

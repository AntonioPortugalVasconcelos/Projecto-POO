package videopoker.main;

import videopoker.game.Game;
import videopoker.mode.*;


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
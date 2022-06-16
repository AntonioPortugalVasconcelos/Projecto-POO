package videopoker.main;

import videopoker.game.Game;
import videopoker.mode.DebugMode;
import videopoker.mode.SimulationMode;


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
		
		game.initializeGame();
		while(game.GetCommandLenght() > 0 && game.Getnumberplays() == 0) {
			if (game.Getstate() == 0) {
				game.TurnStart();
				
			}else {
				game.TurnEnd();
				
			}
			
		}
		
	}
	
}

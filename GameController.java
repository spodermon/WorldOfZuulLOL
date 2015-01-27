import java.util.*;
import java.util.Arrays;
;/**
 *  This class is the main class of the "World of Zuul" application. 
 *  "World of Zuul" is a very simple, text based adventure game.  Users 
 *  can walk around some scenery. That's all. It should really be extended 
 *  to make it more interesting!
 * 
 *  To play this game, create an instance of this class and call the "play"
 *  method.
 * 
 *  This main class creates and initialises all the others: it creates all
 *  rooms, creates the parser and starts the game.  It also evaluates and
 *  executes the commands that the parser returns.
 * 
 * @author  Michael Kolling and David J. Barnes
 * @version 2008.03.30
 */

public class GameController {
    private Parser parser;
    private RoomFactory roomFactory;
    private CommandProcessor commandProcessor;
    private Player player;

    /**
     * Create the game and initialise its internal map.
     */
    public GameController() {
        parser = new Parser();
        roomFactory = new RoomFactory();
        commandProcessor = new CommandProcessor();
        player = new Player();
    }

    public static void main(String[] args) {
        GameController gameController = new GameController();
        gameController.play();
    }

    /**
     *  Main play routine.  Loops until end of play.
     */
    public void play() {   
        Game game = new Game(roomFactory.createRoomSetupAndGetStartRoom());
        printWelcome(game.getCurrentRoom());
        // Enter the main command loop.  Here we repeatedly read commands and
        // execute them until the game is over.
        boolean finished = false;
        while (!finished) {
            Command command = parser.getCommand();
            finished = commandProcessor.processCommand(command, game, player);
        }
        System.out.println("Thank you for playing.  Good bye.");
    }

    /**
     * Print out the opening message for the player.
     */
    private void printWelcome(Room currentRoom) {
        System.out.println("_/_/_/_/ _/    _/ _/_/_/_/  _/    _/   _/_/   _/_/_/  _/_/_/  _/ _/_/_/_/");
        System.out.println("   _/    _/    _/ _/        _/    _/ _/    _/ _/   _/ _/   _/ _/    _/   ");
        System.out.println("   _/    _/_/_/_/ _/_/_/    _/_/_/_/ _/    _/ _/  _/  _/  _/  _/    _/   ");
        System.out.println("   _/    _/    _/ _/        _/    _/ _/    _/ _/_/_/  _/_/_/  _/    _/   ");
        System.out.println("   _/    _/    _/ _/        _/    _/ _/    _/ _/   _/ _/   _/ _/    _/   ");
        System.out.println("   _/    _/    _/ _/_/_/_/  _/    _/   _/_/   _/_/_/  _/_/_/  _/    _/   ");
        System.out.println();
        System.out.println("                                            _______________________       ");
        System.out.println("  _______________________-------------------                       `\\    ");
        System.out.println(" /:--__                                                              |    ");
        System.out.println("||< > |                                   ___________________________/    ");
        System.out.println("| \\__/_________________-------------------                         |     ");
        System.out.println("|                                                                  |      ");
        System.out.println(" |   —«•´¨*•.¸¸.* ..::**: An expected journey :**::… *.¸¸.•*¨`•»—   |     ");
        System.out.println(" |                                                                  |     ");
        System.out.println(" |          'You wake up from a long night and you can't            |     ");
        System.out.println("  |            remember how you got home.                            |    ");
        System.out.println("  |          You get out of bed and search for your first            |    ");
        System.out.println("  |            and second breakfast.                                 |    ");
        System.out.println("  |          You stumble through your home and walk through           |   ");
        System.out.println("   |           the rooms to get to the kitchen.'                      |   ");
        System.out.println("  |                                              ____________________|_   ");
        System.out.println("  |  ___________________-------------------------                      `\\");
        System.out.println("  |/`--_                                                                 |");
        System.out.println("  ||[ ]||                                            ___________________/ ");
        System.out.println("   \\===/___________________--------------------------                    ");
        System.out.println();
        System.out.println("Your commands are:\n   " + CommandWords.getValidCommandWords()+ "\n");
        System.out.println("You are " + currentRoom.getRoomName() + "\n");
        System.out.print(currentRoom.getAllExitsWithDirectionsAsString() + "\n");
    }
}


import static org.hamcrest.Matcher.*;
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * This is a Game System Tests - it tests the
 * whole game and the endpoints between user input
 * and output to the console.
 * 
 * The original 
 *
 * @author  Barbara Kleinen
 */
public class GameSystemTest
{
    private Game game;
    private Parser parser;
    private CommandProcessor commandProcessor;
    private Room currentRoom;
    private RoomFactory roomFactory;
    /*
    public GameSystemTest()
    {

    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp()
    {
        parser = new Parser();
        commandProcessor = new CommandProcessor();
        roomFactory = new RoomFactory();
        currentRoom = roomFactory.createRoomSetupAndGetStartRoom();
        game = new Game(currentRoom);
    }

    @Test
    public void backWithSecondWord(){
        //given
        Command command = parser.getCommand("back home");
        //when
      //  String output = commandProcessor.processCommand(command, game);
        //then
      //  assertEquals(output, "I don't know what you mean...\n");

    }

    /* @Test
    public void testQuit()
    {
    //given
    Command command = parser.getCommand("quit");
    //when
    String output = game.processCommand(command);
    //then
    assertEquals(
    "null is the output that signals that the main loop should stop",
    null,output);
    }

    @Test
    public void testHelp()
    {
    //given
    Command command = parser.getCommand("help");
    //when
    String output = game.processCommand(command);
    //then
    assertTrue("should print help message containing command words", output.contains("command words"));
    }

    @Test
    public void testGoSouth()
    {
    //given
    Command command = parser.getCommand("go south");
    //when
    String output = game.processCommand(command);
    //then
    assertTrue("should be in computing lab",
    output.contains("computing lab"));
    }

    @Test
    public void testGoNorth()
    {
    //given
    Command command = parser.getCommand("go north");
    //when
    String output = game.processCommand(command);
    //then
    assertEquals(true, output.contains("no door"));
    }
    /**
     * version 1: manual test case
     *//*
    @Test
    public void testGoWithoutDirection()
    {
    //given
    Command command = parser.getCommand("go");
    //when
    String output = game.processCommand(command);
    //then
    assertEquals(true, output.contains("Go where"));
    }

    /**
     * version 2: recorded test case
     *//*
    @Test
    public void goWODirectionShouldShowError()
    {
    Command command1 = parser.getCommand("go");
    assertEquals("Go where?", game.processCommand(command1));
    }

    @Test
    public void testCoffee()
    {
    //given
    Command command = parser.getCommand("go south");
    game.processCommand(command);
    command = parser.getCommand("go east");
    //when
    String output = game.processCommand(command);
    //then
    assertEquals(true, output.contains("coffee machine"));
    }

    @Test
    public void completeWalkthrough()
    {
    goAndSee("east",  "lecture theatre");
    goAndSee("west",  "main entrance");
    goAndSee("west",  "campus pub");
    goAndSee("east",  "main entrance");
    goAndSee("south", "computing lab");
    goAndSee("east",  "admin office");
    goAndSee("west",  "computing lab");
    goAndSee("north", "main entrance"); 
    }
    private void goAndSee(String direction, String whatShouldBeContained){
    //given
    Command command = parser.getCommand("go "+direction);
    //when
    String result = game.processCommand(command);
    //then
    if (!result.contains(whatShouldBeContained))
    fail(result +" does not contain "+whatShouldBeContained);
    }
    @Test 
    public void showExits(){
    game.processCommand(parser.getCommand("go south"));
    String result = game.processCommand(parser.getCommand("go north"));
    assertTrue(result.contains("east"));
    assertTrue(result.contains("south"));
    assertTrue(result.contains("west"));

    }*/
}



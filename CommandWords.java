import java.util.Arrays;
/**
 * This class is part of the "World of Zuul" application. 
 * "World of Zuul" is a very simple, text based adventure game.  
 * 
 * This class holds an enumeration of all command words known to the game.
 * It is used to recognise commands as they are typed in.
 *
 * @author  Michael Kolling and David J. Barnes
 * @version 2008.03.30
 */

public enum CommandWords{ 
    GO("go"), 

    QUIT("quit"), 

    HELP("help"), 

    USE("use"),
    
    LOOK("look"),
    
    EAT("eat"),

    UNKNOWN("?"),
    
    DANCE("dance"),
    
    BACK("back"),
    
    ITEMS("items");
    
    private String word;

    /**
     * Constructor - initialise the command words.
     */

    private CommandWords(String word){
        this.word = word;
    }

    public static String getValidCommandWords(){
        return Arrays.asList(CommandWords.values()).toString();
    }

    public static CommandWords getForString(String aString){
        for (CommandWords cw : CommandWords.values()){
            if(cw.toString().equals(aString))
                return cw;
        }
        return UNKNOWN;
    }
    
    @Override
    public String toString(){
        return word;
    }
}
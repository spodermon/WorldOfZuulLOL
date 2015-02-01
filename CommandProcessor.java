
/**
 * Write a description of class CommandProcessor here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CommandProcessor {

    /**
     * Given a command, process (that is: execute) the command.
     * @param command The command to be processed.
     * @return true If the command ends the game, false otherwise.
     */
    public boolean processCommand(Command command, Game game, Player player) {
        boolean wantToQuit = false;
        String result = null;
        switch(command.getCommandWord()) {
            case GO:
            result = goRoom(command, game);
            break;
            case QUIT:
            result = quit(command);
            if(result == null) {
                wantToQuit = true;
                result = "";
            }
            break;
            case HELP:
            result = printHelp();
            break;
            case LOOK:
            result = look(game.getCurrentRoom());
            break;
            case EAT:
            result = eat();
            break;
            case DANCE:
            result = dance();
            break;
            case BACK:
            result = goBack(game);
            break;
            case TAKE:
            result = takeItem(game.getCurrentRoom(), command, player);
            break;
            case DROP:
            result = dropItem(command, player, game.getCurrentRoom());
            break;
            case DROPALL:
            result = dropAllItems(player, game.getCurrentRoom());
            break;
            case ITEMS:
            result = listAllItemsOfPlayer(player);
            break;
            case USE:
            case UNKNOWN:
            default:
            result = "I don't know what you mean...\n";
            break;
        }
        System.out.println(result);
        return wantToQuit;
    }

    // implementations of user commands:
    /**
     * Print out some help information.
     * Here we print some stupid, cryptic message and a list of the 
     * command words.
     */
    private String printHelp() {   
        String result = "";
        result += "You are lost. You are alone. You wander\n";
        result += "around at the university.\n";
        result += "\n";
        result += "Your command words are:\n";
        result += "   go, quit, help, use, look, eat, ?, dance \n";
        return result;
    }

    /** 
     * Try to go to one direction. If there is an exit, enter
     * the new room, otherwise print an error message.
     */
    private String goRoom(Command command, Game game) {
        if(!command.hasSecondWord()) {
            // if there is no second word, we don't know where to go...
            return "Go where?";
        }
        String direction = command.getSecondWord(); 
        return game.changeRoom(direction);
    }

    /** 
     * "Quit" was entered. Check the rest of the command to see
     * whether we really quit the game.
     * @return null, if this command quits the game, something else to output otherwise.
     */
    private String quit(Command command) {
        if(command.hasSecondWord()) {
            return "Quit what?";
        }
        return null;  // signal that we want to quit
    }

    private String look(Room currentRoom) {
        String result = "You are:\n    " + currentRoom.getRoomName() + ": ";
        result += currentRoom.getInformation() + "\n";
        result += currentRoom.getAllExitsWithDirectionsAsString();
        result += currentRoom.getAllItemsInRoom();
        return result;
    }

    private String eat() {
        return "You have eaten now and are not hungry any more";
    }

    private String dance() {
        return "You start to dance furiously";
    }

    private String goBack(Game game) {
        return game.goBack();
    }

    private String takeItem(Room currentRoom, Command command, Player player) {
        Item item = currentRoom.takeItem(command.getSecondWord());
        if (item == null)
            return "No such Item in this Room.";
        else
            player.addItemToInventory(item);
            return "";    
    }

    private String dropItem(Command command, Player player, Room currentRoom) {
        Item itemToDrop = player.dropItemFromInventory(command.getSecondWord());
        if (itemToDrop != null) {
            currentRoom.addItemToRoom(itemToDrop);
            return "Item removed form inventory.";
        }
        else
            return "could not remove item from inventory.";
    }
    
    private String dropAllItems(Player player, Room currentRoom) {
        player.dropAllItemsFromInvetroy(currentRoom);
        return "you droped all the items form your invetory";
    }
    
    private String listAllItemsOfPlayer(Player player) {
        return player.getAllItems();
    }
}

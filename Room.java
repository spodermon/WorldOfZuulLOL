import java.util.*;
/**
 * Class Room - a room in an adventure game.
 *
 * This class is part of the "World of Zuul" application. 
 * "World of Zuul" is a very simple, text based adventure game.  
 *
 * A "Room" represents one location in the scenery of the game.  It is 
 * connected to other rooms via exits.  The exits are labelled north, 
 * east, south, west.  For each direction, the room stores a reference
 * to the neighboring room, or null if there is no exit in that direction.
 * 
 * @author  Michael Kolling and David J. Barnes
 * @version 2008.03.30
 */

public class Room {
    private String roomName;
    private String information;
    private HashMap<String, Room> exits;
    private ArrayList<Item> itemList;

    /**
     * Create a room described "description". Initially, it has
     * no exits. "description" is something like "a kitchen" or
     * "an open court yard".
     * @param description The room's description.
     */
    public Room(String roomName, String information) {
        exits = new HashMap<String, Room>();
        itemList = new ArrayList<Item>();
        this.roomName = roomName;
        this.information = information;
    }

    public Room(String roomName, String information, Item item) {
        exits = new HashMap<String, Room>();
        itemList = new ArrayList<Item>();
        this.roomName = roomName;
        this.information = information;
        this.itemList.add(item);
    }

    public String getInformation() {
        return information;
    }

    /**
     * Define the exits of this room.  Every direction either leads
     * to another room or is null (no exit there).
     * @param direction: direction to walk to
     * @param room: room coming into
     */
    public void setExit(String direction, Room room) {
        exits.put(direction, room);
    }

    /**
     * @return The description of the room.
     */
    public String getRoomName() {
        return roomName;
    }

    /**
     * @direction: direction to go to.
     * @return room in entered direction.
     */
    public Room getExit(String direction) {
        return exits.get(direction);
    }

    /**
     * @return All exits of the room.
     */
    public String getAllExitsAsString() { 
        return exits.keySet().toString();
    }

    public void addItemToRoom(Item item) {
        itemList.add(item);
    }

    public String getAllExitsWithDirectionsAsString() {
        String result = "Exits:";
        for(String direction : exits.keySet()) {
            Room room = exits.get(direction);
            result += "\n   choose [" + direction + "] to go " + room.getRoomName(); 
        }
        return result + "\n";
    }

    public String getAllItemsInRoom() {
        String result = "Items:\n";
        boolean itemsInList = false;
        for(Item actualItem : itemList) {
            result  += "Item: " + actualItem.getName() + "\n";
            result  += "   " + "Description: " + actualItem.getDescription() + "\n";
            result  += "   " + "Weight: " + actualItem.getWeight() + "\n";
            itemsInList = true;
        }

        if(!itemsInList) 
            result += "No Items\n";

        return result;
    }

    public Item takeItem(String name) {
        Item returnItem = null;
        for(Item actualItem : itemList) {
            if(actualItem.getName().equals(name)) {
                returnItem = actualItem;
            }
        }
        
        if(returnItem != null)
            itemList.remove(returnItem);
            
        return returnItem;
    }
}

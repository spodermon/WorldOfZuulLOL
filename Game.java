    import java.util.*;
/**
 * Write a description of class Game here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Game {
    private Room currentRoom;
    private Stack<Room> roomsVisited = new Stack<Room>();

    public Game(Room initialRoom) {
        currentRoom = initialRoom;
        roomsVisited.add(currentRoom);
    }

    public void setCurrentRoom(Room currentRoom) {
        this.currentRoom = currentRoom;
    }

    public Room getCurrentRoom() {
        return this.currentRoom;
    }
    
    public Stack<Room> getRoomsVisitedStack() {
        return this.roomsVisited;
    }

    public String goBack() {
        try {
            roomsVisited.pop();
            currentRoom = roomsVisited.lastElement();
        }
        catch(Exception e) {
            return "Your are back where you've started.\n   " + currentRoom.getRoomName() + "\n";
        }
        
        return "You went back " + currentRoom.getRoomName() + "\n";
    }
    
    public String changeRoom(String direction) {
        Room nextRoom =  currentRoom.getExit(direction);

        // Try to leave current room
        String result = null;
        if (nextRoom == null) {
            result = "There is no Exit!";
        }
        else {
            setCurrentRoom(nextRoom);
            roomsVisited.add(nextRoom);
            result = "You are " + currentRoom.getRoomName() + "\n\n";
            result += currentRoom.getAllExitsWithDirectionsAsString();
        }
        return result;
    }
}

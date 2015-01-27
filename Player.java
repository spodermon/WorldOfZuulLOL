import java.util.ArrayList;
/**
 * Write a description of class Player here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Player {
    private ArrayList<Item> itemList;
    int maxWeight;
    public Player() {
        itemList = new ArrayList<Item>();
        maxWeight = 10;
    }

    public String getAllItems() {
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
}

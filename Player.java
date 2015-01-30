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

    /**
     * Implement an "items" command that prints out all items 
     * currently carried with their weights, and the total weight.
     */
    public String getAllItems() {
        String result = "Your Inventory:\n";
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
    
    public void addItemToInventory(Item item) {
        if (item.getWeight() <= inventoryCapacity())
            itemList.add(item);
        else
            System.out.println("you cant carray anymore!");
    }
    
    public int inventoryCapacity() {
        int totalWeight = 0;
        for(Item actualItem : itemList) {
            totalWeight += actualItem.getWeight();
        }
        return totalWeight;
    }
}

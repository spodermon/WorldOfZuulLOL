/**
 * Write a description of class Food here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Food extends Item {
    public int durability;
    
    public Food(String name, String description, int weight, int durability) {
        super(name, description, weight);
        this.durability = durability;
    }
}

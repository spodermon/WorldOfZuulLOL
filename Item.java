import java.util.*;
/**
 * Write a description of class Item here.
 * 
 * @author (the allmighty folz) 
 * @version (a version number or a date)
 */
public class Item {
    private int weight;
    private String name;
    private String content;
    private String description;
    
    public Item(String name, String description, int weight) {
        this.weight = weight;
        this.name = name;
        this.description = description;
    }

    public Item(String name, String description, int weight,  String content) {
        this.weight = weight;
        this.name = name;
        this.content = content;
        this.description = description;
    }

    public String getName() {
        return name;
    } 

    public String getDescription() {
        return this.description;
    }
    
    public String getContent() {
        return this.content;
    }
    
    public int getWeight() {
        return this.weight;
    }
}

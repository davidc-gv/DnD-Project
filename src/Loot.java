import java.util.*;


/**
 * A class that generates loot randomly.
 */
public class Loot {
    String items;
    String itemModifier;
    private Random rand = new Random();

    /**
     * A method for the class Loot
     * Determines the type of item generated.
     */
    public String itemType() {
        //random number 1-5
        int itemType = rand.nextInt(5)+1;


        if(itemType == 1) {
            items = "Armor";
        }
        else if(itemType == 2) {
            items = "Sword";
        }
        else if(itemType == 3) {
            items = "Bow";
        }
        else if(itemType == 4) {
            items = "Spoon";
        }
        else if(itemType == 5) {
            items = "Dagger";
        }
        return items;
    }
    /**
     * A method for the class Loot
     * Determines modifier the item has.
     */
    public String itemModifier() {
        //random number 1-100
        int itemRange = rand.nextInt(100)+1;

        //Make item modifier +something based on the random number itemRange
        if(itemRange >= 1 && itemRange <= 60) {
            itemModifier = "+1";
        }
        else if(itemRange >= 61 && itemRange <= 90) {
            itemModifier = "+2";
        }
        else if(itemRange >= 91 && itemRange <= 100) {
            itemModifier = "+3";
        }

        return itemModifier;
    }
}

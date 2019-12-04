import javax.swing.*;
import java.util.Random;


/**
 * A class that generates loot randomly.
 */
public class Loot {
  String items;
  String itemModifier;
  int cr;
  int gold;
  private Random rand = new Random();

  /**
   * A method for the class Loot
   * Determines the type of item generated.
   */


  public String itemType() {
    //random number 1-5
    int itemType = rand.nextInt(5) + 1;


    if (itemType == 1) {
      items = "Armor";
    } else if (itemType == 2) {
      items = "Sword";
    } else if (itemType == 3) {
      items = "Bow";
    } else if (itemType == 4) {
      items = "Spoon";
    } else if (itemType == 5) {
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
    int itemRange = rand.nextInt(100) + 1;

    //Make item modifier +something based on the random number itemRange
    if (itemRange >= 1 && itemRange <= 70) {
      itemModifier = "+1";
    } else if (itemRange >= 71 && itemRange <= 95) {
      itemModifier = "+2";
    } else if (itemRange >= 96 && itemRange <= 100) {
      itemModifier = "+3";
    }

    return itemModifier;
  }

  public int goldAmount(int cr){
    int cr2 = cr;

    if (cr2 >= 1 && cr2 <= 4) {
      gold = rand.nextInt(20) + 1;
    } else if (cr2 >= 5 && cr2 <= 10) {
      gold = rand.nextInt(240) + 20;
    } else if (cr2 >= 11 && cr2 <= 16) {
      gold = rand.nextInt(1200) + 100;
    } else if (cr2 >=17 && cr2 <= 100){
      gold = rand.nextInt(6000) + 800;
    }
    return gold;
  }
}

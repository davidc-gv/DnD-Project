import java.util.*;
public class Player {

    //declare instance variables
    int health;
    int maxHealth;
    int armorClass;
    int initiative;
    int id;
    String name;

    /**
     * Constructor method for Player class.
     * Parameter id is used in the encounter class to give each player and monster
     * a unique identifying integer as a key to the initiative table.
     */
    public Player(int id) {
        Random rnd = new Random();
        int ranPlayer = rnd.nextInt(4);
        switch (ranPlayer) {
            case 0:
                name = "Sam";
                maxHealth = rnd.nextInt(5+13);
                health = maxHealth;
                armorClass = rnd.nextInt(5+13);
                initiative = rnd.nextInt(20 + 1) + 2;
                this.id = id;
                break;
            case 1:
                name = "John";
                maxHealth = rnd.nextInt(5+13);
                health = maxHealth;
                armorClass = rnd.nextInt(5+13);
                initiative = rnd.nextInt(20 + 1) + 2;
                this.id = id;
                break;
            case 2:
                name = "Lisa";
                maxHealth = rnd.nextInt(5+13);
                health = maxHealth;
                armorClass = rnd.nextInt(5+13);
                initiative = rnd.nextInt(20 + 1) + 2;
                this.id = id;
                break;
            case 3:
                name = "Jesus";
                maxHealth = rnd.nextInt(5+13);
                health = maxHealth;
                armorClass = rnd.nextInt(5+13);
                initiative = rnd.nextInt(20 + 1) + 2;
                this.id = id;
                break;
        }
    }

    /**
     * accessor method for the player's current health
     * @return the current health of the player.
     */
    public int getHealth() {
        return health;
    }

    /**
     * accessor method for the player's armor class
     * @return the armor class of the player.
     */
    public int getArmorClass() {
        return armorClass;
    }

    /**
     * accessor method for the player's initiative
     * @return the initiative of the player.
     */
    public int getInitiative() {
        return initiative;
    }

    /**
     * accessor method for the player's name
     * @return the name of the player.
     */
    public String getName() {
        return name;
    }

    /**
     * mutator method for the player's current health.
     */
    public void setHealth(int health) {
        this.health = health;
    }
}

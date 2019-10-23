import java.util.*;
public class Player {

    //declare instance variables
    int health;
    int maxHealth;
    int armorClass;
    int initiative;
    int id;
    String name;

    public Player(id) {
        Random rnd = new Random();
        int ranPlayer = rnd.nextInt(4);
        switch (ranPlayer) {
            case 0:
                name = "Sam";
                maxHealth = rnd.nextInt(5+13);
                health = maxHealth;
                armorClass = rnd.nextInt(5+13);;
                initiative = rnd.nextInt(20 + 1) + 2;
                this.id = id;
                break;
            case 1:
                name = "John";
                maxHealth = rnd.nextInt(5+13);;
                health = maxHealth;
                armorClass = rnd.nextInt(5+13);;
                initiative = rnd.nextInt(20 + 1) + 2;
                this.id = id;
                break;
            case 2:
                name = "Lisa";
                maxHealth = rnd.nextInt(5+13);;
                health = maxHealth;
                armorClass = rnd.nextInt(5+13);;
                initiative = rnd.nextInt(20 + 1) + 2;
                this.id = id;
                break;
            case 3:
                name = "Jesus";
                maxHealth = rnd.nextInt(5+13);;
                health = maxHealth;
                armorClass = rnd.nextInt(5+13);;
                initiative = rnd.nextInt(20 + 1) + 2;
                this.id = id;
                break;
        }
    }

    public int getHealth() {
        return health;
    }

    public int getArmorClass() {
        return armorClass;
    }

    public int getInitiative() {
        return initiative;
    }

    public String getName() {
        return name;
    }

    public void setHealth(int health) {
        this.health = health;
    }
}

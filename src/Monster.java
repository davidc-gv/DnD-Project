import java.util.*;
public class Monster {

    //declare instance variables
    double challengeRating;
    int health;
    int maxHealth;
    int armorClass;
    int initiative;
    int xp;
    int id;
    String name;

    public Monster(int id) {
        Random rnd = new Randon();
        int monType = rnd.nextInt(4);
        switch (monType) {
            case 0:
                name = "Kobold";
                maxHealth = 5;
                health = maxHealth;
                armorClass = 12;
                challengeRating = 1 / 8;
                initiative = rnd.nextInt(20 + 1) + 2;
                xp = 25;
                this.id = id;
                break;
            case 1:
                name = "Bandit";
                maxHealth = 11;
                health = maxHealth;
                armorClass = 12;
                challengeRating = 1 / 8;
                initiative = rnd.nextInt(20 + 1) + 2;
                xp = 25;
                this.id = id;
                break;
            case 2:
                name = "Flying Snake";
                maxHealth = 5;
                health = maxHealth;
                armorClass = 14;
                challengeRating = 1 / 8;
                initiative = rnd.nextInt(20 + 1) + 4;
                xp = 25;
                this.id = id;
                break;
            case 3:
                name = "Dolphin";
                maxHealth = 11;
                health = maxHealth;
                armorClass = 12;
                challengeRating = 1 / 8;
                initiative = rnd.nextInt(20 + 1) + 1;
                xp = 25;
                this.id = id;
                break;
        }
    }

    public double getChallengeRating() {
        return challengeRating;
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

    public int getXp() {
        return xp;
    }

    public String getName() {
        return name;
    }

    public void setHealth(int health) {
        this.health = health;
    }
}

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

    /**
     * Constructor method for Monster class.
     * Parameter id is used in the encounter class to give each player and monster
     * a unique identifying integer as a key to the initiative table.
     */
    public Monster(int id) {
        Random rnd = new Random();
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
    
    /**
     * accessor method for the monster's challenge rating
     * @return the challenge rating of the monster.
     */
    public double getChallengeRating() {
        return challengeRating;
    }

    /**
     * accessor method for the monster's health
     * @return the health of the monster.
     */
    public int getHealth() {
        return health;
    }

    /**
     * accessor method for the monster's armor class
     * @return the armor class of the monster.
     */
    public int getArmorClass() {
        return armorClass;
    }

    /**
     * accessor method for the monster's initiative
     * @return the intiative of the monster.
     */
    public int getInitiative() {
        return initiative;
    }

    /**
     * accessor method for the monster's xp
     * @return the xp of the monster.
     */
    public int getXp() {
        return xp;
    }

    /**
     * accessor method for the monster's name
     * @return the name of the monster.
     */
    public String getName() {
        return name;
    }

    /**
     * mutator method for the monster's health.
     */
    public void setHealth(int health) {
        this.health = health;
    }
}

import java.util.Random;

public class Character {

  //declare instance variables
  int health;
  int maxHealth;
  int armorClass;
  int initiative;
  int id;
  String name;

  /**
   * Constructor method for Character class.
   * Parameter id is used in the encounter class to give each Character and monster
   * a unique identifying integer as a key to the initiative table.
   */
  public Character(int id) {
    Random rnd = new Random();
    int ranCharacter = rnd.nextInt(4);
    switch (ranCharacter) {
      default:
        name = "Sam";
        maxHealth = rnd.nextInt(5 + 13);
        health = maxHealth;
        armorClass = rnd.nextInt(5 + 13);
        initiative = rnd.nextInt(20 + 1) + 2;
        this.id = id;
        break;
      case 0:
        name = "Sam";
        maxHealth = rnd.nextInt(5 + 13);
        health = maxHealth;
        armorClass = rnd.nextInt(5 + 13);
        initiative = rnd.nextInt(20 + 1) + 2;
        this.id = id;
        break;
      case 1:
        name = "John";
        maxHealth = rnd.nextInt(5 + 13);
        health = maxHealth;
        armorClass = rnd.nextInt(5 + 13);
        initiative = rnd.nextInt(20 + 1) + 2;
        this.id = id;
        break;
      case 2:
        name = "Lisa";
        maxHealth = rnd.nextInt(5 + 13);
        health = maxHealth;
        armorClass = rnd.nextInt(5 + 13);
        initiative = rnd.nextInt(20 + 1) + 2;
        this.id = id;
        break;
      case 3:
        name = "Jesus";
        maxHealth = rnd.nextInt(5 + 13);
        health = maxHealth;
        armorClass = rnd.nextInt(5 + 13);
        initiative = rnd.nextInt(20 + 1) + 2;
        this.id = id;
        break;
    }
  }

  /**
   * To string method.
   */
  public String toString() {
    return name;
  }

  /**
   * accessor method for the Character's current health.
   *
   * @return the current health of the Character.
   */
  public int getHealth() {
    return health;
  }

  /**
   * accessor method for the Character's armor class.
   *
   * @return the armor class of the Character.
   */
  public int getArmorClass() {
    return armorClass;
  }

  /**
   * accessor method for the Character's initiative.
   *
   * @return the initiative of the Character.
   */
  public int getInitiative() {
    return initiative;
  }

  /**
   * accessor method for the Character's name.
   *
   * @return the name of the Character.
   */
  public String getName() {
    return name;
  }

  /**
   * mutator method for the Character's current health.
   */
  public void setHealth(int health) {
    this.health = health;
  }
}

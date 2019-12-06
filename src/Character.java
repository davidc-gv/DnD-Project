import java.util.Random;

public class Character {

  //declare instance variables
  int health;
  int maxHealth;
  int armorClass;
  int initiative;
  int id;
  String name;
  double challengeRating;
  int xp;

  /**
   * Constructor method for Character class.
   * Parameter a is used in the encounter class to give each Character and monster
   * a unique identifying integer as a key to the initiative table.
   */
  public Character(int a) {
    id = a;
  }

  /**
   * Constructor method that takes a name as input.
   */

  public Character(String playerName) {
    name = playerName;
    maxHealth = 0;
    health = maxHealth;
    armorClass = 0;
    initiative = 0;
    this.id = 0;

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
   * accessor method for the Character's challengeRating.
   *
   * @return the challengeRating of the Character.
   */

  public double getChallengeRating() {
    return challengeRating;
  }

  /**
   * accessor method for the Character's xp.
   *
   * @return the xp of the Character.
   */

  public int getXp() {
    return xp;
  }
}

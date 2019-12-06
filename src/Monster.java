import java.util.Random;

/**
 * Class that initializes and organizes NPCs.
 *
 * @author Samuel Petrarca
 */

public class Monster extends Character {


  /**
   * Constructor method for Monster class.
   * Parameter id is used in the encounter class to give each player and monster
   * a unique identifying integer as a key to the initiative table.
   */
  public Monster(int id) {
    super(id);
    Random rnd = new Random();
    //int monType = rnd.nextInt(4);
    switch (id) {
      default:
        name = "Kobold";
        maxHealth = 5;
        health = maxHealth;
        armorClass = 12;
        challengeRating = 1.0 / 8.0;
        initiative = rnd.nextInt(20 + 1) + 2;
        xp = 25;
        this.id = id;
        break;
      case 0:
        name = "Kobold";
        maxHealth = 5;
        health = maxHealth;
        armorClass = 12;
        challengeRating = 1.0 / 8.0;
        initiative = rnd.nextInt(20 + 1) + 2;
        xp = 25;
        this.id = id;
        break;
      case 1:
        name = "Bandit";
        maxHealth = 11;
        health = maxHealth;
        armorClass = 12;
        challengeRating = 1.0 / 8.0;
        initiative = rnd.nextInt(20 + 1) + 2;
        xp = 25;
        this.id = id;
        break;
      case 2:
        name = "Flying Snake";
        maxHealth = 5;
        health = maxHealth;
        armorClass = 14;
        challengeRating = 1.0 / 8.0;
        initiative = rnd.nextInt(20 + 1) + 4;
        xp = 25;
        this.id = id;
        break;
      case 3:
        name = "Dolphin";
        maxHealth = 11;
        health = maxHealth;
        armorClass = 12;
        challengeRating = 1.0 / 8.0;
        initiative = rnd.nextInt(20 + 1) + 1;
        xp = 25;
        this.id = id;
        break;
      case 4:
        name = "Tribal Warrior";
        maxHealth = 11;
        health = maxHealth;
        armorClass = 12;
        challengeRating = 1.0 / 8.0;
        initiative = rnd.nextInt(20 + 1);
        xp = 25;
        this.id = id;
        break;
      case 5:
        name = "Sprite";
        maxHealth = 2;
        health = maxHealth;
        armorClass = 15;
        challengeRating = 1.0 / 4.0;
        initiative = rnd.nextInt(20 + 1) + 4;
        xp = 50;
        this.id = id;
        break;
      case 6:
        name = "Giant Goat";
        maxHealth = 19;
        health = maxHealth;
        armorClass = 11;
        challengeRating = 1.0 / 2.0;
        initiative = rnd.nextInt(20 + 1);
        xp = 100;
        this.id = id;
        break;
      case 7:
        name = "Tiger";
        maxHealth = 37;
        health = maxHealth;
        armorClass = 12;
        challengeRating = 1;
        initiative = rnd.nextInt(20 + 1) + 2;
        xp = 200;
        this.id = id;
        break;
      case 8:
        name = "Gelatinous Cube";
        maxHealth = 84;
        health = maxHealth;
        armorClass = 6;
        challengeRating = 2;
        initiative = rnd.nextInt(20 + 1) - 4;
        xp = 450;
        this.id = id;
        break;
      case 9:
        name = "Basilisk";
        maxHealth = 52;
        health = maxHealth;
        armorClass = 15;
        challengeRating = 3;
        initiative = rnd.nextInt(20 + 1) - 1;
        xp = 700;
        this.id = id;
        break;
      case 10:
        name = "Gorgon";
        maxHealth = 114;
        health = maxHealth;
        armorClass = 19;
        challengeRating = 5;
        initiative = rnd.nextInt(20 + 1);
        xp = 1800;
        this.id = id;
        break;
      case 11:
        name = "Giant Ape";
        maxHealth = 157;
        health = maxHealth;
        armorClass = 12;
        challengeRating = 7;
        initiative = rnd.nextInt(20 + 1) + 2;
        xp = 2900;
        this.id = id;
        break;
      case 12:
        name = "Young Silver Dragon";
        maxHealth = 168;
        health = maxHealth;
        armorClass = 18;
        challengeRating = 9;
        initiative = rnd.nextInt(20 + 1);
        xp = 5000;
        this.id = id;
        break;
      case 13:
        name = "Behir";
        maxHealth = 168;
        health = maxHealth;
        armorClass = 17;
        challengeRating = 11;
        initiative = rnd.nextInt(20 + 1) + 3;
        xp = 7200;
        this.id = id;
        break;
      case 14:
        name = "Vampire";
        maxHealth = 144;
        health = maxHealth;
        armorClass = 16;
        challengeRating = 13;
        initiative = rnd.nextInt(20 + 1) + 4;
        xp = 10000;
        this.id = id;
        break;
      case 15:
        name = "Adult Purple Dragon";
        maxHealth = 212;
        health = maxHealth;
        armorClass = 19;
        challengeRating = 15;
        initiative = rnd.nextInt(20 + 1);
        xp = 13000;
        this.id = id;
        break;
    }
  }
}



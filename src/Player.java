import java.util.*;

/**
 * Class that initializes and organizes Player Characters
 *
 * @author Samuel Petrarca
 */

public class Player extends Character {
  /**
   * Constructor method for Player class.
   * Parameter id is used in the encounter class to give each player and monster
   * a unique identifying integer as a key to the initiative table.
   */
  public Player(int id) {
    super(id);
  }
}

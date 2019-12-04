import java.util.Random;

/**
 * Class that handles dice rolls.
 *
 * @author Samuel Petrarca
 */

public class DiceRoll {
  private Random roll = new Random();

  /**
   * Constructor method for the Dice_Roll Class.
   */
  public DiceRoll() {
  }

  /**
   * Rolls a custom amount (1+) of custom dice (1+)
   *
   * @author Andrew Langley
   * @param dNum Amount of dice to be rolled
   * @param dType Type of die to roll (e.g. d20 or d10)
   * @return random integer between 1 and dType. -1 if invalid input
   */
  public int customRoll(int dNum, int dType){
    // Checks if both dNum and dType are greater than 0 and returns -1 if either are not
    if(dNum < 1 || dType < 1){
      return -1;
    }
    // Sum of rolls
    int rollSum = 0;
    // Rolls dNum times
    for(int i = 0; i < dNum; ++i){
      // Adds roll to the sum
      rollSum += roll.nextInt(dType) + 1;
    }
    return rollSum;
  }

  /**
   * Simulates rolling a d20 die.
   *
   * @return random integer between 1-20.
   */
  public int rollD20() {
    int d20Roll = roll.nextInt(20) + 1;
    return d20Roll;
  }

  /**
   * Simulates rolling a d12 die.
   *
   * @return random integer between 1-12.
   */
  public int rollD12() {
    int d12Roll = roll.nextInt(12) + 1;
    return d12Roll;
  }

  /**
   * Simulates rolling a d10 percentile die.
   *
   * @return random multiple of 10 between 10-100.
   */
  public int rollD10P() {
    int d10pRoll = roll.nextInt(10) + 1;
    return d10pRoll * 10;
  }

  /**
   * Simulates rolling a standard d10 die.
   *
   * @return random multiple of 10 between 10-100.
   */
  public int rollD10() {
    int d10pRoll = roll.nextInt(10) + 1;
    return d10pRoll;
  }

  /**
   * Simulates rolling a d8 die.
   *
   * @return random integer between 1-8.
   */
  public int rollD8() {
    int d8Roll = roll.nextInt(8) + 1;
    return d8Roll;
  }

  /**
   * Simulates rolling a d6 die.
   *
   * @return random integer between 1-6.
   */
  public int rollD6() {
    int d6Roll = roll.nextInt(6) + 1;
    return d6Roll;
  }

  /**
   * Simulates rolling a d4 die.
   *
   * @return random integer between 1-4.
   */
  public int rollD4() {
    int d4Roll = roll.nextInt(4) + 1;
    return d4Roll;
  }
}

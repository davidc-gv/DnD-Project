import java.util.*;

/**
 * Class that handles dice rolls
 *
 * @author Samuel Petrarca
 */

public class Dice_Roll{
    private Random Roll = new Random();

    /**
     * Constructor method for the Dice_Roll Class
     */
    public Dice_Roll() {}

    /**
     * Simulates rolling a d20 die
     * @return random integer between 1-20
     */
    public int rollD20(){
        int d20Roll = Roll.nextInt(20) +1;
        return d20Roll;
    }

    /**
     * Simulates rolling a d12 die
     * @return random integer between 1-12
     */
    public int rollD12(){
        int d12Roll = Roll.nextInt(12) + 1;
        return d12Roll;
    }

    /**
     * Simulates rolling a d10 percentile die
     * @return random multiple of 10 between 10-100
     */
    public int rollD10P(){
        int d10pRoll = Roll.nextInt(10) + 1;
        return d10pRoll * 10;
    }

    /**
     * Simulates rolling a standard d10 die
     * @return random multiple of 10 between 10-100
     */
    public int rollD10(){
        int d10pRoll = Roll.nextInt(10) + 1;
        return d10pRoll;
    }

    /**
     * Simulates rolling a d8 die
     * @return random integer between 1-8
     */
    public int rollD8(){
        int d8Roll = Roll.nextInt(8) + 1;
        return d8Roll;
    }

    /**
     * Simulates rolling a d6 die
     * @return random integer between 1-6
     */
    public int rollD6(){
        int d6Roll = Roll.nextInt(6) + 1;
        return d6Roll;
    }

    /**
     * Simulates rolling a d4 die
     * @return random integer between 1-4
     */
    public int rollD4(){
        int d4Roll = Roll.nextInt(4) + 1;
        return d4Roll;
    }
}

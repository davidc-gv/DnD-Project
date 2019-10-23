import java.util.*;

public class Dice_Roll{
    Random Roll = new Random();
    
    //constructor
    public Dice_Roll() {}
    
    public int rollD20(){
        int d20Roll = Roll.nextInt(20+1);
        return d20Roll;
    }
    public int rollD12(){
        int d12Roll = Roll.nextInt(12+1);
        return d12Roll;
    }
    public int rollD10P(){
        int d10pRoll = Roll.nextInt(10+1);
        return d10pRoll * 10;
    }
    public int rollD8(){
        int d8Roll = Roll.nextInt(8+1);
        return d8Roll;
    }
    public int rollD6(){
        int d6Roll = Roll.nextInt(6+1);
        return d6Roll;
    }
    public int rollD4(){
        int d4Roll = Roll.nextInt(4+1);
        return d4Roll;
    }
}

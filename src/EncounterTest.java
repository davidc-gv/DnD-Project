import org.junit.Test;

import static org.junit.Assert.*;

public class EncounterTest {

    @Test
    public void nextTurn() {
        Encounter enc = new Encounter(3, 3);
        Character cha = enc.initiative.get(1);
        enc.nextTurn();
        assertEquals(cha, enc.initiative.get(0));

    }

    @Test
    public void removeChar() {
        Encounter enc = new Encounter(new String[]{"John", "Jacob", "Sam"}, new int []  {13, 12, 10}, new int [] {1, 4, 7, 12}, new double [] {1, 3, 7, 13});
        Character cha = enc.initiative.get(1);
        enc.removeChar(0);
        assertEquals(cha, enc.initiative.get(0));
    }

    @Test
    public void addMonster() {
        Encounter enc = new Encounter(0, 0);
        enc.addMonster(15);
        assertEquals(enc.initiative.get(0).challengeRating, 15, 0.1);
        enc.removeChar(0);
        enc.addMonster(14);
        assertEquals(enc.initiative.get(0).challengeRating, 13, 0.1);
        enc.removeChar(0);
        enc.addMonster(13);
        assertEquals(enc.initiative.get(0).challengeRating, 11, 0.1);
        enc.removeChar(0);
        enc.addMonster(12);
        assertEquals(enc.initiative.get(0).challengeRating, 9, 0.1);
        enc.removeChar(0);
        enc.addMonster(11);
        assertEquals(enc.initiative.get(0).challengeRating, 7, 0.1);
        enc.removeChar(0);


    }

    @Test
    public void addMonsterCR() {
        Encounter enc = new Encounter(0, 0);
        enc.addMonsterCR(15);
        assertEquals(enc.initiative.get(0).challengeRating, 15, 0.1);
        enc.removeChar(0);
        enc.addMonsterCR(13);
        assertEquals(enc.initiative.get(0).challengeRating, 13, 0.1);
        enc.removeChar(0);
        enc.addMonsterCR(9);
        assertEquals(enc.initiative.get(0).challengeRating, 9, 0.1);
        enc.removeChar(0);
        enc.addMonsterCR(5);
        assertEquals(enc.initiative.get(0).challengeRating, 5, 0.1);
        enc.removeChar(0);
        enc.addMonsterCR(1.0 / 8.0);
        assertEquals(enc.initiative.get(0).challengeRating, (1.0 / 8.0), 0.1);
        enc.removeChar(0);

    }
    @Test
    public void TestDiceRoll() {
        DiceRoll die = new DiceRoll();
        assertTrue(die.rollD4() > 0 && die.rollD4() <= 4);
        assertTrue(die.rollD6() > 0 && die.rollD6() <= 6);
        assertTrue(die.rollD8() > 0 && die.rollD8() <= 8);
        assertTrue(die.rollD10() > 0 && die.rollD10() <= 10);
        assertTrue(die.rollD10P() > 0 && die.rollD10P() <= 100 && die.rollD10P() % 10 == 0);
        assertTrue(die.rollD12() > 0 && die.rollD12() <= 12);
        assertTrue(die.rollD20() > 0 && die.rollD20() <= 20);
        assertTrue(die.customRoll(4, 8) > 0 && die.customRoll(4, 8) <= 32);
    }
}
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
        Encounter enc = new Encounter(3, 3);
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
}
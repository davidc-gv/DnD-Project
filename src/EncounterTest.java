import org.junit.Test;

import static org.junit.Assert.*;

public class EncounterTest {

    @Test
    public void nextTurn() {
        Encounter enc = new Encounter(3, 3);
        Character cha = enc.initiative.get(1);
        enc.nextTurn();
        assertEquals(cha, enc.initiative.get(enc.initiative.size() - 1));

    }

    @Test
    public void removeChar() {
    }

    @Test
    public void addMonster() {
    }

    @Test
    public void addMonsterCR() {
    }
}
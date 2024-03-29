import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * Class that tests Encounter, Monster, DiceRoll, and Player Classes.
 *
 * @author Samuel Petrarca
 */

public class DndTest {

  /**
   * Tests the nextTurn() function of Encounter as well as the Characters in the order.
   */

  @Test
  public void nextTurn() {
    Encounter enc = new Encounter(3, 3);
    Character cha = enc.initiative.get(1);
    enc.nextTurn();
    assertEquals(cha, enc.initiative.get(0));
  }

  /**
   * Tests the removeChar() function of Encounter as well as the Characters in the order.
   */

  @Test
  public void removeChar() {
    Encounter enc = new Encounter(new String[]{"John", "Jacob", "Sam"}, new int[]{13, 12, 10},
        new int[]{1, 4, 7, 12}, new double[]{1, 3, 7, 13});
    Character cha = enc.initiative.get(1);
    enc.removeChar(0);
    assertEquals(cha, enc.initiative.get(0));
  }

  /**
   * Tests the addMonster() function of Encounter as well as the Characters in the order.
   */

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

  /**
   * Tests the default case in the (id) switch statement in Monster class.
   */

  @Test(expected = IllegalArgumentException.class)
  public void illegalMonsterID() {
    Encounter enc = new Encounter(0, 0);
    enc.addMonster(50);
  }

  /**
   * Tests the addMonsterCR() function of Encounter as well as the Characters in the order.
   */

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

  /**
   * Tests the dice rolls in the DiceRoll class.
   */

  @Test
  public void testDiceRoll() {
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

  @Test

  public void goldTest() {

    Loot lootTest = new Loot();


    int gold = lootTest.goldAmount(1);

    assertNotEquals(0, gold);

    int gold2 = lootTest.goldAmount(5);

    assertNotEquals(19, gold2);

    int gold3 = lootTest.goldAmount(11);

    assertNotEquals(99, gold3);

    int gold4 = lootTest.goldAmount(18);

    assertNotEquals(799, gold4);

  }


  @Test

  public void lootTest() {

    Loot lootTest = new Loot();

    String item = lootTest.itemType(1);


    item = lootTest.itemType(1);

    while (item != "Bag of holding") {

      item = lootTest.itemType(1);

    }

    assertEquals("Bag of holding", item);

    while (item != "Ammunition, +1") {

      item = lootTest.itemType(1);

    }

    assertEquals("Ammunition, +1", item);

    while (item != "Dust of disappearance") {

      item = lootTest.itemType(1);

    }

    assertEquals("Dust of disappearance", item);

    while (item != "Mithral armor") {

      item = lootTest.itemType(1);

    }

    assertEquals("Mithral armor", item);

    while (item != "A Spoon") {

      item = lootTest.itemType(1);

    }

    assertEquals("A Spoon", item);

    while (item != "Spell scroll (5thlevel)") {

      item = lootTest.itemType(1);

    }

    assertEquals("Spell scroll (5thlevel)", item);

    while (item != "Folding boat") {

      item = lootTest.itemType(1);

    }

    assertEquals("Folding boat", item);

    while (item != "Sentinel shield") {

      item = lootTest.itemType(1);

    }

    assertEquals("Sentinel shield", item);

    while (item != "Sword of vengeance") {

      item = lootTest.itemType(1);

    }

    assertEquals("Sword of vengeance", item);

    while (item != "Trident of fish command") {

      item = lootTest.itemType(1);

    }

    assertEquals("Trident of fish command", item);

    while (item != "Adamantine armor (chain mail)") {

      item = lootTest.itemType(1);

    }

    assertEquals("Adamantine armor (chain mail)", item);

    while (item != "Circlet of blasting") {

      item = lootTest.itemType(1);

    }

    assertEquals("Circlet of blasting", item);

    while (item != "Berserker axe") {

      item = lootTest.itemType(1);

    }

    assertEquals("Berserker axe", item);

    while (item != "Helm of teleportation") {

      item = lootTest.itemType(1);

    }

    assertEquals("Helm of teleportation", item);

    while (item != "Ring of animal influence") {

      item = lootTest.itemType(1);

    }

    assertEquals("Ring of animal influence", item);


    while (item != "Potion of invulnerability") {

      item = lootTest.itemType(6);

    }

    assertEquals("Potion of invulnerability", item);

    while (item != "Spell scroll (1st level)") {

      item = lootTest.itemType(6);

    }

    assertEquals("Spell scroll (1st level)", item);

    while (item != "Oil of slipperiness") {

      item = lootTest.itemType(6);

    }

    assertEquals("Oil of slipperiness", item);

    while (item != "Dust of sneezing and choking") {

      item = lootTest.itemType(6);

    }

    assertEquals("Dust of sneezing and choking", item);

    while (item != "Ring of swimming") {

      item = lootTest.itemType(6);

    }

    assertEquals("Ring of swimming", item);

    while (item != "Spell scroll (5thlevel)") {

      item = lootTest.itemType(6);

    }

    assertEquals("Spell scroll (5thlevel)", item);

    while (item != "Potion of speed") {

      item = lootTest.itemType(6);

    }

    assertEquals("Potion of speed", item);

    while (item != "Oil of sharpness") {

      item = lootTest.itemType(6);

    }

    assertEquals("Oil of sharpness", item);

    while (item != "Broom of flying") {

      item = lootTest.itemType(6);

    }

    assertEquals("Broom of flying", item);

    while (item != "Wand of paralysis") {

      item = lootTest.itemType(6);

    }

    assertEquals("Wand of paralysis", item);

    while (item != "Wand of polymorph") {

      item = lootTest.itemType(6);

    }

    assertEquals("Wand of polymorph", item);

    while (item != "Demon armor") {

      item = lootTest.itemType(6);

    }

    assertEquals("Demon armor", item);

    while (item != "Boots of levitation") {

      item = lootTest.itemType(6);

    }

    assertEquals("Boots of levitation", item);

    while (item != "Censer of controlling air elementals") {

      item = lootTest.itemType(6);

    }

    assertEquals("Censer of controlling air elementals", item);

    while (item != "Cube of force") {

      item = lootTest.itemType(6);

    }

    assertEquals("Cube of force", item);

    while (item != "Mace of smiting") {

      item = lootTest.itemType(6);

    }

    assertEquals("Mace of smiting", item);


    while (item != "Potion of gaseous form") {

      item = lootTest.itemType(12);

    }

    assertEquals("Potion of gaseous form", item);

    while (item != "Elixir of health") {

      item = lootTest.itemType(12);

    }

    assertEquals("Elixir of health", item);

    while (item != "Chime of opening") {

      item = lootTest.itemType(12);

    }

    assertEquals("Chime of opening", item);

    while (item != "Spell scroll (8thlevel)") {

      item = lootTest.itemType(12);

    }

    assertEquals("Spell scroll (8thlevel)", item);

    while (item != "Bag of devouring") {

      item = lootTest.itemType(12);

    }

    assertEquals("Bag of devouring", item);

    while (item != "Universal solvent") {

      item = lootTest.itemType(12);

    }

    assertEquals("Universal solvent", item);

    while (item != "Arrow of slaying") {

      item = lootTest.itemType(12);

    }

    assertEquals("Arrow of slaying", item);

    while (item != "Gauntlets of ogre power") {

      item = lootTest.itemType(12);

    }

    assertEquals("Gauntlets of ogre power", item);

    while (item != "Javelin of lightning") {

      item = lootTest.itemType(12);

    }

    assertEquals("Javelin of lightning", item);

    while (item != "Weapon of warning") {

      item = lootTest.itemType(12);

    }

    assertEquals("Weapon of warning", item);

    while (item != "Amulet of health") {

      item = lootTest.itemType(12);

    }

    assertEquals("Amulet of health", item);

    while (item != "Well of many worlds") {

      item = lootTest.itemType(12);

    }

    assertEquals("Well of many worlds", item);

    while (item != "Deck of many things") {

      item = lootTest.itemType(12);

    }

    assertEquals("Deck of many things", item);

    while (item != "Plate armor of resistance") {

      item = lootTest.itemType(12);

    }

    assertEquals("Plate armor of resistance", item);

    while (item != "Ring of three wishes") {

      item = lootTest.itemType(12);

    }

    assertEquals("Ring of three wishes", item);

    while (item != "Talisman of pure good") {

      item = lootTest.itemType(12);

    }

    assertEquals("Talisman of pure good", item);

    while (item != "Talisman of ultimate evil") {

      item = lootTest.itemType(12);

    }

    assertEquals("Talisman of ultimate evil", item);


    while (item != "Quaal's feather token") {

      item = lootTest.itemType(19);

    }

    assertEquals("Quaal's feather token", item);

    while (item != "Potion of longevity") {

      item = lootTest.itemType(19);

    }

    assertEquals("Potion of longevity", item);

    while (item != "Chime of opening") {

      item = lootTest.itemType(19);

    }

    assertEquals("Chime of opening", item);

    while (item != "Sovereign glue") {

      item = lootTest.itemType(19);

    }

    assertEquals("Sovereign glue", item);

    while (item != "Arrow-catching shield") {

      item = lootTest.itemType(19);

    }

    assertEquals("Arrow-catching shield", item);

    while (item != "Cape of the mountebank") {

      item = lootTest.itemType(19);

    }

    assertEquals("Cape of the mountebank", item);

    while (item != "Crystal ball (very rare version)") {

      item = lootTest.itemType(19);

    }

    assertEquals("Crystal ball (very rare version)", item);

    while (item != "Rod of security") {

      item = lootTest.itemType(19);

    }

    assertEquals("Rod of security", item);

    while (item != "Staff of frost") {

      item = lootTest.itemType(19);

    }

    assertEquals("Staff of frost", item);

    while (item != "Animated shield") {

      item = lootTest.itemType(19);

    }

    assertEquals("Animated shield", item);

    while (item != "Holy avenger") {

      item = lootTest.itemType(19);

    }

    assertEquals("Holy avenger", item);

    while (item != "Rod of lordly might") {

      item = lootTest.itemType(19);

    }

    assertEquals("Rod of lordly might", item);

    while (item != "Robe of the archmagi") {

      item = lootTest.itemType(19);

    }

    assertEquals("Robe of the archmagi", item);

    while (item != "Apparatus of Kwalish") {

      item = lootTest.itemType(19);

    }

    assertEquals("Apparatus of Kwalish", item);

    while (item != "Sphere of annihilation") {

      item = lootTest.itemType(19);

    }

    assertEquals("Sphere of annihilation", item);

    while (item != "Tome of the stilled tongue") {

      item = lootTest.itemType(19);

    }

    assertEquals("Tome of the stilled tongue", item);

    while (item != "Talisman of the sphere") {

      item = lootTest.itemType(19);

    }
    assertEquals("Talisman of the sphere", item);
  }
}
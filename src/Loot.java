import java.util.Random;


/**
 * A class that generates loot randomly.
 */
public class Loot {
  String items = null;
  int gold;
  int itemType = 0;
  int itemRange = 0;
  private Random rand = new Random();

  /**
   * A method for the class Loot
   * Determines the type of item generated.
   *
   * @return
   */


  public String itemType(int cr3) {
    //random number 1-5
    int cr4 = cr3;

    itemRange = rand.nextInt(100) + 1;

    if (cr4 >= 1 && cr4 <= 4) {

      if (itemRange >= 1 && itemRange <= 50) {
        itemType = rand.nextInt(5) + 1;
        if (itemType == 1) {
          items = "Bag of holding";
        } else if (itemType == 2) {
          items = "Ammunition, +1";
        } else if (itemType == 3) {
          items = "Dust of disappearance";
        } else if (itemType == 4) {
          items = "Mithral armor";
        } else if (itemType == 5) {
          items = "A Spoon";
        }
      } else if (itemRange >= 51 && itemRange <= 85) {
        itemType = rand.nextInt(5) + 1;
        if (itemType == 1) {
          items = "Spell scroll (5thlevel)";
        } else if (itemType == 2) {
          items = "Bag of beans";
        } else if (itemType == 3) {
          items = "Folding boat";
        } else if (itemType == 4) {
          items = "Sentinel shield";
        } else if (itemType == 5) {
          items = "Sword of vengeance";
        }
      } else if (itemRange >= 86 && itemRange <= 100) {
        itemType = rand.nextInt(6) + 1;
        if (itemType == 1) {
          items = "Trident of fish command";
        } else if (itemType == 2) {
          items = "Adamantine armor (chain mail)";
        } else if (itemType == 3) {
          items = "Circlet of blasting";
        } else if (itemType == 4) {
          items = "Berserker axe";
        } else if (itemType == 5) {
          items = "Helm of teleportation";
        } else if (itemType == 6) {
          items = "Ring of animal influence";
        }

      }

    } else if (cr4 >= 5 && cr4 <= 10) {

      if (itemRange >= 1 && itemRange <= 50) {
        itemType = rand.nextInt(5) + 1;
        if (itemType == 1) {
          items = "Potion of invulnerability";
        } else if (itemType == 2) {
          items = "Spell scroll (1st level)";
        } else if (itemType == 3) {
          items = "Oil of slipperiness";
        } else if (itemType == 4) {
          items = "Dust of sneezing and choking";
        } else if (itemType == 5) {
          items = "Ring of swimming";
        }
      } else if (itemRange >= 51 && itemRange <= 85) {
        itemType = rand.nextInt(5) + 1;
        if (itemType == 1) {
          items = "Spell scroll (5thlevel)";
        } else if (itemType == 2) {
          items = "Potion of speed";
        } else if (itemType == 3) {
          items = "Oil of sharpness";
        } else if (itemType == 4) {
          items = "Broom of flying";
        } else if (itemType == 5) {
          items = "Wand of paralysis";
        }
      } else if (itemRange >= 86 && itemRange <= 100) {
        itemType = rand.nextInt(6) + 1;
        if (itemType == 1) {
          items = "Wand of polymorph";
        } else if (itemType == 2) {
          items = "Demon armor";
        } else if (itemType == 3) {
          items = "Boots of levitation";
        } else if (itemType == 4) {
          items = "Censer of controlling air elementals";
        } else if (itemType == 5) {
          items = "Cube of force";
        } else if (itemType == 6) {
          items = "Mace of smiting";
        }

      }
    } else if (cr4 >= 11 && cr4 <= 16) {

      if (itemRange >= 1 && itemRange <= 50) {
        itemType = rand.nextInt(6) + 1;
        if (itemType == 1) {
          items = "Potion of gaseous form";
        } else if (itemType == 2) {
          items = "Elixir of health";
        } else if (itemType == 3) {
          items = "Chime of opening";
        } else if (itemType == 4) {
          items = "Spell scroll (8thlevel)";
        } else if (itemType == 5) {
          items = "Bag of devouring";
        } else if (itemType == 6) {
          items = "Universal solvent";
        }
      } else if (itemRange >= 51 && itemRange <= 85) {
        itemType = rand.nextInt(5) + 1;
        if (itemType == 1) {
          items = "Arrow of slaying";
        } else if (itemType == 2) {
          items = "Gauntlets of ogre power";
        } else if (itemType == 3) {
          items = "Javelin of lightning";
        } else if (itemType == 4) {
          items = "Weapon of warning";
        } else if (itemType == 5) {
          items = "Amulet of health";
        }
      } else if (itemRange >= 86 && itemRange <= 100) {
        itemType = rand.nextInt(6) + 1;
        if (itemType == 1) {
          items = "Well of many worlds";
        } else if (itemType == 2) {
          items = "Deck of many things";
        } else if (itemType == 3) {
          items = "Plate armor of resistance";
        } else if (itemType == 4) {
          items = "Ring of three wishes";
        } else if (itemType == 5) {
          items = "Talisman of pure good";
        } else if (itemType == 6) {
          items = "Talisman of ultimate evil";
        }
      }
    } else if (cr4 >= 17 && cr4 <= 100) {

      if (itemRange >= 1 && itemRange <= 50) {
        itemType = rand.nextInt(6) + 1;
        if (itemType == 1) {
          items = "Quaal's feather token";
        } else if (itemType == 2) {
          items = "Potion of longevity";
        } else if (itemType == 3) {
          items = "Chime of opening";
        } else if (itemType == 4) {
          items = "Sovereign glue";
        } else if (itemType == 5) {
          items = "Arrow-catching shield";
        } else if (itemType == 6) {
          items = "Cape of the mountebank";
        }
      } else if (itemRange >= 51 && itemRange <= 85) {
        itemType = rand.nextInt(5) + 1;
        if (itemType == 1) {
          items = "Crystal ball (very rare version)";
        } else if (itemType == 2) {
          items = "Rod of security";
        } else if (itemType == 3) {
          items = "Staff of frost";
        } else if (itemType == 4) {
          items = "Animated shield";
        } else if (itemType == 5) {
          items = "Holy avenger";
        }
      } else if (itemRange >= 86 && itemRange <= 100) {
        itemType = rand.nextInt(6) + 1;
        if (itemType == 1) {
          items = "Rod of lordly might";
        } else if (itemType == 2) {
          items = "Robe of the archmagi";
        } else if (itemType == 3) {
          items = "Apparatus of Kwalish";
        } else if (itemType == 4) {
          items = "Sphere of annihilation";
        } else if (itemType == 5) {
          items = "Tome of the stilled tongue";
        } else if (itemType == 6) {
          items = "Talisman of the sphere";
        }
      }
    }

    return items;
  }


  /**
   * A method for the class Loot
   * Determines amount of gold dropped based on CR.
   */
  public int goldAmount(int cr7) {
    int cr2 = cr7;

    if (cr2 >= 1 && cr2 <= 4) {
      gold = rand.nextInt(20) + 1;
    } else if (cr2 >= 5 && cr2 <= 10) {
      gold = rand.nextInt(240) + 20;
    } else if (cr2 >= 11 && cr2 <= 16) {
      gold = rand.nextInt(1200) + 100;
    } else if (cr2 >= 17 && cr2 <= 100) {
      gold = rand.nextInt(6000) + 800;
    }
    return gold;
  }
}

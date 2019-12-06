import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;

public class Encounter {


  private Monster[] monsters;

  private Player[] players;

  //Character[] initiative;
  ArrayList<Character> initiative;

  /**
   * This will build an encounter which will have an array of Monsters,
   * Players, and an initiative tracker.
   * The methods are completely random
   *
   * @param numMon will hold how many randomly generated monsters will be included
   * @param numP   will hold how many players in the encounter
   */
  public Encounter(int numMon, int numP) {
    //initialize the initiative

    //initiative = new Character[numMon + numP];
    //a tracker for the current place in the initiative array
    int c = 0;

    initiative = new ArrayList<>();


    //initializes monsters
    monsters = new Monster[numMon];
    for (int i = 0; i < numMon; i++) {

      //we add a new monster to the array
      monsters[i] = new Monster(i);

      //we then add that monster to the initiative array
      //initiative[c] = monsters[i];
      initiative.add(monsters[i]);

      //increment the initiative tracker variable
      c++;
    }

    //initializes players
    players = new Player[numP];
    for (int i = 0; i < numP; i++) {

      players[i] = new Player(c);
      //initiative[c] = players[i];
      initiative.add(players[i]);
      c++;
    }


    //finally we call the sortInitiative method to sort what has already been inputted
    sortInitiative();
  }


  /**
   * This is a different constructor that takes in the player names and initiatives.
   * This will add players to the initiative tracker with their corresponding initiative values
   * This will also add monsters based on the method the user wishes to do so
   * The monsters can be added via their ID opr via their CR
   * Helper methods will handle this
   * The constructor will then sort the initiatives accordingly
   *
   * @param playerNames a list of player names
   * @param init a list of initiatives
   * @param monsterID a list of ID's of monsters to add to the rotation
   * @param monsterCR a list of CR's of monsters to add to the rotation
   */
  public Encounter(String [] playerNames, int [] init, int [] monsterID, double [] monsterCR) {

    initiative = new ArrayList<>();

    players = new Player[playerNames.length];

    //adding the players
    for (int i = 0; i < playerNames.length; i++) {
      Player p = new Player(playerNames[i]);
      p.initiative = init[i];
      p.name = playerNames[i];
      p.challengeRating = -1;
      p.xp = -1;
      initiative.add(p);

    }

    //adding the monsters based on ID
    for (int value : monsterID) {
      //call helper method
      addMonster(value);
    }

    //adding the monsters based on CR
    for (double v : monsterCR) {
      //call helper method
      addMonsterCR(v);
    }


    //finally we sort the initiative
    sortInitiative();

  }



  /**
   * This method will sort initiative. It uses a sorting algorithm to
   * arrange all the items in the initiative array
   * in the correct order dependent on initiative
   * Since we changed initiative from a list to an arraylist we will convert in order to use the
   * same logic.
   * First we convert to a list and perform our logic, we then convert back to an arraylist
   *
   */
  private void sortInitiative() {



    Character [] init = new Character[initiative.size()];

    for (int i = 0; i < initiative.size(); i++) {
      init[i] = initiative.get(i);
    }


    for (int i = 0; i < init.length - 1; i++) {
      int index = i;
      for (int j = i + 1; j < init.length; j++) {
        if (init[j].getInitiative() < init[index].getInitiative()) {
          index = j;
        }
      }

      Character temp = init[index];
      init[index] = init[i];
      init[i] = temp;
    }

    ArrayList<Character> x = new ArrayList<Character>();

    //this adds all of the elements of init to x
    //Collections.addAll(x, init);

    for (int i = init.length - 1; i >= 0; i--) {

      x.add(init[i]);

    }

    //we then set initiative equal to x
    initiative = x;


  }


  /**
   * This method will iterate and change the head of the initiative to the next person in line.
   * This gets messy but we convert from an arraylist to a list, and then back to an arraylist
   * We sort the list and then convert back. This makes it so our previous logic still holds.
   *
   *
   */
  public void nextTurn() {

    Character [] init = new Character[initiative.size()];

    for (int i = 0; i < initiative.size(); i++) {
      init[i] = initiative.get(i);
    }



    Character temp = init[0];

    for (int i = 1; i < init.length; i++) {

      init[i - 1] = init[i];

    }

    init[init.length - 1] = temp;


    ArrayList<Character> x = new ArrayList<>();

    Collections.addAll(x, init);

    initiative = x;


  }


  /**
   * The program will remove a player/monster from the initiative by taking in an index.
   * There is no need resort since it will still be in order
   *
   * @param index This program will take in the index of the character we want to remove
   * @return The method will return the chracter removed in case we want to use it at a later point
   */
  public Character removeChar(int index) {

    Character temp = initiative.get(index);

    initiative.remove(index);

    return temp;
  }


  /**
   * The method will take in a integer that will represent the monster the user wishes to add
   * We will then add that monster into the initiative.
   * We do not need to sort initiative
   *
   * @param ind is the index of the monster in the constructor for monsters
   */
  public void addMonster(int ind) {

    Monster mon = new Monster(ind);
    initiative.add(mon);

  }

  /**
   * The program will find a monster with the same CR as what was given.
   * If no such CR exists within our amount of monsters, it will return a random Monster
   *
   *
   * @param challengeRating is the challenge rating of the monster we want to add
   */
  public void addMonsterCR(double challengeRating) {

    DiceRoll d = new DiceRoll();
    Monster mon = new Monster(d.rollD4());

    if (challengeRating > 15 || challengeRating < 0) {
      throw new
          IllegalArgumentException("Challenge rating out of bounds, use CR of 0.125 through 15");
    }
    int i = 0;
    while ((mon.getChallengeRating() < (challengeRating - 1.1))
        || (mon.getChallengeRating() > (challengeRating + 1.1))) {
      mon = new Monster(i);
      i++;
    } initiative.add(mon);
  }
}

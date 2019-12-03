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
   *
   * @param numMon will hold how many randomly generated monsters will be included
   * @param numP   will hold how many players in the encounter
   */
  public Encounter(int numMon, int numP) {
    //initialize the initiative

    //initiative = new Character[numMon + numP];
    //a tracker for the current place in the initiative array
    int c = 0;


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


  public Encounter(String [] playerNames){

    players = new Player[playerNames.length];

    for(int i = 0; i < playerNames.length; i++){
      players[i] = new Player(playerNames[i]);
    }



  }



  /**
   * This method will sort initiative. It uses a sorting algorithm to
   * arrange all the items in the initiative array
   * in the correct order dependent on initiative
   */
  private void sortInitiative() {

    Character [] init = new Character[initiative.size()];

    for(int i = 0; i < initiative.size(); i++){
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

    Collections.addAll(x, init);

    initiative = x;

  }

  public void nextTurn(){

    Character [] init = new Character[initiative.size()];

    for(int i = 0; i < initiative.size(); i++){
      init[i] = initiative.get(i);
    }



    Character temp = init[0];

    for(int i = 1; i < init.length -1; i++){

      init[i-1] = init[i];

    }

    init[init.length - 1] = temp;


    ArrayList<Character> x = new ArrayList<>();

    Collections.addAll(x, init);

    initiative = x;


  }


  public Character removeChar(int index){

    Character temp = initiative.get(index);

    initiative.remove(index);

    return temp;
  }


  public void addMonster(int x){

    Monster mon = new Monster(x);
    initiative.add(mon);

    sortInitiative();

  }

  /**
   * The program will find a monster with the same CR as what was given
   *
   * If no such CR exists within our amount of monsters, it will return a random Monster
   *
   *
   * @param ChallengeRating is the challenge rating of the monster we want to add
   */
  public void addMonsterCR(int ChallengeRating){

    DiceRoll d = new DiceRoll();
    Monster mon = new Monster(d.rollD4());

    for(int i = 0; i < 4; i++){

      mon = new Monster(i);

      if(mon.getChallengeRating() == ChallengeRating){
        break;
      }

    }

    initiative.add(mon);
    sortInitiative();


  }

}

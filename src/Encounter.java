public class Encounter {




    Monster monsters[];

    Player players[];

    Character initiative [];

    /**
     * This will build an encounter which will have an array of Monsters, Players, and an initiative tracker
     *
     * @param numMon will hold how many randomly generated monsters will be included
     * @param numP will hold how many players in the encounter
     */
    public Encounter(int numMon, int numP){
        //initialize the initiative

        initiative = new Character[numMon + numP];
        //a tracker for the current place in the initiative array
        int c = 0;


        //initializes monsters
        monsters = new Monster[numMon];
        for(int i = 0; i < numMon; i++){

            //we add a new monster to the array
            monsters[i] = new Monster(i);

            //we then add that monster to the initiative array
            initiative[c] = monsters[i];

            //increment the initiative tracker variable
            c++;
        }

        //initializes players
        players = new Player[numP];
        for(int i = 0; i < numP; i++){

            players[i] = new Player(c);
            initiative[c] = players[i];
            c++;
        }


        //finally we call the sortInitiative method to sort what has already been inputted
        sortInitiative();
    }


    /**
     * This method will sort initiative. It uses a sorting algorithm to arrange all the items in the initiative array
     * in the correct order dependent on initiative
     */
    public void sortInitiative(){

        for (int i = 0; i < initiative.length - 1; i++) {
            int index = i;
            for (int j = i + 1; j < initiative.length; j++)
                if (initiative[j].getInitiative() < initiative[index].getInitiative())
                    index = j;

            Character temp = initiative[index];
            initiative[index] = initiative[i];
            initiative[i] = temp;
        }
    }





}

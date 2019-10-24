public class Encounter {




    Monster monsters[];

    Player players[];

    Character initiative [];

    /**
     *
     * @param numMon
     * @param numP
     */
    public Encounter(int numMon, int numP){
        //initialize the initiative

        initiative = new Character[numMon + numP];
        int c = 0;


        //initializes monsters
        monsters = new Monster[numMon];
        for(int i = 0; i < numMon; i++){

            monsters[i] = new Monster(i);
            initiative[c] = monsters[i];

            c++;
        }

        //initializes players
        players = new Player[numP];
        for(int i = 0; i < numP; i++){

            players[i] = new Player(c);
            initiative[c] = players[i];
            c++;
        }

    sortInitiative();

    }


    public void sortInitiative(){

        for (int i = 0; i < initiative.length ; i++) {
            int index = i;
            for (int j = i + 1; j < initiative.length; j++)
                if (initiative[j].getInitiative() > initiative[index].getInitiative())
                    index = j;

            Character temp = initiative[index];
            initiative[index] = initiative[i];
            initiative[i] = temp;
        }
    }

//    public  showEncounter(){

//    }


}

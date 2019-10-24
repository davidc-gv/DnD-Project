public class Encounter {




    Monster monsters[];

    Player players[];

    Object initiative [];

    /**
     *
     * @param numMon
     * @param numP
     */
    public Encounter(int numMon, int numP){
        //initialize the initiative

        initiative = new Object[numMon + numP];
        int c = 0;


        //inititalizes monsters
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



    }


    private void sortInitiative(){




        for(int i = 0; i < initiative.length; i++){



        }

    }






//    public  showEncounter(){

//    }


}

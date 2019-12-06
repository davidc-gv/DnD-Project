import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.KeyStroke;

/**
 * Dialog that serves as the encounter tracker GUI.
 * Allows the the cycling and adding to a tabbed pane that serves
 * as the initiative tracker. Each tab represents a character and
 * displays the appropriate stat block.
 *
 * @author Andrew Langley
 */


public class EncGUI extends JDialog {
  private JFrame frame;
  private JPanel contentPane;
  //private JButton randomEncounter;
  private JTabbedPane initTracker;
  private JComboBox monsterList;
  private JButton addFromList;
  private JButton addFromChallengeRatingButton;
  private JTextField challengeRating;
  private JButton removeCurrentCharacterButton;
  private JButton nextButton;
  private JButton endButton;
  private Encounter enc;
  private String[] playerList;
  private int[] initList;
  private int monsterID;
  private double desiredCR;


  /**
   * Constructor for the encounter GUI. Adds event listeners to the buttons and handles closing.
   * Gathers information on amount of players, player names, player initiatives, and challenge
   * rating.
   */
  public EncGUI() {
    setContentPane(contentPane);
    setModal(true);
    // getRootPane().setDefaultButton(randomEncounter);

    int playerCount = 0;
    // Asks the user for the amount of players for the encounter and saves it as playerCount
    while (1 == 1) {
      // Makes sure the player amount is an integer greater than 1
      try {
        playerCount = Integer.parseInt(JOptionPane.showInputDialog("How many players"));
        if (playerCount < 1) {
          JOptionPane.showMessageDialog(null, "Please enter an amount greater than 0");
        } else {
          break;
        }
      } catch (Exception ex) {
        JOptionPane.showMessageDialog(null, "Please enter an integer");
      }
    }
    
    // List of player names
    playerList = new String[playerCount];
    // List of player initiatives
    initList = new int[playerCount];
    int curInit = 0;

    // Gets the name and initiative of the players
    for (int i = 0; i < playerCount; ++i) {
      playerList[i] = JOptionPane.showInputDialog("Name of player " + (i + 1));
      while (1 == 1) {
        // Makes sure initiative is an integer greater than 0
        try {
          curInit = Integer.parseInt(JOptionPane.showInputDialog(playerList[i] + "'s initiative"));
          if (curInit < 1) {
            JOptionPane.showMessageDialog(null, "Please enter an amount greater than 0");
          } else {
            break;
          }
        } catch (Exception ex) {
          JOptionPane.showMessageDialog(null, "Please enter an integer");
        }
      }
      initList[i] = curInit;
      curInit = 0;
    }

    InitialMonsters initialMonsters = new InitialMonsters();
    // Sets size to slightly smaller than main window
    initialMonsters.setPreferredSize(new Dimension(500, 400));
    initialMonsters.pack();
    // Places window in center of screen
    initialMonsters.setLocationRelativeTo(null);
    initialMonsters.setVisible(true);

    // Gets monster IDs and CRs from initialMonster form
    int[] initID = new int[initialMonsters.getIdList().size()];
    double[] initCR = new double[initialMonsters.getCrList().size()];

    for (int i = 0; i < initialMonsters.getIdList().size(); ++i) {
      initID[i] = initialMonsters.getIdList().get(i);
    }

    for (int j = 0; j < initialMonsters.getCrList().size(); ++j) {
      initCR[j] = initialMonsters.getCrList().get(j);
    }

    enc = new Encounter(playerList, initList, initID, initCR);

    /*String[] options = {"Kobold","Bandit","Flying Snake","Dolphin"};
    try{
      enc.addMonster(JOptionPane.showInputDialog(null,"Choose a Monster",
              "Monster List", JOptionPane.QUESTION_MESSAGE, null, options, options[0]));
    }catch(Exception ex){

    }*/

    // call onCancel() when cross is clicked
    setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
    addWindowListener(new WindowAdapter() {
      public void windowClosing(WindowEvent e) {
        onCancel();
      }
    });

    // call onCancel() on ESCAPE
    contentPane.registerKeyboardAction(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        onCancel();
      }
    }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0),
        JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);



    //Action listener for the add character button that adds a new tab to the initiative tracker

    /*randomEncounter.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent actionEvent) {

        //were going to use our already coded dice roller for our rng
        DiceRoll r = new DiceRoll();
        //we create a new encounter with d6 monsters and d4 players
        enc = new Encounter(r.rollD6(), r.rollD4());

        for (int i = 0; i < enc.initiative.size(); i++) {
          update();
          /*String info = "Name: " + enc.initiative.get(i).getName() + "\n ";
          info += "Health: " + enc.initiative.get(i).getHealth() + "\n ";
          info += "ArmorClass: " + enc.initiative.get(i).getArmorClass() + "\n ";
          info += "Initiative: " + enc.initiative.get(i).getInitiative() + "\n";
          initTracker.addTab(enc.initiative.get(i).getName(), new JTextArea(info));
        }

        //initTracker.addTab("New Char", new JLabel("New Character"));
      }
    });*/


    // Adds monster from a list
    addFromList.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        monsterID = monsterList.getSelectedIndex();
        enc.addMonster(monsterID);
        /*String info = "Name: " + enc.initiative.get(enc.initiative.size()-1).getName() + "\n ";
        info += "Health: " + enc.initiative.get(enc.initiative.size()-1).getHealth() + "\n ";
        info += "ArmorClass: " +
        enc.initiative.get(enc.initiative.size()-1).getArmorClass() + "\n ";
        info += "Initiative: " +
        enc.initiative.get(enc.initiative.size()-1).getInitiative() + "\n";
        initTracker.addTab(enc.initiative.get(enc.initiative.size()-1).getName(),
        new JTextArea(info));*/
        update();
      }
    });

    // Adds monsters according to challenge rating
    addFromChallengeRatingButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        try {
          // Ensures monster is a double between 0.125 and 15
          if (Double.parseDouble(challengeRating.getText()) < 0.125
              || Double.parseDouble(challengeRating.getText()) > 15) {
            JOptionPane.showMessageDialog(null, "Please enter an amount between 0.125 and 15");
          } else {
            desiredCR = Double.parseDouble(challengeRating.getText());
            enc.addMonsterCR(desiredCR);
            update();
          }
        } catch (Exception ex) {
          JOptionPane.showMessageDialog(null, "Please enter a valid challenge rating");
        }
      }
    });

    // Removes the active tab from the initiative tracker
    removeCurrentCharacterButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        try {
          int index = initTracker.getSelectedIndex();
          initTracker.removeTabAt(index);
          enc.removeChar(index);

        } catch (Exception ex) {
          throw new IllegalArgumentException("unable to perform action");
        }
      }
    });
    
    // Closes the encounter
    endButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        onCancel();
      }
    });
    
    // Advances the initiative
    nextButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        enc.nextTurn();
        update();
      }
    });
    update();
  }

  /*
   * Sets up a tab for the character in the initiative tracker
   */

  /**
   * Closes the window.
   */
  private void onCancel() {
    dispose();
  }

  /**
   * Main method. Initializes the menu and makes it visible.
   *
   * @param args main argument
   */
  public static void main(String[] args) {
    EncGUI dialog = new EncGUI();
    dialog.setPreferredSize(new Dimension(700, 600));
    dialog.pack();
    dialog.setLocationRelativeTo(null);
    dialog.setVisible(true);


    //were going to use our already coded dice roller for our rng
    DiceRoll r = new DiceRoll();
    //we create a new encounter with d6 monsters and d4 players
    Encounter e = new Encounter(r.rollD6(), r.rollD4());

    //we then add all of these monsters and players into the jTabbedPane
    for (int i = 0; i < e.initiative.size(); i++) {

      /*String info = "Name: " + e.initiative.get(i).getName() + "\n";
      info += "Health: " + e.initiative.get(i).getHealth() + "\n";
      info += "ArmorClass: " + e.initiative.get(i).getArmorClass() + "\n";
      info += "Initiative: " + e.initiative.get(i).getInitiative() + "\n";

      dialog.initTracker.addTab(e.initiative.get(i).getName(), new JTextArea(info));
      */
    }


    System.exit(0);
  }

  /*
  * Clears the initTracker and displays all the relative information of the encounter dependent on 
  * the type of character (monsters have more info like challenge rating and exp
  */
  private void update() {
    // Clears the tracker
    initTracker.removeAll();
    for (int i = 0; i < enc.initiative.size(); ++i) {
      String info = "Name: " + enc.initiative.get(i).getName() + "\n";
      info += "Health: " + enc.initiative.get(i).getHealth() + "\n";
      info += "ArmorClass: " + enc.initiative.get(i).getArmorClass() + "\n";
      info += "Initiative: " + enc.initiative.get(i).getInitiative() + "\n";
      if (enc.initiative.get(i).getChallengeRating() != -1) {
        info += "Challenge Rating: " + enc.initiative.get(i).getChallengeRating() + "\n";
      }
      if (enc.initiative.get(i).getXp() != -1) {
        info += "Exp: " + enc.initiative.get(i).getXp();
      }

      initTracker.addTab(enc.initiative.get(i).getName(), new JTextArea(info));
    }
  }
}

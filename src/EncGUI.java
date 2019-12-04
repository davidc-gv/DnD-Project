import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.*;

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
  private JButton addCharacterButton;
  private JTabbedPane initTracker;
  private JComboBox monsterList;
  private JButton addFromList;
  private JButton addFromChallengeRatingButton;
  private JTextField challengeRating;
  private JButton removeCurrentCharacterButton;
  private Encounter e;
  private String[] playerList;
  private int[] initList;
  private int monsterID;
  private double desiredCR;


  /**
   * Constructor for the encounter GUI. Adds event listeners to the buttons and handles closing.
   * Gathers information on amount of players, player names, player initiatives, and challenge rating
   */
  public EncGUI() {
    setContentPane(contentPane);
    setModal(true);
    getRootPane().setDefaultButton(addCharacterButton);

    int playerCount = 0;
    // Asks the user for the amount of players for the encounter and saves it as playerCount
    while(1==1) {
      try {
        playerCount = Integer.parseInt(JOptionPane.showInputDialog("How many players"));
        if(playerCount < 1){
          JOptionPane.showMessageDialog(null, "Please enter an amount greater than 0");
        }
        else {
          break;
        }
      } catch (Exception ex) {
        JOptionPane.showMessageDialog(null, "Please enter an integer");
      }
    }

    playerList = new String[playerCount];
    initList = new int[playerCount];
    int curInit = 0;
    //Gets the name and initiative of the players
    for(int i = 0; i < playerCount; ++i){
      playerList[i] = JOptionPane.showInputDialog("Name of player " + (i+1));
      while(1==1) {
        try {
          curInit = Integer.parseInt(JOptionPane.showInputDialog(playerList[i] + "'s initiative"));
          if(curInit < 1){
            JOptionPane.showMessageDialog(null, "Please enter an amount greater than 0");
          }
          else {
            break;
          }
        } catch (Exception ex) {
          JOptionPane.showMessageDialog(null, "Please enter an integer");
        }
      }
      initList[i] = curInit;
      curInit = 0;
    }

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

    addCharacterButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent actionEvent) {

        //were going to use our already coded dice roller for our rng
        DiceRoll r = new DiceRoll();
        //we create a new encounter with d6 monsters and d4 players
        Encounter e = new Encounter(r.rollD6(), r.rollD4());

        for (int i = 0; i < e.initiative.length; i++) {

          String info = "Name: " + e.initiative[i].getName() + "\n ";
          info += "Health: " + e.initiative[i].getHealth() + "\n ";
          info += "ArmorClass: " + e.initiative[i].getArmorClass() + "\n ";
          info += "Initiative: " + e.initiative[i].getInitiative() + "\n";
          initTracker.addTab(e.initiative[i].getName(), new JTextArea(info));
        }

        //initTracker.addTab("New Char", new JLabel("New Character"));
      }
    });

    // Adds monster from a list
    addFromList.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        monsterID = monsterList.getSelectedIndex();
        Monster monster = new Monster(monsterID);
        String info = "Name: " + monster.getName() + "\n ";
        info += "Health: " + monster.getHealth() + "\n ";
        info += "ArmorClass: " + monster.getArmorClass() + "\n ";
        info += "Initiative: " + monster.getInitiative() + "\n";
        initTracker.addTab(monster.getName(), new JTextArea(info));
      }
    });

    // Adds monsters according to challenge rating
    addFromChallengeRatingButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        try {
          if(Double.parseDouble(challengeRating.getText()) < 0.25){
            JOptionPane.showMessageDialog(null, "Please enter an amount greater than 1/4");
          }
          else{
            desiredCR = Double.parseDouble(challengeRating.getText());
          }
        } catch (Exception ex) {
          JOptionPane.showMessageDialog(null, "Please enter a number");
        }
      }
    });

    // Removes the active tab from the initiative tracker
    removeCurrentCharacterButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        try{
          initTracker.removeTabAt(initTracker.getSelectedIndex());
        }catch(Exception ex){

        }
      }
    });
  }

  /**
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
   * @param args
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
    for (int i = 0; i < e.initiative.length; i++) {

      String info = "Name: " + e.initiative[i].getName() + "\n";
      info += "Health: " + e.initiative[i].getHealth() + "\n";
      info += "ArmorClass: " + e.initiative[i].getArmorClass() + "\n";
      info += "Initiative: " + e.initiative[i].getInitiative() + "\n";

      dialog.initTracker.addTab(e.initiative[i].getName(), new JLabel(info));
    }


    System.exit(0);
  }

  public String[] getPlayerList() {
    return playerList;
  }

  public int[] getInitList() {
    return initList;
  }

  public int getMonsterID() {
    return monsterID;
  }

  public double getDesiredCR() {
    return desiredCR;
  }
}

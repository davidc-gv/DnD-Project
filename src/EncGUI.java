import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
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
  private JButton addCharacterButton;
  private JTabbedPane initTracker;
  private Encounter e;

  /**
   * Constructor for the encounter GUI. Adds event listeners tot he buttons and handles closing
   */
  public EncGUI() {
    setContentPane(contentPane);
    setModal(true);
    getRootPane().setDefaultButton(addCharacterButton);

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
          initTracker.addTab(e.initiative[i].getName(), new JLabel(info));
        }

        //initTracker.addTab("New Char", new JLabel("New Character"));
      }
    });
  }

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

      dialog.initTracker.addTab(e.initiative[i].getName(), new JLabel(info));
    }


    System.exit(0);
  }
}

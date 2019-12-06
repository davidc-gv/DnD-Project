import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.*;

/**
 * Dialog that serves as the GUI for the loot generation system. Displays loot generated from 
 * given challenge ratings
 *
 * @author Andrew Langley
 */

public class LootMenu extends JDialog {
  private JPanel contentPane;
  private JButton generateButton;
  private JButton leaveButton;
  private JLabel generatedLoot;
  private JTextField challengeRating;
  private JButton enterButton;
  private JLabel crDisplay;
  private JLabel gold;

  /**
   * Constructor for the loot menu. Adds action listeners to the buttons and handles closing
   */
  public LootMenu() {
    setContentPane(contentPane);
    setModal(true);
    getRootPane().setDefaultButton(generateButton);

    // Simply updates the challenge rating
    enterButton.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        // Ensures that the challenge rating is an integer between 1 and 100
        try {
          if(Integer.parseInt(challengeRating.getText()) < 1 || Integer.parseInt(challengeRating.getText()) > 100){
            JOptionPane.showMessageDialog(null, "Please enter an amount between 1 and 100");
          }
          else{
            crDisplay.setText("CR:  " + Integer.parseInt(challengeRating.getText()));
          }
        } catch (Exception ex) {
          JOptionPane.showMessageDialog(null, "Please enter a valid challenge rating");
        }
        /*int cr = Integer.parseInt(challengeRating.getText());
        crDisplay.setText("CR:  " + Integer.toString(cr));*/
      }
    });

    // Generates the loot 
    generateButton.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        onGenerate();
      }
    });


    //Event listener for the leave button

    leaveButton.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        onLeave();
      }
    });

    // call onCancel() when cross is clicked
    setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
    addWindowListener(new WindowAdapter() {
      public void windowClosing(WindowEvent e) {
        onLeave();
      }
    });

    // call onCancel() on ESCAPE
    contentPane.registerKeyboardAction(new ActionListener() {
                                         public void actionPerformed(ActionEvent e) {
                                           onLeave();
                                         }
                                       }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0),
            JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
  }

  /**
   * Generates loot using the loot class and displays the results.
   */
  private void onGenerate() {
    Loot loot = new Loot();
    // Ensures that the challenge rating is an integer between 1 and 100
    try {
      if(Integer.parseInt(challengeRating.getText()) < 1 || Integer.parseInt(challengeRating.getText()) > 100){
        JOptionPane.showMessageDialog(null, "Please enter an amount between 1 and 100");
      }
      else{
        crDisplay.setText("CR:  " + Integer.parseInt(challengeRating.getText()));
        int cr = Integer.parseInt(challengeRating.getText());
        generatedLoot.setText(loot.itemType(cr));
        gold.setText("Gold: " + loot.goldAmount(cr));
      }
    } catch (Exception ex) {
      JOptionPane.showMessageDialog(null, "Please enter a valid challenge rating");
    }
  }


  /**
   * Closes the window.
   */
  private void onLeave() {
    dispose();
  }

  /**
   * Main method. Initializes the menu and makes it visible
   *
   * @param args main argument.
   */
  public static void main(String[] args) {
    LootMenu dialog = new LootMenu();
    dialog.pack();
    dialog.setVisible(true);
    System.exit(0);
  }

}

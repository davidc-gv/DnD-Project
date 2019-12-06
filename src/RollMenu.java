import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Scanner;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.KeyStroke;

/**
 * Dialog that serves as the GUI for rolling dice.
 * It is opened when called by the appropriate button on the main page.
 * Allows for rolling of suggested and custom dice.
 *
 * @author Andrew Langley
 */

public class RollMenu extends JDialog {
  private JPanel contentPane;
  private JButton rollButton;
  private JButton leaveButton;
  private JLabel rollResult;
  private JPanel radioHolder;
  private JButton d20;
  private JTextField diceCount;
  private JTextField dieType;
  /*private JButton d10;
  private JButton d12;
  private JButton d8;
  private JButton d6;
  private JButton d4;*/

  /**
   * Constructor for the menu. Adds action listeners to the buttons and handles closing
   */
  public RollMenu() {
    setContentPane(contentPane);
    setModal(true);
    getRootPane().setDefaultButton(rollButton);

    // Uses custom parameters to roll
    rollButton.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        onRoll();
      }
    });

    /* Event listener for the leave button */
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
    ActionListener listener = new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent actionEvent) {

      }
    };

    // Creates instance of Dice_Roll
    DiceRoll dice_roll = new DiceRoll();

    // Rolls dice respective to button pressed
    d20.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        rollResult.setText("" + dice_roll.rollD20());
      }
    });
    /* d10.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
       rollResult.setText("" + dice_roll.rollD10());
      }
     });
     d12.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        rollResult.setText("" + dice_roll.rollD12()); // TYPO ************************
      }
     });
     d8.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        rollResult.setText("" + dice_roll.rollD8());
      }
     });
     d6.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        rollResult.setText("" + dice_roll.rollD6());
      }
     });
     d4.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        rollResult.setText("" + dice_roll.rollD4());
      }
     });*/
  }

  /**
   * Takes user data from diceCount and dieType to call the
   * customRoll method of a DiceRoll object and
   * puts the resulting value in rollResult. Errors are displayed in rollResult
   */
  private void onRoll() {
    // Values passed by user using diceCount and dieType
    int dCount;
    int dType;
    // Creates new DiceRoll object
    DiceRoll dice_roll = new DiceRoll();
    // Attempts to fetch integer values from diceCount and dieType
    try {
      dCount = Integer.parseInt(diceCount.getText());
      dType = Integer.parseInt(dieType.getText());
    } catch (Exception e) {
      rollResult.setText("Please only use integers greater than 1");
      return;
    }
    // Gets the sum of rolls as desired
    int resultingSum = dice_roll.customRoll(dCount, dType);
    // Checks if the roll returns an error (-1 is passed) and displays it in rollResult
    if (resultingSum == -1) {
      rollResult.setText("Please only use integers greater than 1");
    } else {
      // Shows the resulting value in rollResult
      rollResult.setText("" + resultingSum);
    }
  }

  /**
   * Closes the window.
   */
  private void onLeave() {
    dispose();
  }

  /**
   * Main method. Initializes the menu and makes it visible.
   *
   * @param args main argument.
   */
  public static void main(String[] args) {
    RollMenu dialog = new RollMenu();
    dialog.pack();
    dialog.setVisible(true);
    System.exit(0);
  }
}

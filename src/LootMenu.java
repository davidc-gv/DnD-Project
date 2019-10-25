import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.KeyStroke;

/**
 * Dialog that serves as the GUI for the loot generation system. Displays one generated
 * item for right now. Details to be expanded upon****
 *
 * @author Andrew Langley
 */

public class LootMenu extends JDialog {
  private JPanel contentPane;
  private JButton generateButton;
  private JButton leaveButton;
  private JLabel generatedLoot;

  /**
   * Constructor for the loot menu. Adds action listeners to the buttons and handles closing
   */
  public LootMenu() {
    setContentPane(contentPane);
    setModal(true);
    getRootPane().setDefaultButton(generateButton);

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
    generatedLoot.setText(loot.itemType() + " with " + loot.itemModifier());
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
   * @param args
   */
  public static void main(String[] args) {
    LootMenu dialog = new LootMenu();
    dialog.pack();
    dialog.setVisible(true);
    System.exit(0);
  }

}

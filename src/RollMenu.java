import javax.swing.*;
import java.awt.event.*;

/**
 * Dialog that serves as the GUI for rolling dice. It is opened when called by the appropriate button on the main page.
 * Allows for rolling of suggested and custom dice.
 *
 * @author Andrew Langley
 */

public class RollMenu extends JDialog {
    private JPanel contentPane;
    private JButton rollButton;
    private JButton leaveButton;

    /**
     * Constructor for the menu. Adds action listeners to the buttons and handles closing
     */
    public RollMenu() {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(rollButton);

        /** Event listener for the roll button */
        rollButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onRoll();
            }
        });

        /** Event listener for the leave button */
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
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
    }

    /**
     * Rolls selected dice and displays outcome using the dice roll class
     */
    private void onRoll() {
    }

    /**
     * Closes the window.
     */
    private void onLeave() {
        dispose();
    }

    /**
     * Main method. Initializes the menu and makes it visible.
     * @param args
     */
    public static void main(String[] args) {
        RollMenu dialog = new RollMenu();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }
}

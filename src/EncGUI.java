import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * Dialog that serves as the encounter tracker GUI. Allows the the cycling and adding to a tabbed pane that serves
 * as the initiative tracker. Each tab represents a character and displays the appropriate stat block
 *
 * @author Andrew Langley
 */

public class EncGUI extends JDialog {
    private JFrame frame;
    private JPanel contentPane;
    private JButton addCharacterButton;
    private JTabbedPane initTracker;

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
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);

        /**
         * Action listener for the add character button that adds a new tab to the initiative tracker
         */
        addCharacterButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                initTracker.addTab("New Char", new JLabel("New Char"));
                Dice_Roll r = new Dice_Roll();
                Encounter e = new Encounter(r.rollD6(), r.rollD4());
            }
        });
    }

    /**
     * Closes the window
     */
    private void onCancel() {
        dispose();
    }

    /**
     * Main method. Initializes the menu and makes it visible
     * @param args
     */
    public static void main(String[] args) {
        EncGUI dialog = new EncGUI();
        dialog.setPreferredSize(new Dimension(700, 600));
        dialog.pack();
        dialog.setLocationRelativeTo(null);
        dialog.setVisible(true);
        System.exit(0);
    }
}

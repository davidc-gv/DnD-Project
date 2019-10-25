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
    private JLabel rollResult;
    private JPanel radioHolder;
    private JButton d20;
    private JButton d10;
    private JButton d12;
    private JButton d8;
    private JButton d6;
    private JButton d4;

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
        ActionListener listener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

            }
        };

        // Creates instance of Dice_Roll
        Dice_Roll dice_roll = new Dice_Roll();

        // Rolls dice respective to button pressed
        d20.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                rollResult.setText(""+dice_roll.rollD20());
            }
        });
        d10.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                rollResult.setText(""+dice_roll.rollD10());
            }
        });
        d12.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                rollResult.setText(""+dice_roll.rollD12()); // TYPO ************************
            }
        });
        d8.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                rollResult.setText(""+dice_roll.rollD8());
            }
        });
        d6.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                rollResult.setText(""+dice_roll.rollD6());
            }
        });
        d4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                rollResult.setText(""+dice_roll.rollD4());
            }
        });
    }

    /**
     * Does nothing at this point in time
     * #Rolls selected dice and displays outcome using the dice roll class
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
     *
     * @param args
     */
    public static void main(String[] args) {
        RollMenu dialog = new RollMenu();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }
}

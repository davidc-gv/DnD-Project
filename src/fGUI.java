import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * GUI for the main page. All functionality stems from this first page. Opens dialog for respective functions
 * on respective button presses
 *
 * @author Andrew Langley
 */

public class fGUI {
    private JButton generateEncounterButton;
    private JPanel Main;
    private JButton generateLootButton;
    private JButton rollDiceButton;
    private JLabel mainLabel;

    /**
     * Main method. Initializes GUI and makes it visible
     * @param args
     */
    public static void main(String[] args) {
        JFrame frame = new JFrame("fGUI");
        frame.setContentPane(new fGUI().Main);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // Sets size for the main window
        frame.setPreferredSize(new Dimension(800, 700));
        frame.pack();
        // Centers GUI on startup
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    /**
     * Constructor for the GUI. Adds event listeners to all the buttons
     */
    public fGUI() {
        /**
         * Opens the encounter generator GUI
         */
        generateEncounterButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                EncGUI encGUI = new EncGUI();
                // Sets size to slightly smaller than main window
                encGUI.setPreferredSize(new Dimension(700, 600));
                encGUI.pack();
                // Places window in center of screen
                encGUI.setLocationRelativeTo(null);
                encGUI.setVisible(true);
            }
        });
        /**
         * Opens the dice roll menu
         */
        rollDiceButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                RollMenu rollMenu = new RollMenu();
                // Sets size to slightly smaller than main window
                rollMenu.setPreferredSize(new Dimension(700, 600));
                rollMenu.pack();
                // Places window in center of screen
                rollMenu.setLocationRelativeTo(null);
                rollMenu.setVisible(true);
            }
        });
        /**
         * Opens the loot generation menu
         */
        generateLootButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                LootMenu lootMenu = new LootMenu();
                // Sets size to slightly smaller than main window
                lootMenu.setPreferredSize(new Dimension(700, 600));
                lootMenu.pack();
                // Places window in center of screen
                lootMenu.setLocationRelativeTo(null);
                lootMenu.setVisible(true);
            }
        });

        /*testButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                TestPanel testPanel = new TestPanel();
            }
        });*/
    }
}

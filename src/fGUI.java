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

public class FGUI {
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
        frame.setContentPane(new FGUI().Main);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(800, 700));
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    /**
     * Constructor for the GUI. Adds event listeners to all the buttons
     */
    public FGUI() {
        /**
         * Opens the encounter generator GUI
         */
        generateEncounterButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                EncGUI encGUI = new EncGUI();
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
                lootMenu.setVisible(true);
            }
        });
    }
}

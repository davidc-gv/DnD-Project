import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class fGUI {
    private JTextField mainPageTextField;
    private JButton generateEncounterButton;
    private JPanel Main;
    private JButton generateLootButton;
    private JButton rollDiceButton;

    public static void main(String[] args) {
        JFrame frame = new JFrame("fGUI");
        frame.setContentPane(new fGUI().Main);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    public fGUI() {
        generateEncounterButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

            }
        });
    }
}

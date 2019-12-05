import javax.swing.*;

public class initialMonsters extends JDialog {
    private JPanel contentPane;
    private JComboBox comboBox1;
    private JTextField challengeRating;
    private JButton fromList;
    private JButton fromCR;
    private JButton doneButton;

    public initialMonsters() {
        setContentPane(contentPane);
        setModal(true);
    }

    public static void main(String[] args) {
        initialMonsters dialog = new initialMonsters();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }
}

import javax.swing.*;
import java.awt.event.*;

public class EncGUI extends JDialog {
    private JPanel contentPane;
    private JButton addCharacterButton;
    private JTabbedPane initTracker;
    private JButton buttonCancel;

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
        addCharacterButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                initTracker.addTab("New Char", new JLabel("New Char"));
            }
        });
    }

    private void onOK() {
        // add your code here
        dispose();
    }

    private void onCancel() {
        // add your code here if necessary
        dispose();
    }

    public static void main(String[] args) {
        EncGUI dialog = new EncGUI();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }
}

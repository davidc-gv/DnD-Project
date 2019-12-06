import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

class InitialMonsters extends JDialog {
    private JPanel contentPane;
    private JComboBox monsterList;
    private JTextField challengeRating;
    private JButton fromList;
    private JButton fromCR;
    private JButton doneButton;

    private ArrayList<Integer> idList;
    private ArrayList<Double> crList;

    public InitialMonsters() {
        setContentPane(contentPane);
        setModal(true);
        idList = new ArrayList<Integer>(0);
        crList = new ArrayList<Double>(0);

        fromList.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                idList.add(monsterList.getSelectedIndex());
            }
        });

        fromCR.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if(Double.parseDouble(challengeRating.getText()) < 0.125 || Double.parseDouble(challengeRating.getText()) > 15){
                        JOptionPane.showMessageDialog(null, "Please enter an amount between 0.125 and 15");
                    }
                    else{
                        crList.add(Double.parseDouble(challengeRating.getText()));
                    }
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Please enter a valid challenge rating");
                }
            }
        });

        doneButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
    }


    public static void main(String[] args) {
        InitialMonsters dialog = new InitialMonsters();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }

    public ArrayList<Integer> getIdList() {
        return idList;
    }

    public ArrayList<Double> getCrList() {

        return crList;
    }
}

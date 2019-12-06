import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * Asks the user for the initial monsters to be added either by ID or by challenge rating. Displayed before encounter is
 * generated
 *
 * @author Andrew Langley
 */
class InitialMonsters extends JDialog {
  private JPanel contentPane;
  private JComboBox monsterList;
  private JTextField challengeRating;
  private JButton fromList;
  private JButton fromCR;
  private JButton doneButton;

  // Lists containing the ids and crs to be passed to the encounter
  private ArrayList<Integer> idList;
  private ArrayList<Double> crList;

  /**
   * Constructor that initializes the lists and contains the action listeners for all the buttons
   */
  public InitialMonsters() {
    setContentPane(contentPane);
    setModal(true);
    idList = new ArrayList<Integer>(0);
    crList = new ArrayList<Double>(0);

    // Saves the id of the selected monster to the id list
    fromList.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        idList.add(monsterList.getSelectedIndex());
      }
    });

    // Saves the challenge rating as specified as the user if valid
    fromCR.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        // Ensures the CR is between 0.125 and 15
        try {
          if (Double.parseDouble(challengeRating.getText()) < 0.125
              || Double.parseDouble(challengeRating.getText()) > 15) {
            JOptionPane.showMessageDialog(null, "Please enter an amount between 0.125 and 15");
          } else {
            crList.add(Double.parseDouble(challengeRating.getText()));
          }
        } catch (Exception ex) {
          JOptionPane.showMessageDialog(null, "Please enter a valid challenge rating");
        }
      }
    });

    // Closes the initial form and resumes the encounter generation
    doneButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        dispose();
      }
    });
  }

  /**
   * Main method that handles the dialog creation
   *
   * @param args main argument
   */
  public static void main(String[] args) {
    InitialMonsters dialog = new InitialMonsters();
    dialog.pack();
    dialog.setVisible(true);
    System.exit(0);
  }

  /**
   * Getter for idList
   */
  public ArrayList<Integer> getIdList() {
    return idList;
  }

  /**
   * Getter for the crList
   */
  public ArrayList<Double> getCrList() {

    return crList;
  }
}

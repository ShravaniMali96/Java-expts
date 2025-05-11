import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GenderSelectionGUI {

    public static void main(String[] args) {
        JFrame frame = new JFrame("Gender Selection");
        frame.setSize(300, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout());

        JLabel label = new JLabel("Select Gender:");
        frame.add(label);

        JRadioButton maleButton = new JRadioButton("Male");
        JRadioButton femaleButton = new JRadioButton("Female");

        ButtonGroup group = new ButtonGroup();
        group.add(maleButton);
        group.add(femaleButton);

        frame.add(maleButton);
        frame.add(femaleButton);

        JButton submitButton = new JButton("Submit");
        frame.add(submitButton);

        JLabel resultLabel = new JLabel("Selected Gender: ");
        frame.add(resultLabel);

        submitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (maleButton.isSelected()) {
                    resultLabel.setText("Selected Gender: Male");
                } else if (femaleButton.isSelected()) {
                    resultLabel.setText("Selected Gender: Female");
                } else {
                    resultLabel.setText("Selected Gender: None");
                }
            }
        });

        frame.setVisible(true);
    }
}

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class ReverseNumberGUI extends JFrame {
    private JTextField inputField;
    private JButton reverseButton;
    private JLabel resultLabel;
    public ReverseNumberGUI() {
        setTitle("Reverse Number");
        setSize(300, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        JLabel inputLabel = new JLabel("Enter number:");
        inputLabel.setBounds(20, 20, 100, 25);
        add(inputLabel);
        inputField = new JTextField();
        inputField.setBounds(120, 20, 140, 25);
        add(inputField);
        reverseButton = new JButton("Reverse");
        reverseButton.setBounds(90, 50, 100, 30);
        add(reverseButton);
        resultLabel = new JLabel("Reversed: ");
        resultLabel.setBounds(20, 90, 250, 25);
        add(resultLabel);
        reverseButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    int number = Integer.parseInt(inputField.getText());
                    int reversed = 0;
                    while (number != 0) {
                        int digit = number % 10;
                        reversed = reversed * 10 + digit;
                        number /= 10;
                    }
                    resultLabel.setText("Reversed: " + reversed);
                } catch (NumberFormatException ex) {
                    resultLabel.setText("Invalid input.");
                }
            }
        });
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            ReverseNumberGUI frame = new ReverseNumberGUI();
            frame.setVisible(true);
        });
    }
}

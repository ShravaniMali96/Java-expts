import java.applet.Applet;
import java.awt.*;
import java.awt.event.*;
public class FactorialApplet extends Applet implements ActionListener {
    TextField inputField;
    Button calcButton;
    Label resultLabel;
    public void init() {
        setLayout(new FlowLayout());
        add(new Label("Enter a number:"));
        inputField = new TextField(10);
        add(inputField);
        calcButton = new Button("Calculate Factorial");
        add(calcButton);
        calcButton.addActionListener(this);
        resultLabel = new Label("Result: ");
        add(resultLabel);
    }
    public void actionPerformed(ActionEvent e) {
        try {
            int num = Integer.parseInt(inputField.getText());
            long fact = 1;
            for (int i = 1; i <= num; i++) {
                fact *= i;
            }
            resultLabel.setText("Result: " + fact);
        } catch (NumberFormatException ex) {
            resultLabel.setText("Invalid Input");
        }
    }
}

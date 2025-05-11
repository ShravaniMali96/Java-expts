import java.awt.*;
import java.awt.event.*;
import java.text.DecimalFormat;
import javax.swing.*;
public class Calculator extends JFrame implements ActionListener {
    JTextField t1;
    double num1 = 0, num2 = 0, result = 0;
    String operator;
    public Calculator() {    
        setTitle("Swing Calculator");
        setSize(400, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        t1 = new JTextField();
        t1.setBounds(30, 40, 320, 40);
        t1.setEditable(false);
        t1.setFont(new Font("Arial", Font.BOLD, 18));
        add(t1);
        String[] buttons = {
            "7", "8", "9", "/", "√",
            "4", "5", "6", "*", "%",
            "1", "2", "3", "-", "x²",
            "0", ".", "=", "+", "x³",
            "C"
        };
        int x = 30, y = 100;
        for (int i = 0; i < buttons.length; i++) {
            JButton button = new JButton(buttons[i]);
            button.setBounds(x, y, 60, 40);
            button.setFont(new Font("Arial", Font.BOLD, 14));
            button.addActionListener(this);
            add(button);
            x += 70;
            if ((i + 1) % 5 == 0) {
                x = 30;
                y += 50;
            }
        }
        setVisible(true);
    }
    public void actionPerformed(ActionEvent e){
        String input = e.getActionCommand();
        try {
            switch (input) {
                case "C":
                    t1.setText("");
                    num1 = num2 = result = 0;
                    operator = null;
                    break;
                case "+":
                case "-":
                case "*":
                case "/":
                case "%":
                    num1 = Double.parseDouble(t1.getText());
                    operator = input;
                    t1.setText("");
                    break;
                case "=":
                    num2 = Double.parseDouble(t1.getText());
                    switch (operator) {
                        case "+": result = num1 + num2; break;
                        case "-": result = num1 - num2; break;
                        case "*": result = num1 * num2; break;
                        case "/": result = num2 != 0 ? num1 / num2 : 0; break;
                        case "%": result = num1 % num2; break;
                    }
                    t1.setText(new DecimalFormat("0.#####").format(result));
                    break;
                case "√":
                    num1 = Double.parseDouble(t1.getText());
                    t1.setText(new DecimalFormat("0.#####").format(Math.sqrt(num1)));
                    break;
                case "x²":
                    num1 = Double.parseDouble(t1.getText());
                    t1.setText(new DecimalFormat("0.#####").format(num1 * num1));
                    break;
                case "x³":
                    num1 = Double.parseDouble(t1.getText());
                    t1.setText(new DecimalFormat("0.#####").format(num1 * num1 * num1));
                    break;
                default:
                    t1.setText(t1.getText() + input);
            }
        } catch (Exception ex) {
            t1.setText("Error");
        }
    }
    public static void main(String[] args) {
        new Calculator();
    }
}

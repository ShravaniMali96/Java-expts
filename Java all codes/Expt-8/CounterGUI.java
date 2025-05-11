import javax.swing.*;
import java.awt.*;
public class CounterGUI extends JFrame {
    private JTextField textField;
    private int count = 0;
    public CounterGUI() {
        setTitle("Counter");
        setSize(400, 100);
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        JLabel label = new JLabel("Counter");
        textField = new JTextField("0", 10);
        textField.setEditable(false);
        JButton countUpBtn = new JButton("Count Up");
        JButton countDownBtn = new JButton("Count Down");
        JButton resetBtn = new JButton("Reset");
        countUpBtn.addActionListener(e -> {
            count++;
            textField.setText(String.valueOf(count));
        });
        countDownBtn.addActionListener(e -> {
            count--;
            textField.setText(String.valueOf(count));
        });
        resetBtn.addActionListener(e -> {
            count = 0;
            textField.setText(String.valueOf(count));
        });
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());
        panel.add(label);
        panel.add(textField);
        panel.add(countUpBtn);
        panel.add(countDownBtn);
        panel.add(resetBtn);
        add(panel);
        setVisible(true);
    }
    public static void main(String[] args) {
        new CounterGUI();
    }
}

import javax.swing.*;
import java.awt.*;
public class BorderLayoutConverter extends JFrame {
    private JTextField inputField, resultField;
    private JButton binaryBtn, octalBtn, hexBtn;
    public BorderLayoutConverter() {
        setTitle("Number Converter");
        setSize(400, 200);     
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        JPanel northPanel = new JPanel();
        northPanel.add(new JLabel("Enter the number:"));
        inputField = new JTextField(10);
        northPanel.add(inputField);
        add(northPanel, BorderLayout.NORTH);
        JPanel centerPanel = new JPanel(new GridLayout(1, 3));
        binaryBtn = new JButton("Binary");
        octalBtn = new JButton("Octal");
        hexBtn = new JButton("Hex");
        centerPanel.add(binaryBtn);
        centerPanel.add(octalBtn);
        centerPanel.add(hexBtn);
        add(centerPanel, BorderLayout.CENTER);
        JPanel southPanel = new JPanel();
        southPanel.add(new JLabel("Result:"));
        resultField = new JTextField(15);
        resultField.setEditable(false);
        southPanel.add(resultField);
        add(southPanel, BorderLayout.SOUTH);
        binaryBtn.addActionListener(e -> convert("binary"));
        octalBtn.addActionListener(e -> convert("octal"));
        hexBtn.addActionListener(e -> convert("hex"));
        setVisible(true);
    }
    private void convert(String type) {
        try {
            int number = Integer.parseInt(inputField.getText().trim());
            switch (type) {
                case "binary":                    
                resultField.setText(Integer.toBinaryString(number));
                    break;
                case "octal":                    
                resultField.setText(Integer.toOctalString(number));
                    break;
                case "hex":                    
                resultField.setText(Integer.toHexString(number).toUpperCase());
                    break;
            }
        } catch (NumberFormatException e) {
            resultField.setText("Invalid number");
        }
    }
    public static void main(String[] args) {
        new BorderLayoutConverter();
    }
}

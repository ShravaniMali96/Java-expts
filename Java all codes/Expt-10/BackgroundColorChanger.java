import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class BackgroundColorChanger extends JFrame {
    private JComboBox<String> colorComboBox;
    private JPanel mainPanel;
    public BackgroundColorChanger() {
        setTitle("Background Color Changer");
        setSize(400, 300);    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        String[] colors = {"White", "Red", "Green", "Blue", "Yellow", "Pink", "Gray"};
        colorComboBox = new JComboBox<>(colors);    
        mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        mainPanel.add(colorComboBox, BorderLayout.NORTH);
        add(mainPanel);
        colorComboBox.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String selectedColor = (String) colorComboBox.getSelectedItem();
                switch (selectedColor) {
                    case "Red":                      mainPanel.setBackground(Color.RED);
                        break;
                    case "Green":                        mainPanel.setBackground(Color.GREEN);
                        break;
default:                        mainPanel.setBackground(Color.WHITE);
                }
            }
        });
        setVisible(true);
    }
    public static void main(String[] args) {
        new BackgroundColorChanger();
    }}

import javax.swing.*;
import java.awt.*;
public class FlowLayoutExample extends JFrame {
    public FlowLayoutExample() {
        setTitle("FlowLayout Example");
        setSize(300, 150);        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout(FlowLayout.LEFT, 10, 20));
        JCheckBox javaBox = new JCheckBox("Java");
        JCheckBox pythonBox = new JCheckBox("Python");
        JCheckBox cppBox = new JCheckBox("C++");
        add(javaBox);
        add(pythonBox);
        add(cppBox);
        setVisible(true);
    }
    public static void main(String[] args) {
        new FlowLayoutExample();
    }
}

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class TextAnalyzer extends JFrame {
    private JTextArea textArea;
    private JLabel countLabel;
    public TextAnalyzer() {
        setTitle("Real-Time Text Analyzer");
        setSize(400, 300);   setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        textArea = new JTextArea();
        countLabel = new JLabel("Characters: 0 | Words: 0");
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        add(new JScrollPane(textArea), BorderLayout.CENTER);
        add(countLabel, BorderLayout.SOUTH);
        textArea.addKeyListener(new KeyAdapter() {
            public void keyReleased(KeyEvent e) {
                String text = textArea.getText();
                int charCount = text.length();
                int wordCount = text.trim().isEmpty() ? 0 : text.trim().split("\\s+").length;
                countLabel.setText("Characters: " + charCount + " | Words: " + wordCount);
            }
        });
        setVisible(true);
    }
    public static void main(String[] args) {
        new TextAnalyzer();
    }
}

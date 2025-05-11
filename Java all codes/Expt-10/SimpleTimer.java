import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class SimpleTimer extends JFrame {
    private JLabel timeLabel;
    private JButton startButton, stopButton;
    private Timer timer;
    private int elapsedTime = 0;
    public SimpleTimer() {
        setTitle("Simple Timer");
        setSize(300, 150);   setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());
        timeLabel = new JLabel("Elapsed Time: 0 seconds");
        timeLabel.setFont(new Font("Arial", Font.BOLD, 16));
        startButton = new JButton("Start");
        stopButton = new JButton("Stop");
        add(timeLabel);
        add(startButton);
        add(stopButton);
        timer = new Timer(1000, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                elapsedTime++;
                timeLabel.setText("Elapsed Time: " + elapsedTime + " seconds");
            }
        });
        startButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                timer.start();
            }
        });
        stopButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                timer.stop();
            }
        });
        setVisible(true);
    }
    public static void main(String[] args) {
        new SimpleTimer();
    }
}

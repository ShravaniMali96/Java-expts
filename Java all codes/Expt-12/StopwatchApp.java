import javax.swing.*;
import java.awt.*;
public class StopwatchApp extends JFrame {
    private JLabel timeLabel;
    private JButton startButton, stopButton, resetButton;
    private StopwatchThread stopwatchThread;
    private boolean running = false;
    private int seconds = 0;
    private int minutes = 0;
    private int hours = 0;
    public StopwatchApp() {
        setTitle("Stopwatch");
        setSize(300, 200);        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        timeLabel = new JLabel("00:00:00", SwingConstants.CENTER);
        timeLabel.setFont(new Font("Arial", Font.PLAIN, 40));
        startButton = new JButton("Start");
        stopButton = new JButton("Stop");
        resetButton = new JButton("Reset");
        startButton.addActionListener(e -> startStopwatch());
        stopButton.addActionListener(e -> stopStopwatch());
        resetButton.addActionListener(e -> resetStopwatch());
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(2, 2));
        panel.add(startButton);
        panel.add(stopButton);
        panel.add(resetButton);
        add(timeLabel, BorderLayout.CENTER);
        add(panel, BorderLayout.SOUTH);
    }
    private void startStopwatch() {
        if (!running) {
            stopwatchThread = new StopwatchThread();
            new Thread(stopwatchThread).start();
            running = true;
            startButton.setEnabled(false);
        }
    }
    private void stopStopwatch() {
        running = false;
        startButton.setEnabled(true);
    }
    private void resetStopwatch() {
        running = false;
        seconds = 0;
        minutes = 0;
        hours = 0;        timeLabel.setText(String.format("%02d:%02d:%02d", hours, minutes, seconds));
        startButton.setEnabled(true);
    }
    private class StopwatchThread implements Runnable {
        @Override
        public void run() {
            while (running) {
                try {
                    Thread.sleep(1000);
                    seconds++;
                    if (seconds == 60) {
                        seconds = 0;
                        minutes++;
                    }
                    if (minutes == 60) {
                        minutes = 0;
                        hours++;
                    }
                    timeLabel.setText(String.format("%02d:%02d:%02d", hours, minutes, seconds));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            StopwatchApp app = new StopwatchApp();
            app.setVisible(true);
        });
    }
}

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class MouseCoordinates extends JFrame {
    private JLabel coordinatesLabel;
    public MouseCoordinates() {
        setTitle("Mouse Coordinates Display");
        setSize(400, 300);
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        coordinatesLabel = new JLabel("Move the mouse inside the window");      coordinatesLabel.setHorizontalAlignment(SwingConstants.CENTER);
        coordinatesLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        add(coordinatesLabel, BorderLayout.SOUTH);
        addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseMoved(MouseEvent e) {
                coordinatesLabel.setText("Mouse Coordinates: X = " + e.getX() + ", Y = " + e.getY());
            }
        });
        setVisible(true);
    }
    public static void main(String[] args) {
        new MouseCoordinates();
    }
}

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class GridSwapGame extends JFrame {
    private JButton[] buttons = new JButton[6];
    private JButton firstSelected = null;
    public GridSwapGame() {
        setTitle("GridLayout Swap Example");
        setSize(300, 200);
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(2, 3));
        for (int i = 0; i < 6; i++) {
            buttons[i] = new JButton(String.valueOf(i + 1));
            add(buttons[i]);
            buttons[i].addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    JButton clicked = (JButton) e.getSource();
                    handleSwap(clicked);
                }
            });
        }
        setVisible(true);
    }
    private void handleSwap(JButton clicked) {
        if (firstSelected == null) {
            firstSelected = clicked;
        } else {
            String temp = firstSelected.getText();
            firstSelected.setText(clicked.getText());
            clicked.setText(temp);
            firstSelected = null;
        }
    }
    public static void main(String[] args) {
        new GridSwapGame();
    }
}

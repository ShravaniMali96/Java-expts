import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class BookPerStation extends JFrame implements ActionListener{
    JLabel l1;
    JCheckBox cb1, cb2, cb3;
    JButton b1;
    public BookPerStation(){
        setTitle("Book Station");
        setLayout(new GridLayout(5, 1));
        l1 = new JLabel("Stationary Purchase System");
        cb1 = new JCheckBox("Notebook @ 50");
        cb2 = new JCheckBox("Pen @ 30");
        cb3 = new JCheckBox("Pencil @ 10");
        b1 = new JButton("Order");
        b1.addActionListener(this);
        add(l1);
        add(cb1);
        add(cb2);
        add(cb3);
        add(b1);
        setSize(300, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent e){
        double total = 0;
        StringBuilder details = new StringBuilder();
        if (cb1.isSelected()) {
            String input = JOptionPane.showInputDialog(this, "Enter Quantity for Notebook");
            if (input != null && !input.isEmpty()){
                int qty = Integer.parseInt(input);
                total += 50 * qty;
                details.append("Notebook Quantity: ").append(qty).append("  Total: ").append(50 * qty).append("\n");
            }
        }
        if (cb2.isSelected()){
            String input = JOptionPane.showInputDialog(this, "Enter Quantity for Pen");
            if (input != null && !input.isEmpty()){
                int qty = Integer.parseInt(input);
                total += 30 * qty;
                details.append("Pen Quantity: ").append(qty).append("  Total: ").append(30 * qty).append("\n");
            }
        }
        if (cb3.isSelected()){
            String input = JOptionPane.showInputDialog(this, "Enter Quantity for Pencil");
            if (input != null && !input.isEmpty()){
                int qty = Integer.parseInt(input);
                total += 10 * qty;
                details.append("Pencil Quantity: ").append(qty).append("  Total: ").append(10 * qty).append("\n");
            }
        }
        if (total > 0){
            details.append("--------------------------\n");
            details.append("Total: ").append(total);
            JOptionPane.showMessageDialog(this, details.toString(), "Message", JOptionPane.INFORMATION_MESSAGE);
            JOptionPane.showMessageDialog(this, "Successfully Ordered.", "Alert", JOptionPane.INFORMATION_MESSAGE);
        } 
        else{
            JOptionPane.showMessageDialog(this, "No items selected", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    public static void main(String[] args){
        new BookPerStation();
    }
}

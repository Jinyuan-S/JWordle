package MyInterface;

import javax.swing.*;
import java.awt.*;

public class PopWindow extends JDialog {
    JLabel label = null;
    public PopWindow(JFrame jFrame, String text){
        super(jFrame, "Reminder", true);
        this.setLocationRelativeTo(null);
        this.setSize(200, 100);
        label = new JLabel(text);
        label.setFont(new Font("Serif", Font.BOLD, 20) );
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setVerticalAlignment(JLabel.CENTER);
        Container c = this.getContentPane();
        c.add(label);
    }
}

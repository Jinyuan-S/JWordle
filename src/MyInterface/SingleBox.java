package MyInterface;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;


public class SingleBox extends JLabel {
    private Color bgColor = null;
//    private final Color textColor = Color.BLACK;
    private final Color _yellow = new Color(198, 180, 102);
    private final Color _gray = new Color(121, 124, 126);
    private final Color _green = new Color(121, 167, 107);
    private final Color _borderGray = new Color(212, 214, 218);
    private Border border = null;

    private JLabel jl = null;

    public SingleBox(){
        border = BorderFactory.createLineBorder(_borderGray, 4);  //the initial border color is gray
        bgColor = Color.WHITE ;  //initial color is white
        this.setBorder(border);
        this.setText(" ");
        this.setFont(new Font("SansSerif", Font.BOLD, 30));
        this.setSize(63, 63);
        this.setHorizontalAlignment(JLabel.CENTER);
        this.setVerticalAlignment(JLabel.CENTER);
        this.setBackground(bgColor);
        this.setOpaque(true);  //not transparent
        this.setForeground(Color.BLACK);
//        this.setLayout(new CardLayout(2, 2));
//        jl = new JLabel("A");
//        jl.setFont(new Font("SansSerif", Font.BOLD, 20));
//        jl.setHorizontalAlignment(JLabel.CENTER); //center in horizon
//        jl.setVerticalAlignment(JLabel.CENTER);   //center in vertical
//        jl.setSize(58, 58);
//        jl.setBackground(_yellow);

//        this.add(jl);
    }

    /**
     * To refresh the single box with new string s.
     * @param type the refresh type, 1: incorrect, 2: not in right position, 3: correct
     * @param s the new letter to be present
     */
    public void refresh (int type, String s){
        this.setText(s);
        this._setColor(type);
    }

    /**
     * To refresh the single box.
     * @param type the refresh type, 1: incorrect, 2: not in right position, 3: correct
     */
    public void refresh (int type){
        this._setColor(type);
    }
    private void _setColor(int type){
        this.setForeground(Color.WHITE);
        if (type == 1){     //incorrect --gray
            this.border = BorderFactory.createLineBorder(_gray, 4);
            this.setBorder(border);
            this.setBackground(_gray);
        }else if (type == 2){   //not in right position --yellow
            this.border = BorderFactory.createLineBorder(_yellow, 4);
            this.setBorder(border);
            this.setBackground(_yellow);
        }else{      //correct --green
            this.border = BorderFactory.createLineBorder(_green, 4);
            this.setBorder(border);
            this.setBackground(_green);
        }
    }


}

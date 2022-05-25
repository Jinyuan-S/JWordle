package MyInterface;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonOperator implements ActionListener, Enter{
    JButton enter = null;
//    KeyboardReader k = null;
    LetterBoxes boxes = null;

    public ButtonOperator(JButton jButton, LetterBoxes letterBoxes){
        enter = jButton;
        enter.addActionListener(this);
        boxes = letterBoxes;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
//        jb.setText("hi");
        if (Position.getCol() == LetterBoxes.COLS){
            System.out.println("ready to submit");  //for debug
            Enter.submit(boxes.getRow(Position.getRow()));
            if (Position.getRow() < LetterBoxes.ROWS) {
                Position.setRow((Position.getRow()+1));
                Position.setCol(0);
            }
        }else{
            System.out.println("line not full, enter do nothing");      //for debug
        }
        boxes.requestFocusInWindow();
    }
}

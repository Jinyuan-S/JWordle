package MyInterface;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonOperator implements ActionListener, Enter{
    JButton enter = null;
    LetterBoxes boxes = null;
    WordList wordList = null;
    JFrame fatherFrame = null;

    public ButtonOperator(JButton jButton, LetterBoxes letterBoxes, WordList wordList, JFrame fatherFrame){
        this.enter = jButton;
        enter.addActionListener(this);
        this.boxes = letterBoxes;
        this.wordList = wordList;
        this.fatherFrame = fatherFrame;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
//        jb.setText("hi");
        if (Position.getCol() == LetterBoxes.COLS){
            int flag = Enter.submit(boxes.getRow(Position.getRow()), wordList);
            if (flag == 1){
                Position.setRow(6);
                PopWindow pop = new PopWindow(fatherFrame, "You win!");
                pop.setVisible(true);
            }else if (flag == 0) {
                if (Position.getRow() < LetterBoxes.ROWS) {
                    Position.setRow((Position.getRow()+1));
                    Position.setCol(0);
                }
            }else{
                PopWindow pop = new PopWindow(fatherFrame, "not in wordlist");
                pop.setVisible(true);
            }

        }
        else{
            System.out.println("line not full, enter do nothing");      //for debug
        }
        boxes.requestFocusInWindow();
    }
}

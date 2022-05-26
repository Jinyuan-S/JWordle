/*
 * Copyright 2022 Jinyuan Sun (https://github.com/Jinyuan-S)
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated
 * documentation files (the "Software"), to deal in the Software without restriction, including without limitation the
 * rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to
 * permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the
 * Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE
 * WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS
 * OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR
 * OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.THE
 * SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE
 * WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS
 * OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR
 * OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package JWordle;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * Deal with Mouse click the button.
 * <p>
 *     This class was designed to operate the button.
 * </p>
 *
 * @author Jinyuan Sun
 * @version 1.0
 */
public class ButtonOperator implements MouseListener, Enter{
    JButton enter = null;
    LetterBoxes boxes = null;
    WordList wordList = null;
    JFrame fatherFrame = null;

    /**
     * Initialize a {@code ButtonOperator} instance.
     * @param jButton the button to perform.
     * @param letterBoxes an instance of {@code LetterBoxes}.
     * @param wordList an instance of {@code WordList}.
     * @param fatherFrame an instance of {@code JFrame}, the father frame.
     */
    public ButtonOperator(JButton jButton, LetterBoxes letterBoxes, WordList wordList, JFrame fatherFrame){
        this.enter = jButton;
        enter.addMouseListener(this);
        this.boxes = letterBoxes;
        this.wordList = wordList;
        this.fatherFrame = fatherFrame;
    }

    /**
     * Deal with the mouse click.
     * @param e the event to be processed
     */
    @Override
    public void mouseClicked(MouseEvent e) {
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

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
//        fatherFrame.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
    }

    @Override
    public void mouseExited(MouseEvent e) {
//        fatherFrame.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
    }
}

//public class ButtonOperator implements ActionListener, Enter{
//    JButton enter = null;
//    LetterBoxes boxes = null;
//    WordList wordList = null;
//    JFrame fatherFrame = null;
//
//    /**
//     * Initialize a {@code ButtonOperator} instance.
//     * @param jButton the button to perform.
//     * @param letterBoxes an instance of {@code LetterBoxes}.
//     * @param wordList an instance of {@code WordList}.
//     * @param fatherFrame an instance of {@code JFrame}, the father frame.
//     */
//    public ButtonOperator(JButton jButton, LetterBoxes letterBoxes, WordList wordList, JFrame fatherFrame){
//        this.enter = jButton;
//        enter.addActionListener(this);
//        this.boxes = letterBoxes;
//        this.wordList = wordList;
//        this.fatherFrame = fatherFrame;
//    }
//
//    /**
//     * Deal with the mouse click.
//     * @param e the event to be processed
//     */
//    @Override
//    public void actionPerformed(ActionEvent e) {
////        jb.setText("hi");
//        if (Position.getCol() == LetterBoxes.COLS){
//            int flag = Enter.submit(boxes.getRow(Position.getRow()), wordList);
//            if (flag == 1){
//                Position.setRow(6);
//                PopWindow pop = new PopWindow(fatherFrame, "You win!");
//                pop.setVisible(true);
//            }else if (flag == 0) {
//                if (Position.getRow() < LetterBoxes.ROWS) {
//                    Position.setRow((Position.getRow()+1));
//                    Position.setCol(0);
//                }
//            }else{
//                PopWindow pop = new PopWindow(fatherFrame, "not in wordlist");
//                pop.setVisible(true);
//            }
//
//        }
//        else{
//            System.out.println("line not full, enter do nothing");      //for debug
//        }
//        boxes.requestFocusInWindow();
//    }
//}

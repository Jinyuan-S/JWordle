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
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * Deal with Mouse click the button.
 * <p>
 *     This class was designed to operate the button.
 * </p>
 *
 * @author Jinyuan Sun
 * @version 1.5
 */
public class ButtonOperator implements MouseListener, Enter{
    JButton enter = null;
    int enter_hash = 0;
//    JButton setting = null;
    int setting_hash = 0;
    LetterBoxes boxes = null;
    WordList wordList = null;
    JFrame fatherFrame = null;

    /**
     * Initialize a {@code ButtonOperator} instance.
     * @param jbArray the button array to perform.
     * @param letterBoxes an instance of {@code LetterBoxes}.
     * @param wordList an instance of {@code WordList}.
     * @param fatherFrame an instance of {@code JFrame}, the father frame.
     */
    public ButtonOperator(JButton [] jbArray, LetterBoxes letterBoxes, WordList wordList, JFrame fatherFrame){
        this.enter = jbArray[0];
        enter_hash = jbArray[0].hashCode();
        enter.addMouseListener(this);

//        this.setting = jbArray[1];
//        setting_hash = jbArray[1].hashCode();
//        setting.addMouseListener(this);
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
        int src = e.getSource().hashCode();
        if (src == enter_hash){
            _pressEnter();
        }else if(src == setting_hash){
            System.out.println("in setting !!!");
        }
        boxes.requestFocusInWindow();
    }

    /**
     * Private method dealing with Enter.
     */
    private void _pressEnter(){
        if (Position.getCol() == LetterBoxes.COLS){
            int flag = Enter.submit(boxes.getRow(Position.getRow()), wordList);
            if (flag == 1){
                PopWindow pop = new PopRes(fatherFrame, true);
                pop.jb.addActionListener(new ClickRestart(pop, boxes));
                pop.setVisible(true);
                Position.setRow(0);
                Position.setCol(0);
                wordList.generateAns();
            }else if (flag == 0) {
                if (Position.getRow() < LetterBoxes.ROWS) {
                    if (Position.getRow() == 5){
                        PopWindow pop = new PopRes(fatherFrame, false);
                        pop.jb.addActionListener(new ClickRestart(pop, boxes));
                        pop.setVisible(true);
                    }else{
                        Position.setRow(Position.getRow() + 1);
                        Position.setCol(0);
                    }
                }
            }else{
                PopWindow pop = new PopWindow(fatherFrame, "Not in wordlist!", "Close", true);
                pop.setVisible(true);
            }
        } else{
            PopWindow pop = new PopWindow(fatherFrame,"Not enough letters", "Close", true);
            pop.setVisible(true);
        }
        boxes.requestFocusInWindow();
    }

    /**
     * Overriding the mousePressed method in interface {@code MouseListener}
     * @param e the event to be processed
     */
    @Override
    public void mousePressed(MouseEvent e) {
    }

    /**
     * Regain focus on the WordBoxes
     * @param e the event to be processed
     */
    @Override
    public void mouseReleased(MouseEvent e) {
        boxes.requestFocusInWindow();
    }

    /**
     * Overriding the mouseEntered method in interface {@code MouseListener}
     * @param e the event to be processed
     */
    @Override
    public void mouseEntered(MouseEvent e) {
    }

    /**
     * Overriding the mouseExited method in interface {@code MouseListener}
     * @param e the event to be processed
     */
    @Override
    public void mouseExited(MouseEvent e) {
    }
}




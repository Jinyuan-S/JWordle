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
import java.awt.event.*;

/**
 * Deal with Keyboard input.
 * <p>
 *     This class was designed to get the keyboard input and make some response. such as input letter into the WordBox,
 *     make actions respond to some function key and so on.
 * </p>
 *
 * @author Jinyuan Sun
 * @version 1.3
 */
public class KeyboardReader implements KeyListener, Enter {
    LetterBoxes boxes = null;
    SingleBox box = null;
    WordList wordList = null;
    JFrame fatherFrame = null;

    /**
     * Initialize a {@code KeyboardReader}.
     * @param letterBoxes an instance of {@code LetterBoxes}.
     * @param wordList an instance of {@code WordList}.
     * @param fatherFrame the father Frame.
     */
    public KeyboardReader(LetterBoxes letterBoxes, WordList wordList, JFrame fatherFrame){
        this.wordList = wordList;
        this.fatherFrame = fatherFrame;
        this.boxes = letterBoxes;
        boxes.addKeyListener(this);
//        ****调试****
//        boxes.addFocusListener(new FocusListener() {      //for debug :
//            @Override
//            public void focusGained(FocusEvent e) {
//                boxes.setBackground(Color.CYAN);
//            }
//
//            @Override
//            public void focusLost(FocusEvent e) {
//                boxes.setBackground(Color.GREEN);
//            }
//        });

    }

    /**
     * General method response to a key typing event.
     * @param e the KeyEvent to be processed
     */
    @Override
    public void keyTyped(KeyEvent e) {
        char c = e.getKeyChar();
        int ret  =_validate(c);
        if (ret == 1){
            _typeLetter(c);
        }else if (ret == 2){
            int tmp = (int)c - 32;      //change to capital
            c = (char)tmp;
            _typeLetter(c);
        }else if (ret == 3){
            _typeBackspace();
//            System.out.println("this is a backspace");
        }else if (ret ==4){
            _typeEnter();
        }else {
            System.out.println("false");
//            box.setText("?");
        }

    }

    /**
     * Do nothing (empty method).
     * @param e the event to be processed
     */
    @Override
    public void keyPressed(KeyEvent e) {}

    /**
     * Do nothing (empty method).
     * @param e the event to be processed
     */
    @Override
    public void keyReleased(KeyEvent e) {}


    /**
     * private method to validate the keyboard input char c
     * @param c input char tobe validate
     * @return 1 is a capital letter; 2 is a small letter; 3 is Backspace; 4 is Enter.
     */
    private int _validate (char c){
        int ascii = (int)c;
//        65-A, 90-Z, 97-a, 122-z
        if (ascii >= 65 && ascii <= 90){
            return 1;
        }else if(ascii >= 97 && ascii <= 122){
            return 2;
        }else if (ascii == 8){      //backspace
            return 3;
        }else if (ascii == 10){     //enter
            return 4;
        }else return 0;
    }

    /**
     * Private method to type a letter into a {@code SingleBox}.
     * @param c new letter to be written.
     */
    private void _typeLetter (char c){
        if (Position.getCol() < LetterBoxes.COLS){
            box = boxes.getSingleBox(Position.getRow(), Position.getCol());
            box.setText(Character.toString(c));
            Position.setCol(Position.getCol() + 1); //pointer move forward
        }
//        else{
//            System.out.println("the line is full!");    //for debug
//        }
    }

    /**
     * Private method to response to a Backspace.
     * <p>Delete a letter in current row</p>
     */
    private void _typeBackspace (){
        if (Position.getCol() > 0){
            Position.setCol(Position.getCol() - 1);
        }
        box = boxes.getSingleBox(Position.getRow(), Position.getCol());
        box.setText(" ");
    }

    /**
     * Private method response to a Enter.
     */
    private void _typeEnter (){
        if (Position.getCol() == LetterBoxes.COLS){
            int flag = Enter.submit(boxes.getRow(Position.getRow()), wordList); //0-not, 1-win, 2-word not found
            if (flag == 1){
                PopWindow pop = new PopWin(fatherFrame);
                pop.jb.addActionListener(new ClickRestart(pop, boxes));
                pop.setVisible(true);
                Position.setRow(0);
                Position.setCol(0);
                wordList.generateAns();
            }else if (flag == 0){
                if (Position.getRow() < LetterBoxes.ROWS) {
                    Position.setRow(Position.getRow() + 1);
                    Position.setCol(0);
                }
            }else{  //2-not in wordlist
                PopWindow pop = new PopWindow(fatherFrame, "not in wordlist", "Close", true);
                pop.setVisible(true);
            }

        }
//        else{
//            System.out.println("line not full, enter do nothing");      //for debug
//        }
    }

}


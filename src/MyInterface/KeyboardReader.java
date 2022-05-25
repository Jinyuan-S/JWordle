package MyInterface;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class KeyboardReader implements KeyListener, Enter {

    LetterBoxes boxes = null;
    SingleBox box = null;
    WordList wordList = null;
    JFrame fatherFrame = null;

    public KeyboardReader(LetterBoxes letterBoxes, WordList wordList, JFrame fatherFrame){
        this.wordList = wordList;
        this.fatherFrame = fatherFrame;
        this.boxes = letterBoxes;
        boxes.addKeyListener(this);

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


    @Override
    public void keyTyped(KeyEvent e) {
//        System.out.println("in keyTyped current row: " + Position.getRow() +" current col: " + Position.getCol());
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

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }


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

    private void _typeBackspace (){
        if (Position.getCol() > 0){
            Position.setCol(Position.getCol() - 1);
        }
        box = boxes.getSingleBox(Position.getRow(), Position.getCol());
        box.setText(" ");
    }

    private void _typeEnter (){
        if (Position.getCol() == LetterBoxes.COLS){
            int flag = Enter.submit(boxes.getRow(Position.getRow()), wordList); //0-not, 1-win, 2-word not found
            if (flag == 1){
                Position.setRow(6);
                PopWindow pop = new PopWindow(fatherFrame, "You win!");
                pop.setVisible(true);
            }else if (flag == 0){
                if (Position.getRow() < LetterBoxes.ROWS) {
                    Position.setRow(Position.getRow() + 1);
                    Position.setCol(0);
                }
            }else{  //2-not in wordlist
                PopWindow pop = new PopWindow(fatherFrame, "not in wordlist");
                pop.setVisible(true);
            }

        }
//        else{
//            System.out.println("line not full, enter do nothing");      //for debug
//        }
    }

}


package MyInterface;

import javax.swing.*;
import java.awt.*;

public class LetterBoxes extends JPanel {
    private SingleBox boxes[][] = new SingleBox[6][5];
    public static final int WIDTH = 335;    //define the width of the letter box
    public static final int HEIGHT = 403;   //define the height of the letter box
    public static final int ROWS = 6;       //define the rows of the box
    public static final int COLS = 5;       //define the colomns of the box

    public LetterBoxes(){
        this.setLayout(new GridLayout(ROWS, COLS, 5, 5));
//        this.setBackground(Color.CYAN);     //for debug...
        this.setSize(WIDTH, HEIGHT);
        for (int i = 0; i < boxes.length; i++){ //initialize the array
            for (int j = 0; j < boxes[i].length; j++){
                boxes[i][j] = new SingleBox();
                this.add(boxes[i][j]);
            }

        }

    }

    /**
     * Get a specified row of LetterBoxes
     * @param row the row to return [0, 5]
     * @return SingleBox[] array
     */
    public SingleBox[] getRow(int row){
        return this.boxes[row];
    }

    public SingleBox getSingleBox(int row, int col){
        return this.boxes[row][col];
    }

}

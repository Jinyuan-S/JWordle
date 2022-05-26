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
import javax.swing.border.Border;
import java.awt.*;

/**
 * A single letter box on the screen.
 * <p>
 *     The {@code SingleBox} class extends {@code JLabel}, is a basic unit for display. Changing theme logic are
 *     provided in the class.
 * </p>
 * @author Jinyuan Sun
 * @version 1.0
 */
public class SingleBox extends JLabel {
    private final static Color _yellow = new Color(198, 180, 102);
    private final static Color _gray = new Color(121, 124, 126);
    private final static Color _green = new Color(121, 167, 107);
    private final static Color _borderGray = new Color(212, 214, 218);
    private Border border = null;

//    private JLabel jl = null;

    /**
     * Initialize a SingleBox instance to an uncheck state.
     */
    public SingleBox(){
        border = BorderFactory.createLineBorder(_borderGray, 4);  //the initial border color is gray
        this.setBorder(border);
        this.setText(" ");
        this.setFont(new Font("SansSerif", Font.BOLD, 30));
        this.setSize(63, 63);
        this.setHorizontalAlignment(JLabel.CENTER);
        this.setVerticalAlignment(JLabel.CENTER);
        this.setBackground(Color.WHITE);    //initial color is white
        this.setOpaque(true);  //not transparent
        this.setForeground(Color.BLACK);
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

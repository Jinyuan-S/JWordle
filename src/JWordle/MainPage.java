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
import java.awt.event.*;

/**
 *  The {@code MainPage} class build up the main page, including the word boxes and buttons.
 *  <p>
 *      {@code MainPage} class contains a {@code KeyboardReader} instance for keyboard operation, a
 *      {@code ButtonOperator} instance for button operation, some {@code JLabel} instance for display and some other
 *      components which extends {@code JPanel} and {@code JLabel}.
 *  </p>
 *
 * @author Jinyuan Sun
 * @version 1.0
 */
public class MainPage extends JFrame{
    private JLabel titleLabel = null;
    private JLabel version = null;
    private LetterBoxes letterBoxes = null;
    private JButton enter = null;
    private JButton delete = null;
    private WordList wordList = null;

    KeyboardReader k = null;
    ButtonOperator b = null;

    /**
     * The default constructor of {@code MainPage} class.
     * Initialize the layout, size etc.
     */
    public MainPage(){
        this.setTitle("Wordle by Jinyuan");
        this.setSize(601, 850);
        this.setLocationRelativeTo(null);       //make the window always generate at the center of screen
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);    //exit javax when close the window
        this.setResizable(false);   //do not let user resize the window
        this.setLayout(null);
        this.wordList = new WordList("wordList.txt");
        this._buildPage();
    }

    /**
     * Show this main page.
     * Decorate {@code JFrame} method {@code setVisiable}.
     */
    public void myShow(){
        this.addWindowFocusListener(new WindowAdapter() {
            public void windowGainedFocus(WindowEvent e) {
                letterBoxes.requestFocusInWindow();
            }
        });
        this.setVisible(true);
    }

    /**
     * Private method for the constructor to use to build the page.
     */
    private void _buildPage(){  //add component
        Container c = this.getContentPane();
        letterBoxes = new LetterBoxes();
        letterBoxes.setBounds(133, 130, LetterBoxes.WIDTH, LetterBoxes.HEIGHT);
        k = new KeyboardReader(letterBoxes, wordList, this);
        c.add(letterBoxes);

        titleLabel = new JLabel("Wordle");
        titleLabel.setFont(new Font("Serif", Font.BOLD, 45) );
        titleLabel.setHorizontalAlignment(JLabel.CENTER);
        titleLabel.setVerticalAlignment(JLabel.CENTER);
        titleLabel.setBounds(200, 40, 201, 50);
        c.add(titleLabel);

        version = new JLabel("version 1.0 @Jinyuan");
        version.setFont(new Font("Serif", Font.PLAIN, 15) );
        version.setHorizontalAlignment(JLabel.CENTER);
        version.setVerticalAlignment(JLabel.CENTER);
        version.setBounds(200, 750, 201, 50);
        c.add(version);

        enter = new JButton("ENTER");

        enter.setBackground(Color.blue);
        enter.setForeground(Color.BLACK);
        enter.setFont(new Font("SansSerif", Font.PLAIN, 22));
        enter.setBounds(100, 650, 151, 70);
        b = new ButtonOperator(enter, letterBoxes, wordList, this);
        c.add(enter);

        delete = new JButton("DELETE");
        delete.setFont(new Font("SansSerif", Font.PLAIN, 22));
        delete.setBounds(351, 650, 151, 70);
        c.add(delete);
    }
}

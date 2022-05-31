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
 * @version 1.4
 */
public class MainPage extends JFrame{
    /**
     * The width of the whole GUI window
     */
    public static int WIDTH = 601;
    /**
     * The height of the whole GUI window
     */
    public static int HEIGHT = 850;
    /**
     * The first text line containing "Wordle".
     */
    private JLabel titleLabel = null;
    /**
     * The text line in the button indicating the version.
     */
    private JLabel version = null;
    /**
     * An {@code LetterBoxes} instance displayed in the main page.
     */
    private LetterBoxes letterBoxes = null;
    /**
     * An instance of {@code WordList}, the wordlist in use.
     */
    private WordList wordList = null;
    /**
     * Store all the buttons in main page.
     * <p>Although there is only one button in the main page, but it is necessary to make my code scalability</p>
     */
    private JButton [] jbArray = null;

    /**
     * Respond to Keyboard input events.
     */
    KeyboardReader k;

    /**
     * Responds to MouseClick button events.
     */
    ButtonOperator b;

    /**
     * The default constructor of {@code MainPage} class.
     * Initialize the layout, size etc.
     */
    public MainPage(){
        this.setTitle("Wordle by Jinyuan");
        this.setSize(WIDTH, HEIGHT);
        this.setLocationRelativeTo(null);       //make the window always generate at the center of screen
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);    //exit javax when close the window
        this.setResizable(false);   //do not let user resize the window
        this.setLayout(null);
        this.wordList = new WordList("words.txt");
        this.jbArray = new JButton[10];     //ten button in total.
        this._buildPage();
        k = new KeyboardReader(letterBoxes, wordList, this);
        b = new ButtonOperator(jbArray, letterBoxes, wordList, this);
    }

    /**
     * Show this main page.
     * Decorate {@code JFrame} method {@code setVisible}.
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
     * Static method to quickly make a {@code JLabel}
     * @param text text to present.
     * @param font the font.
     * @param FontStyle Bold or Regular or sth.
     * @param textSize text size.
     * @return a made label
     */
    public static JLabel makeLabel(String text, String font , int FontStyle, int textSize){
        JLabel label = new JLabel(text);
        label.setFont(new Font(font, FontStyle, textSize) );
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setVerticalAlignment(JLabel.CENTER);
        return label;
    }

    /**
     * Private method for the constructor to use to build the page.
     */
    private void _buildPage(){  //add component
        Container c = this.getContentPane();
        letterBoxes = new LetterBoxes();
        letterBoxes.setBounds(133, 130, LetterBoxes.WIDTH, LetterBoxes.HEIGHT);
        c.add(letterBoxes);

        //the title
        titleLabel = new JLabel("Wordle");
        titleLabel.setFont(new Font("Serif", Font.BOLD, 45) );
        titleLabel.setHorizontalAlignment(JLabel.CENTER);
        titleLabel.setVerticalAlignment(JLabel.CENTER);
        titleLabel.setBounds(200, 40, 201, 50);
        c.add(titleLabel);

        //the test version
        version = new JLabel("version 1.4 @Jinyuan");
        version.setFont(new Font("Serif", Font.PLAIN, 15) );
        version.setHorizontalAlignment(JLabel.CENTER);
        version.setVerticalAlignment(JLabel.CENTER);
        version.setBounds(200, 750, 201, 50);
        c.add(version);

        //the enter button in main page
        jbArray[0] = new JButton("ENTER");
        jbArray[0].setFont(new Font("SansSerif", Font.PLAIN, 22));
        jbArray[0].setBounds(225, 650, 151, 70);
        System.out.println("the enter hash code in main is" + jbArray[0].hashCode());
        c.add(jbArray[0]);

    }
}

//below are the newest version

///*
// * Copyright 2022 Jinyuan Sun (https://github.com/Jinyuan-S)
// *
// * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated
// * documentation files (the "Software"), to deal in the Software without restriction, including without limitation the
// * rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to
// * permit persons to whom the Software is furnished to do so, subject to the following conditions:
// *
// * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the
// * Software.
// *
// * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE
// * WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS
// * OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR
// * OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.THE
// * SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE
// * WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS
// * OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR
// * OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
// */
//
//package JWordle;
//        import javax.swing.*;
//        import java.awt.*;
//        import java.awt.event.*;
//
///**
// *  The {@code MainPage} class build up the main page, including the word boxes and buttons.
// *  <p>
// *      {@code MainPage} class contains a {@code KeyboardReader} instance for keyboard operation, a
// *      {@code ButtonOperator} instance for button operation, some {@code JLabel} instance for display and some other
// *      components which extends {@code JPanel} and {@code JLabel}.
// *  </p>
// *
// * @author Jinyuan Sun
// * @version 1.4
// */
//public class MainPage extends JFrame{
//    /**
//     * The width of the whole GUI window
//     */
//    public static int WIDTH = 601;
//    /**
//     * The height of the whole GUI window
//     */
//    public static int HEIGHT = 850;
//    private JLabel titleLabel = null;
//    private JLabel version = null;
//    private LetterBoxes letterBoxes = null;
//    private LoginWindow login = null;
//    private WordList wordList = null;
//    private JButton [] jbArray = null;      //store all the buttons
//
//    KeyboardReader k;
//    ButtonOperator b;
//
//    /**
//     * The default constructor of {@code MainPage} class.
//     * Initialize the layout, size etc.
//     */
//    public MainPage(){
//        this.setTitle("Wordle by Jinyuan");
//        this.setSize(WIDTH, HEIGHT);
//        this.setLocationRelativeTo(null);       //make the window always generate at the center of screen
//        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);    //exit javax when close the window
//        this.setResizable(false);   //do not let user resize the window
//        this.setLayout(null);
//        this.wordList = new WordList("wordList.txt");
//        this.jbArray = new JButton[10];     //ten button in total.
//        this._buildPage();
//        k = new KeyboardReader(letterBoxes, wordList, this);
//        b = new ButtonOperator(jbArray, letterBoxes, wordList, this);
//    }
//
//    /**
//     * Show this main page.
//     * Decorate {@code JFrame} method {@code setVisiable}.
//     */
//    public void myShow(){
//        this.addWindowFocusListener(new WindowAdapter() {
//            public void windowGainedFocus(WindowEvent e) {
//                letterBoxes.requestFocusInWindow();
//            }
//        });
//        this.setVisible(true);
//        try{
//            Thread.sleep(1000);     //wait 1 second to show the login window
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//
//        login.setVisible(true);
//    }
//
//    /**
//     * Static method to quickly make a {@code JLabel}
//     * @param text text to present.
//     * @param font the font.
//     * @param FontStyle Bold or Regular or sth.
//     * @param textSize text size.
//     * @return a made label
//     */
//    public static JLabel makeLabel(String text, String font , int FontStyle, int textSize){
//        JLabel label = new JLabel(text);
//        label.setFont(new Font(font, FontStyle, textSize) );
//        label.setHorizontalAlignment(JLabel.CENTER);
//        label.setVerticalAlignment(JLabel.CENTER);
//        return label;
//    }
//
//    /**
//     * Private method for the constructor to use to build the page.
//     */
//    private void _buildPage(){  //add component
//        Container c = this.getContentPane();
//        letterBoxes = new LetterBoxes();
//        letterBoxes.setBounds(133, 130, LetterBoxes.WIDTH, LetterBoxes.HEIGHT);
//        c.add(letterBoxes);
//
//        titleLabel = new JLabel("Wordle");
//        titleLabel.setFont(new Font("Serif", Font.BOLD, 45) );
//        titleLabel.setHorizontalAlignment(JLabel.CENTER);
//        titleLabel.setVerticalAlignment(JLabel.CENTER);
//        titleLabel.setBounds(200, 40, 201, 50);
//        c.add(titleLabel);
//
//        version = new JLabel("version 1.1 @Jinyuan");
//        version.setFont(new Font("Serif", Font.PLAIN, 15) );
//        version.setHorizontalAlignment(JLabel.CENTER);
//        version.setVerticalAlignment(JLabel.CENTER);
//        version.setBounds(200, 750, 201, 50);
//        c.add(version);
//
//        //the enter button in main page
//        jbArray[0] = new JButton("ENTER");
//        jbArray[0].setFont(new Font("SansSerif", Font.PLAIN, 22));
//        jbArray[0].setBounds(100, 650, 151, 70);
//        System.out.println("the enter hash code in main is" + jbArray[0].hashCode());
//        c.add(jbArray[0]);
//
//        //the setting button in main page
//        jbArray[1] = new JButton("SETTING");
//        jbArray[1].setFont(new Font("SansSerif", Font.PLAIN, 22));
//        jbArray[1].setBounds(351, 650, 151, 70);
//        c.add(jbArray[1]);
//
//        //the login window
//        login = new LoginWindow(300, 500, this, "Login");
//
//
//    }
//}
//
//class LoginWindow extends PopWindow{
//    int width = 0;
//    int height = 0;
//    public LoginWindow(int width, int height, JFrame jFrame, String title) {
//        super(width, height, jFrame, title);
//        this.width = width;
//        this.height = height;
//        Layer baseLayer = new Layer(width, height);
//        baseLayer.setLayout(new CardLayout());
//        System.out.println(this.getLayout());
//
//        Layer inputPage = _buildInputPage(baseLayer);
//        Layer loginSuccess = _buildLoginSuccess();
//        Layer enrollSuccess = new Layer(width, height);
//
//
//
//        baseLayer.add("inputPage", inputPage);
//        baseLayer.add("loginSuccess", loginSuccess);
//        baseLayer.add("enrollSuccess", enrollSuccess);
//        ((CardLayout)baseLayer.getLayout()).show(baseLayer,"inputPage");
//
//        this.add(baseLayer);
//    }
//
//    private Layer _buildInputPage(JPanel baseLayer){
//        Layer inputPage = new Layer(width, height);
//
//        //The first line "Login"
//        JLabel label = MainPage.makeLabel("Login", "Serif", Font.BOLD, 30);
//        label.setBounds(50,25,201, 40);
//        inputPage.add(label);
//        ////////
//
//        //The button "Login/Enroll"
//
//        JButton jb = new JButton("Login/Enroll");
//        jb.setFont(new Font("SansSerif", Font.BOLD, 15));
//        jb.addActionListener(new ClickChangeCard(baseLayer, "loginSuccess"));
//        jb.setBounds(75, 250, 150, 50);
//        inputPage.add(jb);
//
//        JLabel jl = MainPage.makeLabel("---Login your account---", "Serif", Font.PLAIN, 15);
//        jl.setBounds(60, 100, 180, 20);
//        inputPage.add(jl);
//
//        JLabel jl1 = MainPage.makeLabel("If the Account exists, then login", "Serif", Font.PLAIN, 15);
//        jl1.setBounds(25, 350, 250, 20);
//        inputPage.add(jl1);
//
//        JLabel jl2 = MainPage.makeLabel("Else create a new Account", "Serif", Font.PLAIN, 15);
//        jl2.setBounds(60, 370, 180, 20);
//        inputPage.add(jl2);
//
//        JTextField textField = new JTextField("username");
//        textField.setColumns(5);
//        textField.setBounds(60, 120, 180, 50);
//        textField.setFont(new Font("SansSerif", Font.BOLD, 15));
//        textField.setHorizontalAlignment(JTextField.CENTER);
//        inputPage.add(textField);
//
//        return inputPage;
//    }
//
//    private Layer _buildLoginSuccess(){
//        Layer loginSuccess = new Layer(width, height);
//
//        //The first line "Login Successful!"
//        JLabel line1 = MainPage.makeLabel("Successful", "Serif", Font.BOLD, 30);
//        line1.setBounds(50,35,201, 40);
//        loginSuccess.add(line1);
//
//        JLabel line2 = MainPage.makeLabel("Login", "Serif", Font.BOLD, 30);
//        line2.setBounds(50,75,201, 40);
//        loginSuccess.add(line2);
//
//        //The button "Let's play"
//        JButton jb = new JButton("Let's Play!");
//        jb.setFont(new Font("SansSerif", Font.BOLD, 15));
//        jb.addActionListener(new ClickClose(this));
//        jb.setBounds(75, 250, 150, 50);
//        loginSuccess.add(jb);
//
//        return loginSuccess;
//    }
//
//
//
//    private class Layer extends JPanel{
//        public Layer(int width, int height){
//            this.setSize(width, height);
//            this.setLayout(null);
//        }
//    }
//
//
//}
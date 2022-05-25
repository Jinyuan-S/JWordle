package MyInterface;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MainPage extends JFrame{
    private JLabel titleLabel = null;
    private LetterBoxes letterBoxes = null;
    private JButton enter = null;
    private JButton delete = null;
    private WordList wordList = null;

    KeyboardReader k = null;
    ButtonOperator b = null;

    public MainPage(){
        this.setTitle("Wordle by Jinyuan");
        this.setSize(601, 850);
        this.setLocationRelativeTo(null);       //make the window always generate at the center of screen
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);    //exit javax when close the window
        this.setResizable(false);   //do not let user resize the window
        this.setLayout(null);
        this.wordList = new WordList();
        this._buildPage();
    }

    /**
     * Show the whole GUI.
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

        enter = new JButton("ENTER");
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

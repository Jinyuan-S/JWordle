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

/**
 * The {@code PopWindow} class extends JDialog, aiming to show a pop-up window for reminder.
 * <p>
 *     In the class I defined some attribute such as font and size of a JDialog.
 * </p>
 *
 * @author Jinyuan Sun
 * @version 1.2
 */
public class PopWindow extends JDialog {
//    JLabel label = null;

    /**
     * Creates a PopWindow instance with default width of 251 and default height of 300.
     * pop window will block the father window.
     * @param jFrame the father window.
     * @param text the text to be displayed.
     */
    public PopWindow(JFrame jFrame, String text){
        super(jFrame, "Reminder", true);
        this.setLayout(null);
        Container c = this.getContentPane();
        _initialize(251, 200, jFrame);
        JLabel label = new JLabel(text);
        label.setFont(new Font("Serif", Font.BOLD, 20) );
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setVerticalAlignment(JLabel.CENTER);
        label.setBounds(25,25,201, 30);

        c.add(label);
        ////////


        JButton jb = new JButton("Close");
        jb.addActionListener(new ClickClose(this));
        jb.setBounds(75, 85, 100, 50);
        c.add(jb);

    }

    /**
     * Creates a PopWindow instance with father window jFrame and String to be displayed in the pop window.
     * pop window will block the father window.
     * @param width the width of the pop widow.
     * @param height the height of the pop window.
     * @param jFrame the father window.
     * @param title the title of the PopWindow.
     */
    public PopWindow(int width, int height, JFrame jFrame, String title){
        super(jFrame, title, true);
        _initialize(width, height, jFrame);
    }

    private void _initialize(int width, int height, JFrame jFrame){
        this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(jFrame);
        setBounds((MainPage.WIDTH - width)/2 + jFrame.getX(), (MainPage.HEIGHT - height)/2 + jFrame.getY(),
                width, height);

    }
}

/**
 * Close the {@code JDialog} when click.
 * @author Jinyuan Sun
 * @version 1.0
 */
class ClickClose implements ActionListener {
    JDialog window = null;

    /**
     * Constructor.
     * @param window the father {@code JDialog}.
     */
    public ClickClose(JDialog window){
        this.window = window;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        window.dispose();
    }
}

class ClickChangeCard implements ActionListener {
    JPanel panel = null;
    String name;    //the destination card name.
    /**
     * Constructor.
     * @param window the father {@code JDialog}.
     */
    public ClickChangeCard(JPanel window, String cardName){
        this.panel = window;
        this.name = cardName;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        ((CardLayout)panel.getLayout()).show(panel,name);
    }
}


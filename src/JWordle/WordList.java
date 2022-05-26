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

import java.io.*;
import java.util.ArrayList;
import java.util.Locale;

/**
 * A class that can read wordlist from file and store in an {@code ArrayList}.
 * <p>
 *     This class maintain a wordlist in an {@code ArrayList}, and maintain an answer to the game.
 * </p>
 * <p>
 *     The class also provides several methods to deal with the wordlist and the answer.
 * </p>
 *
 * @author Jinyuan Sun
 * @version 1.0
 */
public class WordList {

    private ArrayList<String> list = null;  //wordlist
    private BufferedReader br = null;
    private static String ANS = "STAMP";    //the answer

    /**
     * Read file from path, add to the Arraylist.
     * @param path the file path.
     */
    public WordList(String path){
        list = new ArrayList<String>();
        try {
            br = new BufferedReader(new FileReader(path));
            String tmp = br.readLine();
            while (tmp != null){
                list.add(tmp.toUpperCase(Locale.ROOT));
                tmp = br.readLine();
            }
        }catch (FileNotFoundException e){
            System.out.println("File not found in FileReader");
            e.printStackTrace();
        }catch (IOException e){
            System.out.println("IO wrong in BufferedReader");
            e.printStackTrace();
        }finally {
            try{
                if (br != null) br.close();
            }catch (IOException e){
                System.out.println("Error in closing the BufferReader");
                e.printStackTrace();
            }
        }
    }

    /**
     * Judge whether a string is in the wordlist.
     * @param s the fife letter string to judge.
     * @return true: in wordlist; false: not in wordlist.
     */
    public boolean inWordlist(String s){
        return list.contains(s);
    }

    /**
     * static method get the private static variable <b>ANS</b> of the game.
     * @return string answer
     */
    public static String getAns(){
        return ANS;
    }

}
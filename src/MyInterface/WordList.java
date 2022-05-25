package MyInterface;

import java.io.*;
import java.util.ArrayList;
import java.util.Locale;

public class WordList {

    private ArrayList<String> list = null;  //wordlist
    private BufferedReader br = null;
    private static String ans = "STAMP";    //the answer

    public WordList(){
        list = new ArrayList<String>();
        try {
            br = new BufferedReader(new FileReader("/Users/arnoldsun/IdeaProjects/miniproject/wordList.txt"));
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

    public boolean inWordlist(String s){
        return list.contains(s);
    }

    /**
     * static method get the answer of the game.
     * @return string answer
     */
    public static String getAns(){
        return ans;
    }

}
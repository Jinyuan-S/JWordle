package MyInterface;

import java.io.*;
import java.util.ArrayList;
import java.util.Locale;

public class WordList {

    private final ArrayList<String> list = null;  //wordlist
    private BufferedReader br = null;
    public WordList(){
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

}

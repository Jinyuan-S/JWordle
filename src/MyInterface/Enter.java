package MyInterface;

public interface Enter{
//    static String ans = "APPLE";
    static int submit(SingleBox [] box_line, WordList wordList){
        int isWin = 0;  //return win or not 0:not, 1:win, 2:not in wordlist
        int cnt = 0;        //correct letter number
        StringBuffer sb = new StringBuffer(WordList.getAns());
        SingleBox box = null;
        String tobeCheck = new String("");  //storge the c urrent string for checking

        for (SingleBox singleBox : box_line) {
            box = singleBox;
            tobeCheck = tobeCheck.concat(box.getText());
        }
        if (wordList.inWordlist(tobeCheck)){        //the word is in the wordlist
            for (int i = 0; i < box_line.length; i++){
                box = box_line[i];
                char current = box.getText().charAt(0); //the current letter in the box
                int idx = WordList.getAns().indexOf(current);     //the index of box letter in answer
                if (sb.toString().indexOf(current) != -1){    //founded in the remaining answer_copy string
                    if (idx == i){      //--correct
                        cnt ++;
                        box.refresh(3);
                    }else{
                        box.refresh(2);
                    }
                    sb.deleteCharAt(sb.toString().indexOf(current));

                }else{  //not founded in the answer --incorrect
                    box.refresh(1);
                }

            }
            if (cnt == 5){
                isWin = 1;
            }
        }else{      //the word is not in the wordlist
            isWin = 2;
            System.out.println("word not in wordlist!");
        }


        return isWin;
    }

}
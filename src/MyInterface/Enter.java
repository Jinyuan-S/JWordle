package MyInterface;

public interface Enter{
    static String ans = "APPLE";
    static boolean submit(SingleBox [] box_line){
        boolean isWin = false;
        int cnt = 0;        //correct letter number
        StringBuffer sb = new StringBuffer(ans);
        SingleBox box = null;
        for (int i = 0; i < box_line.length; i++){
            box = box_line[i];
            char current = box.getText().charAt(0); //the current letter in the box
            int idx = ans.indexOf(current);     //the index of box letter in answer
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
            isWin = true;
        }
        return isWin;
    }

}
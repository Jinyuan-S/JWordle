package MyInterface;

public class Position {
    private static int row = 0;
    private static int col = 0;

    public static int getRow(){
        return row;
    }

    public static int getCol(){
        return col;
    }

    public static void setRow(int r){
        Position.row = r;
    }

    public static void setCol(int c){
        Position.col = c;
    }
}

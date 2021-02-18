package MyExceptions;

public class MyArrayDataException extends RuntimeException{

    String str[][];
    int i,j;

    public MyArrayDataException(String str[][], int i, int j){
        this.str=str;
        this.i=i;
        this.j=j;
    }

    public String toString(){
        return "В ячейке "+
                (i+1) +
                "x" +
                (j+1) +
                "(" +
                str[i][j] +
                ")" +
                ", лежит не число.";
    }
}

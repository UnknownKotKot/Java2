package MyExceptions;



public class MyArraySizeException extends Exception{
    String str[][];

    public MyArraySizeException(String strArr[][]){
        str=strArr;
    }

    public String toString(){
        return "Введите массив корректного размера - 4x4." + "\n" +
                "Длина вашего массива = " +
                str.length +
                ", " +
                " ширина = " +
                str[0].length +
                ".";
    }


}

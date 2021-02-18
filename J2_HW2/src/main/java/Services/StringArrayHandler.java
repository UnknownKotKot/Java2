package Services;

import MyExceptions.MyArraySizeException;
import MyExceptions.MyArrayDataException;


public class StringArrayHandler  {
    public void stringArrayHandler4x4(String arr[][]) throws MyArraySizeException, RuntimeException{
        if (arr.length!=4||arr[0].length!=4){
            throw new MyArraySizeException(arr);
        }else{
            int intArr[][] = new int[4][4];
            int sum = 0;
            for (int i = 0; i <arr.length ; i++) {
                for (int j = 0; j <arr[0].length ; j++) {
                   try{
                       intArr[i][j] = Integer.parseInt(arr[i][j]);
                       sum+=intArr[i][j];
                   }catch (NumberFormatException e){
                       throw new MyArrayDataException(arr, i, j);
                   }
                }
            }
            System.out.println("Сумма элементов в таблице "+ " = " + sum);
        }
    }
}

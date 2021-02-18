import MyExceptions.MyArrayDataException;
import MyExceptions.MyArraySizeException;
import Services.StringArrayHandler;

public class Main {
    public static void main(String[] args) throws Exception{

        String str1[][] =  {
                {"100", "150", "Vasya", "56"},
                {"Petya", "1500", "Kolya", "c"},
                {"0", "60", "Vasya", "58"},
                {"120", "Tolik", "-10", "Vova"}
        };
        String str2[][] =  {
                {"100", "150", "432", "56"},
                {"-500", "1500", "3213", "1"},
                {"0", "60", "123", "58"},
                {"120", "213", "-10", "213"}
        };
        String str3[][] =  new String[1][1];
        String str4[][] =  new String[5][5];

        StringArrayHandler sah = new StringArrayHandler();
        try{
            sah.stringArrayHandler4x4(str1);
        }catch (MyArrayDataException e){
            System.out.println(e);
        }finally {
            try{
                sah.stringArrayHandler4x4(str2);
            }catch (MyArrayDataException e){
                System.out.println(e);
            }finally {
                try{
                    sah.stringArrayHandler4x4(str3);
                }catch (MyArraySizeException e){
                    System.out.println(e);
                }finally {
                    try{
                        sah.stringArrayHandler4x4(str4);
                    }catch (MyArraySizeException e){
                        System.out.println(e);
                    }
                }
            }
        }
    }
}

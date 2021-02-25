package Part2;

import java.util.stream.IntStream;

public class FirstIndexSearcher{

    public int searchViaStream (Integer n, Integer[]list){
        int l = list.length;
        return IntStream.range(0, l)
                .filter(i -> n == list[i])
                .findFirst()
                .orElse(-1);
    }
    
    public IndexSearch sLambda = (n, list)-> {
        boolean exit = false;
        do{
            for (int i = 0; i < list.length; i++) {
                if(list[i].equals(n)){
                    exit = true;
                    return i;
                }
            }
            return -1;
        }while(exit);
    };
}

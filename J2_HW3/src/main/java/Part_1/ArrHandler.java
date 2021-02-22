package Part_1;

import java.util.*;

public class ArrHandler {

    public void arrHandler(ArrayList<String> arr){

        ArrayList<String> sArr = new ArrayList<>();
        Map<String, Integer> mArr = new HashMap<>();
        for (int i = 0; i <arr.size() ; i++) {
            int count = 1;
            for (int j = i+1; j <arr.size() ; j++) {
                if(arr.get(i).equals(arr.get(j))){
                count++;
                }
            }
            if(count>1&&!mArr.containsKey(arr.get(i))){
                mArr.put(arr.get(i), count);
            }else{
                if(!mArr.containsKey(arr.get(i))){
                    sArr.add(arr.get(i));
                }
            }
        }
        System.out.println("Список уникальных слов: ");
        if(sArr.isEmpty()) {
            System.out.println("No Data");
        }
        for (int i = 0; i <sArr.size() ; i++) {
            System.out.print("'" + sArr.get(i) + "' ");
        }

        System.out.println(" ");
        System.out.println("Список слов дубликатов с колличеством: ");
        if(mArr.isEmpty()) {
            System.out.println("No Data");
        }
        for (Map.Entry entry: mArr.entrySet()) {
            System.out.println(entry);
        }
        mArr.clear();
        sArr.clear();
    }
}

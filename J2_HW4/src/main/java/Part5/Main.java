package Part5;

import Part4.GetMaxValue;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<Integer>();
        list.add(1);
        list.add(4);
        list.add(43);
        list.add(432);
        list.add(434);
        list.add(-991);
        list.add(9);

        System.out.println(new GetAverageValue().aValue.averageValue(list));
    }
}

package Part4;

import java.util.Arrays;
import java.util.stream.IntStream;

public class GetMaxValue {

    public Maximum getMaxValue = (Integer[] list)->{
        Arrays.sort(list);
        return list[list.length-1];
    };
}

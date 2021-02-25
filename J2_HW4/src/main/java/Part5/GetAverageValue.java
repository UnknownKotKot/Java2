package Part5;

import java.util.List;

public class GetAverageValue {
    public Average aValue = (List<Integer> list)->list.stream().mapToDouble((x)->x).sum()/list.stream().count();
}

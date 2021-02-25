package Part6;

import java.util.List;
import java.util.stream.Collectors;

public class GetSuchString {

    public StringSearch ss =(List<String> list)->
                 list.stream()
                .filter(x -> x.length() == 3 && x.charAt(0) == 'a')
                .collect(Collectors.toList());
}

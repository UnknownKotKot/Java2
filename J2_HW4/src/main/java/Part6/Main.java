package Part6;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<String> list = new ArrayList<String>();
        list.add("ava");
        list.add("gag");
        list.add("a2");
        list.add("vavavava");
        list.add("sdsa");
        list.add("aaaaaaa");
        list.add("Adds");
        list.add("AAA");
        list.add("aaa");

        new GetSuchString().ss.search(list).forEach(a-> System.out.println(a+ " "));
    }
}

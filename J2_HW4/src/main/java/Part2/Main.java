package Part2;

public class Main {
    public static void main(String[] args) {

        Integer[] arr = { 5, 4, 6, 1, 3, 2, 7, 8, 9 };
        FirstIndexSearcher fis = new FirstIndexSearcher();


        System.out.println(fis.searchViaStream(10, arr));

        System.out.println(fis.sLambda.search(10, arr));


    }
}

import Part_1.ArrHandler;
import Part_2.PhoneBook;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        String [] str1 = {
                "Cat", "Dog", "Bird", "Human", "Fish",
                "notCat", "notDog", "notBird", "notHuman", "notFish",
                "Cat1", "Dog", "Bird", "Human", "Fish",
                "Cat", "Dog", "Bird", "Human", "Fish",
                "newCat", "newDog", "Bird", "newHuman", "newFish",
        };
        String [] str2 = {
                "Bird1", "Dog", "Bird2", "Human3", "Fish1",
                "notCat", "notDog", "notBird", "notHuman", "notFish",
                "Cat1", "Dog2", "Bird7", "Human1", "Fish2",
                "Cat2", "Dog3", "Bird4", "Human2", "Fish3",
                "newCat", "newDog", "Bird", "newHuman", "newFish",
        };
        String [] str3 = {
                "Dog", "Dog", "Dog", "Dog", "Dog",
                "Dog", "Dog", "Dog", "Dog", "Dog",
                "Dog", "Dog", "Dog", "Dog", "Dog",
                "Dog", "Dog", "Dog", "Dog", "Dog",
                "Dog", "Dog", "Dog", "Dog", "Dog",
        };

        ArrayList<String> arrS = new ArrayList<>();
        ArrHandler ah = new ArrHandler();

        System.out.println("--------------------------------------------");
        arrS.addAll(Arrays.asList(str1));
        ah.arrHandler(arrS);
        arrS.clear();
        System.out.println("--------------------------------------------");
        arrS.addAll(Arrays.asList(str2));
        ah.arrHandler(arrS);
        arrS.clear();
        System.out.println("--------------------------------------------");
        arrS.addAll(Arrays.asList(str3));
        ah.arrHandler(arrS);
        arrS.clear();
        System.out.println("--------------------------------------------");

        System.out.println("PhoneBook: ");
        PhoneBook pb = new PhoneBook();
        pb.add("vasya", "2");
        pb.add("vasya", "911");
        pb.add("vasya", "11");
        pb.add("tolya", "908");
        pb.add("tolya", "908");
        pb.add("tolya", "918");
        pb.get("vasya");
        pb.get("tolya");
        pb.get("Cat");

    }
}

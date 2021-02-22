package Part_2;

import java.util.*;

public class PhoneBook {

    private String surname;
    private String phoneNumber;

    private  ArrayList<String> str = new ArrayList<>();
    private Map<Integer, PhoneBook> pbMap = new HashMap<>();

    public PhoneBook(){}

    private PhoneBook(String surname, String phoneNumber) {
        this.surname = surname;
        this.phoneNumber = phoneNumber;
    }

    public void add(String surname, String phoneNumber){
        if(!str.contains(surname)){
            str.add(surname);
            pbMap.put(str.indexOf(surname), new PhoneBook(surname, phoneNumber));
            System.out.println("Добавлен абонент - " + surname);
        }else{
            if(!(pbMap.get(str.lastIndexOf(surname))).equals(new PhoneBook(surname, phoneNumber))){
                str.add(surname);
                pbMap.put(str.lastIndexOf(surname), new PhoneBook(surname, phoneNumber));
                System.out.println("Добавлен абонент - " + surname);
            }else{
                System.out.println("Такой абонент уже есть! - " + surname);
            }
        }
    }

    public void get(String surname){
            if(str.contains(surname)) {
                for (int i = 0; i <str.size() ; i++) {
                    if(str.get(i).equals(surname)){
                        System.out.println(getInfo(pbMap.get(i)));
                    }
                }
            }else {
                System.out.println("No such user - " + surname + "!");
            }
    }

    private String getInfo(PhoneBook e){
        return e.surname + " - "+ e.phoneNumber + ".";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PhoneBook phoneBook = (PhoneBook) o;
        return surname.equals(phoneBook.surname) &&
                phoneNumber.equals(phoneBook.phoneNumber);
    }
}

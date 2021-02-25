package Part3;

public class StringReverser {

    public StringRevers sr = (s)->{
        String revers = "";
        for (int i = s.length()-1; i >=0 ; i--) {
            revers+=s.charAt(i);
        }
        return revers.toString();
    };
}

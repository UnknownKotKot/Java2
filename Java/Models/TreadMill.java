package Models;

public class TreadMill {

    private int length;
    private int tmNumber;

    public TreadMill(int tmNumber, int length) {
        this.tmNumber = tmNumber;
        this.length = length;
    }

    public int getLength() {
        return length;
    }

    public int getTmNumber() {
        return tmNumber;
    }
}

package Models;

public class Wall {
    private int height;
    private int wNumber;

    public Wall(int wNumber, int height) {
        this.wNumber = wNumber;
        this.height = height;
    }

    public int getHeight() {
        return height;
    }

    public int getWNumber() {
        return wNumber;
    }

}
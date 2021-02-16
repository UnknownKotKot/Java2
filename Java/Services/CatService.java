package Services;

import Models.Cat;

public class CatService {

    private Cat cat;

    public CatService(Cat cat) {
        this.cat = cat;
    }

    public int getWasteCount(){
        return cat.getWasteCount();
    }

    void runner(Cat cat, int distanceLength) {
        if (cat.getRunDistanceLimit() < distanceLength) {
            System.out.println(cat.getName() + " is wasted");
            cat.setWasteCount(1);
        } else {
            if (distanceLength <= cat.getDistanceRan()) {
                System.out.println("TreadMill " + distanceLength +" distance ends");
            } else {
                int a = cat.getRunDistanceLimit();
                a += cat.getDistanceRan();
                cat.setDistanceRan(a);
                cat.run();
                System.out.println(cat.getName() + " got it!");
            }
        }
    }
    public void jumper(Cat cat, int height) {
        if (cat.getJumpHeight() < height) {
            System.out.println(cat.getName() + " is wasted");
        } else {
            cat.jump();
            System.out.println(cat.getName() + " got it!");
        }
    }
}

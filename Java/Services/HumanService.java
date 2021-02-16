package Services;

import Models.Human;

public class HumanService {

    private Human human;

    public HumanService(Human human) {
        this.human = human;
    }

    public int getWasteCount(){
        return human.getWasteCount();
    }

    void runner(Human human, int distanceLength) {
        if (human.getRunDistanceLimit() < distanceLength) {
            System.out.println(human.getName() + " is wasted");
            human.setWasteCount(1);
        } else {
            if (distanceLength <= human.getDistanceRan()) {
                System.out.println("TreadMill " + distanceLength +" distance ends");
            } else {
                int a = human.getRunDistanceLimit();
                a += human.getDistanceRan();
                human.setDistanceRan(a);
                human.run();
                System.out.println(human.getName() + " got it!");
            }
        }
    }
    public void jumper(Human human, int height) {
        if (human.getJumpHeight() < height) {
            System.out.println(human.getName() + " is wasted");
        } else {
            human.jump();
            System.out.println(human.getName() + " got it!");

        }
    }
}
package Models;

import Interfaces.Jumper;
import Interfaces.Runner;

public class Cat implements Runner, Jumper {

    private final String name;
    private final int runDistanceLimit;
    private final int jumpHeight;
    private int distanceRan;
    private int wasteCount;

    public Cat(String name, int runDistanceLimit, int jumpHeight){
        this.name= "Cat " + name ;
        this.runDistanceLimit = Math.abs(runDistanceLimit);
        this.jumpHeight = Math.abs(jumpHeight);
    }

    public void run(){
        System.out.println(name + " is running " + runDistanceLimit);
    }
    public void jump(){
        System.out.println(name + " is jumping " + jumpHeight);
    }

    public String getName() {
        return name;
    }
    public int getRunDistanceLimit() {
        return runDistanceLimit;
    }
    public int getJumpHeight() {
        return jumpHeight;
    }

    public void setDistanceRan(int distanceRan) {
        this.distanceRan = distanceRan;
    }
    public int getDistanceRan() {
        return distanceRan;
    }

    public void setWasteCount(int count){
        this.wasteCount = count;
    }

    public int getWasteCount() {
        return wasteCount;
    }

}

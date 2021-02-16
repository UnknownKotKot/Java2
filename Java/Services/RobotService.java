package Services;

import Models.Robot;

public class RobotService {

    private Robot robot;



    public RobotService(Robot robot) {
        this.robot = robot;
    }
    public int getWasteCount(){
        return robot.getWasteCount();
    }

    public void runner(Robot robot, int distanceLength) {


        if (robot.getRunDistanceLimit() < distanceLength) {
            System.out.println(robot.getName() + " is wasted");
            robot.setWasteCount(1);
        } else {
            if (distanceLength <= robot.getDistanceRan()) {
                System.out.println("TreadMill " + distanceLength +" distance ends");
            } else {
                int a = robot.getRunDistanceLimit();
                a += robot.getDistanceRan();
                robot.setDistanceRan(a);
                robot.run();
                System.out.println(robot.getName() + " got it!");
            }
        }
    }

    public void jumper(Robot robot, int height) {
        if (robot.getJumpHeight() < height) {
            System.out.println(robot.getName() + " is wasted");
        } else {
            robot.jump();
            System.out.println(robot.getName() + " got it!");
            }
        }
    }



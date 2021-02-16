package Services;

import Models.*;

public class RunService {

    private RobotService rs;
    private HumanService hs;
    private CatService cs;
    private TreadMill tm;
    private final Object obj;


    public RunService(Human human, TreadMill tm, HumanService hs) {
        this.tm = tm;
        this.obj = human;
        this.hs=hs;
    }

    public RunService(Cat cat, TreadMill tm, CatService cs) {
        this.tm = tm;
        this.obj = cat;
        this.cs=cs;
    }

    public RunService(Robot robot, TreadMill tm, RobotService rs) {
        this.tm = tm;
        this.obj = robot;
        this.rs=rs;
    }

    public  void letsRun(){
        if(obj instanceof Cat){
            cs.runner((Cat)obj, tm.getLength());
        }else if(obj instanceof Human){
                hs.runner((Human)obj, tm.getLength());
                }else if(obj instanceof Robot){
                        rs.runner((Robot)obj, tm.getLength());
                        }else{
                        System.out.println("We do not know how he or she or it is running!");
                        }
    }
}

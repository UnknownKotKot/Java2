package Services;

import Models.*;

public class JumpService {

    private RobotService rs;
    private HumanService hs;
    private CatService cs;
    private Wall wall;
    private final Object obj;


    public JumpService(Human human, Wall wall, HumanService hs) {
        this.wall = wall;
        this.obj = human;
        this.hs=hs;
    }

    public JumpService(Cat cat, Wall wall, CatService cs) {
        this.wall = wall;
        this.obj = cat;
        this.cs=cs;
    }

    public JumpService(Robot robot, Wall wall, RobotService rs) {
        this.wall = wall;
        this.obj = robot;
        this.rs=rs;
    }

    public  void letsJump(){
        if(obj instanceof Cat){
            cs.jumper((Cat)obj, wall.getHeight());
        }else if(obj instanceof Human){
            hs.jumper((Human)obj, wall.getHeight());
        }else if(obj instanceof Robot){
            rs.jumper((Robot)obj, wall.getHeight());
        }else{
            System.out.println("We do not know how he or she or it is jumping!");
        }
    }
}

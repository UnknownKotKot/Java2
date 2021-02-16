package Services;

import Models.Cat;
import Models.Human;
import Models.Robot;

public class RaceService {

    RunService rs;
    JumpService js;
    Object obj;

    public RaceService(RunService rs) {
        this.rs = rs;
        this.obj = rs;
    }

    public RaceService(JumpService js) {
        this.js = js;
        this.obj = js;
    }

    public void startRace(){
        if(obj instanceof RunService){
            rs.letsRun();
        }else if(obj instanceof JumpService){
            js.letsJump();

        }else{
            System.out.println("We do not know what to do!");
        }
    }
}



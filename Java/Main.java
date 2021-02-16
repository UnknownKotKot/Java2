
import Models.*;
import Services.*;

public class Main {

    public static void main(String[] args) {
       
        Object obj[] = new Object[]{
                new Cat("Vasya", 350, 200),
                new Human(" Vova", 75, 5),
                new Robot(" r2-d2", 150, 0)
        };

        Object obj2[] = new Object[]{
                new TreadMill(1000, 100),
                new Wall(32, 100),
                new TreadMill(10200, 120),
                new TreadMill(10010, 101)
        };


        for (int i = 0; i <obj.length ; i++) {
            for (int j = 0; j <obj2.length ; j++) {
                if(obj[i] instanceof Cat ){
                    CatService cs = new CatService((Cat)obj[i]);
                    if(cs.getWasteCount()!=0){
                        break;
                    }else if(obj2[j] instanceof TreadMill){
                        RunService rs = new RunService((Cat)obj[i], (TreadMill)obj2[j],cs );
                        RaceService race = new RaceService(rs);
                        race.startRace();
                    }else if(obj2[j] instanceof Wall&&cs.getWasteCount()==0){
                        JumpService js = new JumpService((Cat)obj[i], (Wall)obj2[j],cs );
                        RaceService race = new RaceService(js);
                        race.startRace();
                    }
                }else if(obj[i] instanceof Robot){
                    RobotService robs = new RobotService((Robot)obj[i]);
                    if(robs.getWasteCount()!=0){
                        break;
                    }else if(obj2[j] instanceof TreadMill){
                        RunService rs = new RunService((Robot)obj[i], (TreadMill)obj2[j],robs );
                        RaceService race = new RaceService(rs);
                        race.startRace();
                    }else if(obj2[j] instanceof Wall&&robs.getWasteCount()==0){
                        JumpService js = new JumpService((Robot)obj[i], (Wall)obj2[j],robs );
                        RaceService race = new RaceService(js);
                        race.startRace();
                    }
                }else if(obj[i] instanceof Human){
                    HumanService hs = new HumanService((Human)obj[i]);
                    if(hs.getWasteCount()!=0){
                        break;
                    }else
                    if(obj2[j] instanceof TreadMill){
                        RunService rs = new RunService((Human)obj[i], (TreadMill)obj2[j],hs );
                        RaceService race = new RaceService(rs);
                        race.startRace();
                    }else if(obj2[j] instanceof Wall&&hs.getWasteCount()==0){
                        JumpService js = new JumpService((Human)obj[i], (Wall)obj2[j],hs );
                        RaceService race = new RaceService(js);
                        race.startRace();
                    }
                }
            }
        }
    }
}

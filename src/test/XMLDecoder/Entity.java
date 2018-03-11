package test.XMLDecoder;

public class Entity {

    GlobalInfo globalInfo;
//    ReturnStateInfo returnStateInfo;


    public Entity(){
        this.globalInfo = new GlobalInfo();
//        this.returnStateInfo = new ReturnStateInfo();
    }

    @Override
    public String toString() {
        return "Entity{" +
                "globalInfo=" + globalInfo +
//                ", returnStateInfo=" + returnStateInfo +
                '}';
    }

    public GlobalInfo getGlobalInfo() {
        return globalInfo;
    }

    public void setGlobalInfo(GlobalInfo globalInfo) {
        this.globalInfo = globalInfo;
    }
}



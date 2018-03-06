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



}


class GlobalInfo {
    String appId;
    String interfaceId;
    String interfaceCode;
    String requestCode;
    String requestTime;
    String responseCode;
    ReturnStateInfo returnStateInfo;

    public GlobalInfo() {
        this.returnStateInfo = new ReturnStateInfo();
        this.appId ="appId";
        this.interfaceCode = "interfaceCode";
        this.interfaceId = "interfaceId";
        this.requestCode = "requestCode";
        this.requestTime = "requestCode";
        this.requestTime = "requestCode";
        this.responseCode = "responseCode";
    }

    @Override
    public String toString() {
        return "globalInfo{" +
                "appId='" + appId + '\'' +
                ", interfaceId='" + interfaceId + '\'' +
                ", interfaceCode='" + interfaceCode + '\'' +
                ", requestCode='" + requestCode + '\'' +
                ", requestTime='" + requestTime + '\'' +
                ", responseCode='" + responseCode + '\'' +
                ", returnStateInfo=" + returnStateInfo +
                '}';
    }
}

class ReturnStateInfo{
    String returnCode;
    String returnMessage;

    public ReturnStateInfo(){
        this.returnCode = "returnCode";
        this.returnMessage = "returnMessage";
    }

    @Override
    public String toString() {
        return "returnStateInfo{" +
                "returnCode='" + returnCode + '\'' +
                ", returnMessage='" + returnMessage + '\'' +
                '}';
    }
}
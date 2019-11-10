package test.XMLDecoder;

public class ReturnStateInfo{
    String returnCode;
    String returnMessage;

    public ReturnStateInfo(){
        this.returnCode = "123";
        this.returnMessage = "21432521531";
    }

    @Override
    public String toString() {
        return "returnStateInfo{" +
                "returnCode='" + returnCode + '\'' +
                ", returnMessage='" + returnMessage + '\'' +
                '}';
    }


    public String getReturnCode() {
        return returnCode;
    }

    public void setReturnCode(String returnCode) {
        this.returnCode = returnCode;
    }

    public String getReturnMessage() {
        return returnMessage;
    }

    public void setReturnMessage(String returnMessage) {
        this.returnMessage = returnMessage;
    }
}

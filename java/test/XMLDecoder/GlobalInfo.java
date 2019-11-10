package test.XMLDecoder;

public class GlobalInfo {
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

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getInterfaceId() {
        return interfaceId;
    }

    public void setInterfaceId(String interfaceId) {
        this.interfaceId = interfaceId;
    }

    public String getInterfaceCode() {
        return interfaceCode;
    }

    public void setInterfaceCode(String interfaceCode) {
        this.interfaceCode = interfaceCode;
    }

    public String getRequestCode() {
        return requestCode;
    }

    public void setRequestCode(String requestCode) {
        this.requestCode = requestCode;
    }

    public String getRequestTime() {
        return requestTime;
    }

    public void setRequestTime(String requestTime) {
        this.requestTime = requestTime;
    }

    public String getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(String responseCode) {
        this.responseCode = responseCode;
    }

    public ReturnStateInfo getReturnStateInfo() {
        return returnStateInfo;
    }

    public void setReturnStateInfo(ReturnStateInfo returnStateInfo) {
        this.returnStateInfo = returnStateInfo;
    }
}

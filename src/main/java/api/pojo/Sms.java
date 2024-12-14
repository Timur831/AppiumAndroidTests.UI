package api.pojo;

public class Sms {
    public Integer id;
    public String mainCtn;
    public String ctn;
    public String code;
    public Integer attemptCount;
    public Boolean activeStatus;
    public Boolean status;
    public String createdDate;

    public Sms() {
    }

    public Sms(Integer id, String mainCtn, String ctn, String code, Integer attemptCount, Boolean activeStatus, Boolean status, String createdDate) {
        this.id = id;
        this.mainCtn = mainCtn;
        this.ctn = ctn;
        this.code = code;
        this.attemptCount = attemptCount;
        this.activeStatus = activeStatus;
        this.status = status;
        this.createdDate = createdDate;
    }
}

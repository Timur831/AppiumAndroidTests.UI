package helpers.mock.balanceBM.pojo;

public class RequestedDate {
    private Integer timestampUTC;
    private String zone;

    public RequestedDate(Integer timestampUTC, String zone) {
        this.timestampUTC = timestampUTC;
        this.zone = zone;
    }

    public RequestedDate() {
    }

    public Integer getTimestampUTC() {
        return timestampUTC;
    }

    public String getZone() {
        return zone;
    }

    public void setTimestampUTC(Integer timestampUTC) {
        this.timestampUTC = timestampUTC;
    }

    public void setZone(String zone) {
        this.zone = zone;
    }
}

package helpers.mock.balanceBM.pojo;

public class EndDateTime {
    private Integer timestampUTC;
    private Object zone;

    public EndDateTime(Integer timestampUTC, Object zone) {
        this.timestampUTC = timestampUTC;
        this.zone = zone;
    }

    public EndDateTime() {
    }

    public Integer getTimestampUTC() {
        return timestampUTC;
    }

    public Object getZone() {
        return zone;
    }

    public void setTimestampUTC(Integer timestampUTC) {
        this.timestampUTC = timestampUTC;
    }

    public void setZone(Object zone) {
        this.zone = zone;
    }
}

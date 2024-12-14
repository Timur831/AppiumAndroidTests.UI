package helpers.mock.balanceBM.pojo;

public class StartDateTime {
    private Integer timestampUTC;
    private Object zone;

    public StartDateTime(Integer timestampUTC, Object zone) {
        this.timestampUTC = timestampUTC;
        this.zone = zone;
    }

    public StartDateTime() {
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

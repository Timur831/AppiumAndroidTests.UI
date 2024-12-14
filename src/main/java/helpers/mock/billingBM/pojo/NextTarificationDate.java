package helpers.mock.billingBM.pojo;

public class NextTarificationDate {
    private Integer timestampUTC;
    private String zone;

    public NextTarificationDate(Integer timestampUTC, String zone) {
        this.timestampUTC = timestampUTC;
        this.zone = zone;
    }

    public NextTarificationDate() {
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

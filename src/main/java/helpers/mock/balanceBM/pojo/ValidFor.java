package helpers.mock.balanceBM.pojo;

public class ValidFor {
    private EndDateTime endDateTime;
    private StartDateTime startDateTime;

    public ValidFor(EndDateTime endDateTime, StartDateTime startDateTime) {
        this.endDateTime = endDateTime;
        this.startDateTime = startDateTime;
    }

    public ValidFor() {
    }

    public EndDateTime getEndDateTime() {
        return endDateTime;
    }

    public StartDateTime getStartDateTime() {
        return startDateTime;
    }

    public void setEndDateTime(EndDateTime endDateTime) {
        this.endDateTime = endDateTime;
    }

    public void setStartDateTime(StartDateTime startDateTime) {
        this.startDateTime = startDateTime;
    }
}

package helpers.mock.billingBM.pojo;

public class RecurringChargePeriod {
    private ChargeAmount chargeAmount;
    private String cycleType;
    private NextTarificationDate nextTarificationDate;
    private PeriodValue periodValue;

    public RecurringChargePeriod(ChargeAmount chargeAmount, String cycleType, NextTarificationDate nextTarificationDate, PeriodValue periodValue) {
        this.chargeAmount = chargeAmount;
        this.cycleType = cycleType;
        this.nextTarificationDate = nextTarificationDate;
        this.periodValue = periodValue;
    }

    public RecurringChargePeriod() {
    }

    public ChargeAmount getChargeAmount() {
        return chargeAmount;
    }

    public String getCycleType() {
        return cycleType;
    }

    public NextTarificationDate getNextTarificationDate() {
        return nextTarificationDate;
    }

    public PeriodValue getPeriodValue() {
        return periodValue;
    }

    public void setChargeAmount(ChargeAmount chargeAmount) {
        this.chargeAmount = chargeAmount;
    }

    public void setCycleType(String cycleType) {
        this.cycleType = cycleType;
    }

    public void setNextTarificationDate(NextTarificationDate nextTarificationDate) {
        this.nextTarificationDate = nextTarificationDate;
    }

    public void setPeriodValue(PeriodValue periodValue) {
        this.periodValue = periodValue;
    }
}

package helpers.mock.billingBM.pojo;

public class PeriodValue {
    private String unit;
    private Value value;

    public PeriodValue(String unit, Value value) {
        this.unit = unit;
        this.value = value;
    }

    public PeriodValue() {
    }

    public String getUnit() {
        return unit;
    }

    public Value getValue() {
        return value;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public void setValue(Value value) {
        this.value = value;
    }
}

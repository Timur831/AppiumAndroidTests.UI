package helpers.mock.balanceBM.pojo;

public class RemainingValue {
    private String unit;
    private Value value;

    public RemainingValue(String unit, Value value) {
        this.unit = unit;
        this.value = value;
    }

    public RemainingValue() {
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

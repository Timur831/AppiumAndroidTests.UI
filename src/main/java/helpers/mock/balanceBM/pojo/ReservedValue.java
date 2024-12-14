package helpers.mock.balanceBM.pojo;

public class ReservedValue {
    private String unit;
    private Value value;

    public ReservedValue(String unit, Value value) {
        this.unit = unit;
        this.value = value;
    }

    public ReservedValue() {
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

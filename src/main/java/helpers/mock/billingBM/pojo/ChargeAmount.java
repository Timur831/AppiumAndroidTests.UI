package helpers.mock.billingBM.pojo;

public class ChargeAmount {
    private String unit;
    private Value value;

    public ChargeAmount(String unit, Value value) {
        this.unit = unit;
        this.value = value;
    }

    public ChargeAmount() {
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

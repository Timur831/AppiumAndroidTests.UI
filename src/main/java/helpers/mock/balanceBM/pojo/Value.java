package helpers.mock.balanceBM.pojo;

public class Value {
    private Integer digits;
    private Integer value;

    public Value(Integer digits, Integer value) {
        this.digits = digits;
        this.value = value;
    }

    public Value() {
    }

    public Integer getDigits() {
        return digits;
    }

    public Integer getValue() {
        return value;
    }

    public void setDigits(Integer digits) {
        this.digits = digits;
    }

    public void setValue(Integer value) {
        this.value = value;
    }
}

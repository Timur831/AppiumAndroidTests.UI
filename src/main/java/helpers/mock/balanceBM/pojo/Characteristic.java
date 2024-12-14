package helpers.mock.balanceBM.pojo;

public class Characteristic {
    private String name;
    private String value;
    private String valueType;

    public Characteristic(String name, String value, String valueType) {
        this.name = name;
        this.value = value;
        this.valueType = valueType;
    }

    public Characteristic() {
    }

    public String getName() {
        return name;
    }

    public String getValue() {
        return value;
    }

    public String getValueType() {
        return valueType;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public void setValueType(String valueType) {
        this.valueType = valueType;
    }
}

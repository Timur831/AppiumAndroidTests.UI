package helpers.mock.billingBM.pojo;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Product {
    @JsonProperty("@baseType")
    private String baseType;
    @JsonProperty("@schemaLocation")
    private String schemaLocation;
    @JsonProperty("@type")
    private String type;
    private String id;
    private String name;

    public Product(String baseType, String schemaLocation, String type, String id, String name) {
        this.baseType = baseType;
        this.schemaLocation = schemaLocation;
        this.type = type;
        this.id = id;
        this.name = name;
    }

    public Product() {
    }

    public String getBaseType() {
        return baseType;
    }

    public String getSchemaLocation() {
        return schemaLocation;
    }

    public String getType() {
        return type;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setBaseType(String baseType) {
        this.baseType = baseType;
    }

    public void setSchemaLocation(String schemaLocation) {
        this.schemaLocation = schemaLocation;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }
}

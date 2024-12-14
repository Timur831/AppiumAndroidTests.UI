package helpers.mock.balanceBM.pojo;

import com.fasterxml.jackson.annotation.JsonProperty;

public class LogicalResource {
    @JsonProperty("@baseType")
    private String baseType;
    @JsonProperty("@referredType")
    private String referredType;
    @JsonProperty("@schemaLocation")
    private String schemaLocation;
    private Object href;
    private String id;
    private String name;
    private String value;

    public LogicalResource(String baseType, String referredType, String schemaLocation, Object href, String id, String name, String value) {
        this.baseType = baseType;
        this.referredType = referredType;
        this.schemaLocation = schemaLocation;
        this.href = href;
        this.id = id;
        this.name = name;
        this.value = value;
    }

    public LogicalResource() {
    }

    public String getBaseType() {
        return baseType;
    }

    public String getReferredType() {
        return referredType;
    }

    public String getSchemaLocation() {
        return schemaLocation;
    }

    public Object getHref() {
        return href;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getValue() {
        return value;
    }

    public void setBaseType(String baseType) {
        this.baseType = baseType;
    }

    public void setReferredType(String referredType) {
        this.referredType = referredType;
    }

    public void setSchemaLocation(String schemaLocation) {
        this.schemaLocation = schemaLocation;
    }

    public void setHref(Object href) {
        this.href = href;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setValue(String value) {
        this.value = value;
    }
}


package helpers.mock.billingBM.pojo;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;

public class RootBilling {
    @JsonProperty("@baseType")
    private String baseType;
    @JsonProperty("@schemaLocation")
    private String schemaLocation;
    @JsonProperty("@type")
    private String type;
    private Bucket bucket;
    private LastChargedAmount lastChargedAmount;
    private LastTarificationDate lastTarificationDate;
    private LogicalResource logicalResource;
    private String name;
    private Product product;
    private ArrayList<RecurringChargePeriod> recurringChargePeriod;
    private String recurringPeriodType;

    public RootBilling(String baseType, String schemaLocation, String type, Bucket bucket, LastChargedAmount lastChargedAmount, LastTarificationDate lastTarificationDate, LogicalResource logicalResource, String name, Product product, ArrayList<RecurringChargePeriod> recurringChargePeriod, String recurringPeriodType) {
        this.baseType = baseType;
        this.schemaLocation = schemaLocation;
        this.type = type;
        this.bucket = bucket;
        this.lastChargedAmount = lastChargedAmount;
        this.lastTarificationDate = lastTarificationDate;
        this.logicalResource = logicalResource;
        this.name = name;
        this.product = product;
        this.recurringChargePeriod = recurringChargePeriod;
        this.recurringPeriodType = recurringPeriodType;
    }

    public RootBilling() {
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

    public Bucket getBucket() {
        return bucket;
    }

    public LastChargedAmount getLastChargedAmount() {
        return lastChargedAmount;
    }

    public LastTarificationDate getLastTarificationDate() {
        return lastTarificationDate;
    }

    public LogicalResource getLogicalResource() {
        return logicalResource;
    }

    public String getName() {
        return name;
    }

    public Product getProduct() {
        return product;
    }

    public ArrayList<RecurringChargePeriod> getRecurringChargePeriod() {
        return recurringChargePeriod;
    }

    public String getRecurringPeriodType() {
        return recurringPeriodType;
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

    public void setBucket(Bucket bucket) {
        this.bucket = bucket;
    }

    public void setLastChargedAmount(LastChargedAmount lastChargedAmount) {
        this.lastChargedAmount = lastChargedAmount;
    }

    public void setLastTarificationDate(LastTarificationDate lastTarificationDate) {
        this.lastTarificationDate = lastTarificationDate;
    }

    public void setLogicalResource(LogicalResource logicalResource) {
        this.logicalResource = logicalResource;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public void setRecurringChargePeriod(ArrayList<RecurringChargePeriod> recurringChargePeriod) {
        this.recurringChargePeriod = recurringChargePeriod;
    }

    public void setRecurringPeriodType(String recurringPeriodType) {
        this.recurringPeriodType = recurringPeriodType;
    }
}

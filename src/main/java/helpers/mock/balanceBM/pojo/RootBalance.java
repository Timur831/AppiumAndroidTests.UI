package helpers.mock.balanceBM.pojo;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;

public class RootBalance {
    @JsonProperty("@baseType")
    private String baseType;
    @JsonProperty("@schemaLocation")
    private String schemaLocation;
    @JsonProperty("@type")
    private String type;
    private ArrayList<Characteristic> characteristics;
    private Object confirmationDate;
    private String description;
    private String href;
    private String id;
    private Object initialValue;
    @JsonProperty("isShared")
    private Boolean isShared;
    private ArrayList<LogicalResource> logicalResource;
    private String name;
    private Object partyAccount;
    private ArrayList<Object> product;
    private ArrayList<Object> relatedParty;
    private RemainingValue remainingValue;
    private String remainingValueName;
    private RequestedDate requestedDate;
    private ReservedValue reservedValue;
    private String status;
    private String usageType;
    private ValidFor validFor;

    public RootBalance(String baseType, String schemaLocation, String type, ArrayList<Characteristic> characteristics, Object confirmationDate, String description, String href, String id, Object initialValue, Boolean isShared, ArrayList<LogicalResource> logicalResource, String name, Object partyAccount, ArrayList<Object> product, ArrayList<Object> relatedParty, RemainingValue remainingValue, String remainingValueName, RequestedDate requestedDate, ReservedValue reservedValue, String status, String usageType, ValidFor validFor) {
        this.baseType = baseType;
        this.schemaLocation = schemaLocation;
        this.type = type;
        this.characteristics = characteristics;
        this.confirmationDate = confirmationDate;
        this.description = description;
        this.href = href;
        this.id = id;
        this.initialValue = initialValue;
        this.isShared = isShared;
        this.logicalResource = logicalResource;
        this.name = name;
        this.partyAccount = partyAccount;
        this.product = product;
        this.relatedParty = relatedParty;
        this.remainingValue = remainingValue;
        this.remainingValueName = remainingValueName;
        this.requestedDate = requestedDate;
        this.reservedValue = reservedValue;
        this.status = status;
        this.usageType = usageType;
        this.validFor = validFor;
    }

    public RootBalance() {
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

    public ArrayList<Characteristic> getCharacteristics() {
        return characteristics;
    }

    public Object getConfirmationDate() {
        return confirmationDate;
    }

    public String getDescription() {
        return description;
    }

    public String getHref() {
        return href;
    }

    public String getId() {
        return id;
    }

    public Object getInitialValue() {
        return initialValue;
    }

    public Boolean getShared() {
        return isShared;
    }

    public ArrayList<LogicalResource> getLogicalResource() {
        return logicalResource;
    }

    public String getName() {
        return name;
    }

    public Object getPartyAccount() {
        return partyAccount;
    }

    public ArrayList<Object> getProduct() {
        return product;
    }

    public ArrayList<Object> getRelatedParty() {
        return relatedParty;
    }

    public RemainingValue getRemainingValue() {
        return remainingValue;
    }

    public String getRemainingValueName() {
        return remainingValueName;
    }

    public RequestedDate getRequestedDate() {
        return requestedDate;
    }

    public ReservedValue getReservedValue() {
        return reservedValue;
    }

    public String getStatus() {
        return status;
    }

    public String getUsageType() {
        return usageType;
    }

    public ValidFor getValidFor() {
        return validFor;
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

    public void setCharacteristics(ArrayList<Characteristic> characteristics) {
        this.characteristics = characteristics;
    }

    public void setConfirmationDate(Object confirmationDate) {
        this.confirmationDate = confirmationDate;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setInitialValue(Object initialValue) {
        this.initialValue = initialValue;
    }

    public void setShared(Boolean shared) {
        isShared = shared;
    }

    public void setLogicalResource(ArrayList<LogicalResource> logicalResource) {
        this.logicalResource = logicalResource;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPartyAccount(Object partyAccount) {
        this.partyAccount = partyAccount;
    }

    public void setProduct(ArrayList<Object> product) {
        this.product = product;
    }

    public void setRelatedParty(ArrayList<Object> relatedParty) {
        this.relatedParty = relatedParty;
    }

    public void setRemainingValue(RemainingValue remainingValue) {
        this.remainingValue = remainingValue;
    }

    public void setRemainingValueName(String remainingValueName) {
        this.remainingValueName = remainingValueName;
    }

    public void setRequestedDate(RequestedDate requestedDate) {
        this.requestedDate = requestedDate;
    }

    public void setReservedValue(ReservedValue reservedValue) {
        this.reservedValue = reservedValue;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setUsageType(String usageType) {
        this.usageType = usageType;
    }

    public void setValidFor(ValidFor validFor) {
        this.validFor = validFor;
    }
}

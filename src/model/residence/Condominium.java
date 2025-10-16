package model.residence;

public class Condominium {
    private String name;
    private String postalCode;
    private Double maintenanceFee;
    private Boolean hasSecurity;
    private Boolean hasParking;
    private Boolean hasPool;
    private Boolean hasGym;
    private Boolean hasPlayground;
    private Boolean allowsPets;


    public Condominium(String name, String postalCode, Double maintenanceFee, Boolean hasSecurity, Boolean hasParking, Boolean hasPool, Boolean hasGym, Boolean hasPlayground, Boolean allowsPets) {
        this.name = name;
        this.postalCode = postalCode;
        this.maintenanceFee = maintenanceFee;
        this.hasSecurity = hasSecurity;
        this.hasParking = hasParking;
        this.hasPool = hasPool;
        this.hasGym = hasGym;
        this.hasPlayground = hasPlayground;
        this.allowsPets = allowsPets;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public Double getMaintenanceFee() {
        return maintenanceFee;
    }

    public void setMaintenanceFee(Double maintenanceFee) {
        this.maintenanceFee = maintenanceFee;
    }

    public Boolean getHasSecurity() {
        return hasSecurity;
    }

    public void setHasSecurity(Boolean hasSecurity) {
        this.hasSecurity = hasSecurity;
    }

    public Boolean getHasParking() {
        return hasParking;
    }

    public void setHasParking(Boolean hasParking) {
        this.hasParking = hasParking;
    }

    public Boolean getHasPool() {
        return hasPool;
    }

    public void setHasPool(Boolean hasPool) {
        this.hasPool = hasPool;
    }

    public Boolean getHasGym() {
        return hasGym;
    }

    public void setHasGym(Boolean hasGym) {
        this.hasGym = hasGym;
    }

    public Boolean getHasPlayground() {
        return hasPlayground;
    }

    public void setHasPlayground(Boolean hasPlayground) {
        this.hasPlayground = hasPlayground;
    }

    public Boolean getAllowsPets() {
        return allowsPets;
    }

    public void setAllowsPets(Boolean allowsPets) {
        this.allowsPets = allowsPets;
    }

    @Override
    public String toString() {
        return "{"
                + "\"Name\":\"" + name + "\","
                + "\"Postal Code\":\"" + postalCode + "\","
                + "\"Maintance Fee\":" + maintenanceFee + ","
                + "}";
    }
}



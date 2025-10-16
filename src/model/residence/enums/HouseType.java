package model.residence.enums;

public enum HouseType {
    DOMESTIC_HOUSE("Domestic House"),
    TOWNHOUSE("Townhouse");

    private final String label;

    HouseType(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
}

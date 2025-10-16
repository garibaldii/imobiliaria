package model.residence.enums;

public enum FarmType {
    SMALL_FARM("Small Farm"),
    COUNTRY_HOUSE("Country House"),
    RANCH("Ranch");


    private final String label;

    FarmType(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
}

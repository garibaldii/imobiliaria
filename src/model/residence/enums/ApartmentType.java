package model.residence.enums;

public enum ApartmentType {
    NORMAL_APARTMENT("Normal Apartment"),
    PENTHOUSE("PentHouse"),
    DUPLEX("Duplex"),
    TRIPLEX("Triplex"),
    FLAT("Flat"),
    KITNET("Kitnet");


    private final String label;

    ApartmentType(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
}

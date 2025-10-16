package model.residence;

import model.Owner;
import model.residence.enums.ApartmentType;

import java.util.Optional;

public class Apartment extends Residence {

    private ApartmentType type;
    private int floorNumber;
    private boolean hasElevator;
    private boolean hasBalcony;

    // Construtor refatorado
    public Apartment(
            String postalCode,
            int number,
            Owner owner,
            boolean rented,
            int rentPrice,
            Optional<Condominium> condominium,
            ApartmentType type,
            int floorNumber,
            boolean hasElevator,
            boolean hasBalcony
    ) {
        super(postalCode, number, owner, rented, rentPrice, condominium);
        this.type = type;
        this.floorNumber = floorNumber;
        this.hasElevator = hasElevator;
        this.hasBalcony = hasBalcony;
    }

    // Getters e Setters
    public ApartmentType getType() {
        return type;
    }

    public void setType(ApartmentType type) {
        this.type = type;
    }

    public int getFloorNumber() {
        return floorNumber;
    }

    public void setFloorNumber(int floorNumber) {
        this.floorNumber = floorNumber;
    }

    public boolean isHasElevator() {
        return hasElevator;
    }

    public void setHasElevator(boolean hasElevator) {
        this.hasElevator = hasElevator;
    }

    public boolean isHasBalcony() {
        return hasBalcony;
    }

    public void setHasBalcony(boolean hasBalcony) {
        this.hasBalcony = hasBalcony;
    }
}

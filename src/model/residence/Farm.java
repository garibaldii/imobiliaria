package model.residence;

import model.Owner;
import model.residence.enums.FarmType;

public class Farm extends Residence {

    private FarmType type;


    public Farm(String postalCode, int number, Owner owner, boolean rented, int rentPrice) {
        super(postalCode, number, owner, rented, rentPrice);
    }
}

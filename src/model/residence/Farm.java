package model.residence;

import model.Owner;
import model.residence.enums.FarmType;

public class Farm extends Residence {

    private FarmType type;


    @Override
    public int getBrokerFee() {
        return (int) (getRentPrice() * 1.05);
    }

    public Farm(String postalCode, int number, Owner owner, boolean rented, int rentPrice, FarmType type) {
        super(postalCode, number, owner, rented, rentPrice);
        this.type = type;
    }

    @Override
    public String getType() {
        return type.getLabel();
    }

    public void setType(FarmType type) {
        this.type = type;
    }
}

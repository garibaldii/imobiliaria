package model.residence;

import model.Owner;
import model.residence.enums.HouseType;

public class DomesticHouse extends Residence {

    private HouseType type;
    private boolean hasPool;


    public DomesticHouse(
            String postalCode,
            int number,
            Owner owner,
            boolean rented,
            int rentPrice,
            HouseType type,
            boolean hasPool
    ) {
        super(postalCode, number, owner, rented, rentPrice);
        this.type = type;
        this.hasPool = hasPool;
    }

    public void setType(HouseType type) {
        this.type = type;
    }

    public void setHasPool(boolean hasPool) {
        this.hasPool = hasPool;
    }


    public boolean isHasPool() {
        return hasPool;
    }

    @Override
    public int getBrokerFee() {
        return (int) (getRentPrice() * 1.10);
    }

    @Override
    public String getType() {
        return type.getLabel();
    }
}

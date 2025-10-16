package model.residence;

import model.residence.enums.HouseType;

public class DomesticHouse extends Residence {

    private HouseType type;
    private boolean hasPool;


    public DomesticHouse(HouseType type, boolean hasPool) {
        super();
        this.type = type;
        this.hasPool = hasPool;
    }

    public void setType(HouseType type) {
        this.type = type;
    }

    public void setHasPool(boolean hasPool) {
        this.hasPool = hasPool;
    }
}

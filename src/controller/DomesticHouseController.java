package controller;

import model.residence.DomesticHouse;

import java.util.ArrayList;
import java.util.List;

public class DomesticHouseController {

    List<DomesticHouse> availableHouses = new ArrayList<>();

    private static DomesticHouseController instance = new DomesticHouseController();

    public static DomesticHouseController getInstance() {
        return instance;
    }

    public void deleteHouse(DomesticHouse h) {
        availableHouses.remove(h);
    }

    public List<DomesticHouse> getAvailableHouses() {
        System.out.println(availableHouses);
        return availableHouses;
    }


    public DomesticHouse postDomesticHouse(DomesticHouse h) {
        availableHouses.add(h);
        return h;
    }
}

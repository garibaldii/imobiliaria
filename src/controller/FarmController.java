package controller;

import model.residence.Farm;

import java.util.ArrayList;
import java.util.List;

public class FarmController {

    private static FarmController instance = new FarmController();

    public static FarmController getInstance() {
        return instance;
    }

    List<Farm> farms = new ArrayList<>();

    public void deleteFarm(Farm f) {
        farms.remove(f);
    }

    public List<Farm> getAllFarms() {
        System.out.println(farms);
        return farms;
    }

    public Farm postFarm(Farm f) {
        farms.add(f);
        return f;
    }
}

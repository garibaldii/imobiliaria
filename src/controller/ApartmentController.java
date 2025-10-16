package controller;

import model.residence.Apartment;

import java.util.List;

public class ApartmentController {

    List<Apartment> apartments;

    public List<Apartment> getApartments() {
        return apartments;
    }

    public Apartment postApartment(Apartment a) {
        apartments.add(a);
        return a;
    }
}

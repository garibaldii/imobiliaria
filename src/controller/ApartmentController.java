package controller;

import model.residence.Apartment;

import java.util.ArrayList;
import java.util.List;

public class ApartmentController {

    private static ApartmentController instance = new ApartmentController();

    public static ApartmentController getInstance(){
        return instance;
    }

    List<Apartment> apartments = new ArrayList<>();

    public List<Apartment> getApartments() {
        System.out.println(apartments);
        return apartments;
    }

    public Apartment postApartment(Apartment a) {
        apartments.add(a);
        return a;
    }

    public Apartment updateApartment(Apartment a, int apartmentId) {
        for (Apartment existing : apartments) {
            if (existing.getId() == apartmentId) {
                // exemplo: atualiza apenas os campos relevantes
                existing.setPostalCode(a.getPostalCode());
                existing.setNumber(a.getNumber());
                existing.setOwner(a.getOwner());
                existing.setRented(a.isRented());
                existing.setRentPrice(a.getRentPrice());
                return existing;
            }
        }
        return null; // se não encontrou
    }

}
